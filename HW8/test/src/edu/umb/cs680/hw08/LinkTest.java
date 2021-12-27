package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.FSElement;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;
import edu.umb.cs680.hw08.Link;
class LinkTest {

	static LocalDateTime localTime = LocalDateTime.now();
	private String[] fsElementToStringArray(FSElement f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fsElementInfo = { Boolean.toString(f.isDirectory()), f.getName(), 
				Integer.toString(f.getSize()), f.getCreationTime().toString(), 
				optionalDirectory.isPresent()?f.getParent().getName():null};
		return fsElementInfo;
	}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupfilestructure() {
		Directory root = new Directory(null, "root", 0, localTime);
		Directory applications = new Directory(root, "applications", 0, localTime);
		Directory home = new Directory(root, "home", 0, localTime);
		Directory code = new Directory(home, "code", 0, localTime);
		File a = new File(applications, "a", 1300, localTime);
		File b = new File(applications, "b", 350, localTime);
		File c = new File(home, "c", 500, localTime);
		File d = new File(home, "d", 700, localTime);
		Link x = new Link(home, "x", 0, localTime, applications);
		File e = new File(code, "e", 70, localTime);
		File f = new File(code, "f", 130, localTime);	
		Link y = new Link(code, "y", 0, localTime, b);
		
		FileSystem.getFileSystem().addRootDir(root);
	}
	
	@Test
	public void verifyTargetEqualityHome() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root" };
		Directory actual = (Directory) fileSystem.getRootDirs().get(0).findLinkByName("x").getTarget();
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}
	@Test
	public void verifyTargetEqualityE() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "350", localTime.toString(), "applications" };
		File actual = (File) fileSystem.getRootDirs().get(0).findLinkByName("y").getTarget();
		assertArrayEquals(expected,fsElementToStringArray(actual));
	}
}
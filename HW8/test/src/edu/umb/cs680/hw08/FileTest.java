package edu.umb.cs680.hw08;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw08.Directory;
import edu.umb.cs680.hw08.File;
import edu.umb.cs680.hw08.FileSystem;
import edu.umb.cs680.hw08.Link;
class FileTest {
	private String[] stringarraytocompare(File f) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
		String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(), 
				Integer.toString(f.getSize()), f.getCreationTime().toString(), 
				optionalDirectory.isPresent()?f.getParent().getName():null};
		return fileInfo;
	}
	static LocalDateTime localTime = LocalDateTime.now();
	
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
		//creating files and addding the root directory
		FileSystem.getFileSystem().addRootDir(root);
	}
	
	
	@Test
	public void verifyA() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "a", "1300", localTime.toString(), "applications" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("a");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}
	
	@Test
	public void verifyB() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "350", localTime.toString(), "applications" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("b");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}
	
	@Test
	public void verifyC() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "c", "500", localTime.toString(), "home" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("c");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}

	
	@Test
	public void verifyF() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "f", "130", localTime.toString(), "code" };
		File actual = fileSystem.getRootDirs().get(0).findFileByName("f");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}
	
	@Test
	void TestforDirectory() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("root").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("home").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("applications").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDirByName("code").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("a").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("b").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("c").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("d").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("e").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFileByName("f").isDirectory());
	}
	
	}
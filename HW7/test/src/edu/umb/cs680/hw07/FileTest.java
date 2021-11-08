package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
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
	public static void directoryandfilecreation() {
		Directory root = new Directory(null, "root", 0, localTime);
		Directory applications = new Directory(root, "applications", 0, localTime);
		Directory home = new Directory(root, "home", 0, localTime);
		Directory code = new Directory(home, "code", 0, localTime);
		File a = new File(applications, "a", 1300, localTime);
		File b = new File(applications, "b", 350, localTime);
		File c = new File(home, "c", 500, localTime);
		File d = new File(home, "d", 700, localTime);
		File e = new File(code, "e", 70, localTime);
		File f = new File(code, "f", 130, localTime);
		
		FileSystem.getFileSystem().addRootDir(root);
	}
	
	
	@Test
	public void verifyA() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "a", "1300", localTime.toString(), "applications" };
		File actual = fileSystem.getRootDirs().get(0).findFile("a");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}
	
	@Test
	public void verifyB() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "b", "350", localTime.toString(), "applications" };
		File actual = fileSystem.getRootDirs().get(0).findFile("b");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}
	
	@Test
	public void verifyC() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "c", "500", localTime.toString(), "home" };
		File actual = fileSystem.getRootDirs().get(0).findFile("c");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}

	
	@Test
	public void verifyE() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "false", "e", "70", localTime.toString(), "code" };
		File actual = fileSystem.getRootDirs().get(0).findFile("e");
		assertArrayEquals(expected,stringarraytocompare(actual));
	}
	
	@Test
	void TestforDirectory() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertTrue(fileSystem.getRootDirs().get(0).findDir("root").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDir("home").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDir("applications").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDir("code").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("a").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("b").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("c").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("d").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("e").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("f").isDirectory());
	}
	@Test
	void TestforDirectoryroot() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertTrue(fileSystem.getRootDirs().get(0).findDir("root").isDirectory());
	}

}

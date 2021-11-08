package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
class DirectoryTest {

	
static LocalDateTime localTime = LocalDateTime.now();
	
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
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
	
	private String[] dirToStringArray(Directory d) {
		Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
		String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(), 
				Integer.toString(d.getSize()), d.getCreationTime().toString(), 
				optionalDirectory.isPresent()?d.getParent().getName():null, 
						Integer.toString(d.getTotalSize()),
						Integer.toString(d.countChildren())};
		return directorystring;
	}

	
	
	@Test
	void testretDirectoryandFiles() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("home", fileSystem.getRootDirs().get(0).findDir("home").getName());
		assertSame("root", fileSystem.getRootDirs().get(0).findDir("root").getName());
		assertSame("applications", fileSystem.getRootDirs().get(0).findDir("applications").getName());
		assertSame("code", fileSystem.getRootDirs().get(0).findDir("code").getName());
		assertSame("a", fileSystem.getRootDirs().get(0).findFile("a").getName());
		assertSame("f", fileSystem.getRootDirs().get(0).findFile("f").getName());
	} 
	
	@Test
	void testforDirectoryandfiles() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertTrue(fileSystem.getRootDirs().get(0).findDir("root").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDir("home").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDir("home").isDirectory());
		assertTrue(fileSystem.getRootDirs().get(0).findDir("code").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("a").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("b").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("c").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("d").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("e").isDirectory());
		assertFalse(fileSystem.getRootDirs().get(0).findFile("f").isDirectory());
	}
	
	@Test
	public void verifyDirectory_Code() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "200", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDir("code");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	void testdirectoryfilenumbers() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("a", fileSystem.getRootDirs().get(0).findDir("applications").getFiles().get(0).getName());
		assertSame("b", fileSystem.getRootDirs().get(0).findDir("applications").getFiles().get(1).getName());
		assertSame("c", fileSystem.getRootDirs().get(0).findDir("home").getFiles().get(0).getName());
		assertSame("d", fileSystem.getRootDirs().get(0).findDir("home").getFiles().get(1).getName());
		assertSame("e", fileSystem.getRootDirs().get(0).findDir("code").getFiles().get(0).getName());
		assertSame("f", fileSystem.getRootDirs().get(0).findDir("code").getFiles().get(1).getName());
	}
	
	@Test
	void testsubdirectoriesonly() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertSame("applications", fileSystem.getRootDirs().get(0).findDir("root").getSubDirectories().get(0).getName());
		assertSame("home", fileSystem.getRootDirs().get(0).findDir("root").getSubDirectories().get(1).getName());
		assertSame("code", fileSystem.getRootDirs().get(0).findDir("home").getSubDirectories().get(0).getName());
	}
	@Test
	void tesforcodesize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(200, fileSystem.getRootDirs().get(0).findDir("code").getTotalSize());

		
	}
	
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3050", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDir("root");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	
	@Test
	public void verifyDirectory_Home() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "1400", "3" };
		Directory actual = fileSystem.getRootDirs().get(0).findDir("home");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	@Test
	void testsubfilesandfoldersnumber() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(2, fileSystem.getRootDirs().get(0).findDir("root").countChildren());
		assertEquals(2, fileSystem.getRootDirs().get(0).findDir("applications").countChildren());
		assertEquals(3, fileSystem.getRootDirs().get(0).findDir("home").countChildren());
		assertEquals(2, fileSystem.getRootDirs().get(0).findDir("code").countChildren());
	}
	@Test
	void tesrfoldersize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(3050, fileSystem.getRootDirs().get(0).findDir("root").getTotalSize());
		assertEquals(200, fileSystem.getRootDirs().get(0).findDir("code").getTotalSize());
		assertEquals(1650, fileSystem.getRootDirs().get(0).findDir("applications").getTotalSize());
		assertEquals(1400, fileSystem.getRootDirs().get(0).findDir("home").getTotalSize());
		
	}
	@Test
	void testsize() {
		FileSystem fileSystem = FileSystem.getFileSystem();
		assertEquals(3050, fileSystem.getRootDirs().get(0).findDir("root").getTotalSize());	
	}
	@Test
	public void verifyDirectory_Applications() { 
		FileSystem fileSystem = FileSystem.getFileSystem();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1650", "2" };
		Directory actual = fileSystem.getRootDirs().get(0).findDir("applications");
		assertArrayEquals(expected,dirToStringArray(actual));
	}
	

}
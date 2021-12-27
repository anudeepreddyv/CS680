package edu.umb.cs680.hw09;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.*;
//import edu.umb.cs680.hw09.fs.*;


class APFSTest {

	private String[] apfsElementToArray(ApfsElement e) {
		String[] elementInfo = {Boolean.toString(e.isDirectory()), e.getName(), Integer.toString(e.getSize()),
				e.getOwnerName() };
		return elementInfo;
	}
	
	

	@Test
	public void getRootDirTest() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsFileSystem.initFileSystem("Apfs", 500);
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true","root", "0","Apfs" };
		assertArrayEquals(expected,apfsElementToArray(actual));
	}

	@Test
	public void createDefaultRootTest() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		ApfsDirectory actual = ApfsFileSystem.getRootDir();
		String[] expected = { "true","root", "0", "Apfs" };
		assertArrayEquals(expected, apfsElementToArray(actual));
	}

}
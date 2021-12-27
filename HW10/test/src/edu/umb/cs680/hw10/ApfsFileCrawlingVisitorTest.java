package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw10.apfs.*;
class AfspFileCrawlingVisitorTest {
	LocalDateTime localTime = LocalDateTime.now();
	APFS ApfsFileSystem = APFS.getAPFSFileSystem();
	ApfsDirectory root = (ApfsDirectory) ApfsFileSystem.initFileSystem("Apfs", 1000);
	ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime,"ApfsFile",localTime);
	ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime,"ApfsFile",localTime);
	ApfsFile a = new ApfsFile(applications, "a", 100, localTime,"ApfsFile",localTime);
	ApfsFile b = new ApfsFile(applications, "b", 110, localTime,"ApfsFile",localTime);
	ApfsFile c = new ApfsFile(home, "c", 120, localTime,"ApfsFile",localTime);
	ApfsFile d = new ApfsFile(home, "d", 130, localTime,"ApfsFile",localTime);
	ApfsFile e = new ApfsFile(code, "e", 140, localTime,"ApfsFile",localTime);
	ApfsFile f = new ApfsFile(code, "f", 200, localTime,"ApfsFile",localTime);
	ApfsLink x = new ApfsLink(home, "x", 0, localTime, "ApfsFile", localTime, applications);
	ApfsLink y = new ApfsLink(code, "y", 0, localTime,"ApfsFile",localTime,b);
	
    @Test
	public void fileCrawlingCode() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		code.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		ApfsFile[] expected = { e, f };
		assertArrayEquals(expected, actual.toArray());
	}
	  
	@Test
	public void fileCrawlingHome() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		home.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		ApfsFile[] expected = {e, f,c,d};
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void fileCrawlingRoot() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		root.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		ApfsFile[] expected = { a,b,e, f, c, d };
		assertArrayEquals(expected, actual.toArray());
	}
		}
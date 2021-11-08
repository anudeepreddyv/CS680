package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DVDPlayerTest {
	
	DVDPlayer dvd = DVDPlayer.getInstance();
	

	@Test
	public void DrawerClosedPlaying_playButtonPushed() {
		
		dvd.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), dvd.getCurrentState());
		
	}
	
	@Test
	public void DrawerClosedNotPlaying_stopButtonPushedDVDPlaying() {
		dvd.playButtonPushed();
		dvd.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), dvd.getCurrentState());
	}
	
	@Test
	public void DrawerOpen_openCloseButtonPushedDVDPlaying() {
		dvd.playButtonPushed();
		dvd.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(),dvd.getCurrentState());
	}
	
	

}
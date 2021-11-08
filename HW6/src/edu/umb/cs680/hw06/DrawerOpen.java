package edu.umb.cs680.hw06;

public class DrawerOpen implements State{
	private static DrawerOpen instance = null;

	public static DrawerOpen getInstance() {
		if (instance == null)
			instance = new DrawerOpen();
		return instance;
	}

	public void openCloseButtonPushed() {
		dvdPlayer.close();
		dvdPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}

	public void playButtonPushed() {
		dvdPlayer.close();
		dvdPlayer.changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed() {
		System.out.println("DVD stopped playing!");
	}
}
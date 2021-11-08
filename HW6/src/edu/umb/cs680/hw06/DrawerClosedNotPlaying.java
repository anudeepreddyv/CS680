package edu.umb.cs680.hw06;


public class DrawerClosedNotPlaying implements State{

	private static DrawerClosedNotPlaying instance = null;
	
	public static DrawerClosedNotPlaying getInstance() {
		if (instance == null)
			instance = new DrawerClosedNotPlaying();
		return instance;
	}

	public void openCloseButtonPushed() {
		dvdPlayer.open();
		dvdPlayer.changeState(DrawerOpen.getInstance());
	}

	public void playButtonPushed() {
		dvdPlayer.play();
		dvdPlayer.changeState(DrawerClosedPlaying.getInstance());
	}

	public void stopButtonPushed() {
		System.out.println("DVD stopped playing!");
	}
}

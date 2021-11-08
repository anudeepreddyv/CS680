package edu.umb.cs680.hw06;


public class DVDPlayer {

	private static DVDPlayer instance = null;
	private static State state;

	public DVDPlayer(State s) {
		state = s;
	}

	public static DVDPlayer getInstance() {
		if (instance == null) {
			State s = DrawerClosedNotPlaying.getInstance();
			instance = new DVDPlayer(s);
		}
		return instance;
	}

	public void changeState(State s) {
		state = s;
	}
	
	public Object getCurrentState() {
		return state;
	}

	public void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}

	public void playButtonPushed() {
		state.playButtonPushed();
	}

	public void stopButtonPushed() {
		state.stopButtonPushed();
	}

	public void open() {
		System.out.println("Drawer is opening...");
	}

	public void close() {
		System.out.println("Drawer is closing...");
	}

	public void play() {
		System.out.println("DVD is playing...");
	}

	public void stop() {
		System.out.println("DVD stopped playing...");
	}

	public Object getPresentState() {
		return state;
	}

	public static void main(String args[]) {
		DVDPlayer dvdPlayer = DVDPlayer.getInstance();
		dvdPlayer.openCloseButtonPushed();
		dvdPlayer.playButtonPushed();
		dvdPlayer.stopButtonPushed();
	}

}

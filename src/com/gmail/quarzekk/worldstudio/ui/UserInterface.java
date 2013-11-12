package com.gmail.quarzekk.worldstudio.ui;

/**
 * 
 * Represents the many modes of interface between the program code and the
 * user.
 *
 */
public class UserInterface {
	
	/**
	 * The display thread.
	 */
	private DisplayThread displayThread;
	
	/**
	 * Constructs a new UserInterface.
	 */
	public UserInterface() {
		this.displayThread = new DisplayThread();
	}
	
	/**
	 * Starts the display thread.
	 */
	public void startDisplay() {
		this.displayThread.start();
	}
	
	/**
	 * Stops the display thread.
	 */
	public void stopDisplay() {
		this.displayThread.close();
	}
	
	/**
	 * Gets the display thread.
	 * @return The display thread
	 */
	public DisplayThread getDisplayThread() {
		return this.displayThread;
	}
	
}

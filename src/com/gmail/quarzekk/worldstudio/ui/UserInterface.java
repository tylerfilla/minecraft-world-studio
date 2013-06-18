package com.gmail.quarzekk.worldstudio.ui;

public class UserInterface {
	
	private DisplayThread displayThread;
	
	public UserInterface() {
		this.displayThread = new DisplayThread();
	}
	
	public void startDisplay() {
		this.displayThread.start();
	}
	
	public void stopDisplay() {
		this.displayThread.close();
	}
	
}

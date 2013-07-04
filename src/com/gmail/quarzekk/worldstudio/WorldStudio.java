package com.gmail.quarzekk.worldstudio;

import com.gmail.quarzekk.worldstudio.ui.UserInterface;

public class WorldStudio {
	
	public static WorldStudio instance;
	
	private UserInterface userInterface;
	
	public WorldStudio() {
		this.userInterface = new UserInterface();
	}
	
	public void start() {
		this.userInterface.startDisplay();
	}
	
	public void exit(int status) {
		if (status > 0) {
			System.err.println("Minecraft World Studio is exiting with errors.");
		}
		
		System.exit(status);
	}
	
	public static void main(String[] args) {
		WorldStudio.instance = new WorldStudio();
		WorldStudio.instance.start();
	}
	
}

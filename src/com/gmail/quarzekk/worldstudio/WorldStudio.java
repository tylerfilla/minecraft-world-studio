package com.gmail.quarzekk.worldstudio;

public class WorldStudio {
	
	public static WorldStudio instance;
	
	public WorldStudio() {
	}
	
	public void start() {
	}
	
	public static void main(String[] args) {
		WorldStudio.instance = new WorldStudio();
		WorldStudio.instance.start();
	}
	
}

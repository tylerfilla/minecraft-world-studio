package com.gmail.quarzekk.worldstudio.world;

import java.util.ArrayList;

public class World {
	
	/**
	 * An ArrayList of all chunks currently loaded within this world.
	 */
	private ArrayList<Chunk> loadedChunks;
	
	/**
	 * Constructs a new world with default values
	 */
	public World() {
		this.loadedChunks = new ArrayList<Chunk>();
	}
	
}

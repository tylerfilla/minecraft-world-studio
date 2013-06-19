package com.gmail.quarzekk.worldstudio.world;

import java.util.ArrayList;

public class World {
	
	/**
	 * An ArrayList of all chunks currently loaded within this world.
	 */
	private ArrayList<Chunk> loadedChunks;
	
	/**
	 * The object that stores this world's information.
	 */
	private WorldInformation info;
	
	/**
	 * Constructs a new world with default values
	 */
	public World() {
		this.loadedChunks = new ArrayList<Chunk>();
		this.info = WorldInformation.EMPTY;
	}
	
}

package com.gmail.quarzekk.worldstudio.world;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Gets a List of all chunks currently loaded within this world.
	 * @return A List&lt;Chunk&gt; of loaded chunks
	 */
	public List<Chunk> getLoadedChunks() {
		return this.loadedChunks;
	}
	
	/**
	 * Loads a chunk into the world.
	 * @param chunk The chunk to load
	 */
	public void loadChunk(Chunk chunk) {
		this.loadedChunks.add(chunk);
		chunk.setWorld(this);
	}
	
	/**
	 * Unloads a chunk from the world.
	 * @param chunk The chunk to unload
	 */
	public void unloadChunk(Chunk chunk) {
		this.loadedChunks.remove(chunk);
		chunk.setWorld(null);
	}
	
	/**
	 * Gets the loaded chunk at the given coordinates.
	 * @param chunkX The x-coordinate of the chunk
	 * @param chunkZ The z-coordinate of the chunk
	 * @return The chunk at the given coordinates
	 */
	public Chunk getChunkAt(int chunkX, int chunkZ) {
		for (Chunk chunk : this.loadedChunks) {
			if (chunk.getCoordX() == chunkX && chunk.getCoordZ() == chunkZ) {
				return chunk;
			}
		}
		
		return null;
	}
	
}

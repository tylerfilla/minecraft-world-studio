package com.gmail.quarzekk.worldstudio.core.io.world;

import com.gmail.quarzekk.worldstudio.world.Chunk;
import com.gmail.quarzekk.worldstudio.world.WorldInformation;

/**
 * 
 * Represents a world save handler capable of loading and saving world data and
 * chunk data from a location on the filesystem.
 *
 */
public interface ISaveHandler {
	
	/**
	 * Loads information about the world save described by this save handler.
	 * @return A WorldInformation containing said information
	 */
	public WorldInformation loadWorldInfo();
	
	/**
	 * Saves information contained within the given WorldInformation to the
	 * world save described by this save handler.
	 * @param info A WorldInformation containing said information
	 */
	public void saveWorldInfo(WorldInformation info);
	
	/**
	 * Loads the chunk from the world save described by this save handler at
	 * the given coordinates.
	 * @return The chunk loaded from the world save at the given coordinates
	 */
	public Chunk loadChunk();
	
	/**
	 * Saves a chunk to the world save described by this save handler. The
	 * coordinates for this chunk are stored in the Chunk class.
	 * @param chunk The chunk to save to the world save
	 */
	public void saveChunk(Chunk chunk);
	
}

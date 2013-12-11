package com.gmail.quarzekk.worldstudio.core.io.world.anvil;

import com.gmail.quarzekk.worldstudio.core.io.world.ISaveHandler;
import com.gmail.quarzekk.worldstudio.world.Chunk;
import com.gmail.quarzekk.worldstudio.world.WorldInformation;

/**
 * 
 * A save handler for the Anvil format.
 *
 */
public class AnvilSaveHandler implements ISaveHandler {
	
	/**
	 * The location on the filesystem of the world save.
	 */
	private final String saveLocation;
	
	/**
	 * Constructs a new AnvilSaveHandler for the given save location.
	 * @param saveLocation The location of the world save
	 */
	public AnvilSaveHandler(String saveLocation) {
		this.saveLocation = saveLocation;
	}
	
	/**
	 * Gets the location on the filesystem of the world save.
	 * @return The location of the world save
	 */
	public String getSaveLocation() {
		return this.saveLocation;
	}
	
	@Override
	public WorldInformation loadWorldInfo() {
		return null;
	}
	
	@Override
	public void saveWorldInfo(WorldInformation info) {
	}
	
	@Override
	public Chunk loadChunk(int coordX, int coordY) {
		return null;
	}
	
	@Override
	public void saveChunk(Chunk chunk) {
	}
	
}

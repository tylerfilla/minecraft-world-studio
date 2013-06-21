package com.gmail.quarzekk.worldstudio.world;

/**
 * 
 * Represents the immutable coordinates of a chunk in chunk space.
 *
 */
public class ChunkCoordinates {
	
	/**
	 * The x-coordinate of the chunk represented by these coordinates.
	 */
	private final int coordX;
	
	/**
	 * The z-coordinate of the chunk represented by these coordinates.
	 */
	private final int coordZ;
	
	/**
	 * Constructs a new ChunkCoordinates with no data.
	 */
	public ChunkCoordinates() {
		this(0, 0);
	}
	
	/**
	 * Constructs a new ChunkCoordinates with the given coordinate data.
	 * @param coordX The x-coordinate of the chunk
	 * @param coordZ The z-coordinate of the chunk
	 */
	public ChunkCoordinates(int coordX, int coordZ) {
		this.coordX = coordX;
		this.coordZ = coordZ;
	}
	
	/**
	 * Gets the x-coordinate of the chunk represented by these coordinates.
	 * @return The x-coordinate of the chunk 
	 */
	public int getCoordX() {
		return this.coordX;
	}
	
	/**
	 * Gets the z-coordinate of the chunk represented by these coordinates.
	 * @return The z-coordinate of the chunk
	 */
	public int getCoordZ() {
		return this.coordZ;
	}
	
}

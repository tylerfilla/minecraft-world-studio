package com.gmail.quarzekk.worldstudio.world;

public class Chunk {
	
	/**
	 * The X coordinate of this chunk.
	 */
	private int coordX;
	
	/**
	 * The Z coordinate of this chunk.
	 */
	private int coordZ;
	
	/**
	 * An array of integers corresponding to this chunk's subchunks' VBO indexes.
	 */
	private int[] vboIds;
	
	/**
	 * Constructs a new chunk object with default values.
	 */
	public Chunk() {
		this(0, 0);
	}
	
	/**
	 * Constructs a new chunk with the given coordinate data.
	 * @param coordX The X coordinate of this chunk
	 * @param coordZ The Z coordinate of this chunk
	 */
	public Chunk(int coordX, int coordZ) {
		this.coordX = coordX;
		this.coordZ = coordZ;
	}
	
	/**
	 * Gets the X coordinate of this chunk.
	 * @return The X coordinate of this chunk
	 */
	public int getCoordX() {
		return this.coordX;
	}
	
	/**
	 * Gets the Z coordinate of this chunk.
	 * @return The Z coordinate of this chunk.
	 */
	public int getCoordZ() {
		return this.coordZ;
	}
	
}

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
	 * An array of integers representing the amounts of VBO elements per section.
	 */
	private int[] numVboElements;
	
	/**
	 * An array of boolean values signifying which sections need to be redrawn.
	 */
	private boolean[] vboUpdatesRequired;
	
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
	
	/**
	 * Gets the OpenGL VBO (vertex buffer object) identifier for the given
	 * section.
	 * @param section The section represented by the requested VBO ID
	 * @return The VBO ID for the given section
	 */
	public int getVboId(int section) {
		return this.vboIds[section];
	}
	
	/**
	 * Gets the amount of VBO elements in the given section.
	 * @param section The section containing the elements
	 * @return The amount of VBO elements
	 */
	public int getNumVboElements(int section) {
		return this.numVboElements[section];
	}
	
	public boolean getVboUpdateRequired(int section) {
		return this.vboUpdatesRequired[section];
	}
	
}

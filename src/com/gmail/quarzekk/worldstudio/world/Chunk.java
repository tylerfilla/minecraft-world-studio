package com.gmail.quarzekk.worldstudio.world;

/**
 * 
 * A chunk within a world.
 *
 */
public class Chunk {
	
	/**
	 * The world to which this chunk belongs.
	 */
	private World world;
	
	/**
	 * The x-coordinate of this chunk.
	 */
	private int coordX;
	
	/**
	 * The z-coordinate of this chunk.
	 */
	private int coordZ;
	
	/**
	 * The Blocks within this chunk.
	 */
	private Block[] blocks;
	
	/**
	 * An array of integers corresponding to this chunk's sections' VBO indexes.
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
	 * @param coordX The x-coordinate of this chunk
	 * @param coordZ The z-coordinate of this chunk
	 */
	public Chunk(int coordX, int coordZ) {
		this.coordX = coordX;
		this.coordZ = coordZ;
		
		this.blocks = new Block[65536];
		
		this.vboIds = new int[8];
		this.numVboElements = new int[8];
		this.vboUpdatesRequired = new boolean[8];
	}
	
	/**
	 * Gets the world to which this chunk belongs.
	 * @return The parent World
	 */
	public World getWorld() {
		return this.world;
	}
	
	/**
	 * Sets the world to which this chunk belongs.
	 * @param world The desired parent World
	 */
	public void setWorld(World world) {
		this.world = world;
	}
	
	/**
	 * Gets the x-coordinate of this chunk.
	 * @return The x-coordinate of this chunk
	 */
	public int getCoordX() {
		return this.coordX;
	}
	
	/**
	 * Gets the z-coordinate of this chunk.
	 * @return The z-coordinate of this chunk.
	 */
	public int getCoordZ() {
		return this.coordZ;
	}
	
	/**
	 * Gets the block at the specified block coordinates relative to this
	 * chunk's origin.
	 * @param x The x-coordinate of the block
	 * @param y The y-coordinate of the block
	 * @param z The z-coordinate of the block
	 * @return The block at the specified coordinates
	 */
	public Block getBlockAt(int x, int y, int z) {
		int index = y*256 + z*16 + x;
		
		if (index < 0 || index > 65535) {
			return null;
		}
		
		return this.blocks[index];
	}
	
	/**
	 * Sets the block at the specified block coordinates relative to this
	 * chunk's origin.
	 * @param x The x-coordinate of the block
	 * @param y The y-coordinate of the block
	 * @param z The z-coordinate of the block
	 * @param block The block to set at the specified coordinates
	 */
	public void setBlockAt(int x, int y, int z, Block block) {
		int index = y*256 + z*16 + x;
		int section = y/16;
		
		if (index < 0 || index > 65535) {
			return;
		}
		
		this.blocks[index] = block;
		this.vboUpdatesRequired[section] = true;
	}
	
	/**
	 * Gets the VBO identifier for the given section.
	 * @param section The section of the chunk
	 * @return The VBO ID for the given section
	 */
	public int getVboId(int section) {
		return this.vboIds[section];
	}
	
	/**
	 * Sets the VBO identifier for the given section.
	 * @param section The section of the chunk
	 * @param vboId The new VBO ID for the given section.
	 */
	public void setVboId(int section, int vboId) {
		this.vboIds[section] = vboId;
	}
	
	/**
	 * Gets the amount of VBO elements in the given section.
	 * @param section The section containing the elements
	 * @return The amount of VBO elements
	 */
	public int getNumVboElements(int section) {
		return this.numVboElements[section];
	}
	
	/**
	 * Sets the amount of VBO elements in the given section to that of the
	 * given.
	 * @param section The section containing the elements
	 * @param numVboElements The new amount of VBO elements
	 */
	public void setNumVboElements(int section, int numVboElements) {
		this.numVboElements[section] = numVboElements;
	}
	
	/**
	 * Gets whether or not the specified section's VBO needs to be updated.
	 * @param section The section represented by the VBO
	 * @return Whether or not the section's VBO needs to be updated
	 */
	public boolean getVboUpdateRequired(int section) {
		return this.vboUpdatesRequired[section];
	}
	
	/**
	 * Sets whether or not the specified section's VBO needs to be updated.
	 * @param section The section represented by the VBO
	 * @param vboUpdateRequired Whether or not the section's VBO needs to be
	 * updated.
	 */
	public void setVboUpdateRequired(int section, boolean vboUpdateRequired) {
		this.vboUpdatesRequired[section] = vboUpdateRequired;
	}
	
}

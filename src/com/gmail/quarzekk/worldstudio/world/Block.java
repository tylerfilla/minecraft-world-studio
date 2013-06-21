package com.gmail.quarzekk.worldstudio.world;

/**
 * 
 * A block within a chunk.
 *
 */
public class Block {
	
	/**
	 * The ID of this block.
	 */
	private int id;
	
	/**
	 * The metadata used to further define this block.
	 */
	private int metadata;
	
	/**
	 * Constructs a new Block with no data.
	 */
	public Block() {
		this(0, 0);
	}
	
	/**
	 * Constructs a new Block with the given data.
	 * @param id The ID of the block
	 * @param metadata The metadata used to further define the block
	 */
	public Block(int id, int metadata) {
		this.id = id;
		this.metadata = metadata;
	}
	
	/**
	 * Gets the ID of this block.
	 * @return The ID of this block
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Sets the ID of this block to that of the given.
	 * @param id The new ID for this block
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the metadata used to further define this block.
	 * @return The metadata used to further define this block
	 */
	public int getMetadata() {
		return this.metadata;
	}
	
	/**
	 * Sets the metadata of this block to that of the given.
	 * @param metadata The new metadata for this block
	 */
	public void setMetadata(int metadata) {
		this.metadata = metadata;
	}
	
}

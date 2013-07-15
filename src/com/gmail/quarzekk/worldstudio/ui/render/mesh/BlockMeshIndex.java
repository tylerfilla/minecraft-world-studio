package com.gmail.quarzekk.worldstudio.ui.render.mesh;

import java.util.HashMap;

/**
 * 
 * A static index for the mapping of block info to Mesh objects representing
 * the blocks themselves.
 *
 */
public class BlockMeshIndex {
	
	/**
	 * A map of condensed block info to Mesh objects.
	 */
	private static final HashMap<Long, Mesh> blockMeshMap = new HashMap<Long, Mesh>();
	
	/**
	 * Adds a block mesh to the index. As the Mesh object is universal, it is
	 * necessary to check whether or not the Mesh you are indexing actually
	 * represents a block before adding it.
	 * @param blockId The ID of the block
	 * @param blockMetadata The metadata of the block
	 * @param blockMesh The mesh for the block
	 */
	public static void addBlockMesh(int blockId, int blockMetadata, Mesh blockMesh) {
		blockMeshMap.put(((long) blockId << 32) | (long) blockMetadata, blockMesh);
	}
	
	/**
	 * Removes a block mesh from the index based on the block ID and metadata.
	 * @param blockId The ID of the block
	 * @param blockMetadata The metadata of the block
	 */
	public static void removeBlockMesh(int blockId, int blockMetadata) {
		blockMeshMap.remove(((long) blockId << 32) | (long) blockMetadata);
	}
	
	/**
	 * Removes a block mesh from the index based on the Mesh object itself.
	 * @param blockMesh The Mesh object
	 */
	public static void removeBlockMesh(Mesh blockMesh) {
		blockMeshMap.values().remove(blockMesh);
	}
	
}

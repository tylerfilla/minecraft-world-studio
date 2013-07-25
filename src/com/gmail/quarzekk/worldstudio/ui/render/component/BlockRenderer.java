package com.gmail.quarzekk.worldstudio.ui.render.component;

import java.nio.FloatBuffer;

import com.gmail.quarzekk.worldstudio.ui.render.mesh.block.BlockMesh;
import com.gmail.quarzekk.worldstudio.ui.render.mesh.block.BlockMeshIndex;
import com.gmail.quarzekk.worldstudio.world.Block;
import com.gmail.quarzekk.worldstudio.world.Chunk;

/**
 * 
 * A component renderer that generates data for given blocks.
 *
 */
public class BlockRenderer implements IComponentRenderer {
	
	public BlockRenderer() {
	}
	
	/**
	 * Renders a given block to the given buffer with the given chunk context.
	 * @param buffer The buffer to which render data is stored
	 * @param chunk The chunk context
	 * @param block The block to render
	 * @param x The x-coordinate of the block's position
	 * @param y The y-coordinate of the block's position
	 * @param z The z-coordinate of the block's position
	 * @return The number of VBO elements used to render the block
	 */
	public int renderBlock(FloatBuffer buffer, Chunk chunk, Block block, int x, int y, int z) {
		BlockMesh mesh = BlockMeshIndex.getMeshForBlockInfo(block.getId(), block.getMetadata());
		
		for (float[] vertex : mesh.getVertices()) {
			float vX = vertex[0];
			float vY = vertex[1];
			float vZ = vertex[2];
			
			vX += (float) x;
			vY += (float) y;
			vZ += (float) z;
			
			buffer.put(vX);
			buffer.put(vY);
			buffer.put(vZ);
		}
		
		return mesh.getVertices().length;
	}
	
}

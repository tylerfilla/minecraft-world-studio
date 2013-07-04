package com.gmail.quarzekk.worldstudio.ui.render.component;

import java.nio.FloatBuffer;

import com.gmail.quarzekk.worldstudio.world.Block;
import com.gmail.quarzekk.worldstudio.world.Chunk;

/**
 * 
 * A component renderer that generates data for given chunks.
 *
 */
public class ChunkRenderer implements IComponentRenderer {
	
	private BlockRenderer blockRenderer;
	
	public ChunkRenderer() {
		this.blockRenderer = new BlockRenderer();
	}
	
	/**
	 * Renders a given section of a given chunk to the given buffer.
	 * @param buffer The buffer to which render data is stored
	 * @param chunk The chunk containing the section
	 * @param section The section to render
	 * @return The number of VBO elements used to render the section
	 */
	public int renderSection(FloatBuffer buffer, Chunk chunk, int section) {
		int elementCount = 0;
		
		for (int x = 0; x < 16; x++) {
			for (int y = section*16; y < 16; y++) {
				for (int z = 0; z < 16; z++) {
					Block block = chunk.getBlockAt(x, y, z);
					if (block != null) {
						elementCount += this.blockRenderer.renderBlock(buffer, chunk, block, x, y, z);
					}
				}
			}
		}
		
		return elementCount;
	}
	
}

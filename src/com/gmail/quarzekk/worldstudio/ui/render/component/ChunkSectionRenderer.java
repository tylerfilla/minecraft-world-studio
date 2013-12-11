package com.gmail.quarzekk.worldstudio.ui.render.component;

import java.nio.FloatBuffer;

import com.gmail.quarzekk.worldstudio.world.Block;
import com.gmail.quarzekk.worldstudio.world.Chunk;
import com.gmail.quarzekk.worldstudio.world.World;

public class ChunkSectionRenderer {
	
	private BlockRenderer blockRenderer;
	
	public ChunkSectionRenderer() {
		this.blockRenderer = new BlockRenderer();
	}
	
	public int renderChunkSection(FloatBuffer buffer, World world, Chunk chunk, int section) {
		int elementTotal = 0;
		
		for (int x = 0; x < 16; x++) {
			for (int y = section*16; y < section*16 + 16; y++) {
				for (int z = 0; z < 16; z++) {
					Block block = chunk.getBlockAt(x, y, z);
					
					if (block != null) {
						elementTotal += this.blockRenderer.renderBlock(buffer, world, chunk, block, x, y, z);
					}
				}
			}
		}
		
		return elementTotal;
	}
	
}

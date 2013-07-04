package com.gmail.quarzekk.worldstudio.ui.render;

import static org.lwjgl.opengl.ARBVertexBufferObject.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;

import com.gmail.quarzekk.worldstudio.ui.render.component.ChunkRenderer;
import com.gmail.quarzekk.worldstudio.world.Chunk;
import com.gmail.quarzekk.worldstudio.world.World;

public class WorldRenderer implements IRenderer {
	
	/**
	 * The ChunkRenderer from which this renderer gets chunk render data.
	 */
	private ChunkRenderer chunkRenderer;
	
	/**
	 * A reference to the world this renderer is concerned with.
	 */
	private World world;
	
	public WorldRenderer() {
		this.chunkRenderer = new ChunkRenderer();
		
		this.world = null;
	}
	
	@Override
	public void update() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(45.0F, (float) Display.getWidth()/(float) Display.getHeight(), 0.0F, 100.0F);
		
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		this.render();
	}
	
	/**
	 * Gets the world rendered by this renderer.
	 * @return The World rendered by this renderer
	 */
	public World getWorld() {
		return this.world;
	}
	
	/**
	 * Sets the world to render with this renderer.
	 * @param world The World to render
	 */
	public void setWorld(World world) {
		this.world = world;
	}
	
	/**
	 * Renders the active world. It is not necessary to expose this method
	 * publicly, as the modularization is merely for code readability.
	 */
	private void render() {
		if (this.world != null) {
			Iterable<Chunk> chunks = this.world.getLoadedChunks();
			
			for (Chunk chunk : chunks) {
				for (int section = 0; section < 8; section++) {
					if (chunk.getVboId(section) == 0) {
						int vboId = glGenBuffersARB();
						chunk.setVboId(section, vboId);
						chunk.setVboUpdateRequired(section, true);
					}
					
					if (chunk.getVboUpdateRequired(section)) {
						FloatBuffer buffer = BufferUtils.createFloatBuffer(3*3);
						
						int numElements = this.chunkRenderer.renderSection(buffer, chunk, section);
						
						buffer.flip();
						
						glBindBufferARB(GL_ARRAY_BUFFER_ARB, chunk.getVboId(section));
						glBufferDataARB(GL_ARRAY_BUFFER_ARB, buffer, GL_STATIC_DRAW_ARB);
						glBindBufferARB(GL_ARRAY_BUFFER_ARB, 0);
						
						chunk.setVboUpdateRequired(section, false);
						chunk.setNumVboElements(section, numElements);
					}
					
					glPushMatrix();
					
					glRotatef(((float) (System.currentTimeMillis()%1000)/1000.0F)*360.0F, 1.0F, 1.0F, 0.0F);
					
					glEnableClientState(GL_VERTEX_ARRAY);
					
					glBindBufferARB(GL_ARRAY_BUFFER_ARB, chunk.getVboId(section));
					glVertexPointer(3, GL_FLOAT, 0, 0L);
					glDrawArrays(GL_TRIANGLES, 0, 3);
					glBindBufferARB(GL_ARRAY_BUFFER_ARB, 0);
					
					glDisableClientState(GL_VERTEX_ARRAY);
					
					glPopMatrix();
				}
			}
		}
	}
	
}

package com.gmail.quarzekk.worldstudio.ui;

import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;

import com.gmail.quarzekk.worldstudio.ui.render.StudioRenderer;
import com.gmail.quarzekk.worldstudio.ui.render.WorldRenderer;

/**
 * 
 * A thread that handles the display and rendering via the appropriate
 * UserInterface.
 *
 */
public class DisplayThread extends Thread {
	
	/**
	 * The WorldRenderer run from the display thread.
	 */
	private WorldRenderer worldRenderer;
	
	/**
	 * The StudioRenderer run from the display thread.
	 */
	private StudioRenderer studioRenderer;
	
	/**
	 * Whether or not this thread should continue to operate.
	 */
	private volatile boolean shouldContinue;
	
	/**
	 * The title of the display window.
	 */
	private String displayTitle;
	
	/**
	 * The x-coordinate of the size of the display window.
	 */
	private int displaySizeX;
	
	/**
	 * The y-coordinate of the size of the display window.
	 */
	private int displaySizeY;
	
	/**
	 * Constructs a new DisplayThread with reference to the constructing
	 * UserInterface.
	 * @param userInterface A reference to the UserInterface
	 */
	public DisplayThread() {
		super("worldstudio.display");
		
		this.worldRenderer = new WorldRenderer();
		this.studioRenderer = new StudioRenderer();
		
		this.shouldContinue = true;
		
		this.displayTitle = "Minecraft World Studio";
		
		this.displaySizeX = 800; // TODO: Load from config
		this.displaySizeY = 600; // TODO: Load from config
	}
	
	@Override
	public void run() {
		try {
			this.createDisplay();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		while (this.shouldContinue) {
			this.updateDisplay();
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			glMatrixMode(GL_PROJECTION);
			glLoadIdentity();
			
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			
			this.worldRenderer.update();
			this.studioRenderer.update();
			
			Display.sync(60); // TODO: Load from config
		}
		
		this.destroyDisplay();
	}
	
	/**
	 * Signals that the thread should cease execution as soon as possible.
	 */
	public void close() {
		this.shouldContinue = false;
	}
	
	/**
	 * Creates the display window via LWJGL.
	 * @throws LWJGLException
	 */
	private void createDisplay() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(this.displaySizeX, this.displaySizeY));
		Display.setTitle(this.displayTitle);
		Display.setIcon(new ByteBuffer[0]); // TODO: Icon reference
		Display.setResizable(true); // TODO: Load from config
		Display.create();
		
		if (!GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
			System.err.println("Vertex buffer objects are unsupported by the graphics card.");
			this.destroyDisplay();
			System.exit(1);
		}
		
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	
	/**
	 * Destroys the display window.
	 */
	private void destroyDisplay() {
		Display.destroy();
	}
	
	/**
	 * Updates the display window.
	 */
	private void updateDisplay() {
		Display.update();
		
		if (Display.wasResized()) {
			glViewport(0, 0, Display.getWidth(), Display.getHeight());
		}
		
		this.shouldContinue = this.shouldContinue && !Display.isCloseRequested();
	}
	
	/**
	 * Gets a reference to the WorldRenderer on the display thread.
	 * @return A reference to the WorldRenderer
	 */
	public WorldRenderer getWorldRenderer() {
		return this.worldRenderer;
	}
	
	/**
	 * Gets a reference to the StudioRenderer on the display thread.
	 * @return A reference to the StudioRenderer
	 */
	public StudioRenderer getStudioRenderer() {
		return this.studioRenderer;
	}
	
}

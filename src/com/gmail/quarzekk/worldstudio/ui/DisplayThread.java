package com.gmail.quarzekk.worldstudio.ui;

import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;

import com.gmail.quarzekk.worldstudio.WorldStudio;
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
	 * A reference to the UserInterface object that constructed this
	 * DisplayThread.
	 */
	private UserInterface userInterface;
	
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
	public DisplayThread(UserInterface userInterface) {
		super("worldstudio.display");
		
		this.userInterface = userInterface;
		
		this.userInterface.worldRenderer = new WorldRenderer();
		this.userInterface.studioRenderer = new StudioRenderer();
		
		this.shouldContinue = true;
		
		this.displayTitle = "Minecraft World Studio";
		
		this.displaySizeX = 800;
		this.displaySizeY = 600;
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
			
			this.userInterface.worldRenderer.update();
			this.userInterface.studioRenderer.update();
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
		Display.setIcon(new ByteBuffer[0]);
		Display.setResizable(true);
		Display.create();
		
		if (!GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
			System.err.println("Vertex buffer objects are unsupported by the graphics card.");
			this.destroyDisplay();
			WorldStudio.instance.exit(1);
		}
		
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
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
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
}

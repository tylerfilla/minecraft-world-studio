package com.gmail.quarzekk.worldstudio.ui;

import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.gmail.quarzekk.worldstudio.ui.render.StudioRenderer;
import com.gmail.quarzekk.worldstudio.ui.render.WorldRenderer;

public class DisplayThread extends Thread {
	
	private WorldRenderer worldRenderer;
	private StudioRenderer studioRenderer;
	
	private boolean shouldContinue;
	
	private int displaySizeX;
	private int displaySizeY;
	
	public DisplayThread() {
		super("worldstudio.display");
		
		this.worldRenderer = new WorldRenderer();
		this.studioRenderer = new StudioRenderer();
		
		this.shouldContinue = true;
		
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
		
		this.worldRenderer.initialize();
		this.studioRenderer.initialize();
		
		while (this.shouldContinue) {
			this.updateDisplay();
			
			this.worldRenderer.update();
			this.studioRenderer.update();
		}
		
		this.destroyDisplay();
	}
	
	public void close() {
		this.shouldContinue = false;
	}
	
	private void createDisplay() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(this.displaySizeX, this.displaySizeY));
		Display.setIcon(new ByteBuffer[0]); // TODO: No icon yet
		Display.create();
	}
	
	private void destroyDisplay() {
		Display.destroy();
	}
	
	private void updateDisplay() {
		Display.update();
		
		this.shouldContinue = this.shouldContinue && !Display.isCloseRequested();
	}
	
}

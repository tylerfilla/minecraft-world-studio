package com.gmail.quarzekk.worldstudio.ui;

import com.gmail.quarzekk.worldstudio.ui.render.StudioRenderer;
import com.gmail.quarzekk.worldstudio.ui.render.WorldRenderer;

/**
 * 
 * Represents the many modes of interface between the program code and the
 * user.
 *
 */
public class UserInterface {
	
	/**
	 * The display thread.
	 */
	private DisplayThread displayThread;
	
	/**
	 * The WorldRenderer run from the display thread.
	 */
	protected WorldRenderer worldRenderer;
	
	/**
	 * The StudioRenderer run from the display thread.
	 */
	protected StudioRenderer studioRenderer;
	
	/**
	 * Constructs a new UserInterface.
	 */
	public UserInterface() {
		this.displayThread = new DisplayThread(this);
	}
	
	/**
	 * Starts the display thread.
	 */
	public void startDisplay() {
		this.displayThread.start();
	}
	
	/**
	 * Stops the display thread.
	 */
	public void stopDisplay() {
		this.displayThread.close();
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

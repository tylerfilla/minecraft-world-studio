package com.gmail.quarzekk.worldstudio.ui.render;

/**
 * 
 * Represents a renderer that makes OpenGL calls to draw a visible component to
 * the buffer.
 *
 */
public interface IRenderer {
	
	/**
	 * Updates this renderer. This is called once per frame, however the
	 * renderer is not required to render the scene at each call to this
	 * method.
	 */
	public void update();
	
}

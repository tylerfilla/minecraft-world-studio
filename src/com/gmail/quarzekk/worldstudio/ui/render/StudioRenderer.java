package com.gmail.quarzekk.worldstudio.ui.render;

/**
 * 
 * A renderer responsible for rendering the studio interface, GUIs, etc.
 *
 */
public class StudioRenderer implements IRenderer {
	
	public StudioRenderer() {
	}
	
	@Override
	public void update() {
		this.render();
	}
	
	/**
	 * Renders the studio interface, GUIs, etc. It is not necessary to expose
	 * this method publicly, as the modularization is merely for code
	 * readability.
	 */
	private void render() {
	}
	
}

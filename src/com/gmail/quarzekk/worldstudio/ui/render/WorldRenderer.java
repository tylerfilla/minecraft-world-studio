package com.gmail.quarzekk.worldstudio.ui.render;

import com.gmail.quarzekk.worldstudio.ui.render.component.ChunkRenderer;

public class WorldRenderer implements IRenderer {
	
	private ChunkRenderer chunkRenderer;
	
	public WorldRenderer() {
		this.chunkRenderer = new ChunkRenderer();
	}
	
	@Override
	public void initialize() {
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

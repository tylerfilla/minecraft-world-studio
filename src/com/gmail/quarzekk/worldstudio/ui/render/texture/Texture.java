package com.gmail.quarzekk.worldstudio.ui.render.texture;

import java.awt.image.BufferedImage;

public class Texture {
	
	/**
	 * The width of the image represented by this texture.
	 */
	private int imageWidth;
	
	/**
	 * The height of the image represented by this texture.
	 */
	private int imageHeight;
	
	/**
	 * The pixel data of the image represented by this texture. The pixel data
	 * is in the format ARGB.
	 */
	private byte[] imageData;
	
	/**
	 * The OpenGL texture index of the buffered copy of the image represented
	 * by this texture.
	 */
	private int glTextureId;
	
	public Texture() {
		this.imageWidth = 0;
		this.imageHeight = 0;
		this.glTextureId = 0;
	}
	
	/**
	 * Gets the width of the image represented by this texture.
	 * @return The width of the image
	 */
	public int getImageWidth() {
		return this.imageWidth;
	}
	
	/**
	 * Sets the width for the image represented by this texture.
	 * @param imageWidth The width for the image
	 */
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	
	/**
	 * Gets the height of the image represented by this texture.
	 * @return The height of the image
	 */
	public int getImageHeight() {
		return this.imageHeight;
	}
	
	/**
	 * Sets the height for the image represented by this texture.
	 * @param imageHeight The height for the image
	 */
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	
	/**
	 * Gets the pixel data of the image represented by this texture.
	 * @return The pixel data of the image
	 */
	public byte[] getImageData() {
		return this.imageData;
	}
	
	/**
	 * Sets the pixel data for the image represented by this texture.
	 * @param imageData The pixel data for the image
	 */
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	/**
	 * Gets the OpenGL texture index of the buffered copy of the image
	 * represented by this texture.
	 * @return The OpenGL texture index of the image
	 */
	public int getGlTextureId() {
		return this.glTextureId;
	}
	
	/**
	 * Sets the OpenGL texture index for the buffered copy of the image
	 * represented by this texture.
	 * @param glTextureId The OpenGL texture index for the image
	 */
	public void setGlTextureId(int glTextureId) {
		this.glTextureId = glTextureId;
	}
	
	/**
	 * Creates a Texture with image data from the given {@link BufferedImage}.
	 * This texture has not yet been buffered to the graphics card and has not
	 * yet been assigned a texture index via <code>glGenTextures()</code>. 
	 * @param image The BufferedImage from which to extract image data
	 * @return The new Texture reflecting the given image data
	 */
	public static Texture fromBufferedImage(BufferedImage image) {
		Texture texture = new Texture();
		
		texture.imageWidth = image.getWidth();
		texture.imageHeight = image.getHeight();
		
		texture.imageData = new byte[image.getWidth()*image.getHeight()*4];
		
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				int pixel = image.getRGB(x, y);
				int index = (y*image.getWidth() + x)*4;
				
				texture.imageData[index + 0] = (byte) ((pixel >>> 24) & 0xFF);
				texture.imageData[index + 1] = (byte) ((pixel >>> 16) & 0xFF);
				texture.imageData[index + 2] = (byte) ((pixel >>> 8) & 0xFF);
				texture.imageData[index + 3] = (byte) ((pixel >>> 0) & 0xFF);
			}
		}
		
		return texture;
	}
	
}

package com.gmail.quarzekk.worldstudio.ui.render;

/**
 * 
 * A render-specific camera-like perspective.
 *
 */
public class RenderPerspective {
	
	/**
	 * The X-coordinate of this perspective's position.
	 */
	private double coordX;
	
	/**
	 * The Y-coordinate of this perspective's position.
	 */
	private double coordY;
	
	/**
	 * The Z-coordinate of this perspective's position.
	 */
	private double coordZ;
	
	/**
	 * The X-coordinate of this perspective's rotation.
	 */
	private double rotationX;
	
	/**
	 * The Y-coordinate of this perspective's rotation.
	 */
	private double rotationY;
	
	/**
	 * The Z-coordinate of this perspective's rotation.
	 */
	private double rotationZ;
	
	/**
	 * Constructs a new RenderPerspective.
	 */
	public RenderPerspective() {
		this.coordX = 0.0D;
		this.coordY = 0.0D;
		this.coordZ = 0.0D;
		
		this.rotationX = 0.0D;
		this.rotationY = 0.0D;
		this.rotationZ = 0.0D;
	}
	
	/**
	 * Gets the X-coordinate of this perspective's position.
	 * @return The X-coordinate of this perspectives position
	 */
	public double getCoordX() {
		return this.coordX;
	}
	
	/**
	 * Sets the X-coordinate of this perspective's position to that of the
	 * given.
	 * @param coordX The desired X-coordinate of this perspective's position
	 */
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	
	/**
	 * Gets the Y-coordinate of this perspective's position.
	 * @return The Y-coordinate of this perspectives position
	 */
	public double getCoordY() {
		return this.coordY;
	}
	
	/**
	 * Sets the Y-coordinate of this perspective's position to that of the
	 * given.
	 * @param coordY The desired Y-coordinate of this perspective's position
	 */
	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}
	
	/**
	 * Gets the Z-coordinate of this perspective's position.
	 * @return The Z-coordinate of this perspectives position
	 */
	public double getCoordZ() {
		return this.coordZ;
	}
	
	/**
	 * Sets the Z-coordinate of this perspective's position to that of the
	 * given.
	 * @param coordZ The desired Z-coordinate of this perspective's position
	 */
	public void setCoordZ(double coordZ) {
		this.coordZ = coordZ;
	}
	
	/**
	 * Gets the X-coordinate of this perspective's rotation.
	 * @return The X-coordinate of this perspectives rotation
	 */
	public double getRotationX() {
		return this.rotationX;
	}

	/**
	 * Sets the X-coordinate of this perspective's rotation to that of the
	 * given.
	 * @param coordX The desired X-coordinate of this perspective's rotation
	 */
	public void setRotationX(double rotationX) {
		this.rotationX = rotationX;
	}
	
	/**
	 * Gets the Y-coordinate of this perspective's rotation.
	 * @return The Y-coordinate of this perspectives rotation
	 */
	public double getRotationY() {
		return this.rotationY;
	}
	
	/**
	 * Sets the Y-coordinate of this perspective's rotation to that of the
	 * given.
	 * @param coordY The desired Y-coordinate of this perspective's rotation
	 */
	public void setRotationY(double rotationY) {
		this.rotationY = rotationY;
	}
	
	/**
	 * Gets the Z-coordinate of this perspective's rotation.
	 * @return The Z-coordinate of this perspectives rotation
	 */
	public double getRotationZ() {
		return this.rotationZ;
	}

	/**
	 * Sets the Z-coordinate of this perspective's rotation to that of the
	 * given.
	 * @param coordZ The desired Z-coordinate of this perspective's rotation
	 */
	public void setRotationZ(double rotationZ) {
		this.rotationZ = rotationZ;
	}
	
}

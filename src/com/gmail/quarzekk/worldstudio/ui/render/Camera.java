package com.gmail.quarzekk.worldstudio.ui.render;

public class Camera {
	
	/**
	 * The x-coordinate of the camera's position.
	 */
	private double positionX;
	
	/**
	 * The y-coordinate of the camera's position.
	 */
	private double positionY;
	
	/**
	 * The z-coordinate of the camera's position.
	 */
	private double positionZ;
	
	/**
	 * The x-coordinate of the camera's velocity.
	 */
	private double velocityX;
	
	/**
	 * The y-coordinate of the camera's velocity.
	 */
	private double velocityY;
	
	/**
	 * The z-coordinate of the camera's velocity.
	 */
	private double velocityZ;
	
	/**
	 * The x-coordinate of the camera's rotation.
	 */
	private double rotationX;
	
	/**
	 * The y-coordinate of the camera's rotation.
	 */
	private double rotationY;
	
	/**
	 * The z-coordinate of the camera's rotation.
	 */
	private double rotationZ;
	
	/**
	 * The x-coordinate of the camera's rotational velocity.
	 */
	private double rotationalVelocityX;
	
	/**
	 * The y-coordinate of the camera's rotational velocity.
	 */
	private double rotationalVelocityY;
	
	/**
	 * The z-coordinate of the camera's rotational velocity.
	 */
	private double rotationalVelocityZ;
	
	/**
	 * The last time the camera was updated as provided by
	 * {@link System#currentTimeMillis()}.
	 */
	private long lastUpdateTime;
	
	public Camera() {
		this.positionX = 0.0D;
		this.positionY = 0.0D;
		this.positionZ = 0.0D;
		
		this.velocityX = 0.0D;
		this.velocityY = 0.0D;
		this.velocityZ = 0.0D;
		
		this.rotationX = 0.0D;
		this.rotationY = 0.0D;
		this.rotationZ = 0.0D;
		
		this.rotationalVelocityX = 0.0D;
		this.rotationalVelocityY = 0.0D;
		this.rotationalVelocityZ = 0.0D;
		
		this.lastUpdateTime = System.currentTimeMillis();
	}
	
	public double getPositionX() {
		return this.positionX;
	}
	
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
	public double getPositionY() {
		return this.positionY;
	}
	
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	
	public double getPositionZ() {
		return this.positionZ;
	}
	
	public void setPositionZ(double positionZ) {
		this.rotationZ = positionZ;
	}
	
	public void setPosition(double positionX, double positionY, double positionZ) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.positionZ = positionZ;
	}
	
	public double getVelocityX() {
		return this.velocityX;
	}
	
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	
	public double getVelocityY() {
		return this.velocityY;
	}
	
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}
	
	public double getVelocityZ() {
		return this.velocityZ;
	}
	
	public void setVelocityZ(double velocityZ) {
		this.velocityZ = velocityZ;
	}
	
	public void setVelocity(double velocityX, double velocityY, double velocityZ) {
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.velocityZ = velocityZ;
	}
	
	public double getRotationX() {
		return this.rotationX;
	}
	
	public void setRotationX(double rotationX) {
		this.rotationX = rotationX;
	}
	
	public double getRotationY() {
		return this.rotationY;
	}
	
	public void setRotationY(double rotationY) {
		this.rotationY = rotationY;
	}
	
	public double getRotationZ() {
		return this.rotationZ;
	}
	
	public void setRotationZ(double rotationZ) {
		this.rotationZ = rotationZ;
	}
	
	public void setRotation(double rotationX, double rotationY, double rotationZ) {
		this.rotationX = rotationX;
		this.rotationY = rotationY;
		this.rotationZ = rotationZ;
	}
	
	public double getRotationalVelocityX() {
		return this.rotationalVelocityX;
	}
	
	public void setRotationalVelocityX(double rotationalVelocityX) {
		this.rotationalVelocityX = rotationalVelocityX;
	}
	
	public double getRotationalVelocityY() {
		return this.rotationalVelocityY;
	}
	
	public void setRotationalVelocityY(double rotationalVelocityY) {
		this.rotationalVelocityY = rotationalVelocityY;
	}
	
	public double getRotationalVelocityZ() {
		return this.rotationalVelocityZ;
	}
	
	public void setRotationalVelocityZ(double rotationalVelocityZ) {
		this.rotationalVelocityZ = rotationalVelocityZ;
	}
	
	public void setRotationalVelocity(double rotationalVelocityX, double rotationalVelocityY, double rotationalVelocityZ) {
		this.rotationalVelocityX = rotationalVelocityX;
		this.rotationalVelocityY = rotationalVelocityY;
		this.rotationalVelocityZ = rotationalVelocityZ;
	}
	
	public void update() {
		long currentTimeMillis = System.currentTimeMillis();
		double elapsedTime = ((double) currentTimeMillis - (double) this.lastUpdateTime)/1000.0D;
		
		this.positionX += this.velocityX*elapsedTime;
		this.positionY += this.velocityY*elapsedTime;
		this.positionZ += this.velocityZ*elapsedTime;
		
		this.rotationX += this.rotationalVelocityX*elapsedTime;
		this.rotationY += this.rotationalVelocityY*elapsedTime;
		this.rotationZ += this.rotationalVelocityZ*elapsedTime;
		
		this.lastUpdateTime = currentTimeMillis;
	}
	
}

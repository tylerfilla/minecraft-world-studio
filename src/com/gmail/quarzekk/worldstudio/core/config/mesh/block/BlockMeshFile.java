package com.gmail.quarzekk.worldstudio.core.config.mesh.block;

import java.io.File;

import com.gmail.quarzekk.worldstudio.core.config.IConfigFile;

public class BlockMeshFile implements IConfigFile {
	
	/**
	 * The {@link File} that backs this MeshFile.
	 */
	private File file;
	
	/**
	 * The parsed block ID.
	 */
	private int blockId;
	
	/**
	 * The parsed block data.
	 */
	private int blockData;
	
	/**
	 * The parsed texture location.
	 */
	private String textureLocation;
	
	/**
	 * The parsed vertex data.
	 */
	private float[][] vertexData;
	
	private int vertexDataIndex;
	
	/**
	 * The parsed texcoord data.
	 */
	private float[][] texcoordData;
	
	private int texcoordDataIndex;
	
	/**
	 * Constructs a new MeshFile on the given {@link File}.
	 * @param file The File to back this MeshFile
	 */
	public BlockMeshFile(File file) {
		this.file = file;
		
		this.blockId = -1;
		this.blockData = -1;
		this.textureLocation = "";
		
		// Max of 128 vertices per mesh
		this.vertexData = new float[128][3];
		this.texcoordData = new float[128][2];
		
		this.vertexDataIndex = 0;
		this.texcoordDataIndex = 0;
	}
	
	@Override
	public File getFile() {
		return this.file;
	}
	
	/**
	 * Gets the parsed block ID.
	 * @return The parsed block ID
	 */
	public int getBlockId() {
		return this.blockId;
	}
	
	protected void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	/**
	 * Gets the parsed block data.
	 * @return The parsed block data
	 */
	public int getBlockData() {
		return this.blockData;
	}
	
	protected void setBlockData(int blockData) {
		this.blockData = blockData;
	}
	
	/**
	 * Gets the parsed texture location.
	 * @return The parsed texture tile U
	 */
	public String getTextureLocation() {
		return this.textureLocation;
	}
	
	protected void setTextureLocation(String textureLocation) {
		this.textureLocation = textureLocation;
	}
	
	/**
	 * Gets the parsed vertex data.
	 * @return The parsed vertex data
	 */
	public float[][] getVertexData() {
		return this.vertexData;
	}
	
	/**
	 * Gets the number of vertices added.
	 * @return The number of added vertices
	 */
	public int getNumVertices() {
		return this.vertexDataIndex;
	}
	
	protected void addVertexData(float[] vertex) {
		this.vertexData[this.vertexDataIndex++] = vertex;
	}
	
	/**
	 * Gets the parsed texcoord data.
	 * @return The parsed texcoord data
	 */
	public float[][] getTexcoordData() {
		return this.texcoordData;
	}
	
	/**
	 * Gets the number of texcoords added.
	 * @return The number of added texcoords
	 */
	public int getNumTexcoords() {
		return this.texcoordDataIndex;
	}
	
	protected void addTexcoordData(float[] texcoord) {
		this.texcoordData[this.texcoordDataIndex++] = texcoord;
	}
	
}

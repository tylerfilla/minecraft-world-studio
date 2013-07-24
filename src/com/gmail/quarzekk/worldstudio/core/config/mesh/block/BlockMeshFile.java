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
	 * The parsed texture tile U.
	 */
	private int textureTileU;
	
	/**
	 * The parsed texture tile V.
	 */
	private int textureTileV;
	
	/**
	 * The parsed texture tile span U.
	 */
	private int textureTileSpanU;
	
	/**
	 * The parsed texture tile span V.
	 */
	private int textureTileSpanV;
	
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
		this.textureTileU = -1;
		this.textureTileV = -1;
		this.textureTileSpanU = -1;
		this.textureTileSpanV = -1;
		
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
	 * Gets the parsed texture tile U.
	 * @return The parsed texture tile U
	 */
	public int getTextureTileU() {
		return this.textureTileU;
	}
	
	protected void setTextureTileU(int textureTileU) {
		this.textureTileU = textureTileU;
	}
	
	/**
	 * Gets the parsed texture tile V.
	 * @return The parsed texture tile V
	 */
	public int getTextureTileV() {
		return this.textureTileV;
	}
	
	protected void setTextureTileV(int textureTileV) {
		this.textureTileV = textureTileV;
	}
	
	/**
	 * Gets the parsed texture tile span U.
	 * @return The parsed texture tile span U
	 */
	public int getTextureTileSpanU() {
		return this.textureTileSpanU;
	}
	
	protected void setTextureTileSpanU(int textureTileSpanU) {
		this.textureTileSpanU = textureTileSpanU;
	}
	
	/**
	 * Gets the parsed texture tile span V.
	 * @return The parsed texture tile span V
	 */
	public int getTextureTileSpanV() {
		return this.textureTileSpanV;
	}
	
	protected void setTextureTileSpanV(int textureTileSpanV) {
		this.textureTileSpanV = textureTileSpanV;
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

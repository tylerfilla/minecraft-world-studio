package com.gmail.quarzekk.worldstudio.ui.render.mesh.block;

import com.gmail.quarzekk.worldstudio.core.config.mesh.block.BlockMeshFile;

public class BlockMesh {
	
	private float[][] vertices;
	
	private float[][] texcoords;
	
	private BlockMesh() {
	}
	
	public float[][] getVertices() {
		return this.vertices;
	}
	
	public void setVertices(float[][] vertices) {
		this.vertices = vertices;
	}
	
	public float[] getVertex(int index) {
		return this.vertices[index];
	}
	
	public void setVertex(int index, float[] vertex) {
		this.vertices[index] = vertex;
	}
	
	public float[][] getTexcoords() {
		return this.texcoords;
	}
	
	public void setTexcoords(float[][] texcoords) {
		this.texcoords = texcoords;
	}
	
	public float[] getTexcoord(int index) {
		return this.texcoords[index];
	}
	
	public void setTexcoord(int index, float[] texcoord) {
		this.texcoords[index] = texcoord;
	}
	
	public static BlockMesh fromBlockMeshFile(BlockMeshFile blockMeshFile) {
		BlockMesh blockMesh = new BlockMesh();
		
		blockMesh.vertices = new float[blockMeshFile.getNumVertices()][3];
		
		for (int i = 0; i < blockMesh.vertices.length; i++) {
			blockMesh.vertices[i] = blockMeshFile.getVertexData()[i];
		}
		
		blockMesh.texcoords = blockMeshFile.getTexcoordData();
		
		return blockMesh;
	}
	
}

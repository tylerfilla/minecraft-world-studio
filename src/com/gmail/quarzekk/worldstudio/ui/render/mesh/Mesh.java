package com.gmail.quarzekk.worldstudio.ui.render.mesh;

import com.gmail.quarzekk.worldstudio.core.config.blockmesh.BlockMeshFile;

/**
 * 
 * Represents a universal triangular mesh.
 *
 */
public class Mesh {
	
	/**
	 * The vertices that make up the mesh structure.
	 */
	private float[] vertices;
	
	/**
	 * The amount of vertices within this mesh.
	 */
	private int numVertices;
	
	/**
	 * The texture coordinates that align with the vertices to texture the
	 * mesh.
	 */
	private float[] texcoords;
	
	/**
	 * The amount of texture coordinates within this mesh.
	 */
	private int numTexcoords;
	
	private Mesh() {
	}

	/**
	 * Retrieves the full array of vertex data. This data is a one-dimensional
	 * float array in which every group of three floats, starting at index 0,
	 * represents a single vertex in the form of XYZ. As this mesh is
	 * triangular, every group of three vertices (every group of nine floats)
	 * makes up one triangle.
	 * @return The full vertex data array
	 */
	public float[] getVertexData() {
		return this.vertices;
	}
	
	/**
	 * Gets the number of vertices that make up this mesh. If the mesh is
	 * completely valid, this should not differ from the number of texture
	 * coordinates.
	 * @return The number of vertices within this mesh
	 */
	public int getNumVertices() {
		return this.numVertices;
	}

	/**
	 * Retrieves the full array of texture coordinate data. This data is a
	 * one-dimensional float array in which every group of two floats, starting
	 * at index 0, represents a single texture coordinate in the form of UV.
	 * These texture coordinates directly correspond to vertices. This is how
	 * one could get the texture coordinates for a known vertex:
	 * <p />
	 * <em>Let <strong><code>vertexDataIndex</code></strong> be an <code>int
	 * </code> representing the start index of the XYZ vertex data from <code>
	 * getVertexData()</code>.</em>
	 * <pre>
	 * int vertexIndex = <strong>vertexDataIndex</strong>/3; // Three floats per vertex
	 * int texcoordIndex = vertexIndex; // This is the direct correspondence
	 * int texcoordDataIndex = texcoordIndex*2; // Two floats per texture coordinate
	 * 
	 * // The following indices can be looked up in the data from <code>getTexcoordData()</code>
	 * float texcoordIndexU = texcoordDataIndex + 0;
	 * float texcoordIndexV = texcoordDataIndex + 1;
	 * </pre>
	 * @return The full texture coordinate data array
	 */
	public float[] getTexcoordData() {
		return this.texcoords;
	}
	
	/**
	 * Gets the number of texture coordinates that correspond to vertices. If
	 * the mesh is completely valid, this should not differ from the number of
	 * vertices.
	 * @return The number of texture coordinates within this mesh
	 */
	public int getNumTexcoords() {
		return this.numTexcoords;
	}
	
	/**
	 * Creates a new Mesh from a given representative mesh config file.
	 * @param meshConfigFile The mesh config file
	 * @return A new universal Mesh reflecting the given mesh config file
	 */
	public static Mesh fromMeshConfigFile(BlockMeshFile meshConfigFile) {
		Mesh mesh = new Mesh();
		
		mesh.vertices = meshConfigFile.getVertexData();
		mesh.texcoords = meshConfigFile.getTexcoordData();
		
		mesh.numVertices = meshConfigFile.getNumVertices();
		mesh.numTexcoords = meshConfigFile.getNumTexcoords();
		
		return mesh;
	}
	
}

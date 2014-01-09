package com.gmail.quarzekk.worldstudio.ui.render.mesh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MeshParser {
	
	private File meshFile;
	
	private boolean hasErrors;

	private HashMap<String, String[]> faces;
	private HashMap<String, Float[]> vertices;
	
	public MeshParser(File meshFile) {
		this.meshFile = meshFile;
		
		this.hasErrors = false;
		
		this.faces    = new HashMap<String, String[]>();
		this.vertices = new HashMap<String, Float[]>();
	}
	
	public void parse() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.meshFile));
		
		int lineNum = 0;
		String line = null;
		while ((line = reader.readLine()) != null) {
			lineNum++;
			line = line.trim();
			
			while (line.contains("#")) {
				line = line.substring(0, line.indexOf("#")).trim();
			}
			
			if (line.isEmpty()) {
				continue;
			}
			
			int mode = 0;
			int wait = 0;
			
			String[] components = line.split("[ \t]");
			for (int i = 0; i < components.length; i++) {
				if (wait > 0) {
					wait--;
					continue;
				}
				
				String component = components[i];
				
				if (component.isEmpty()) {
					continue;
				}
				
				if (component.equalsIgnoreCase("face") && mode == 0) {
					if (components.length < 4) {
						System.err.println("Improper number of arguments to 'face' on line " + lineNum + " of file \"" + this.meshFile.getPath() + ".\"");
						this.hasErrors = true;
						continue;
					}
					
					mode = 1;
					wait = 3;
					
					String faceName           = components[i + 1];
					String faceCancellableStr = components[i + 2];
					String faceDataStr        = components[i + 3];
					
					boolean faceCancellable = Boolean.parseBoolean(faceCancellableStr);
					String[] faceData       = faceDataStr.split(",");
				} else if (component.equalsIgnoreCase("vertex") && mode == 0) {
					if (components.length < 3) {
						System.err.println("Improper number of arguments to 'vertex' on line " + lineNum + " of file \"" + this.meshFile.getPath() + ".\"");
						this.hasErrors = true;
						continue;
					}
					
					mode = 2;
					wait = 2;
				} else {
					System.err.println("Unrecognized mode on line " + lineNum + " of file \"" + this.meshFile.getPath() + ".\"");
					this.hasErrors = true;
					continue;
				}
			}
		}
		
		if (this.hasErrors) {
			System.err.println("Parse of file \"" + this.meshFile.getPath() + "\" completed with errors; expect further malfunction.");
		}
		
		reader.close();
	}
	
	public boolean hasErrors() {
		return this.hasErrors;
	}
	
	public String[] getFaceGroups() {
		return this.faces.keySet().toArray(new String[this.faces.size()]);
	}
	
	public String[] getFaceVertices(String face) {
		return this.faces.get(face);
	}
	
	public Float[] getVertexCoords(String vertexId) {
		return this.vertices.get(vertexId);
	}
	
}

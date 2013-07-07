package com.gmail.quarzekk.worldstudio.core.config.mesh;

import java.io.File;

import com.gmail.quarzekk.worldstudio.core.config.IConfigFile;

public class MeshFile implements IConfigFile {
	
	private File file;
	
	public MeshFile(File file) {
		this.file = file;
	}
	
	@Override
	public File getFile() {
		return this.file;
	}
	
}

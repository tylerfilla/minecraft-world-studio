package com.gmail.quarzekk.worldstudio.core.config;

import java.io.File;

/**
 * 
 * Represents a configuration file of any format.
 *
 */
public interface IConfigFile {
	
	/**
	 * Gets the {@link File} that backs this IConfigFile.
	 * @return The File behind this IConfigFile
	 */
	public File getFile();
	
}

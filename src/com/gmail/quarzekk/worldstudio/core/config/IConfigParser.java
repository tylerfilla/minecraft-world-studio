package com.gmail.quarzekk.worldstudio.core.config;

import java.io.IOException;

/**
 * 
 * Represents a parser capable of extracting data from an {@link IConfigFile}.
 *
 */
public interface IConfigParser {
	
	/**
	 * Parses the contents of the {@link IConfigFile} and stores extracted
	 * data.
	 * @throws IOException If an I/O error occurs in the process (most likely
	 * while reading the file)
	 */
	public void parse() throws IOException;
	
}

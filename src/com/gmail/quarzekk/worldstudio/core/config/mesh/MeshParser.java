package com.gmail.quarzekk.worldstudio.core.config.mesh;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gmail.quarzekk.worldstudio.core.config.IConfigParser;

public class MeshParser implements IConfigParser {
	
	/**
	 * The MeshFile parsed by this MeshParser.
	 */
	private MeshFile meshFile;
	
	/**
	 * The current state of the parse procedure. This is used to create a
	 * context with which subsequent lines are parsed.
	 */
	private int parseState;
	
	public MeshParser(MeshFile meshFile) {
		this.meshFile = meshFile;
		this.parseState = 0;
	}
	
	/**
	 * Gets the {@link MeshFile} parsed by this MeshParser.
	 * @return The parsed MeshFile
	 */
	public MeshFile getMeshFile() {
		return this.meshFile;
	}
	
	/**
	 * Parses the contents of the mesh file and stores extracted data. It is
	 * necessary to parse the file prior to accessing any data.
	 * @throws IOException If an I/O error occurs while reading the mesh file
	 */
	public void parse() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.meshFile.getFile())));
		
		String line = null;
		int lineNum = 0;
		
		while ((line = reader.readLine()) != null) {
			lineNum++;
			line = line.trim();
			
			if (line.isEmpty() || line.startsWith("#")) {
				continue;
			}
			
			this.parseLine(line, lineNum);
		}
		
		reader.close();
	}
	
	/**
	 * Parses an individual line of the mesh file as provided by
	 * {@link MeshParser#parse()}.
	 * @param line The line to parse
	 */
	private void parseLine(String line, int lineNum) {
		if (this.parseState == 0) {
			if (line.length() >= 5 && line.substring(0, 5).equalsIgnoreCase("block")) {
				if (line.length() >= 8 && line.substring(6, 8).equalsIgnoreCase("id")) {
					String idString = line.substring(9);
					int id = -1;
					try {
						id = Integer.parseInt(idString);
					} catch (NumberFormatException e) {
						this.printLineError(e, "Could not parse block ID as integer", line, lineNum, 9);
					}
					this.meshFile.setBlockId(id);
				}
				if (line.length() >= 10 && line.substring(6, 10).equalsIgnoreCase("data")) {
					String dataString = line.substring(11);
					int data = -1;
					try {
						data = Integer.parseInt(dataString);
					} catch (NumberFormatException e) {
						this.printLineError(e, "Could not parse block data as integer", line, lineNum, 11);
					}
					this.meshFile.setBlockData(data);
				}
			}
			if (line.length() >= 7 && line.substring(0, 7).equalsIgnoreCase("texture")) {
				if (line.length() >= 13 && line.substring(8, 13).equalsIgnoreCase("tileU")) {
					String tileUString = line.substring(14);
					int tileU = -1;
					try {
						tileU = Integer.parseInt(tileUString);
					} catch (NumberFormatException e) {
						this.printLineError(e, "Could not parse texture tile U as integer", line, lineNum, 14);
					}
					this.meshFile.setTextureTileU(tileU);
				}
				if (line.length() >= 13 && line.substring(8, 13).equalsIgnoreCase("tileV")) {
					String tileVString = line.substring(14);
					int tileV = -1;
					try {
						tileV = Integer.parseInt(tileVString);
					} catch (NumberFormatException e) {
						this.printLineError(e, "Could not parse texture tile V as integer", line, lineNum, 14);
					}
					this.meshFile.setTextureTileV(tileV);
				}
				if (line.length() >= 16 && line.substring(8, 17).equalsIgnoreCase("tileSpanU")) {
					String tileSpanUString = line.substring(18);
					int tileSpanU = -1;
					try {
						tileSpanU = Integer.parseInt(tileSpanUString);
					} catch (NumberFormatException e) {
						this.printLineError(e, "Could not parse texture tile span U as integer", line, lineNum, 18);
					}
					this.meshFile.setTextureTileSpanU(tileSpanU);
				}
				if (line.length() >= 16 && line.substring(8, 17).equalsIgnoreCase("tileSpanV")) {
					String tileSpanVString = line.substring(18);
					int tileSpanV = -1;
					try {
						tileSpanV = Integer.parseInt(tileSpanVString);
					} catch (NumberFormatException e) {
						this.printLineError(e, "Could not parse texture tile span V as integer", line, lineNum, 18);
					}
					this.meshFile.setTextureTileSpanU(tileSpanV);
				}
			}
		}
	}
	
	/**
	 * Prints a formatted error string to STDERR.
	 * @param throwable The Throwable associated with the error
	 * @param message A message describing the error
	 * @param line The offending line
	 * @param lineNum The number of the line
	 * @param charNum The number of the character within the line at which the
	 * error occurs (-1 for the entire line)
	 */
	private void printLineError(Throwable throwable, String message, String line, int lineNum, int charNum) {
		System.err.println("An error occurred while parsing mesh file \"" + this.meshFile.getFile().getAbsolutePath() + "\"");
		System.err.println("Error: " + message);
		System.err.println(lineNum + ":\"" + line + "\"");
		
		if (charNum > -1) {
			System.err.print("+-");
			for (int i = 0; i < String.valueOf(lineNum).length(); i++) {
				System.err.print("-");
			}
			for (int i = 0; i < charNum; i++) {
				System.err.print("-");
			}
			System.err.println("^");
		}
		
		System.err.println();
		throwable.printStackTrace();
		System.err.println();
	}
	
}

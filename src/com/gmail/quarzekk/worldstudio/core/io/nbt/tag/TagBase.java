package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

/**
 * 
 * Represents a tag of all types.
 *
 */
public abstract class TagBase {
	
	/**
	 * The name of this tag.
	 */
	protected String name;
	
	/**
	 * The type of this tag.
	 */
	protected EnumTagType type;
	
	/**
	 * Gets the name of this tag.
	 * @return The name of this tag
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the type of this tag.
	 * @return The type of this tag
	 */
	public abstract EnumTagType getType();
	
	/**
	 * Writes this tag to the given DataOutput.
	 * @param output The DataOutput to which to write
	 */
	public abstract void writeData(DataOutput output) throws IOException;
	
	/**
	 * Reads and loads data from the given DataInput.
	 * @param input The DataInput from which to read
	 */
	public abstract void loadData(DataInput input) throws IOException;
	
	@Override
	public String toString() {
		return "TAG_Base('" + this.getName() + "')";
	}
	
}

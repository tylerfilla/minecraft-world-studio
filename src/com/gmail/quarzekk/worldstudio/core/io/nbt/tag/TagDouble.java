package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

/**
 * 
 * Represents a tag capable of holding a <code>double</code> value.
 *
 */
public class TagDouble extends TagBase {
	
	/**
	 * The value of this tag.
	 */
	private double value;
	
	/**
	 * Constructs a new TagDouble with default values.
	 */
	public TagDouble() {
		this(null, (double) 0);
	}
	
	/**
	 * Constructs a new TagDouble with the given name.
	 * @param name The name for this tag
	 */
	public TagDouble(String name) {
		this(name, (double) 0);
	}
	
	/**
	 * Constructs a new TagDouble with the given value.
	 * @param value The value for this tag
	 */
	public TagDouble(double value) {
		this(null, value);
	}
	
	/**
	 * Constructs a new TagDouble with the given name and value.
	 * @param name The name for this tag
	 * @param value The value for this tag
	 */
	public TagDouble(String name, double value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of this tag.
	 * @return The value of this tag
	 */
	public double getValue() {
		return this.value;
	}
	
	/**
	 * Sets the value of this tag to that of the given.
	 * @param value The desired value for this tag
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Double;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeDouble(this.value);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		this.value = input.readDouble();
	}
	
	@Override
	public String toString() {
		return "TAG_Double('" + this.getName() + "'): " + this.getValue();
	}
	
}

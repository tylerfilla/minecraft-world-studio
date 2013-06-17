package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

/**
 * 
 * Represents a tag capable of holding a <code>float</code> value.
 *
 */
public class TagFloat extends TagBase {
	
	/**
	 * The value of this tag.
	 */
	private float value;
	
	/**
	 * Constructs a new TagFloat with default values.
	 */
	public TagFloat() {
		this(null, (float) 0);
	}
	
	/**
	 * Constructs a new TagFloat with the given name.
	 * @param name The name for this tag
	 */
	public TagFloat(String name) {
		this(name, (float) 0);
	}
	
	/**
	 * Constructs a new TagFloat with the given value.
	 * @param value The value for this tag
	 */
	public TagFloat(float value) {
		this(null, value);
	}
	
	/**
	 * Constructs a new TagFloat with the given name and value.
	 * @param name The name for this tag
	 * @param value The value for this tag
	 */
	public TagFloat(String name, float value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of this tag.
	 * @return The value of this tag
	 */
	public float getValue() {
		return this.value;
	}
	
	/**
	 * Sets the value of this tag to that of the given.
	 * @param value The desired value for this tag
	 */
	public void setValue(float value) {
		this.value = value;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Float;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeFloat(this.value);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		this.value = input.readFloat();
	}
	
	@Override
	public String toString() {
		return "TAG_Float('" + this.getName() + "'): " + this.getValue();
	}
	
}

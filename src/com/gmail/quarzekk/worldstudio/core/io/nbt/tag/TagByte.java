package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

public class TagByte extends TagBase {
	
	/**
	 * The value of this tag.
	 */
	private byte value;
	
	/**
	 * Constructs a new TagByte with default values.
	 */
	public TagByte() {
		this(null, (byte) 0);
	}
	
	/**
	 * Constructs a new TagByte with the given name.
	 * @param name The name for this tag
	 */
	public TagByte(String name) {
		this(name, (byte) 0);
	}
	
	/**
	 * Constructs a new TagByte with the given.
	 * @param value The value for this tag
	 */
	public TagByte(byte value) {
		this(null, value);
	}
	
	/**
	 * Constructs a new TagByte with the given name and value.
	 * @param name The name for this tag
	 * @param value The value for this tag
	 */
	public TagByte(String name, byte value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of this tag.
	 * @return The value of this tag
	 */
	public byte getValue() {
		return this.value;
	}
	
	/**
	 * Sets the value of this tag to that of the given value.
	 * @param value The desired value for this tag
	 */
	public void setValue(byte value) {
		this.value = value;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Byte;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeByte(this.value);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		this.value = input.readByte();
	}
	
	@Override
	public String toString() {
		return "TAG_Byte('" + this.getName() + "'): " + this.getValue();
	}
	
}

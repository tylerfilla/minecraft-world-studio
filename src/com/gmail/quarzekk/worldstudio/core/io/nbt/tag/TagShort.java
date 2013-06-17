package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

public class TagShort extends TagBase {
	
	/**
	 * The value of this tag.
	 */
	private short value;
	
	/**
	 * Constructs a new TagShort with default values.
	 */
	public TagShort() {
		this(null, (short) 0);
	}
	
	/**
	 * Constructs a new TagShort with the given name.
	 * @param name The name for this tag
	 */
	public TagShort(String name) {
		this(name, (short) 0);
	}
	
	/**
	 * Constructs a new TagShort with the given value.
	 * @param value The value for this tag
	 */
	public TagShort(short value) {
		this(null, value);
	}
	
	/**
	 * Constructs a new TagShort with the given name and value.
	 * @param name The name for this tag
	 * @param value The value for this tag
	 */
	public TagShort(String name, short value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of this tag.
	 * @return The value of this tag
	 */
	public short getValue() {
		return this.value;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Short;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeShort(this.value);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		this.value = input.readShort();
	}
	
	@Override
	public String toString() {
		return "TAG_Short('" + this.getName() + "'): " + this.getValue();
	}
	
}

package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

public class TagInt extends TagBase {
	
	/**
	 * The value of this tag.
	 */
	private int value;
	
	/**
	 * Constructs a new TagInt with default values.
	 */
	public TagInt() {
		this(null, (int) 0);
	}
	
	/**
	 * Constructs a new TagInt with the given name.
	 * @param name The name for this tag
	 */
	public TagInt(String name) {
		this(name, (int) 0);
	}
	
	/**
	 * Constructs a new TagInt with the given value.
	 * @param value The value for this tag
	 */
	public TagInt(int value) {
		this(null, value);
	}
	
	/**
	 * Constructs a new TagInt with the given name and value.
	 * @param name The name for this tag
	 * @param value The value for this tag
	 */
	public TagInt(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of this tag.
	 * @return The value of this tag
	 */
	public int getValue() {
		return this.value;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Int;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeInt(this.value);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		this.value = input.readInt();
	}
	
	@Override
	public String toString() {
		return "TAG_Int('" + this.getName() + "'): " + this.getValue();
	}
	
}

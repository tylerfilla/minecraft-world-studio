package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

public class TagLong extends TagBase {
	
	/**
	 * The value of this tag.
	 */
	private long value;
	
	/**
	 * Constructs a new TagLong with default values.
	 */
	public TagLong() {
		this(null, (long) 0);
	}
	
	/**
	 * Constructs a new TagLong with the given name.
	 * @param name The name for this tag
	 */
	public TagLong(String name) {
		this(name, (long) 0);
	}
	
	/**
	 * Constructs a new TagLong with the given value.
	 * @param value The value for this tag
	 */
	public TagLong(long value) {
		this(null, value);
	}
	
	/**
	 * Constructs a new TagLong with the given name and value.
	 * @param name The name for this tag
	 * @param value The value for this tag
	 */
	public TagLong(String name, long value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of this tag.
	 * @return The value of this tag
	 */
	public long getValue() {
		return this.value;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Long;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeLong(this.value);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		this.value = input.readLong();
	}
	
	@Override
	public String toString() {
		return "TAG_Long('" + this.getName() + "'): " + this.getValue();
	}
	
}

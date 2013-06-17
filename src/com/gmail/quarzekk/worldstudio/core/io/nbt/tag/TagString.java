package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

public class TagString extends TagBase {
	
	/**
	 * The value of this tag.
	 */
	private String value;
	
	/**
	 * Constructs a new TagString with default values.
	 */
	public TagString() {
		this(null, null);
	}
	
	/**
	 * Constructs a new TagString with the given name.
	 * @param name The name for this tag
	 */
	public TagString(String name) {
		this.name = name;
	}
	
	/**
	 * Constructs a new TagString with the given name and value.
	 * @param name The name for this tag
	 * @param value The value for this tag
	 */
	public TagString(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of this tag.
	 * @return The value of this tag
	 */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Sets the value of this tag to that of the given.
	 * @param value The desired value for this tag
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_String;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeUTF(this.value);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		this.value = input.readUTF();
	}
	
	@Override
	public String toString() {
		return "TAG_String('" + this.getName() + "'): '" + this.value + "'";
	}
	
}

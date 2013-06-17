package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

/**
 * 
 * Represents a tag capable of holding <code>byte[]</code> data.
 *
 */
public class TagByteArray extends TagBase {
	
	/**
	 * The data of this tag.
	 */
	private byte[] data;
	
	/**
	 * Constructs a new TagByteArray with no data.
	 */
	public TagByteArray() {
		this(null, new byte[0]);
	}
	
	/**
	 * Constructs a new TagByteArray with the given name.
	 * @param name The name for this tag
	 */
	public TagByteArray(String name) {
		this.name = name;
	}
	
	/**
	 * Constructs a new TagByteArray with the given name and data.
	 * @param name The name for this tag
	 * @param data The data for this tag
	 */
	public TagByteArray(String name, byte[] data) {
		this.name = name;
		this.data = data;
	}
	
	/**
	 * Gets the data of this tag.
	 * @return The data of this tag
	 */
	public byte[] getData() {
		return this.data;
	}
	
	/**
	 * Sets the data of this tag to that of the given.
	 * @param data The desired data for this tag
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Byte_Array;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeInt(this.data.length);
		output.write(this.data);
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		int length = input.readInt();
		this.data = new byte[length];
		input.readFully(this.data);
	}
	
	@Override
	public String toString() {
		return "TAG_Byte_Array('" + this.getName() + "'): [" + this.getData().length + " bytes]"; 
	}
	
}

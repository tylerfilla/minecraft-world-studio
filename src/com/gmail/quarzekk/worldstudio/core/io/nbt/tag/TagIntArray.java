package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

/**
 * 
 * Represents a tag capable of holding <code>int[]</code> data.
 *
 */
public class TagIntArray extends TagBase {
	
	/**
	 * The data of this tag.
	 */
	private int[] data;
	
	/**
	 * Constructs a new TagIntArray with no data.
	 */
	public TagIntArray() {
		this(null, new int[0]);
	}
	
	/**
	 * Constructs a new TagIntArray with the given name.
	 * @param name The name for this tag
	 */
	public TagIntArray(String name) {
		this.name = name;
	}
	
	/**
	 * Constructs a new TagIntArray with the given name and data.
	 * @param name The name for this tag
	 * @param data The data for this tag
	 */
	public TagIntArray(String name, int[] data) {
		this.name = name;
		this.data = data;
	}
	
	/**
	 * Gets the data of this tag.
	 * @return The data of this tag
	 */
	public int[] getData() {
		return this.data;
	}
	
	/**
	 * Sets the data of this tag to that of the given.
	 * @param data The desired data for this tag
	 */
	public void setData(int[] data) {
		this.data = data;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Int_Array;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeInt(this.data.length);
		
		for (int i = 0; i < this.data.length; i++) {
			output.writeInt(i);
		}
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		int length = input.readInt();
		
		this.data = new int[length];
		for (int i = 0; i < length; i++) {
			this.data[i] = input.readInt();
		}
	}
	
	@Override
	public String toString() {
		return "TAG_Int_Array('" + this.getName() + "'): [" + this.getData().length + " ints]"; 
	}
	
}

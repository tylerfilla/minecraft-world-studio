package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

/**
 * 
 * Represents a tag similar to TAG_Compound that contains nameless tags of a
 * single type. This is much like an array in most programming languages.
 *
 */
public class TagList extends TagBase {
	
	/**
	 * The type of tag that this list contains.
	 */
	private EnumTagType listType;
	
	/**
	 * This list's children tags.
	 */
	private ArrayList<TagBase> children;
	
	/**
	 * Constructs a new TagCompound.
	 */
	public TagList() {
		this(null);
	}
	
	/**
	 * Constructs a new TagList with the given name.
	 * @param name The name for this tag
	 */
	public TagList(String name) {
		this.name = name;
		this.children = new ArrayList<TagBase>();
	}
	
	/**
	 * Gets all children tags contained within this list.
	 * @return An ArrayList of contained TagBases in the form of a Collection
	 */
	public Collection<TagBase> getChildren() {
		return this.children;
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_List;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		output.writeByte(this.listType.getTypeId());
		output.writeInt(this.children.size());
		
		for (TagBase tag : this.children) {
			tag.writeData(output);
		}
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		int listTypeId = input.readByte();
		int listLength = input.readInt();
		
		this.listType = EnumTagType.fromTypeId(listTypeId);
		
		for (int i = 0; i < listLength; i++) {
			TagBase tag = null;
			
			try {
				tag = (TagBase) this.listType.getTagClass().getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
			if (tag != null && tag.getType() != EnumTagType.TAG_End) {
				tag.loadData(input);
				this.children.add(tag);
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("TAG_List");
		builder.append("('").append(this.getName()).append("')");

		if (this.children.size() == 1) {
			builder.append(": 1 entry");
		} else {
			builder.append(": ").append(this.children.size()).append(" entries");
		}
		
		builder.append(System.lineSeparator());
		
		builder.append("{").append(System.lineSeparator());
		if (this.children.size() > 0) {
			for (TagBase tag : this.children) {
				String tagString = tag.toString();
				if (tagString.endsWith(System.lineSeparator())) {
					tagString = tagString.substring(0, tagString.length() - 2);
				}
				tagString = tagString.replaceAll(System.lineSeparator(), System.lineSeparator() + '\t');
				builder.append('\t').append(tagString).append(System.lineSeparator());
			}
		} else {
			builder.append('\t').append("[ NONE ]").append(System.lineSeparator());
		}
		builder.append("}").append(System.lineSeparator());
		
		return builder.toString();
	}
	
}

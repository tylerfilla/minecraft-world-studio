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
 * Represents a tag capable of holding numerous other tags.
 *
 */
public class TagCompound extends TagBase {
	
	/**
	 * This compound's children tags.
	 */
	private ArrayList<TagBase> children;
	
	/**
	 * Constructs a new TagCompound.
	 */
	public TagCompound() {
		this(null);
	}
	
	/**
	 * Constructs a new TagCompound with the given name.
	 * @param name The name for this tag
	 */
	public TagCompound(String name) {
		this.name = name;
		this.children = new ArrayList<TagBase>();
	}
	
	/**
	 * Gets the first child by the given name.
	 * @param name The name to search for
	 * @return The child tag resulting from the search
	 */
	public TagBase getFirstChild(String name) {
		for (TagBase tag : this.children) {
			if (tag.getName().equals(name)) {
				return tag;
			}
		}
		return null;
	}
	
	/**
	 * Gets all children tags contained within this compound.
	 * @return An ArrayList of contained TagBases in the form of a
	 *         		parameterized Collection
	 */
	public Collection<TagBase> getChildren() {
		return this.children;
	}
	
	/**
	 * Adds a child tag to this compound.
	 * @param child The child tag to add to this compound
	 */
	public void addChild(TagBase child) {
		this.children.add(child);
	}
	
	/**
	 * Removes a child tag from this compound.
	 * @param child The child tag to be removed from this compound
	 */
	public void removeChild(TagBase child) {
		this.children.remove(child);
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_Compound;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
		for (TagBase tag : this.children) {
			output.writeByte(tag.getType().getTypeId());
			
			if (tag.getType() != EnumTagType.TAG_End) {
				output.writeUTF(tag.getName());
				tag.writeData(output);
			}
		}
		
		output.writeByte(EnumTagType.TAG_End.getTypeId());
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
		TagBase tag = null;
		
		while (true) {
			int tagTypeId = input.readByte();
			EnumTagType tagType = EnumTagType.fromTypeId(tagTypeId);
			
			if (tagType != null) {
				if (tagType != EnumTagType.TAG_End) {
					String tagName = input.readUTF();
					
					try {
						tag = (TagBase) tagType.getTagClass().getConstructor(String.class).newInstance(tagName);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}
				} else {
					tag = (TagBase) new TagEnd();
				}
			}
			
			if (tag != null && tag.getType() != EnumTagType.TAG_End) {
				tag.loadData(input);
				this.children.add(tag);
			} else {
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("TAG_Compound");
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
					tagString = tagString.replaceAll(System.lineSeparator(), System.lineSeparator() + '\t');
				}
				builder.append('\t').append(tagString).append(System.lineSeparator());
			}
		} else {
			builder.append('\t').append("[ NONE ]").append(System.lineSeparator());
		}
		builder.append("}").append(System.lineSeparator());
		
		return builder.toString();
	}
	
}

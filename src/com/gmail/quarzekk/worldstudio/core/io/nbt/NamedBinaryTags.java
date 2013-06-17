package com.gmail.quarzekk.worldstudio.core.io.nbt;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagBase;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagEnd;

/**
 * 
 * Provides methods for manipulating tags within various sources.
 *
 */
public class NamedBinaryTags {
	
	/**
	 * Writes an NBT tag of any type to the given output stream.
	 * @param tag The tag to write to the output stream
	 * @param outputStream The output stream to which to write
	 * @throws IOException
	 */
	public static void writeTagToStream(TagBase tag, OutputStream outputStream) throws IOException {
		DataOutput output = null;
		
		if (outputStream instanceof DataOutputStream) {
			output = (DataOutputStream) outputStream;
		} else {
			output = new DataOutputStream(outputStream);
		}
		
		output.writeByte(tag.getType().getTypeId());
		
		if (tag.getType() != EnumTagType.TAG_End) {
			output.writeUTF(tag.getName());
		}
		
		tag.writeData(output);
	}
	
	/**
	 * Reads an NBT tag of any type from the given input stream.
	 * @param inputStream The input stream from which to read
	 * @return The tag read from the input stream
	 * @throws IOException
	 */
	public static TagBase readTagFromStream(InputStream inputStream) throws IOException {
		DataInput input = null;
		
		if (inputStream instanceof DataInputStream) {
			input = (DataInputStream) inputStream;
		} else {
			input = new DataInputStream(inputStream);
		}
		
		int tagTypeId = input.readByte();
		String tagName = null;
		
		TagBase tag = null;
		
		EnumTagType tagType = EnumTagType.fromTypeId(tagTypeId);
		if (tagType != null) {
			if (tagType != EnumTagType.TAG_End) {
				tagName = input.readUTF();
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
			return tag;
		} else {
			return null;
		}
	}
	
}

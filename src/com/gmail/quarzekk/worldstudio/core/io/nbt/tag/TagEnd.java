package com.gmail.quarzekk.worldstudio.core.io.nbt.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import com.gmail.quarzekk.worldstudio.core.io.nbt.EnumTagType;

public class TagEnd extends TagBase {
	
	/**
	 * Constructs a new TagEnd used to signify the end of a compound.
	 */
	public TagEnd() {
	}
	
	@Override
	public EnumTagType getType() {
		return EnumTagType.TAG_End;
	}
	
	@Override
	public void writeData(DataOutput output) throws IOException {
	}
	
	@Override
	public void loadData(DataInput input) throws IOException {
	}
	
	@Override
	public String toString() {
		return "TAG_End";
	}
	
}

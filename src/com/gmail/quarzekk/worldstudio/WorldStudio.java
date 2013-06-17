package com.gmail.quarzekk.worldstudio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import com.gmail.quarzekk.worldstudio.core.io.nbt.NamedBinaryTags;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagCompound;

public class WorldStudio {
	
	public static WorldStudio instance;
	
	public WorldStudio() {
	}
	
	public void start() {
		try {
			//TagCompound compound = NamedBinaryTags.readCompoundFromStream(new GZIPInputStream(new FileInputStream("C:\\Users\\Tyler\\Development\\nbt\\bigtest.nbt")));
			TagCompound compound = NamedBinaryTags.readCompoundFromStream(new GZIPInputStream(new FileInputStream("C:\\Users\\Tyler\\Development\\nbt\\test.nbt")));
			//System.out.println(compound);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WorldStudio.instance = new WorldStudio();
		WorldStudio.instance.start();
	}
	
}

package com.gmail.quarzekk.worldstudio.core.io.nbt;

import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagBase;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagByte;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagByteArray;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagCompound;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagDouble;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagEnd;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagFloat;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagInt;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagIntArray;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagList;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagLong;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagShort;
import com.gmail.quarzekk.worldstudio.core.io.nbt.tag.TagString;

/**
 * 
 * An enum structure providing NBT type representation data.
 *
 */
public enum EnumTagType {
	
	/**
	 * A tag used to signify the end of a compound. This tag is a special case
	 * in that it is never named and must be treated in a different matter to
	 * the other tags.
	 */
	TAG_End(0, TagEnd.class),
	
	/**
	 * A tag containing a byte value. 
	 */
	TAG_Byte(1, TagByte.class),
	
	/**
	 * A tag containing a short integer value (2 bytes).
	 */
	TAG_Short(2, TagShort.class),
	
	/**
	 * A tag containing an integer value (4 bytes).
	 */
	TAG_Int(3, TagInt.class),
	
	/**
	 * A tag containing a long integer value (8 bytes).
	 */
	TAG_Long(4, TagLong.class),
	
	/**
	 * A tag containing a floating-point integer value.
	 */
	TAG_Float(5, TagFloat.class),
	
	/**
	 * A tag containing a double-precision floating-point integer value.
	 */
	TAG_Double(6, TagDouble.class),
	
	/**
	 * A tag containing an array of up to 65536 bytes.
	 */
	TAG_Byte_Array(7, TagByteArray.class),
	
	/**
	 * A tag containing a string value.
	 */
	TAG_String(8, TagString.class),
	
	/**
	 * A tag containing a list of unnamed similar tags.
	 */
	TAG_List(9, TagList.class),
	
	/**
	 * A compound tag capable of holding named tags of any type.
	 */
	TAG_Compound(10, TagCompound.class),
	
	/**
	 * A tag containing an array of up to 65536 integers.
	 */
	TAG_Int_Array(11, TagIntArray.class),
	
	;
	
	/**
	 * This tag type's unique ID.
	 */
	private int typeId;
	
	/**
	 * The class of the tag with this type.
	 */
	private Class<TagBase> tagClass;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private EnumTagType(int typeId, Class tagClass) {
		this.typeId = typeId;
		this.tagClass = (Class<TagBase>) tagClass;
	}
	
	/**
	 * Gets this tag type's unique ID.
	 * @return This tag type's unique ID
	 */
	public int getTypeId() {
		return this.typeId;
	}
	
	/**
	 * Gets the class of the tag with this type.
	 * @return The class of this tag with this type
	 */
	public Class<TagBase> getTagClass() {
		return this.tagClass;
	}
	
	/**
	 * Gets the EnumTagType corresponding to the given type ID.
	 * @param typeId The ID of the type to search for
	 * @return The type if a one was found, else null
	 */
	public static EnumTagType fromTypeId(int typeId) {
		for (EnumTagType type : values()) {
			if (type.getTypeId() == typeId) {
				return type;
			}
		}
		return null;
	}
	
}

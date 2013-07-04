package com.gmail.quarzekk.worldstudio.world;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * A universal package of world information created by a save handler.
 *
 */
public class WorldInformation {
	
	/**
	 * Represents an empty set of world information.
	 */
	public static final WorldInformation EMPTY = new WorldInformation();
	
	/**
	 * A map of miscellaneous data required by the save handler processing this
	 * WorldInformation.
	 */
	private Map<String, Object> miscData;
	
	/**
	 * Constructs a new WorldInformation with no data.
	 */
	public WorldInformation() {
		this.miscData = new HashMap<String, Object>();
	}
	
	/**
	 * Gets a miscellaneous data value previously stored in this
	 * WorldInformation under the given key.
	 * @param key The key the value was stored under
	 * @return The value stored under the given key
	 */
	public Object getMiscData(String key) {
		return this.miscData.get(key);
	}
	
	/**
	 * Stores a miscellaneous data value in this WorldInformation. This data
	 * can represent anything required by the save handler that is not
	 * necessarily required by the program itself.
	 * @param key The key to store this value under
	 * @param value The value to store
	 */
	public void setMiscData(String key, Object value) {
		this.miscData.put(key, value);
	}
	
}

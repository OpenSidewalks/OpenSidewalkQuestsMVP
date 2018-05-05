package de.tcat.opensidewalks.data.osm.changes;

import java.util.Map;

public interface StringMapEntryChange
{
	void applyTo(Map<String,String> map);
	String toString();
	boolean conflictsWith(Map<String,String> map);
	boolean equals(Object other);
	StringMapEntryChange reversed();
}

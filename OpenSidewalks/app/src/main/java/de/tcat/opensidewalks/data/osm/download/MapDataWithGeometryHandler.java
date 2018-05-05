package de.tcat.opensidewalks.data.osm.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import de.tcat.opensidewalks.data.osm.ElementGeometry;
import de.westnordost.osmapi.map.data.Element;

public interface MapDataWithGeometryHandler
{
	void handle(@NonNull Element element, @Nullable ElementGeometry geometry);
}

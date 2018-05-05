package de.tcat.opensidewalks.data.osm.persist.test;

import android.os.Bundle;

import java.util.Map;

import de.tcat.opensidewalks.data.osm.OsmElementQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.westnordost.osmapi.map.data.BoundingBox;
import de.westnordost.osmapi.map.data.Element;
import de.tcat.opensidewalks.data.osm.download.MapDataWithGeometryHandler;

public class TestQuestType2 implements OsmElementQuestType
{
	@Override public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes) { }
	@Override public String getCommitMessage() { return null; }
	@Override public boolean download(BoundingBox bbox, MapDataWithGeometryHandler handler)
	{
		return false;
	}
	@Override public AbstractQuestAnswerFragment createForm()
	{
		return null;
	}
	@Override public int getIcon() { return 0; }
	@Override public int getTitle() { return 0; }
	@Override public int getTitle(Map<String,String> tags) { return 0; }
	@Override public boolean appliesTo(Element element) { return false; }
}
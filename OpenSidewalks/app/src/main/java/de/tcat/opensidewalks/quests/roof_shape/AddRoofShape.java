package de.tcat.opensidewalks.quests.roof_shape;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;

public class AddRoofShape extends SimpleOverpassQuestType
{
	@Inject public AddRoofShape(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "ways, relations with roof:levels and roof:levels!=0 and !roof:shape";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new AddRoofShapeForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		ArrayList<String> values = answer.getStringArrayList(AddRoofShapeForm.OSM_VALUES);
		if(values != null  && values.size() == 1)
		{
			changes.add("roof:shape", values.get(0));
		}
	}

	@Override public String getCommitMessage() { return "Add roof shapes"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_roof_shape; }
	@Override public int getTitle(Map<String, String> tags)
	{
		return de.tcat.opensidewalks.R.string.quest_roofShape_title;
	}
}

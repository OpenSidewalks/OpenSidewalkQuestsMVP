package de.tcat.opensidewalks.quests.recycling;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.R;
import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;

public class AddRecyclingType extends SimpleOverpassQuestType
{
	@Inject public AddRecyclingType(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return " nodes, ways, relations with " +
				" amenity = recycling" +
				" and !recycling_type";
	}

	@Override public AddRecyclingTypeForm createForm()
	{
		return new AddRecyclingTypeForm();
	}

	@Override public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		ArrayList<String> values = answer.getStringArrayList(AddRecyclingTypeForm.OSM_VALUES);
		String recycling = values.get(0);

		switch (recycling) {
			case "centre":
				changes.add("recycling_type", "centre");
				break;
			case "overground":
				changes.add("recycling_type", "container");
				changes.add("location", "overground");
				break;
			case "underground":
				changes.add("recycling_type", "container");
				changes.add("location", "underground");
				break;
			default:
				break;
		}
	}

	@Override public String getCommitMessage() { return "Add recycling type to recycling amenity"; }
	@Override public int getIcon() { return R.drawable.ic_quest_recycling; }
	@Override public int getTitle(Map<String, String> tags)
	{
		return R.string.quest_recycling_type_title;
	}
}

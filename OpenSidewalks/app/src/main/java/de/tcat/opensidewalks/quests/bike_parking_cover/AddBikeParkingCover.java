package de.tcat.opensidewalks.quests.bike_parking_cover;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class AddBikeParkingCover extends SimpleOverpassQuestType
{
	@Inject public AddBikeParkingCover(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "nodes, ways with amenity=bicycle_parking and access!=private and !covered and bicycle_parking !~ shed|lockers|building";
	}

	public AbstractQuestAnswerFragment createForm() { return new YesNoQuestAnswerFragment(); }

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("covered", yesno);
	}

	@Override public String getCommitMessage() { return "Add bicycle parkings cover"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_bicycle_parking_cover; }
	@Override public int getTitle(Map<String,String> tags)
	{
		return de.tcat.opensidewalks.R.string.quest_bicycleParkingCoveredStatus_title;
	}
}
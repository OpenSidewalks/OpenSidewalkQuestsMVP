package de.tcat.opensidewalks.quests.curb_ramps;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class AnnotateCurbRamps extends SimpleOverpassQuestType
{
	@Inject public AnnotateCurbRamps(OverpassMapDataDao overpassServer)
	{ super(overpassServer); }

	@Override protected String getTagFilters()
	{
		//return "nodes, ways with "(("footway"="crossing") "and" ("kerb"="lowered"))";

		return "nodes with (" +
				"(highway=crossing) and (footway=sidewalk)" + ")";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new YesNoQuestAnswerFragment();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("curb_ramps", yesno);
	}

	@Override public String getCommitMessage() { return "Add curb ramps"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_street_surface_paved_detail; }
	@Override public int getTitle(Map<String, String> tags)
	{
		boolean hasName = tags.containsKey("name");
		if(hasName) return de.tcat.opensidewalks.R.string.quest_curb_ramps;
		else        return de.tcat.opensidewalks.R.string.quest_curb_ramps;
	}
}

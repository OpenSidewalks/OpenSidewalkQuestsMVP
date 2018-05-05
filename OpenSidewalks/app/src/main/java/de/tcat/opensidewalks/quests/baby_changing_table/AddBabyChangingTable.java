package de.tcat.opensidewalks.quests.baby_changing_table;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class AddBabyChangingTable extends SimpleOverpassQuestType
{
	@Inject public AddBabyChangingTable(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "nodes, ways with (" +
				"((amenity ~ restaurant|cafe|fuel|fast_food or shop ~ mall|department_store) and name and toilets=yes)" +
				" or amenity=toilets" +
				") and !diaper";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new YesNoQuestAnswerFragment();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("diaper", yesno);
	}

	@Override public String getCommitMessage() { return "Add baby changing table"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_baby; }
	@Override public int getTitle(Map<String, String> tags)
	{
		boolean hasName = tags.containsKey("name");
		if(hasName) return de.tcat.opensidewalks.R.string.quest_baby_changing_table_title;
		else        return de.tcat.opensidewalks.R.string.quest_baby_changing_table_toilets_title;
	}
}

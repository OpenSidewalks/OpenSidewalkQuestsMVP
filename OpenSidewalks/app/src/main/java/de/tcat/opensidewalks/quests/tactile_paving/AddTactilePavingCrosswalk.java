package de.tcat.opensidewalks.quests.tactile_paving;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class AddTactilePavingCrosswalk extends SimpleOverpassQuestType
{
	@Inject public AddTactilePavingCrosswalk(OverpassMapDataDao overpassServer)
	{
		super(overpassServer);
	}

	@Override protected String getTagFilters()
	{
		return "nodes with highway=crossing and !tactile_paving";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new TactilePavingCrosswalkForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("tactile_paving", yesno);
	}

	@Override public String getCommitMessage() { return "Add tactile pavings on crosswalks"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_blind_pedestrian_crossing; }
	@Override public int getTitle(Map<String, String> tags)
	{
		return de.tcat.opensidewalks.R.string.quest_tactilePaving_title_crosswalk;
	}
}

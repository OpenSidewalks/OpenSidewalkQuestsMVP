package de.tcat.opensidewalks.quests.tactile_paving;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class AddTactilePavingBusStop extends SimpleOverpassQuestType
{
	@Inject public AddTactilePavingBusStop(OverpassMapDataDao overpassServer)
	{
		super(overpassServer);
	}

	@Override protected String getTagFilters()
	{
		return "nodes with (public_transport=platform or (highway=bus_stop and public_transport!=stop_position)) and !tactile_paving";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new TactilePavingBusStopForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("tactile_paving", yesno);
	}

	@Override public String getCommitMessage() { return "Add tactile pavings on bus stops"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_blind_bus; }
	@Override public int getTitle(Map<String,String> tags)
	{
		boolean hasName = tags.containsKey("name");
		if(hasName) return de.tcat.opensidewalks.R.string.quest_tactilePaving_title_name_bus;
		else        return de.tcat.opensidewalks.R.string.quest_tactilePaving_title_bus;
	}
}

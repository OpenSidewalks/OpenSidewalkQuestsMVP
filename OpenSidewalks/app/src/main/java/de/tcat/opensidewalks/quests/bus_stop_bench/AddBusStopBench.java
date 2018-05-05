package de.tcat.opensidewalks.quests.bus_stop_bench;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class AddBusStopBench extends SimpleOverpassQuestType
{
	@Inject public AddBusStopBench(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "nodes with (public_transport=platform or (highway=bus_stop and public_transport!=stop_position)) and !bench";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new YesNoQuestAnswerFragment();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
		changes.add("bench", yesno);
	}

	@Override public String getCommitMessage() { return "Add bus stop bench"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_bus; }
	@Override public int getTitle(Map<String, String> tags)
	{
		boolean hasName = tags.containsKey("name");
		if(hasName)
			return de.tcat.opensidewalks.R.string.quest_busStopBench_name_title;
		else        return de.tcat.opensidewalks.R.string.quest_busStopBench_title;
	}
}

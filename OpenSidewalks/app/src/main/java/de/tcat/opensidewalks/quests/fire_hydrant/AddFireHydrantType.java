package de.tcat.opensidewalks.quests.fire_hydrant;

import android.os.Bundle;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;

public class AddFireHydrantType extends SimpleOverpassQuestType
{
	@Inject public AddFireHydrantType(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override protected String getTagFilters()
	{
		return "nodes with emergency=fire_hydrant and !fire_hydrant:type";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new AddFireHydrantTypeForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		List<String> values = answer.getStringArrayList(AddFireHydrantTypeForm.OSM_VALUES);
		if(values != null  && values.size() == 1)
		{
			changes.add("fire_hydrant:type", values.get(0));
		}
	}

	@Override public String getCommitMessage() { return "Add fire hydrant type"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_fire_hydrant; }
	@Override public int getTitle(Map<String,String> tags)
	{
		return de.tcat.opensidewalks.R.string.quest_fireHydrant_type_title;
	}
}

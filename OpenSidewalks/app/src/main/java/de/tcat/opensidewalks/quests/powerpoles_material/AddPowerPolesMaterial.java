package de.tcat.opensidewalks.quests.powerpoles_material;

import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;

public class AddPowerPolesMaterial extends SimpleOverpassQuestType
{
	@Inject public AddPowerPolesMaterial(OverpassMapDataDao overpassServer)
	{
		super(overpassServer);
	}

	@Override
	protected String getTagFilters()
	{
		return "nodes with power=pole and !material";
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new AddPowerPolesMaterialForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		List<String> values = answer.getStringArrayList(AddPowerPolesMaterialForm.OSM_VALUES);
		if(values != null  && values.size() == 1)
		{
			changes.add("material", values.get(0));
		}
	}

	@Override public String getCommitMessage() { return "Add powerpoles material type"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_power; }
	@Override public int getTitle(@NonNull Map<String, String> tags)
	{
		return de.tcat.opensidewalks.R.string.quest_powerPolesMaterial_title;
	}
}

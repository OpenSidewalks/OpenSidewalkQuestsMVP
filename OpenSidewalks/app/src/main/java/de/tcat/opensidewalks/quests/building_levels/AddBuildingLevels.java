package de.tcat.opensidewalks.quests.building_levels;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;

public class AddBuildingLevels extends SimpleOverpassQuestType
{
	@Inject public AddBuildingLevels(OverpassMapDataDao overpassServer) { super(overpassServer); }

	@Override
	protected String getTagFilters()
	{
		return " ways, relations with " +
		       " building ~ house|residential|apartments|detached|terrace|farm|hotel|dormitory|houseboat|" +
							"school|civic|college|university|public|hospital|kindergarten|transportation|train_station|"+
							"retail|commercial|warehouse|industrial|manufacture" +
		       " and !building:levels and !height and !building:height";
		// building:height is undocumented, but used the same way as height and currently over 50k times
	}

	public AbstractQuestAnswerFragment createForm()
	{
		return new AddBuildingLevelsForm();
	}

	public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
	{
		changes.add("building:levels", ""+answer.getInt(AddBuildingLevelsForm.BUILDING_LEVELS));

		// only set the roof levels if the user supplied that in the form
		int roofLevels = answer.getInt(AddBuildingLevelsForm.ROOF_LEVELS,-1);
		if(roofLevels != -1)
		{
			changes.addOrModify("roof:levels", "" + roofLevels);
		}
	}

	@Override public String getCommitMessage() { return "Add building and roof levels"; }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_building_levels; }
	@Override public int getTitle(Map<String,String> tags)
	{
		boolean isBuildingPart = tags.containsKey("building:part");
		if(isBuildingPart) return de.tcat.opensidewalks.R.string.quest_buildingLevels_title_buildingPart;
		else               return de.tcat.opensidewalks.R.string.quest_buildingLevels_title;
	}
}

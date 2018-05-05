package de.tcat.opensidewalks.quests.crossing_markings;

import android.os.Bundle;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.R;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;

public class AddCrossingMarkings extends SimpleOverpassQuestType
{
    @Inject public AddCrossingMarkings(OverpassMapDataDao overpassServer) { super(overpassServer); }

    @Override
    protected String getTagFilters() { return "nodes with highway=crossing and !crossing"; }

    public AbstractQuestAnswerFragment createForm()
    {
        return new AddCrossingMarkingsForm();
    }

    public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
    {
        List<String> values = answer.getStringArrayList(AddCrossingMarkingsForm.OSM_VALUES);
        if(values != null  && values.size() == 1)
        {

            changes.add("crossing", values.get(0));
        }
    }

    @Override public String getCommitMessage() { return "Add crossing type"; }
    @Override public int getIcon() { return R.drawable.ic_quest_pedestrian_crossing; }
	@Override public int getTitle(Map<String, String> tags)
	{
		return R.string.quest_crossing_type_title;
	}
}

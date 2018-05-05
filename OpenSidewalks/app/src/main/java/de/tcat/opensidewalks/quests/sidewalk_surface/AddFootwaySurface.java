package de.tcat.opensidewalks.quests.sidewalk_surface;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.R;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;

/**
 * Created by Neelam Purswani on 12-01-2018.
 */

public class AddFootwaySurface extends SimpleOverpassQuestType
{
    // well, all roads have surfaces, what I mean is that not all ways with highway key are
    // "something with a surface"
    @Inject
    public AddFootwaySurface(OverpassMapDataDao overpassServer) { super(overpassServer); }

    @Override protected String getTagFilters()
    {
        return "ways with (" +
                "((highway=footway)" +
                " ) and !surface)";
    }

    public AbstractQuestAnswerFragment createForm()
    {
        return new AddFootwaySurfaceForm();
    }

    public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
    {
        changes.add("surface", answer.getString(AddFootwaySurfaceForm.SURFACE));
    }

    @Override public String getCommitMessage() { return "Add sidewalk surfaces"; }
    @Override public int getIcon() { return R.drawable.ic_quest_street_surface; }
    @Override public int getTitle(Map<String, String> tags)
    {
        boolean hasName = tags.containsKey("name");
        if(hasName) return R.string.quest_sideWalk_title;
        else        return R.string.quest_sideWalk_title;
    }
}


package de.tcat.opensidewalks.quests.passenger_information_display;

import android.os.Bundle;

import java.util.Map;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.data.osm.changes.StringMapChangesBuilder;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class AddPassengerInformationDisplay extends SimpleOverpassQuestType {
    @Inject
    public AddPassengerInformationDisplay(OverpassMapDataDao overpassServer) { super(overpassServer); }

    @Override protected String getTagFilters()
    {
        return "nodes with (public_transport=platform or (highway=bus_stop and public_transport!=stop_position)) and !passenger_information_display";
    }

    public AbstractQuestAnswerFragment createForm()
    {
        return new YesNoQuestAnswerFragment();
    }

    public void applyAnswerTo(Bundle answer, StringMapChangesBuilder changes)
    {
        String yesno = answer.getBoolean(YesNoQuestAnswerFragment.ANSWER) ? "yes" : "no";
        changes.add("passenger_information_display", yesno);
    }

    @Override public String getCommitMessage() { return "Add bus stop information display"; }
    @Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_bus; }
    @Override public int getTitle(Map<String, String> tags)
    {
        boolean hasName = tags.containsKey("name");
        if(hasName) return de.tcat.opensidewalks.R.string.quest_passengerInformation_name_title;
        else        return de.tcat.opensidewalks.R.string.quest_passengerInformationDisplay_title;
    }
}


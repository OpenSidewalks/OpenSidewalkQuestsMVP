package de.tcat.opensidewalks.quests.crossing_type;

import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddCrossingTypeForm extends ImageListQuestAnswerFragment
{
    private final OsmItem[] TYPES = new OsmItem[] {
            new OsmItem("traffic_signals", de.tcat.opensidewalks.R.drawable.crossing_type_signals, de.tcat.opensidewalks.R.string.quest_crossing_type_signals),
            new OsmItem("uncontrolled", de.tcat.opensidewalks.R.drawable.crossing_type_zebra, de.tcat.opensidewalks.R.string.quest_crossing_type_uncontrolled),
            new OsmItem("unmarked", de.tcat.opensidewalks.R.drawable.crossing_type_unmarked, de.tcat.opensidewalks.R.string.quest_crossing_type_unmarked)
    };

    @Override protected OsmItem[] getItems() { return TYPES; }
    @Override protected int getItemsPerRow() { return 3; }
}

package de.tcat.opensidewalks.quests.crossing_markings;

import de.tcat.opensidewalks.R;
import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddCrossingMarkingsForm extends ImageListQuestAnswerFragment
{
    private final OsmItem[] TYPES = new OsmItem[] {
            new OsmItem("traffic_signals", R.drawable.crossing_type_signals, R.string.quest_crossing_type_signals),
            new OsmItem("uncontrolled", R.drawable.crossing_type_zebra, R.string.quest_crossing_type_uncontrolled),
            new OsmItem("unmarked", R.drawable.crossing_type_unmarked, R.string.quest_crossing_type_unmarked)
    };

    @Override protected OsmItem[] getItems() { return TYPES; }
    @Override protected int getItemsPerRow() { return 3; }
}

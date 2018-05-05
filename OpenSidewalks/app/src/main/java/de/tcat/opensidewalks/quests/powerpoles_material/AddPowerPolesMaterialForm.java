package de.tcat.opensidewalks.quests.powerpoles_material;

import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddPowerPolesMaterialForm extends ImageListQuestAnswerFragment
{
	private final OsmItem[] TYPES = new OsmItem[] {
			new OsmItem("wood", de.tcat.opensidewalks.R.drawable.power_pole_wood, de.tcat.opensidewalks.R.string.quest_powerPolesMaterial_wood),
			new OsmItem("steel", de.tcat.opensidewalks.R.drawable.power_pole_steel, de.tcat.opensidewalks.R.string.quest_powerPolesMaterial_metal),
			new OsmItem("concrete", de.tcat.opensidewalks.R.drawable.power_pole_concrete, de.tcat.opensidewalks.R.string.quest_powerPolesMaterial_concrete)
	};

	@Override protected OsmItem[] getItems() { return TYPES; }
	@Override protected int getItemsPerRow() { return 3; }
}

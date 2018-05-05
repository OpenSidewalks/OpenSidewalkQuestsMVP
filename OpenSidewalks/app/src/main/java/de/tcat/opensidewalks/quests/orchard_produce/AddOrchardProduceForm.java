package de.tcat.opensidewalks.quests.orchard_produce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddOrchardProduceForm extends ImageListQuestAnswerFragment
{
	private static final OsmItem[] PRODUCES = new OsmItem[]{
			// ordered alphabetically here for overview

			// may have been mistaken for an orchard (i.e. agave) from satellite imagery
			// landuse=farmland
			new OsmItem("sisal",		de.tcat.opensidewalks.R.drawable.produce_sisal, de.tcat.opensidewalks.R.string.produce_sisal),
			// landuse=vineyard
			new OsmItem("grape",		de.tcat.opensidewalks.R.drawable.produce_grape, de.tcat.opensidewalks.R.string.produce_grapes),

			new OsmItem("agave",		de.tcat.opensidewalks.R.drawable.produce_agave, de.tcat.opensidewalks.R.string.produce_agaves),
			new OsmItem("almond",		de.tcat.opensidewalks.R.drawable.produce_almond, de.tcat.opensidewalks.R.string.produce_almonds),
			new OsmItem("apple",		de.tcat.opensidewalks.R.drawable.produce_apple, de.tcat.opensidewalks.R.string.produce_apples),
			new OsmItem("apricot",		de.tcat.opensidewalks.R.drawable.produce_apricot, de.tcat.opensidewalks.R.string.produce_apricots),
			new OsmItem("areca_nut",	de.tcat.opensidewalks.R.drawable.produce_areca_nut, de.tcat.opensidewalks.R.string.produce_areca_nuts),
			new OsmItem("avocado",		de.tcat.opensidewalks.R.drawable.produce_avocado, de.tcat.opensidewalks.R.string.produce_avocados),
			new OsmItem("banana",		de.tcat.opensidewalks.R.drawable.produce_banana, de.tcat.opensidewalks.R.string.produce_bananas),
			new OsmItem("sweet_pepper",	de.tcat.opensidewalks.R.drawable.produce_bell_pepper, de.tcat.opensidewalks.R.string.produce_sweet_peppers),
			new OsmItem("blueberry",	de.tcat.opensidewalks.R.drawable.produce_blueberry, de.tcat.opensidewalks.R.string.produce_blueberries),
			new OsmItem("brazil_nut",	de.tcat.opensidewalks.R.drawable.produce_brazil_nut, de.tcat.opensidewalks.R.string.produce_brazil_nuts),
			new OsmItem("cacao",		de.tcat.opensidewalks.R.drawable.produce_cacao, de.tcat.opensidewalks.R.string.produce_cacao),
			new OsmItem("cashew",		de.tcat.opensidewalks.R.drawable.produce_cashew, de.tcat.opensidewalks.R.string.produce_cashew_nuts),
			new OsmItem("cherry",		de.tcat.opensidewalks.R.drawable.produce_cherry, de.tcat.opensidewalks.R.string.produce_cherries),
			new OsmItem("chestnut",		de.tcat.opensidewalks.R.drawable.produce_chestnut, de.tcat.opensidewalks.R.string.produce_chestnuts),
			new OsmItem("chilli_pepper", de.tcat.opensidewalks.R.drawable.produce_chili, de.tcat.opensidewalks.R.string.produce_chili),
			new OsmItem("coconut",		de.tcat.opensidewalks.R.drawable.produce_coconut, de.tcat.opensidewalks.R.string.produce_coconuts),
			new OsmItem("coffee",		de.tcat.opensidewalks.R.drawable.produce_coffee, de.tcat.opensidewalks.R.string.produce_coffee),
			new OsmItem("cranberry",	de.tcat.opensidewalks.R.drawable.produce_cranberry, de.tcat.opensidewalks.R.string.produce_cranberries),
			new OsmItem("date",			de.tcat.opensidewalks.R.drawable.produce_date, de.tcat.opensidewalks.R.string.produce_dates),
			new OsmItem("fig",			de.tcat.opensidewalks.R.drawable.produce_fig, de.tcat.opensidewalks.R.string.produce_figs),
			new OsmItem("grapefruit",	de.tcat.opensidewalks.R.drawable.produce_grapefruit, de.tcat.opensidewalks.R.string.produce_grapefruits),
			new OsmItem("guava",		de.tcat.opensidewalks.R.drawable.produce_guava, de.tcat.opensidewalks.R.string.produce_guavas),
			new OsmItem("hazelnut",		de.tcat.opensidewalks.R.drawable.produce_hazelnut, de.tcat.opensidewalks.R.string.produce_hazelnuts),
			new OsmItem("hop",			de.tcat.opensidewalks.R.drawable.produce_hop, de.tcat.opensidewalks.R.string.produce_hops),
			new OsmItem("jojoba",		de.tcat.opensidewalks.R.drawable.produce_jojoba, de.tcat.opensidewalks.R.string.produce_jojoba),
			new OsmItem("kiwi",			de.tcat.opensidewalks.R.drawable.produce_kiwi, de.tcat.opensidewalks.R.string.produce_kiwis),
			new OsmItem("kola_nut",		de.tcat.opensidewalks.R.drawable.produce_kola_nut, de.tcat.opensidewalks.R.string.produce_kola_nuts),
			new OsmItem("lemon",		de.tcat.opensidewalks.R.drawable.produce_lemon, de.tcat.opensidewalks.R.string.produce_lemons),
			new OsmItem("lime",			de.tcat.opensidewalks.R.drawable.produce_lime, de.tcat.opensidewalks.R.string.produce_limes),
			new OsmItem("mango",		de.tcat.opensidewalks.R.drawable.produce_mango, de.tcat.opensidewalks.R.string.produce_mangos),
			new OsmItem("mangosteen",	de.tcat.opensidewalks.R.drawable.produce_mangosteen, de.tcat.opensidewalks.R.string.produce_mangosteen),
			new OsmItem("mate",			de.tcat.opensidewalks.R.drawable.produce_mate, de.tcat.opensidewalks.R.string.produce_mate),
			new OsmItem("nutmeg",		de.tcat.opensidewalks.R.drawable.produce_nutmeg, de.tcat.opensidewalks.R.string.produce_nutmeg),
			new OsmItem("olive",		de.tcat.opensidewalks.R.drawable.produce_olive, de.tcat.opensidewalks.R.string.produce_olives),
			new OsmItem("orange",		de.tcat.opensidewalks.R.drawable.produce_orange, de.tcat.opensidewalks.R.string.produce_oranges),
			new OsmItem("palm_oil",		de.tcat.opensidewalks.R.drawable.produce_palm_oil, de.tcat.opensidewalks.R.string.produce_oil_palms),
			new OsmItem("papaya",		de.tcat.opensidewalks.R.drawable.produce_papaya, de.tcat.opensidewalks.R.string.produce_papayas),
			new OsmItem("peach",		de.tcat.opensidewalks.R.drawable.produce_peach, de.tcat.opensidewalks.R.string.produce_peaches),
			new OsmItem("pear",			de.tcat.opensidewalks.R.drawable.produce_pear, de.tcat.opensidewalks.R.string.produce_pears),
			new OsmItem("pepper",		de.tcat.opensidewalks.R.drawable.produce_pepper, de.tcat.opensidewalks.R.string.produce_pepper),
			new OsmItem("persimmon",	de.tcat.opensidewalks.R.drawable.produce_persimmon, de.tcat.opensidewalks.R.string.produce_persimmons),
			new OsmItem("pineapple", 	de.tcat.opensidewalks.R.drawable.produce_pineapple, de.tcat.opensidewalks.R.string.produce_pineapples),
			new OsmItem("pistachio",	de.tcat.opensidewalks.R.drawable.produce_pistachio, de.tcat.opensidewalks.R.string.produce_pistachios),
			new OsmItem("plum",			de.tcat.opensidewalks.R.drawable.produce_plum, de.tcat.opensidewalks.R.string.produce_plums),
			new OsmItem("raspberry",	de.tcat.opensidewalks.R.drawable.produce_raspberry, de.tcat.opensidewalks.R.string.produce_raspberries),
			new OsmItem("rubber",		de.tcat.opensidewalks.R.drawable.produce_rubber, de.tcat.opensidewalks.R.string.produce_rubber),
			new OsmItem("strawberry",	de.tcat.opensidewalks.R.drawable.produce_strawberry, de.tcat.opensidewalks.R.string.produce_strawberries),
			new OsmItem("tea",			de.tcat.opensidewalks.R.drawable.produce_tea, de.tcat.opensidewalks.R.string.produce_tea),
			new OsmItem("tomatoe",		de.tcat.opensidewalks.R.drawable.produce_tomatoe, de.tcat.opensidewalks.R.string.produce_tomatoes),
			new OsmItem("tung_nut",		de.tcat.opensidewalks.R.drawable.produce_tung_nut, de.tcat.opensidewalks.R.string.produce_tung_nuts),
			new OsmItem("vanilla",		de.tcat.opensidewalks.R.drawable.produce_vanilla, de.tcat.opensidewalks.R.string.produce_vanilla),
			new OsmItem("walnut",		de.tcat.opensidewalks.R.drawable.produce_walnut, de.tcat.opensidewalks.R.string.produce_walnuts),
	};
	private static final Map<String,OsmItem> PRODUCES_MAP = new HashMap<>();
	static
	{
		for(OsmItem item : PRODUCES) PRODUCES_MAP.put(item.osmValue, item);
	}

	protected int getItemsPerRow() { return 3; }
	protected int getMaxNumberOfInitiallyShownItems() { return -1; }

	@Override protected OsmItem[] getItems()
	{
		// only include what is given for that country
		ArrayList<OsmItem> result = new ArrayList<>();
		for(String name : getCountryInfo().getOrchardProduces())
		{
			OsmItem item = PRODUCES_MAP.get(name);
			if(item != null) result.add(item);
		}
		return result.toArray(new OsmItem[result.size()]);
	}
}

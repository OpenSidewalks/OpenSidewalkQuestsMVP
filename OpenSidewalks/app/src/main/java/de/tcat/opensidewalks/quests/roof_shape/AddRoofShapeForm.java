package de.tcat.opensidewalks.quests.roof_shape;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import de.tcat.opensidewalks.quests.ImageListQuestAnswerFragment;

public class AddRoofShapeForm extends ImageListQuestAnswerFragment
{
	protected static final int MORE_THAN_95_PERCENT_COVERED = 8;

	private static final OsmItem[] ROOF_SHAPES = new OsmItem[]{
			new OsmItem("gabled",			de.tcat.opensidewalks.R.drawable.ic_roof_gabled),
			new OsmItem("hipped",			de.tcat.opensidewalks.R.drawable.ic_roof_hipped),
			new OsmItem("flat",				de.tcat.opensidewalks.R.drawable.ic_roof_flat),
			new OsmItem("pyramidal",		de.tcat.opensidewalks.R.drawable.ic_roof_pyramidal),

			new OsmItem("half-hipped",		de.tcat.opensidewalks.R.drawable.ic_roof_half_hipped),
			new OsmItem("skillion",			de.tcat.opensidewalks.R.drawable.ic_roof_skillion),
			new OsmItem("gambrel",			de.tcat.opensidewalks.R.drawable.ic_roof_gambrel),
			new OsmItem("round",			de.tcat.opensidewalks.R.drawable.ic_roof_round),

			new OsmItem("double_saltbox",	de.tcat.opensidewalks.R.drawable.ic_roof_double_saltbox),
			new OsmItem("saltbox",			de.tcat.opensidewalks.R.drawable.ic_roof_saltbox),
			new OsmItem("mansard",			de.tcat.opensidewalks.R.drawable.ic_roof_mansard),
			new OsmItem("dome",				de.tcat.opensidewalks.R.drawable.ic_roof_dome),

			new OsmItem("quadruple_saltbox", de.tcat.opensidewalks.R.drawable.ic_roof_quadruple_saltbox),
			new OsmItem("round_gabled",		de.tcat.opensidewalks.R.drawable.ic_roof_round_gabled),
			new OsmItem("onion",			de.tcat.opensidewalks.R.drawable.ic_roof_onion),
			new OsmItem("cone",				de.tcat.opensidewalks.R.drawable.ic_roof_cone),
			};

	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
									   Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);
		imageSelector.setCellLayout(de.tcat.opensidewalks.R.layout.labeled_icon_select_cell);

		addOtherAnswer(de.tcat.opensidewalks.R.string.quest_roofShape_answer_many, new Runnable()
		{
			@Override public void run()
			{
				applyManyRoofsAnswer();
			}
		});

		return view;
	}

	private void applyManyRoofsAnswer()
	{
		Bundle answer = new Bundle();
		ArrayList<String> strings = new ArrayList<>(1);
		strings.add("many");
		answer.putStringArrayList(OSM_VALUES, strings);
		applyImmediateAnswer(answer);
	}

	@Override protected int getMaxNumberOfInitiallyShownItems()
	{
		return MORE_THAN_95_PERCENT_COVERED;
	}

	@Override protected OsmItem[] getItems()
	{
		return ROOF_SHAPES;
	}

}
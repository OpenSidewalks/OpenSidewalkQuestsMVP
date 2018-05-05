package de.tcat.opensidewalks.quests.tactile_paving;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.tcat.opensidewalks.quests.YesNoQuestAnswerFragment;

public class TactilePavingCrosswalkForm extends YesNoQuestAnswerFragment
{
	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);
		setContentView(de.tcat.opensidewalks.R.layout.quest_tactile_paving);
		return view;
	}
}

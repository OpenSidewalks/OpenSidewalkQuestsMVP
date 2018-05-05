package de.tcat.opensidewalks.quests.wheelchair_access;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddWheelchairAccessPublicTransportForm extends WheelchairAccessAnswerFragment
{
	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);
		setContentView(de.tcat.opensidewalks.R.layout.quest_wheelchair_public_transport_explanation);
		return view;
	}
}

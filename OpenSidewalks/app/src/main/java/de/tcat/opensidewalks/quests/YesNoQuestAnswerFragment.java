package de.tcat.opensidewalks.quests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/** Abstract base class for dialogs in which the user answers a yes/no quest */
public class YesNoQuestAnswerFragment extends AbstractQuestAnswerFragment
{
	public static final String ANSWER = "answer";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);
		View buttonPanel = setButtonsView(de.tcat.opensidewalks.R.layout.quest_buttonpanel_yesno);

		buttonPanel.findViewById(de.tcat.opensidewalks.R.id.buttonYes).setOnClickListener(new View.OnClickListener()
		{
			@Override public void onClick(View v)
			{
				onClickYesNo(true);
			}
		});
		buttonPanel.findViewById(de.tcat.opensidewalks.R.id.buttonNo).setOnClickListener(new View.OnClickListener()
		{
			@Override public void onClick(View v)
			{
				onClickYesNo(false);
			}
		});
		return view;
	}

	@Override public boolean hasChanges()
	{
		return false;
	}

	protected void onClickYesNo(boolean answer)
	{
		Bundle bundle = new Bundle();
		bundle.putBoolean(ANSWER, answer);
		applyImmediateAnswer(bundle);
	}
}

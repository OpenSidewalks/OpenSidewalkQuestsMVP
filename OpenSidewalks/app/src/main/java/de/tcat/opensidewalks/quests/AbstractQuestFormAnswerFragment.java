package de.tcat.opensidewalks.quests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/** Abstract base class for dialogs in which the user answers a quest with a form he has to fill
 *  out */
public abstract class AbstractQuestFormAnswerFragment extends AbstractQuestAnswerFragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);
		View buttonPanel = setButtonsView(de.tcat.opensidewalks.R.layout.quest_buttonpanel_ok);
		Button buttonOk = buttonPanel.findViewById(de.tcat.opensidewalks.R.id.buttonOk);
		buttonOk.setOnClickListener(new View.OnClickListener()
		{
			@Override public void onClick(View v)
			{
				onClickOk();
			}
		});
		return view;
	}

	/** Apply an answer given in the form with the "OK" button. Checks if the form has any changes
	 *  first */
	protected final void applyFormAnswer(Bundle data)
	{
		// each form should check this on its own, but in case it doesn't, this is the last chance
		if(!hasChanges())
		{
			Toast.makeText(getActivity(), de.tcat.opensidewalks.R.string.no_changes, Toast.LENGTH_SHORT).show();
			return;
		}
		applyImmediateAnswer(data);
	}

	protected abstract void onClickOk();
	public abstract boolean hasChanges();
}

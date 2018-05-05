package de.tcat.opensidewalks.quests.place_name;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import de.tcat.opensidewalks.quests.AbstractQuestFormAnswerFragment;
import de.tcat.opensidewalks.view.dialogs.AlertDialogBuilder;

public class AddPlaceNameForm extends AbstractQuestFormAnswerFragment
{
	public static final String NO_NAME = "no_name";
	public static final String NAME = "name";

	private EditText nameInput;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);

		View contentView = setContentView(de.tcat.opensidewalks.R.layout.quest_placename);
		nameInput = contentView.findViewById(de.tcat.opensidewalks.R.id.nameInput);

		addOtherAnswer(de.tcat.opensidewalks.R.string.quest_name_answer_noName, new Runnable()
		{
			@Override public void run()
			{
				confirmNoName();
			}
		});

		return view;
	}

	@Override protected void onClickOk()
	{
		Bundle data = new Bundle();
		String name = nameInput.getText().toString().trim();
		data.putString(NAME, name);
		applyFormAnswer(data);
	}

	private void confirmNoName()
	{
		new AlertDialogBuilder(getActivity())
				.setTitle(de.tcat.opensidewalks.R.string.quest_name_answer_noName_confirmation_title)
				.setPositiveButton(de.tcat.opensidewalks.R.string.quest_name_noName_confirmation_positive, new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						Bundle data = new Bundle();
						data.putBoolean(NO_NAME, true);
						applyImmediateAnswer(data);
					}
				})
				.setNegativeButton(de.tcat.opensidewalks.R.string.quest_generic_confirmation_no, null)
				.show();
	}

	@Override public boolean hasChanges()
	{
		return !nameInput.getText().toString().trim().isEmpty();
	}
}

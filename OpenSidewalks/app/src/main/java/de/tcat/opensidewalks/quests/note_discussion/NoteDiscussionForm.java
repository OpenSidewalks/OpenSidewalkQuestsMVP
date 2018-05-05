package de.tcat.opensidewalks.quests.note_discussion;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import javax.inject.Inject;

import de.tcat.opensidewalks.Injector;
import de.tcat.opensidewalks.data.osmnotes.OsmNoteQuestDao;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.util.InlineAsyncTask;
import de.westnordost.osmapi.notes.Note;
import de.westnordost.osmapi.notes.NoteComment;

import static android.text.format.DateUtils.MINUTE_IN_MILLIS;

public class NoteDiscussionForm extends AbstractQuestAnswerFragment
{
	private static final String TAG = "NoteDiscussionForm";
	public static final String TEXT = "text";

	@Inject
    OsmNoteQuestDao noteDb;

	private EditText noteInput;
	private LinearLayout noteDiscussion;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Injector.instance.getApplicationComponent().inject(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = super.onCreateView(inflater, container, savedInstanceState);

		View contentView = setContentView(de.tcat.opensidewalks.R.layout.quest_note_discussion);

		View buttonPanel = setButtonsView(de.tcat.opensidewalks.R.layout.quest_notediscussion_buttonbar);
		Button buttonOk = buttonPanel.findViewById(de.tcat.opensidewalks.R.id.buttonOk);
		buttonOk.setOnClickListener(new View.OnClickListener()
		{
			@Override public void onClick(View v)
			{
				onClickOk();
			}
		});
		Button buttonNo = buttonPanel.findViewById(de.tcat.opensidewalks.R.id.buttonNo);
		buttonNo.setOnClickListener(new View.OnClickListener()
		{
			@Override public void onClick(View v)
			{
				skipQuest();
			}
		});

		noteInput = contentView.findViewById(de.tcat.opensidewalks.R.id.noteInput);
		noteDiscussion = contentView.findViewById(de.tcat.opensidewalks.R.id.noteDiscussion);

		buttonOtherAnswers.setVisibility(View.GONE);

		new InlineAsyncTask<Note>()
		{
			@Override protected Note doInBackground() throws Exception
			{
				return noteDb.get(getQuestId()).getNote();
			}

			@Override public void onSuccess(Note result)
			{
				if(getActivity() != null && result != null)
				{
					inflateNoteDiscussion(result);
				}
			}

			@Override public void onError(Exception e)
			{
				Log.e(TAG, "Error fetching note quest " + getQuestId() + " from DB.", e);
			}
		}.execute();

		return view;
	}

	private void inflateNoteDiscussion(Note note)
	{
		for(NoteComment noteComment : note.comments)
		{
			CharSequence userName;
			if (noteComment.isAnonymous())
			{
				userName = getResources().getString(de.tcat.opensidewalks.R.string.quest_noteDiscussion_anonymous);
			} else
			{
				userName = noteComment.user.displayName;
			}

			CharSequence dateDescription = DateUtils.getRelativeTimeSpanString(
					noteComment.date.getTime(), new Date().getTime(), MINUTE_IN_MILLIS);

			CharSequence commenter = String.format(
					getResources().getString(getNoteCommentActionResourceId(noteComment.action)),
					userName, dateDescription);

			if(noteComment == note.comments.get(0))
			{
				TextView noteText = getView().findViewById(de.tcat.opensidewalks.R.id.noteText);
				noteText.setText(noteComment.text);
				TextView noteAuthor = getView().findViewById(de.tcat.opensidewalks.R.id.noteAuthor);
				noteAuthor.setText(commenter);
			}
			else
			{
				ViewGroup discussionItem = (ViewGroup) LayoutInflater.from(getActivity()).inflate(
						de.tcat.opensidewalks.R.layout.quest_note_discussion_item, noteDiscussion, false);

				TextView commentInfo = discussionItem.findViewById(de.tcat.opensidewalks.R.id.comment_info);
				commentInfo.setText(commenter);

				TextView commentText = discussionItem.findViewById(de.tcat.opensidewalks.R.id.comment_text);
				commentText.setText(noteComment.text);

				noteDiscussion.addView(discussionItem);
			}
		}
	}

	private int getNoteCommentActionResourceId(NoteComment.Action action)
	{
		switch (action)
		{
			case OPENED:		return de.tcat.opensidewalks.R.string.quest_noteDiscussion_create;
			case COMMENTED:		return de.tcat.opensidewalks.R.string.quest_noteDiscussion_comment;
			case CLOSED:		return de.tcat.opensidewalks.R.string.quest_noteDiscussion_closed;
			case REOPENED:		return de.tcat.opensidewalks.R.string.quest_noteDiscussion_reopen;
		}
		throw new RuntimeException();
	}

	private void onClickOk()
	{
		String noteText = noteInput.getText().toString().trim();
		if(noteText.isEmpty())
		{
			Toast.makeText(getActivity(), de.tcat.opensidewalks.R.string.no_changes, Toast.LENGTH_SHORT).show();
			return;
		}

		Bundle answer = new Bundle();
		answer.putString(TEXT, noteText);
		applyImmediateAnswer(answer);
	}

	@Override public boolean hasChanges()
	{
		return !noteInput.getText().toString().trim().isEmpty();
	}

}

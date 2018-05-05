package de.tcat.opensidewalks.data.osmnotes;

import de.tcat.opensidewalks.data.QuestType;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.note_discussion.NoteDiscussionForm;

public class OsmNoteQuestType implements QuestType
{
	@Override public AbstractQuestAnswerFragment createForm() { return new NoteDiscussionForm(); }
	@Override public int getIcon() { return de.tcat.opensidewalks.R.drawable.ic_quest_notes; }
	@Override public int getTitle() { return de.tcat.opensidewalks.R.string.quest_noteDiscussion_title; }
}

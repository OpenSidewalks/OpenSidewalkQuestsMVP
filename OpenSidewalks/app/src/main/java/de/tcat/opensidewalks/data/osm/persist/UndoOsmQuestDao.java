package de.tcat.opensidewalks.data.osm.persist;

import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.QuestTypes;
import de.tcat.opensidewalks.util.Serializer;

/** Same as OsmQuestDao, only operates on a different table to have a clear cut between
 * "real" quests and reversed quests used to revert changes made by another quest */
public class UndoOsmQuestDao extends AOsmQuestDao
{
	@Inject public UndoOsmQuestDao(SQLiteOpenHelper dbHelper, Serializer serializer, QuestTypes questTypeList)
	{
		super(dbHelper, serializer, questTypeList);
	}

	@Override protected String getTableName() { return OsmQuestTable.NAME_UNDO; }
	@Override protected String getMergedViewName() { return OsmQuestTable.NAME_UNDO_MERGED_VIEW; }
}

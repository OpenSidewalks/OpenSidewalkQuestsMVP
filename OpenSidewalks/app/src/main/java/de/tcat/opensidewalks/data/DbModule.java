package de.tcat.opensidewalks.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.tcat.opensidewalks.data.changesets.OpenChangesetsDao;
import de.tcat.opensidewalks.data.osm.persist.OsmQuestDao;
import de.tcat.opensidewalks.data.statistics.QuestStatisticsDao;
import de.tcat.opensidewalks.quests.road_name.data.RoadNamesTablesHelper;
import de.tcat.opensidewalks.util.KryoSerializer;
import de.tcat.opensidewalks.util.Serializer;
import de.tcat.opensidewalks.data.osm.persist.UndoOsmQuestDao;
import de.westnordost.osmapi.changesets.ChangesetsDao;

@Module
public class DbModule
{
	@Provides @Singleton public static SQLiteOpenHelper sqliteOpenHelper(Context ctx)
	{
		return new StreetCompleteOpenHelper(ctx, new TablesHelper[]{ new RoadNamesTablesHelper() });
	}

	@Provides @Singleton public static Serializer serializer()
	{
		return new KryoSerializer();
	}

	@Provides @Singleton public static QuestStatisticsDao questStatisticsDao(
			SQLiteOpenHelper dbHelper, ChangesetsDao changesetsDao)
	{
		return new QuestStatisticsDao(dbHelper, changesetsDao);
	}

	@Provides @Singleton public static OpenChangesetsDao changesetsManagerDao(
			SQLiteOpenHelper dbHelper, SharedPreferences prefs)
	{
		return new OpenChangesetsDao(dbHelper,prefs);
	}

	@Provides @Singleton public static OsmQuestDao osmQuestDao(
			SQLiteOpenHelper dbHelper, Serializer serializer, QuestTypes questTypeList)
	{
		return new OsmQuestDao(dbHelper, serializer, questTypeList);
	}

	@Provides @Singleton public static UndoOsmQuestDao undoOsmQuestDao(
			SQLiteOpenHelper dbHelper, Serializer serializer, QuestTypes questTypeList)
	{
		return new UndoOsmQuestDao(dbHelper, serializer, questTypeList);
	}
}

package de.tcat.opensidewalks;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.tcat.opensidewalks.data.osm.persist.ElementGeometryDao;
import de.tcat.opensidewalks.data.osm.persist.MergedElementDao;
import de.tcat.opensidewalks.data.QuestTypes;
import de.tcat.opensidewalks.data.QuestController;
import de.tcat.opensidewalks.data.changesets.OpenChangesetsDao;
import de.tcat.opensidewalks.data.download.MobileDataAutoDownloadStrategy;
import de.tcat.opensidewalks.data.download.WifiAutoDownloadStrategy;
import de.tcat.opensidewalks.data.osm.persist.OsmQuestDao;
import de.tcat.opensidewalks.data.osm.persist.UndoOsmQuestDao;
import de.tcat.opensidewalks.data.osmnotes.CreateNoteDao;
import de.tcat.opensidewalks.data.osmnotes.OsmNoteQuestDao;
import de.tcat.opensidewalks.data.tiles.DownloadedTilesDao;
import de.tcat.opensidewalks.location.LocationRequestFragment;
import de.tcat.opensidewalks.oauth.OsmOAuthDialogFragment;
import de.tcat.opensidewalks.tools.CrashReportExceptionHandler;

@Module
public class ApplicationModule
{
	private final Application application;

	public ApplicationModule(Application application)
	{
		this.application = application;
	}

	@Provides public Context appContext()
	{
		return application;
	}

	@Provides public Application application()
	{
		return application;
	}

	@Provides public SharedPreferences preferences()
	{
		return PreferenceManager.getDefaultSharedPreferences(application);
	}

	@Provides public AssetManager assetManager()
	{
		return application.getAssets();
	}

	@Provides public Resources resources()
	{
		return application.getResources();
	}

	@Provides public QuestController questController(
            OsmQuestDao osmQuestDB, UndoOsmQuestDao undoOsmQuestDB, MergedElementDao osmElementDB,
            ElementGeometryDao geometryDB, OsmNoteQuestDao osmNoteQuestDB,
            CreateNoteDao createNoteDB, OpenChangesetsDao manageChangesetsDB)
	{
		return new QuestController(
				osmQuestDB, undoOsmQuestDB, osmElementDB, geometryDB, osmNoteQuestDB, createNoteDB,
				manageChangesetsDB,	appContext());
	}

	@Provides public static MobileDataAutoDownloadStrategy mobileDataAutoDownloadStrategy(
			OsmQuestDao osmQuestDB, DownloadedTilesDao downloadedTilesDao, QuestTypes questTypes,
			SharedPreferences preferences
	)
	{
		return new MobileDataAutoDownloadStrategy(osmQuestDB, downloadedTilesDao, questTypes,
				preferences);
	}

	@Provides public static WifiAutoDownloadStrategy wifiAutoDownloadStrategy(
			OsmQuestDao osmQuestDB, DownloadedTilesDao downloadedTilesDao, QuestTypes questTypes,
			SharedPreferences preferences
	)
	{
		return new WifiAutoDownloadStrategy(osmQuestDB, downloadedTilesDao, questTypes,
				preferences);
	}

	@Provides public static LocationRequestFragment locationRequestComponent()
	{
		return new LocationRequestFragment();
	}

	@Provides @Singleton public static CrashReportExceptionHandler serializer(Context ctx)
	{
		return new CrashReportExceptionHandler(ctx);
	}

	@Provides public static OsmOAuthDialogFragment osmOAuthFragment()
	{
		return new OsmOAuthDialogFragment();
	}
}

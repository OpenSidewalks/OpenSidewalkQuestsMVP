package de.tcat.opensidewalks.data.osm.upload;

import android.content.SharedPreferences;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.changesets.OpenChangesetsDao;
import de.tcat.opensidewalks.data.osm.persist.ElementGeometryDao;
import de.tcat.opensidewalks.data.osm.persist.MergedElementDao;
import de.tcat.opensidewalks.data.statistics.QuestStatisticsDao;
import de.tcat.opensidewalks.data.tiles.DownloadedTilesDao;
import de.westnordost.osmapi.changesets.ChangesetsDao;
import de.westnordost.osmapi.map.MapDataDao;
import de.tcat.opensidewalks.data.osm.OsmQuestUnlocker;
import de.tcat.opensidewalks.data.osm.persist.UndoOsmQuestDao;

public class UndoOsmQuestChangesUpload extends AOsmQuestChangesUpload
{
	@Inject public UndoOsmQuestChangesUpload(
            MapDataDao osmDao, UndoOsmQuestDao questDB, MergedElementDao elementDB,
            ElementGeometryDao elementGeometryDB, QuestStatisticsDao statisticsDB,
            OpenChangesetsDao openChangesetsDB, ChangesetsDao changesetsDao,
            DownloadedTilesDao downloadedTilesDao, SharedPreferences prefs,
            OsmQuestUnlocker questUnlocker)
	{
		super(osmDao, questDB, elementDB, elementGeometryDB, statisticsDB, openChangesetsDB,
				changesetsDao, downloadedTilesDao, prefs, questUnlocker);
	}
}

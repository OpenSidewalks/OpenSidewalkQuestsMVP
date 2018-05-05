package de.tcat.opensidewalks.quests;

import java.util.Arrays;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.tcat.opensidewalks.data.osm.download.OverpassMapDataDao;
import de.tcat.opensidewalks.quests.curb_ramps_tactile_pavings.CheckCurbRamps_TactilePavings;
import de.tcat.opensidewalks.quests.road_name.data.RoadNameSuggestionsDao;
import de.tcat.opensidewalks.quests.sidewalk_lit.SidewalkLit;
import de.tcat.opensidewalks.quests.sidewalk_surface.AddFootwaySurface;
import de.tcat.opensidewalks.data.QuestType;
import de.tcat.opensidewalks.data.QuestTypes;
import de.tcat.opensidewalks.quests.bin.AddBin;
import de.tcat.opensidewalks.quests.bus_stop_lit.AddBusStopLit;
import de.tcat.opensidewalks.quests.bus_stop_shelter.AddBusStopShelter;
import de.tcat.opensidewalks.quests.road_name.data.PutRoadNameSuggestionsHandler;
import de.tcat.opensidewalks.data.osmnotes.OsmNoteQuestType;

import de.tcat.opensidewalks.quests.bus_stop_bench.AddBusStopBench;

@Module
public class QuestModule
{
	@Provides @Singleton public static QuestTypes questTypeList(
			OsmNoteQuestType osmNoteQuestType, OverpassMapDataDao o,
			RoadNameSuggestionsDao roadNameSuggestionsDao,
			PutRoadNameSuggestionsHandler putRoadNameSuggestionsHandler)
	{
		QuestType[] questTypesOrderedByImportance = new QuestType[]{
				// ↓ notes
				//osmNoteQuestType,
				new AddFootwaySurface(o),
				new CheckCurbRamps_TactilePavings(o),
				new AddBusStopBench(o),
				new AddBusStopShelter(o),
				new AddBusStopLit(o),
				new AddBin(o),
				new SidewalkLit(o)
		};
		return new QuestTypes(Arrays.asList(questTypesOrderedByImportance));
	}

	@Provides @Singleton public static OsmNoteQuestType osmNoteQuestType()
	{
		return new OsmNoteQuestType();
	}
}

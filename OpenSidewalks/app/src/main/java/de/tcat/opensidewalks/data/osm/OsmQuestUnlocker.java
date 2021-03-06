package de.tcat.opensidewalks.data.osm;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import de.tcat.opensidewalks.data.QuestStatus;
import de.tcat.opensidewalks.data.QuestType;
import de.tcat.opensidewalks.data.QuestTypes;
import de.tcat.opensidewalks.data.osm.persist.ElementGeometryDao;
import de.tcat.opensidewalks.data.osm.persist.OsmQuestDao;
import de.tcat.opensidewalks.data.osmnotes.OsmNoteQuestDao;
import de.westnordost.osmapi.map.data.BoundingBox;
import de.westnordost.osmapi.map.data.Element;
import de.westnordost.osmapi.map.data.LatLon;

public class OsmQuestUnlocker
{
	private static final String TAG = "OsmQuestUnlocker";

	private final OsmNoteQuestDao osmNoteQuestDb;
	private final OsmQuestDao questDB;
	private final ElementGeometryDao elementGeometryDB;
	private final QuestTypes questTypes;

	@Inject public OsmQuestUnlocker(OsmNoteQuestDao osmNoteQuestDb, OsmQuestDao questDB,
									ElementGeometryDao elementGeometryDB, QuestTypes questTypes)
	{
		this.osmNoteQuestDb = osmNoteQuestDb;
		this.questDB = questDB;
		this.elementGeometryDB = elementGeometryDB;
		this.questTypes = questTypes;
	}

	public List<OsmQuest> unlockNewQuests(Element element)
	{
		ElementGeometry geometry = elementGeometryDB.get(element.getType(), element.getId());
		if(hasNoteAt(geometry.center)) return new ArrayList<>();

		final ArrayList<OsmQuest> quests = new ArrayList<>();

		Set<QuestType> currentQuestTypes = getCurrentQuestTypes(element);

		for(QuestType questType : questTypes.getQuestTypesSortedByImportance())
		{
			if(!(questType instanceof OsmElementQuestType)) continue;
			OsmElementQuestType osmQuestType = (OsmElementQuestType)questType;

			if(currentQuestTypes.contains(osmQuestType)) continue;
			if(!osmQuestType.appliesTo(element)) continue;

			quests.add(new OsmQuest(osmQuestType, element.getType(), element.getId(), geometry));
		}

		if(!quests.isEmpty())
		{
			int questCount = questDB.addAll(quests);

			Log.i(TAG, "Unlocked " + questCount + " new quests" +
					" for " + element.getType().name() + "#" + element.getId());
		}

		return quests;
	}

	private boolean hasNoteAt(LatLon pos)
	{
		BoundingBox bbox = new BoundingBox(pos, pos);
		return !osmNoteQuestDb.getAllPositions(bbox).isEmpty();
	}

	private Set<QuestType> getCurrentQuestTypes(Element element)
	{
		List<OsmQuest> previousQuests = questDB.getAll(null, null, null, element.getType(), element.getId());
		Set<QuestType> previousQuestTypes = new HashSet<>(previousQuests.size());
		for (OsmQuest previousQuest : previousQuests)
		{
			if(previousQuest.getStatus() == QuestStatus.REVERT) continue;

			previousQuestTypes.add(previousQuest.getType());
		}
		return previousQuestTypes;
	}
}

package de.tcat.opensidewalks.data.osm.persist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.tcat.opensidewalks.data.QuestTypes;
import de.tcat.opensidewalks.data.osm.ElementGeometry;
import de.tcat.opensidewalks.data.osm.changes.StringMapChanges;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryAdd;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryChange;
import de.tcat.opensidewalks.data.osm.persist.ElementGeometryDao;
import de.tcat.opensidewalks.data.ApplicationDbTestCase;
import de.tcat.opensidewalks.data.osm.persist.test.TestQuestType;
import de.tcat.opensidewalks.data.osm.persist.OsmQuestDao;
import de.westnordost.osmapi.map.data.BoundingBox;
import de.tcat.opensidewalks.data.QuestStatus;
import de.tcat.opensidewalks.data.QuestType;
import de.tcat.opensidewalks.data.osm.OsmQuest;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryDelete;
import de.tcat.opensidewalks.data.osm.changes.StringMapEntryModify;
import de.tcat.opensidewalks.data.osm.persist.test.TestQuestType2;
import de.westnordost.osmapi.map.data.Element;
import de.westnordost.osmapi.map.data.OsmLatLon;

public class OsmQuestDaoTest extends ApplicationDbTestCase
{
	private ElementGeometryDao geometryDao;
	private OsmQuestDao dao;

	@Override public void setUp()
	{
		super.setUp();
		geometryDao = new ElementGeometryDao(dbHelper, serializer);
		List<QuestType> list = new ArrayList<>();
		list.add(new TestQuestType());
		list.add(new TestQuestType2());

		dao = new OsmQuestDao(dbHelper, serializer, new QuestTypes(list));
	}

	public void testAddGetNoChanges()
	{
		OsmQuest quest = createNewQuest(11, Element.Type.NODE);

		addToDaos(quest);

		assertEquals(1, (long) quest.getId());
		OsmQuest dbQuest = dao.get(1);

		checkEqual(quest, dbQuest);
	}

	public void testAddGetWithChanges()
	{
		List<StringMapEntryChange> changes = new ArrayList<>();
		changes.add(new StringMapEntryAdd("a key", "a value"));
		changes.add(new StringMapEntryDelete("delete this","key"));
		changes.add(new StringMapEntryModify("modify","this","to that"));
		OsmQuest quest = createNewQuest(11, Element.Type.NODE);
		quest.setChanges(new StringMapChanges(changes), "bla");

		addToDaos(quest);

		assertEquals(1, (long) quest.getId());
		OsmQuest dbQuest = dao.get(1);

		checkEqual(quest, dbQuest);
	}

	public void testGetAllByBBox()
	{
		OsmQuest quest1 = createNewQuest(11, Element.Type.NODE);
		OsmQuest quest2 = createNewQuest(12, Element.Type.NODE, new ElementGeometry(new OsmLatLon(11,11)));

		addToDaos(quest1, quest2);

		assertEquals(1,dao.getAll(new BoundingBox(0,0,10,10), null, null, null, null).size());
		assertEquals(2,dao.getAll(null, null, null, null, null).size());
	}

	public void testGetAllByElementTypeAndId()
	{
		OsmQuest quest1 = createNewQuest(11, Element.Type.NODE);
		OsmQuest quest2 = createNewQuest(12, Element.Type.WAY);

		addToDaos(quest1, quest2);

		assertEquals(1,dao.getAll(null, null, null, Element.Type.NODE, null).size());
		assertEquals(1,dao.getAll(null, null, null, Element.Type.WAY, 12L).size());
	}

	private static OsmQuest createNewQuest(long id, Element.Type elementType)
	{
		return createNewQuest(id, elementType, new ElementGeometry(new OsmLatLon(5,5)));
	}

	private static OsmQuest createNewQuest(long id, Element.Type elementType, ElementGeometry geometry)
	{
		return new OsmQuest(null, new TestQuestType(), elementType, id,
				QuestStatus.ANSWERED, null, null, new Date(), geometry);
	}

	private void addToDaos(OsmQuest ...quests)
	{
		for (OsmQuest quest : quests)
		{
			geometryDao.put(quest.getElementType(), quest.getElementId(), quest.getGeometry());
			dao.add(quest);
		}
	}

	public void testDeleteAllClosed()
	{
		OsmQuest quest1 = createNewQuest(1, Element.Type.NODE);
		quest1.setStatus(QuestStatus.CLOSED);
		OsmQuest quest2 = createNewQuest(2, Element.Type.NODE);
		quest2.setStatus(QuestStatus.REVERT);
		OsmQuest quest3 = createNewQuest(3, Element.Type.NODE);

		addToDaos(quest1, quest2);

		assertEquals(2,dao.deleteAllClosed(System.currentTimeMillis() + 10000L));
	}

	private void checkEqual(OsmQuest quest, OsmQuest dbQuest)
	{
		assertEquals(quest.getId(), dbQuest.getId());
		assertEquals(quest.getType().getClass(), dbQuest.getType().getClass());
		assertEquals(quest.getElementId(), dbQuest.getElementId());
		assertEquals(quest.getElementType(), dbQuest.getElementType());
		assertEquals(quest.getStatus(), dbQuest.getStatus());
		assertEquals(quest.getChanges(), dbQuest.getChanges());
		assertEquals(quest.getChangesSource(), dbQuest.getChangesSource());
		assertEquals(quest.getGeometry(), dbQuest.getGeometry());
		assertEquals(quest.getMarkerLocation(), dbQuest.getMarkerLocation());
		// is now updated to current time on DB insert
		// no: assertEquals(quest.getLastUpdate(), dbQuest.getLastUpdate());
	}
}

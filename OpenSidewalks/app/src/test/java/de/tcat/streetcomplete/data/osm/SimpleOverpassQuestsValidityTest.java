package de.tcat.opensidewalks.data.osm;

import junit.framework.TestCase;

import java.util.List;

import de.tcat.opensidewalks.data.QuestType;
import de.tcat.opensidewalks.data.osm.SimpleOverpassQuestType;
import de.tcat.opensidewalks.quests.QuestModule;
import de.tcat.opensidewalks.data.osmnotes.OsmNoteQuestType;

public class SimpleOverpassQuestsValidityTest extends TestCase
{
	public void testQueryValid()
	{
		List<QuestType> questTypes = QuestModule.questTypeList(new OsmNoteQuestType(),
				null,null,null).getQuestTypesSortedByImportance();
		for(QuestType questType : questTypes)
		{
			if(questType instanceof SimpleOverpassQuestType)
			{
				// if this fails and the returned exception is not informative, catch here and record
				// the name of the SimpleOverpassQuestType
				((SimpleOverpassQuestType) questType).getOverpassQuery(null);
			}
		}
		// parsing the query threw no errors -> valid
		assertTrue(true);
	}
}

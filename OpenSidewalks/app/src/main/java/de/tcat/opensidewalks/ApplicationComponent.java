package de.tcat.opensidewalks;

import javax.inject.Singleton;

import dagger.Component;
import de.tcat.opensidewalks.data.OsmModule;
import de.tcat.opensidewalks.data.download.QuestDownloadService;
import de.tcat.opensidewalks.data.meta.MetadataModule;
import de.tcat.opensidewalks.data.osm.upload.ChangesetAutoCloserService;
import de.tcat.opensidewalks.data.upload.QuestChangesUploadService;
import de.tcat.opensidewalks.oauth.OAuthModule;
import de.tcat.opensidewalks.oauth.OsmOAuthDialogFragment;
import de.tcat.opensidewalks.quests.AbstractQuestAnswerFragment;
import de.tcat.opensidewalks.quests.QuestModule;
import de.tcat.opensidewalks.quests.opening_hours.AddOpeningHoursForm;
import de.tcat.opensidewalks.quests.road_name.AddRoadNameForm;
import de.tcat.opensidewalks.settings.SettingsActivity;
import de.tcat.opensidewalks.settings.SettingsFragment;
import de.tcat.opensidewalks.statistics.AnswersCounter;
import de.tcat.opensidewalks.tangram.QuestsMapFragment;
import de.tcat.opensidewalks.data.DbModule;
import de.tcat.opensidewalks.quests.note_discussion.NoteDiscussionForm;
import de.tcat.opensidewalks.util.SerializedSavedState;

@Singleton
@Component(modules = {ApplicationModule.class, OAuthModule.class, OsmModule.class, QuestModule.class,
		DbModule.class, MetadataModule.class})
public interface ApplicationComponent
{
	void inject(StreetCompleteApplication app);

	void inject(MainActivity mainActivity);
	void inject(NoteDiscussionForm noteDiscussionForm);
	void inject(SerializedSavedState tSerializedSavedState);

	void inject(QuestChangesUploadService questChangesUploadService);
	void inject(QuestDownloadService questChangesDownloadService);
	void inject(ChangesetAutoCloserService changesetAutoCloserService);

	void inject(SettingsFragment settingsFragment);
	void inject(SettingsActivity settingsActivity);

	void inject(AnswersCounter answersCounter);

	void inject(AddOpeningHoursForm addOpeningHoursForm);
	void inject(AddRoadNameForm addRoadNameForm);

	void inject(OsmOAuthDialogFragment osmOAuthDialogFragment);

	void inject(AbstractQuestAnswerFragment abstractQuestAnswerFragment);

	void inject(QuestsMapFragment questsMapFragment);
}

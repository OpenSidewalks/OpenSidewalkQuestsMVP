package de.tcat.opensidewalks.data.upload;

public interface QuestChangesUploadProgressListener
{
	void onError(Exception e);
	void onFinished();
}

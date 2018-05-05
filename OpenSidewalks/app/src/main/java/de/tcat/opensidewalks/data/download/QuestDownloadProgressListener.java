package de.tcat.opensidewalks.data.download;

public interface QuestDownloadProgressListener
{
	void onStarted();
	void onProgress(float progress);
	void onError(Exception e);
	void onSuccess();
	void onFinished();
	void onNotStarted();
}

package de.tcat.opensidewalks;

import de.tcat.opensidewalks.DaggerApplicationComponent;

public enum Injector
{
	instance;

	private ApplicationComponent applicationComponent;

	void initializeApplicationComponent(StreetCompleteApplication app)
	{
		applicationComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(app))
				.build();
	}

	public ApplicationComponent getApplicationComponent() {
		return applicationComponent;
	}
}

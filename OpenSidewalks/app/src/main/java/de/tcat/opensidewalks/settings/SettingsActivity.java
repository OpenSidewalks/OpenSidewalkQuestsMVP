package de.tcat.opensidewalks.settings;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import de.tcat.opensidewalks.oauth.OsmOAuthDialogFragment;

public class SettingsActivity extends AppCompatActivity implements OsmOAuthDialogFragment.Listener
{
	public static final String EXTRA_LAUNCH_AUTH = "de.tcat.opensidewalks.settings.launch_auth";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		PreferenceManager.setDefaultValues(this, de.tcat.opensidewalks.R.xml.preferences, false);
		setContentView(de.tcat.opensidewalks.R.layout.activity_settings);

		Toolbar toolbar = findViewById(de.tcat.opensidewalks.R.id.toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		if(getIntent().getBooleanExtra(EXTRA_LAUNCH_AUTH, false))
		{
			new OsmOAuthDialogFragment().show(getFragmentManager(), OsmOAuthDialogFragment.TAG);
		}
	}

	@Override public void onOAuthAuthorized()
	{
	}

	@Override protected void onNewIntent(Intent intent)
	{
		super.onNewIntent(intent);
		OsmOAuthDialogFragment oauthFragment = (OsmOAuthDialogFragment) getFragmentManager()
				.findFragmentByTag(OsmOAuthDialogFragment.TAG);
		if(oauthFragment != null)
		{
			oauthFragment.onNewIntent(intent);
		}
	}
}
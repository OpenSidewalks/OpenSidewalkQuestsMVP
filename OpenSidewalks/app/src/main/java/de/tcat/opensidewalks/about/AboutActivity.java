package de.tcat.opensidewalks.about;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity
{
	@Override protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(de.tcat.opensidewalks.R.layout.activity_about);

		Toolbar toolbar = findViewById(de.tcat.opensidewalks.R.id.toolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		if(savedInstanceState == null)
		{
			getFragmentManager()
					.beginTransaction()
					.add(de.tcat.opensidewalks.R.id.fragment_container, new AboutFragment())
					.commit();
		}
	}

	@Override
	public void onBackPressed() {
		if (getFragmentManager().getBackStackEntryCount() > 0) {
			getFragmentManager().popBackStack();
		} else {
			super.onBackPressed();
		}
	}

	// TODO consider using this instead (for UI/toolbar redesign)
	// https://stackoverflow.com/questions/29558568/manage-toolbars-navigation-and-back-button-from-fragment-in-android#29795569
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

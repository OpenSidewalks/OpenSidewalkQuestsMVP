package de.tcat.opensidewalks.about;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowHtmlFragment extends Fragment
{
	public static final String
			TEXT = "text",
			TITLE_STRING_RESOURCE_ID = "title_string_id";

	public static ShowHtmlFragment create(String text, int titleStringId)
	{
		Bundle args = new Bundle();
		args.putString(TEXT, text);
		args.putInt(TITLE_STRING_RESOURCE_ID, titleStringId);
		ShowHtmlFragment result = new ShowHtmlFragment();
		result.setArguments(args);
		return result;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(de.tcat.opensidewalks.R.layout.showhtml, container, false);
		final TextView textView = view.findViewById(de.tcat.opensidewalks.R.id.text);
		textView.setMovementMethod(LinkMovementMethod.getInstance());
		textView.setText(Html.fromHtml(getArguments().getString(TEXT)));
		return view;
	}

	@Override public void onStart()
	{
		super.onStart();
		getActivity().setTitle(getArguments().getInt(TITLE_STRING_RESOURCE_ID));
	}
}

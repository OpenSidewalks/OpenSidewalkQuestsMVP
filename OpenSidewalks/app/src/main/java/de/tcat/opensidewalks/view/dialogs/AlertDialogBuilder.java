package de.tcat.opensidewalks.view.dialogs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;

public class AlertDialogBuilder extends AlertDialog.Builder
{
	public AlertDialogBuilder(@NonNull Context context)
	{
		super(context, de.tcat.opensidewalks.R.style.AppTheme_AlertDialog);
	}

	public AlertDialogBuilder(@NonNull Context context, @StyleRes int themeResId)
	{
		super(context, themeResId);
	}
}

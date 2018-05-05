/*

package de.tcat.opensidewalks.quests;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import R;


*/
/** Abstract base class for dialogs in which the user answers a yes/no quest *//*


public class TwoLevelQuestAnswerFragment extends AbstractQuestAnswerFragment
{
    public static final String ANSWER = "answer";
    private Activity activity;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        View buttonPanel = setButtonsView(R.layout.quest_buttonpanel_yesno);
        //setContentView(R.layout.quest_buttonpanel_yesno);

        buttonPanel.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                onClickYesNo(true);
                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.quest_buttonpanel_yesno, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

               *//*

*/
/* final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // get user input and set it to result
                                        // edit text
                                        result.setText(userInput.getText());
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });*//*



                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });
        buttonPanel.findViewById(R.id.buttonNo).setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v)
            {
                onClickYesNo(false);
            }
        });
        return view;
    }

    @Override public boolean hasChanges()
    {
        return false;
    }

    protected void onClickYesNo(boolean answer)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ANSWER, answer);
        applyImmediateAnswer(bundle);
    }
}

*/

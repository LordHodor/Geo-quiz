package com.example.hodorviii.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.hodorviii.geoquiz.answer_is_true";
    // add a key for the extra

    private static final  String EXTRA_ANSWER_SHOWN = "com.example.hodorviii.geoquiz.answer_shown";
    // adding an extra on the intent I plan to report to the quiz activity with

    private  boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswerButton;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
        /* 4-17-17 this Intent method will do all of the work implementing what CheatActivity expects as extras on its Intent
        the answerIsTrue is a boolean, and its put into the intent using EXTRA_ANSWER_IS_TRUE constant. now I can use similar methods in my subclasses to
        properly configure intents.
         */
    }

    public static  boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
        // set the default value of if the answer shown to false to make the result intent understandable
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        // retrieves the value from the extra in onCreate(Bundle) and stores in a memeber variable

        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                }else{
                    mAnswerTextView.setText(R.string.false_button);
                }

                setAnswerShownResult(true);
            }
            //I set the TextView's text using TextView.setText(int) using a R.ID as a string resource.
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_IS_TRUE, isAnswerShown);
        setResult(RESULT_OK, data);
        /*create the new intent that will be going to the parent activity with the extra EXTRA_ANSWER_IS_TRUE
         When the user presses the show answer button the cheat activity sends the results xode with the intent in the call to setResult(int, Intent)
          */
    }
}

package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView textStory;
    Button buttonAns1;
    Button buttonAns2;

    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        textStory = (TextView) findViewById(R.id.storyTextView);
        buttonAns1 = (Button) findViewById(R.id.buttonTop);
        buttonAns2 = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mStoryIndex == 1 || mStoryIndex ==2){
                    textStory.setText(R.string.T3_Story);
                    buttonAns1.setText(R.string.T3_Ans1);
                    buttonAns2.setText(R.string.T3_Ans2);
                    mStoryIndex = 3;
                }
                else {
                    textStory.setText(R.string.T6_End);
                    buttonAns1.setVisibility(View.GONE);
                    buttonAns2.setVisibility(View.GONE);
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mStoryIndex == 1){
                    textStory.setText(R.string.T2_Story);
                    buttonAns1.setText(R.string.T2_Ans1);
                    buttonAns2.setText(R.string.T2_Ans2);
                    mStoryIndex = 2;
                }
                else if(mStoryIndex == 2){
                    textStory.setText(R.string.T4_End);
                    buttonAns1.setVisibility(View.GONE);
                    buttonAns2.setVisibility(View.GONE);
                }
                else{
                    textStory.setText(R.string.T5_End);
                    buttonAns1.setVisibility(View.GONE);
                    buttonAns2.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("StoryIndex", mStoryIndex=1);
    }
}

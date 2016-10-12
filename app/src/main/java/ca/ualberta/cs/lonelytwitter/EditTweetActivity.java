package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class EditTweetActivity extends Activity {
    private EditText bodyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        String content = (String) getIntent().getExtras().get("tweet_content");
        bodyText = (EditText) findViewById(R.id.EditTweetText);
        bodyText.setText(content);
    }
}

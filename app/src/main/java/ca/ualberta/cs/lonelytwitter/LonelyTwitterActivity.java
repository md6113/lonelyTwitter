/*
Copyright (c) 2016 CMPUT301, University of Alberta - All Rights Reserved.
For further information contact me at abc@abc.com
notice documentation
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main class of the LonelyTwitterProject. It handles all user interaction as well as
 * file manipulations. </p>
 * <pre> All the files are stored in the form of "json" files stored in the Emulator,
 * accessible from the Android Device Monitor.</pre>
 * <code> Pseudo Code Sample:
 * open some file ... <br>
 * manipulate some file ... <br>
 * close some file ...
 * </code>
 * <ul>
 * <li>an item</li>
 * <li>yet another item</li>
 * <li>the final item</li>
 * </ul>
 *
 * @author Maximus Decimus
 * @see NormalTweet
 * @see Tweet
 * @see Tweetable
 * @see TweetList
 * @see Sad
 * @see ImportantTweet
 * @see Happy
 * @see CurrentMood
 * @see TweetTooLongExeption
 * @since 1.0
 * @deprecated
 */
public class LonelyTwitterActivity extends Activity {

    /**
     * This is the file name ("file.sav") that is being saved/loaded and contains all the tweets.
     * @see #loadFromFile()
     * @see #saveInFile()
     * @see #
     */

	private Activity activity = this;
	private static final String FILE_NAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	private LonelyTwitterActivity myApp = this;

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList = new ArrayList<Tweet>();
				adapter = new ArrayAdapter<Tweet>(myApp,
						R.layout.list_item, tweetList);
				oldTweetsList.setAdapter(adapter);
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
				Tweet tweet = (Tweet) parent.getItemAtPosition(position);
				intent.putExtra("tweet_content", tweet.getMessage());
				startActivity(intent);
			}
		});

	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * This method loads the tweets from FILE_NAME (file.sav), and ...
     * @throws FileNotFoundException
     * @exception RuntimeException
     *
     */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILE_NAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Code form http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * This method saves the tweets from FILE_NAME (file.sav), and ...
	 * @throws FileNotFoundException
	 * @exception RuntimeException
	 *
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILE_NAME,
					0);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}
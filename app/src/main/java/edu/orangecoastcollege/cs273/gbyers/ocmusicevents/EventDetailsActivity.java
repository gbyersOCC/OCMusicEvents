package edu.orangecoastcollege.cs273.gbyers.ocmusicevents;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gbyers on 9/27/2016.
 */

public class EventDetailsActivity extends AppCompatActivity {
    private ImageView eventImageView;
    private Context context= this;
    TextView eventTitle = (TextView) findViewById(R.id.eventTitleTextView);
    TextView eventDetail = (TextView) findViewById(R.id.eventDetailsTextView);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);


        Intent recieved = getIntent();

        String titleText = recieved.getStringExtra("Title");
        String detailText = recieved.getStringExtra("Details");
        String imageFileName = titleText.replace(" ","")+".jpeg";

        AssetManager am = context.getAssets();

        try{
            InputStream stream = am.open(imageFileName);
            Drawable draImage =  Drawable.createFromStream(stream, titleText);
            eventImageView.setImageDrawable(draImage);
        }catch(IOException e){
            Log.e("OC Music Events", "CANNOT lOAD EVENT");
        }
    eventTitle.setText(titleText);
        eventDetail.setText(detailText);




    }


}

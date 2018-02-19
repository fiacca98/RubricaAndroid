package com.example.luigi.rubricatelefonica;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luigi on 15/02/2018.
 */

public class showContact extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcontact);

        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra(MainActivity.EXTRA_SELECTED_ITEM);

        // Set TextView
        TextView resultTextView = (TextView) findViewById(R.id.detailTextView);
        resultTextView.setText(selectedItem);

        // Set ImageView
        ImageView imageView = (ImageView) findViewById(R.id.detailImageView);
        imageView.setImageResource(R.drawable.ic_fruit);
        String uri = "ic_" + selectedItem.toLowerCase();

        if (uri != null && uri.length() > 0) {

            try {
                int imageResource = getResources().getIdentifier(uri, "drawable", getPackageName());
                Drawable image = getResources().getDrawable(imageResource, null);
                imageView.setImageDrawable(image);
            } catch (Exception e) {
                Log.w("LIST_EXAMPLE", "Exception while retrieving resource " + uri);
            }
        }

        // Set onclick listener
        Button detailButton = (Button) findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

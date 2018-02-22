package com.example.luigi.rubricatelefonica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        final String nome = intent.getStringExtra("nome");
        String numero = intent.getStringExtra("numero");

        // Set TextView
        TextView nameTextView = (TextView) findViewById(R.id.nome);
        nameTextView.setText(nome);

        TextView numberTextView = (TextView) findViewById(R.id.number);
        numberTextView.setText(numero);

        // Set ImageView
        ImageView imageView = (ImageView) findViewById(R.id.detailImageView);
        imageView.setImageResource(R.drawable.ic_fruit);
        String uri = "ic_" + nome.toLowerCase();

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

        Button favouriteButton = (Button) findViewById(R.id.favourite);
        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ciao", "ciao");
                ArrayUtility.setSharedPreferences(nome, showContact.this);
            }
        });

        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}

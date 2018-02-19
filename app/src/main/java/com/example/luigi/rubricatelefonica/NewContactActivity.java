package com.example.luigi.rubricatelefonica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static java.security.AccessController.getContext;


public class NewContactActivity extends Activity{

    private String currentItemValue;
    private Contatto contatto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);

        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra(MainActivity.EXTRA_SELECTED_ITEM);

        currentItemValue = selectedItem;




        // Set ImageView
        /*ImageView imageView = (ImageView) findViewById(R.id.detailImageView);
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
        }*/
        // Set onclick listener
        Button detailButton = (Button) findViewById(R.id.detailButton);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText) findViewById(R.id.nome);
                String nomeString = valueOf(nome.getText());
                EditText numero = (EditText) findViewById(R.id.numero);
                String numeroString = valueOf(numero.getText());
                contatto = new Contatto(nomeString, numeroString);
                ArrayUtility.addData(contatto);
                finish();
            }
        });
    }



}

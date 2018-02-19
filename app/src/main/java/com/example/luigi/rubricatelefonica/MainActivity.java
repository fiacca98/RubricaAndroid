package com.example.luigi.rubricatelefonica;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_SELECTED_ITEM = "com.example.luigi.fruitlist.FRUITS";
    private CustomArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayUtility.initDataSource(this);
        List<Contatto> contactList= new ArrayList<Contatto>(ArrayUtility.getDataSourceItemList(this));
         adapter = new CustomArrayAdapter(this, contactList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final Contatto item = ArrayUtility.getDataSourceItemList(MainActivity.this).get(position);

                /*Intent intent = new Intent(MainActivity.this,showFruit.class);
                intent.putExtra(EXTRA_SELECTED_ITEM,item);

                startActivity(intent);*/
                /*final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Alert");
                //alertDialog.setMessage("Alert message to be shown");
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ArrayUtility.removeData(position);
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

            }
        });*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: {

                Intent intent = new Intent(MainActivity.this, NewContactActivity.class);

                startActivity(intent);
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}

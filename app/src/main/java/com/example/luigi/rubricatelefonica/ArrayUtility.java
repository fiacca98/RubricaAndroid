package com.example.luigi.rubricatelefonica;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luigi on 15/02/2018.
 */

public class ArrayUtility {
    public static void initDataSource(Context context){
        List<Contatto> contactList = new ArrayList<Contatto>();

        Singleton.getOurInstance().setItemList(contactList);

        Singleton.addItem(new Contatto("mamma", "3881130136"));
        Singleton.addItem(new Contatto("papa", "3883785433"));
        Singleton.addItem(new Contatto("zio", "3887425456"));
        Singleton.addItem(new Contatto("zia", "3887423872"));
        Singleton.addItem(new Contatto("nonna", "3889759501"));
        Singleton.addItem(new Contatto("nonno", "3884566123"));
        Singleton.addItem(new Contatto("capo", "3882233445"));



    }
    public static List<Contatto> getDataSourceItemList(Context context){
        return Singleton.getOurInstance().getItemList();
    }

    public static void addData(Contatto add) {
        Singleton.addItem(add);
    }

    public static void removeData(int position) {
        Singleton.removeData(position);
    }

    public static void setSharedPreferences(String favouriteValue, Activity a) {

        SharedPreferences sharedPref = a.getSharedPreferences("Preferiti",Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Preferito", favouriteValue);
        editor.commit();
        Log.d("salvato", "salvato");
    }

    public static String readFromSharedPreferences(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("Preferiti", Context.MODE_PRIVATE);
        String preferito = sharedPref.getString("Preferito",null);
        return preferito;
    }
}

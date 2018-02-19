package com.example.luigi.rubricatelefonica;

import android.content.Context;

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
}

package com.example.luigi.rubricatelefonica;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luigi on 15/02/2018.
 */

public class Singleton {
    private static Singleton ourInstance = new Singleton();
    private static List<Contatto> contactList = new ArrayList<Contatto>();

    public static Singleton getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Singleton ourInstance) {
        Singleton.ourInstance = ourInstance;
    }
    private Singleton(){}

    public void setItemList(List<Contatto> contactList) {
        this.contactList = contactList;
    }

    public List<Contatto> getItemList() {
        return this.contactList;
    }

    public static void addItem(Contatto add) {
        contactList.add(add);
    }

    public static void removeData(int position) {
        contactList.remove(position);
    }
}

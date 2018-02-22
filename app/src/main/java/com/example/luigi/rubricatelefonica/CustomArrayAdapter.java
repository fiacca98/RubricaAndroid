package com.example.luigi.rubricatelefonica;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by luigi on 15/02/2018.
 */

class CustomArrayAdapter extends ArrayAdapter<Contatto>{
    private final Context context;
    private List<Contatto> values;

    public CustomArrayAdapter(Context context, List<Contatto> values){
        super(context,R.layout.item_layout, values);
        this.values=values;
        this.context = context;
    }

    public void refreshValues(){
        this.values = Singleton.getOurInstance().getItemList();
        notifyDataSetChanged();
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_layout, parent, false);

        //return getViewOptimize(position, convertView, parent);



        TextView textViewName = (TextView) rowView.findViewById(R.id.name);
        TextView textViewNumber = (TextView) rowView.findViewById(R.id.number);
        ImageView imageViewStar = (ImageView) rowView.findViewById(R.id.star);
        Contatto itemName = this.values.get(position);
        textViewName.setText(itemName.getNome());
        textViewNumber.setText(itemName.getNumero());


        // Set icon
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        imageView.setImageResource(R.drawable.ic_fruit);
        String uri = "ic_" + itemName.getNome().toLowerCase();
        if (uri != null && uri.length() > 0) {
            try {
                String logoname = "ic_" + itemName.getNome().toLowerCase();
                if (logoname != null) {
                    int imageResource = context.getResources().getIdentifier(uri, "drawable", getContext().getPackageName());
                    Drawable image = context.getResources().getDrawable(imageResource, null);
                    imageView.setImageDrawable(image);
                }
            } catch (Exception e) {
                Log.w("LIST_EXAMPLE", "Exception while retrieving resource " + uri);
            }
        }

        String preferito = ArrayUtility.readFromSharedPreferences(this.context);
        if(preferito != null)
            Log.d("preferito",preferito);
        else
            Log.d("preferito","is null");
        if(preferito != null && preferito.equals(itemName.getNome()))
        {
            imageViewStar.setVisibility(View.VISIBLE);
        }

        return rowView;

    }

    @Override
    public int getCount() {
        return values.size();
    }

    public View getViewOptimize(int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)convertView.findViewById(R.id.name);
            viewHolder.logo = (ImageView)convertView.findViewById(R.id.logo);
            viewHolder.number = (TextView)convertView.findViewById(R.id.number);
            viewHolder.star = (ImageView)convertView.findViewById(R.id.star);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Singleton singleton = Singleton.getOurInstance();
        List<Contatto> contactList = new ArrayList<Contatto>();
        contactList = singleton.getItemList();
        Contatto contatto = contactList.get(position);
        viewHolder.name.setText(contatto.getNome());
        viewHolder.number.setText(contatto.getNumero());
        String favouriteContact = ArrayUtility.readFromSharedPreferences(context);
        if(contatto.getNome().equals(favouriteContact))
            viewHolder.star.setVisibility(View.VISIBLE);

        return convertView;
    }

    private class ViewHolder{
        public TextView name;
        public TextView number;
        public ImageView logo;
        public ImageView star;
    }

}

package com.example.listshoppingbysql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class sectionadapter extends ArrayAdapter<datasectionmodel> {

    Context c;
    ArrayList<datasectionmodel> ass;
    public sectionadapter(Context context, ArrayList<datasectionmodel> cont) {
        super(context, R.layout.section_items,cont);
        c=context;
        ass=cont;
    }

    class Holder
    {
        ImageView imgsection;
        TextView namesection,pricesection,dessection;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        final datasectionmodel data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        final Holder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new Holder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.section_items, parent, false);

            viewHolder.namesection = (TextView) convertView.findViewById(R.id.nametxt);
            viewHolder.imgsection = (ImageView) convertView.findViewById(R.id.imgsection);
            viewHolder.pricesection = (TextView) convertView.findViewById(R.id.txtprice);
            viewHolder.dessection = (TextView) convertView.findViewById(R.id.destxt);



            convertView.setTag(viewHolder);

        } else {
            viewHolder = (Holder) convertView.getTag();
        }
        // PicassoClient.downloadImage(c,data.getImage(),viewHolder.imgcategory);
        // viewHolder.txtname.setText(data.getSecname());
        viewHolder.namesection.setText(data.name);
        viewHolder.imgsection.setImageResource(data.img);
        viewHolder.pricesection.setText(data.price);
        viewHolder.dessection.setText(data.description);
        return convertView;
    }

}

package com.example.dellll.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DELLLL on 5/5/2017.
 */
public class Adapter extends ArrayAdapter<Level> {

    Context mConText;
    ArrayList<Level> arrayList=new ArrayList<Level>();

    public Adapter(Context context, int resource, ArrayList<Level> objects) {
        super(context, resource, objects);
        this.mConText = context;
        this.arrayList = new ArrayList<Level>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView=convertView;
        ViewHolder viewHolder;
        if (rowView==null)
        {
            LayoutInflater inflater=(LayoutInflater)
                    mConText.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView=inflater.inflate(R.layout.itemlevel,null);
            viewHolder =new ViewHolder();
            // anh xa
            viewHolder.lv_name=(TextView)rowView.findViewById(R.id.lv_name);
            viewHolder.lv_img=(ImageView)rowView.findViewById(R.id.lv_Image);
            rowView.setTag(viewHolder);

        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }

        Level level=arrayList.get(position);
        viewHolder.lv_name.setText(level.getName());
        //viewHolder.lv_img.setImageResource(level.getPicture());




        return rowView;
    }


    public class ViewHolder
    {

        ImageView lv_img;
        TextView lv_name;

    }


}

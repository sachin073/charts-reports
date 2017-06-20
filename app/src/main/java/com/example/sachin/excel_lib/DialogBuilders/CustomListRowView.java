package com.example.sachin.excel_lib.DialogBuilders;

/**
 * @author Sachin verma
 * @discription inflate only the view . No logic simple view generation.
 * */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sachin.excel_lib.R;

/**
 * Created by sachin on 14/6/17.
 */

public class CustomListRowView extends ArrayAdapter<String> {

    private final Integer[] imgs;
    private final String[] fileNames;
    private final Activity context;
    public CustomListRowView(Activity context,Integer[] imgs,String[] fileNames){
        super(context, R.layout.file_list_row,fileNames);
        this.context=context;
        this.imgs=imgs;
        this.fileNames=fileNames;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View rowView= layoutInflater.inflate(R.layout.file_list_row,null,true);
        TextView txt  = (TextView) rowView.findViewById(R.id.FOLDER_FILE_NAME);
        ImageView img = (ImageView) rowView.findViewById(R.id.FOLDER_FILE_IMG);

        img.setImageResource(imgs[position]);
        txt.setText(fileNames[position]);
        return rowView;

    }
}

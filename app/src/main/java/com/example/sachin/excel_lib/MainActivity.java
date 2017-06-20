package com.example.sachin.excel_lib;

import android.app.Dialog;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;

import ExcelUtils.AndroidUtils;
import ExcelUtils.BaseExlUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        showDialog(0);      //should be replace with fragment manager class of dialogFragment >>setStyle


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        //return super.onCreateDialog(id);

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.file_chooser_dialog);
       // dialog.setTitle("custom file choose");
        dialog.setCanceledOnTouchOutside(true);

        try {

            ListView lst=(ListView) dialog.findViewById(R.id.ITEM_LIST);
            AndroidUtils.getInstance().generatePopUp(lst,this,
                    new Integer[]{R.drawable.clover_icon,R.drawable.clover_icon},
                    new String[]{"Item-1","Item-2"});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialog;
    }


    public void prepareList(File currentDir){

        File[] files=currentDir.listFiles();




    }

}

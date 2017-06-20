package ExcelUtils;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sachin.excel_lib.DialogBuilders.CustomListRowView;

/**
 * Created by sachin on 14/6/17.
 */

public class AndroidUtils {

    private AndroidUtils(){

    }
    private static final AndroidUtils _instance=null;
    public static AndroidUtils getInstance() {
        if(_instance == null)
            return new AndroidUtils();
        return _instance;
    }

    public void generatePopUp(ListView list, final Activity context, final Integer[] imageResIds, final String[] filename){

        CustomListRowView customListRowView = new CustomListRowView(context,imageResIds,filename);
        list.setAdapter(customListRowView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"clicked at "+imageResIds[position]+" "+filename[position],Toast.LENGTH_LONG)
                        .show();
            }
        });
    }




}

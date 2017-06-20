package ExcelUtils;

import android.util.Log;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * Created by sachin on 8/6/17.
 */

public class BaseExlUtil {


 static BaseExlUtil _instance=null;

        private BaseExlUtil(){
            return;
        }

    public static BaseExlUtil getInstance() {
        if (_instance == null)
            return new BaseExlUtil();
        return _instance;
    }

    public  String demoXls= "/xls/Demo.xls";


    public String readFile(InputStream path){

        try {

            File xlsFile= new File(demoXls);
            //OutputStream outputStream =new FileOutputStream(new File())

            FileInputStream fip =new FileInputStream(xlsFile);
            Workbook wkbook =new XSSFWorkbook(fip);
            Sheet dataSheet = wkbook.getSheet("0");

            Iterator<Row> rowIterator= dataSheet.rowIterator();
            if (rowIterator != null)
            while ( rowIterator.hasNext()){
                Iterator<Cell> cellIterator = rowIterator.next().cellIterator();

                if (cellIterator !=null)
                while (cellIterator.hasNext()){
                    Cell thisCell = cellIterator.next();
                    String cellData="";

                            cellData = String.valueOf(thisCell.getStringCellValue());
                    Log.i("data",cellData +" | ");

                }
                Log.i("data","\n");

            }



        } catch (FileNotFoundException  e) {
            e.printStackTrace();
            Log.e("Exception came in ",e.getMessage());
        }catch (IOException e) {
            Log.e("Exception came in ",e.getMessage());
        }


        return "";
    }


}

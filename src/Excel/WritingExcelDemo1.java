package Excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WritingExcelDemo1 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Student data");

        Map<String,String> data=new HashMap<String,String>();
        data.put("100","Ram");
        data.put("101","Sham");
        data.put("102","Tom");

        int rowno=0;

        for(Map.Entry entry:data.entrySet()){
            XSSFRow row=sheet.createRow(rowno++);

            row.createCell(0).setCellValue((String) entry.getKey());
            row.createCell(1).setCellValue((String) entry.getValue());
        }

        FileOutputStream fos =new FileOutputStream("E:\\Trial\\src\\DataFiles\\Student.xlsx");
        workbook.write(fos);
        fos.close();
        System.out.println("Excel Written successfully");


    }
}

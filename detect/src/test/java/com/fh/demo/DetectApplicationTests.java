//package com.fh.demo;
//
//import javafx.scene.control.Cell;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.apache.*;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import java.io.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class DetectApplicationTests {
//
//    @Test
//    public void contextLoads() {
//        System.out.println(123);
//
//    }
//
//    public void writer_Excel(String sSheetName,int iRow,String sColumn,String Data)  {
//        InputStream is=null;
//        OutputStream os=null;
//        iRow=iRow-1;
//        try{
//            is=new FileInputStream(file);
//            workbook=new HSSFWorkbook(is);
//            Sheet sheet=workbook.getSheet(sSheetName);
//
//            int Column=Excel_ReturnColumnIndex(sheet,iRow,sColumn);
//            Cell cell=sheet.getRow(iRow).getCell(Column);
//            System.out.println(getCellValue(cell));
//            cell.setCellType(cell.CELL_TYPE_STRING);
//
//            cell.setCellValue(Data);
//            os=new FileOutputStream(file);
//            workbook.write(os);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            try {
//                os.close();
//            } catch (IOException e1) {
//                // TODO Auto-generated catch block
//                e1.printStackTrace();
//            }
//
//            try {
//                is.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//            try {
//                workbook.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//
//}

//package com.fh.demo;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class TestPoi {
////    public static void updateExcel(File exlFile, String sheetName, int col,
////                                   int row, String value) throws Exception {
////        FileInputStream fis = new FileInputStream(exlFile);
////        HSSFWorkbook workbook = new HSSFWorkbook(fis);
////        // workbook.
////        HSSFSheet sheet = workbook.getSheet(sheetName);
////        HSSFCell mycell = sheet.createRow(row).createCell(col);
////        mycell.setCellValue(value);
////        HSSFRow r = sheet.getRow(row);
////        HSSFCell cell = r.getCell(col);
////        // int type=cell.getCellType();
////        String str1 = cell.getStringCellValue();
////        // 这里假设对应单元格原来的类型也是String类型
////        cell.setCellValue(value);
////        System.out.println("单元格原来值为" + str1);
////        System.out.println("单元格值被更新为" + value);
////
////        fis.close();// 关闭文件输入流
////
////        FileOutputStream fos = new FileOutputStream(exlFile);
////        workbook.write(fos);
////        fos.close();// 关闭文件输出流
////    }
//
//    public static void update2(String url) {
//        int coloum = 2; // 比如你要获取第1列
//        try {
//            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(url));
//            HSSFSheet sheet = workbook.getSheet("Sheet1");
//
//            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//                HSSFRow row = sheet.getRow((short) i);
//                if (null == row) {
//                    continue;
//                }
//                HSSFCell cell = row.getCell((short) coloum);
//                if (null == cell) {
//                    continue;
//                }
//                cell.setCellValue("he1");
//            }
//            FileOutputStream out = null;
//            try {
//                out = new FileOutputStream(url);
//                workbook.write(out);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static boolean writeXlsx(String fileName, int row, int column, String content) {
//        boolean flag = false;
//        FileOutputStream out = null;
//        XSSFWorkbook xwb;
//        try {
//            xwb = new XSSFWorkbook(new FileInputStream(fileName));
//            XSSFSheet xSheet = xwb.getSheetAt(0);
//            XSSFCell xCell = xSheet.createRow(row).createCell(column);
//            xCell.setCellValue(content);
//            out = new FileOutputStream(fileName);
//            xwb.write(out);
//            out.close();
//            flag = true;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        return flag;
//    }
//
//    public static void main(String[] args) throws Exception {
//        // TODO Auto-generated method stub
//        // 下面改成你自己的xls文件进行测试，2003格式的，不能2007
////        File file = new File("/Users/guangtou/Desktop/test.xlsx");
//        // 下面尝试更改第一行第一列的单元格的值
//        update2("/Users/guangtou/Desktop/test.xlsx");
////        File file1 = new File("C:\\Users\\Administrator\\Desktop\\test - 副本.xlsx");
////        writeXlsx("C:\\Users\\Administrator\\Desktop\\test - 副本.xlsx", 0, 0,"1");
//    }
//}
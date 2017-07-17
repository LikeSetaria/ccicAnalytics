package web.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import mybatis.pojo.Order;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 宝超 on 2017/6/10.
 */
public class ReadOrderExcel {

    public List<Order> readOrderExcel(String excelPath) {
        List<Order> list = new ArrayList<Order>();
        XSSFWorkbook workbook = null;

        try {
            InputStream inputStream = new FileInputStream(excelPath);
            workbook=new XSSFWorkbook(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        循环列表
         */
        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = workbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 循环行
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
                Order order=new Order();
                xssfRow.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                XSSFCell cell = xssfRow.getCell(1);
                if (cell == null) {
                    continue;
                }
                order.setSaleModeID(cell.getStringCellValue());

                cell = xssfRow.getCell(2);
                if (cell == null) {
                    continue;
                }
                order.setOrderDate(cell.getDateCellValue().toString());

                cell = xssfRow.getCell(11);
                if (cell == null) {
                    continue;
                }
                order.setCCICCompanyCode(String.valueOf(cell.getNumericCellValue()));

                xssfRow.getCell(10).setCellType(Cell.CELL_TYPE_STRING);

                cell = xssfRow.getCell(10);
                if (cell == null) {
                    continue;
                }
                //System.out.println(cell.getStringCellValue());
                order.setCCICCompanyName(cell.getStringCellValue());

                cell = xssfRow.getCell(9);
                if (cell == null) {
                    continue;
                }
                order.setHandler(cell.getStringCellValue());

                cell = xssfRow.getCell(5);
                if (cell == null) {
                    continue;
                }
                order.setInsuredPerson(cell.getStringCellValue());

                cell = xssfRow.getCell(3);
                if (cell == null) {
                    continue;
                }
                order.setPolicyID(cell.getStringCellValue());
                //xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(4);
                if (cell == null) {
                    continue;
                }
                order.setPremium(cell.getNumericCellValue());

                cell = xssfRow.getCell(6);
                if (cell == null) {
                    continue;
                }
                order.setProjectName(cell.getStringCellValue());
                xssfRow.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(12);
                if (cell == null) {
                    continue;
                }
                order.setStartDate(cell.getStringCellValue());
                list.add(order);
            }
        }
        return list;
    }
}

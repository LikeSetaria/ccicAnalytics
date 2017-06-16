package service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.Order;
import pojo.OrderDetail;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 宝超 on 2017/6/10.
 */
public class ReadOrderDetailExcel {

    public List<OrderDetail> readOrderDetailExcel(String excelPath) {
        List<OrderDetail> list = new ArrayList<OrderDetail>();
        Set<String> keySet=new HashSet<String>();
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
            // 循环行,从第0行开始
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
                OrderDetail orderDetail=new OrderDetail();

                XSSFCell cell = xssfRow.getCell(0);
                if (cell == null) {
                    continue;
                }
                String key1_date=cell.getStringCellValue();
                orderDetail.setDate(key1_date);

                cell = xssfRow.getCell(1);
                if (cell == null) {
                    continue;
                }
                orderDetail.setVIPUserName(cell.getStringCellValue());

                cell = xssfRow.getCell(2);
                if (cell == null) {
                    continue;
                }
                orderDetail.setProviderName(cell.getStringCellValue());

                xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);

                cell = xssfRow.getCell(3);
                if (cell == null) {
                    continue;
                }
                //System.out.println(cell.getStringCellValue());
                orderDetail.setVIPNo(cell.getStringCellValue());

                cell = xssfRow.getCell(4);
                if (cell == null) {
                    continue;
                }
                orderDetail.setCarLicenseNo(cell.getStringCellValue());
                xssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(5);
                if (cell == null) {
                    continue;
                }
                String key2_policyID=cell.getStringCellValue();
                orderDetail.setPolicyID(key2_policyID);

                //xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(6);
                if (cell == null) {
                    continue;
                }
                 String key3_usedIntegral=String.valueOf((int)cell.getNumericCellValue());
                orderDetail.setUsedIntegral(cell.getNumericCellValue());

                cell = xssfRow.getCell(7);
                if (cell == null) {
                    continue;
                }
                orderDetail.setPaintCount((int)cell.getNumericCellValue());

                cell = xssfRow.getCell(8);
                if (cell == null) {
                    continue;
                }
                orderDetail.setMaintenanceCount((int) cell.getNumericCellValue());
                cell = xssfRow.getCell(9);
                if (cell == null) {
                    continue;
                }
                orderDetail.setWashCount((int) cell.getNumericCellValue());
                cell = xssfRow.getCell(10);
                if (cell == null) {
                    continue;
                }
                orderDetail.setAnnualInspectionCount((int) cell.getNumericCellValue());

                cell = xssfRow.getCell(11);
                if (cell == null) {
                    continue;
                }
                orderDetail.setIllegalHandledCount((int)cell.getNumericCellValue());


                cell = xssfRow.getCell(12);
                if (cell == null) {
                    continue;
                }
                int key4_memoLength=cell.getStringCellValue().length();
                orderDetail.setMemo(cell.getStringCellValue().replace("\n",""));
                String primaryKey=key1_date.replace("-","")+key3_usedIntegral+key4_memoLength+key2_policyID;
                orderDetail.setOrderDetailID(primaryKey);

                if(!keySet.contains(primaryKey))//根据主键判断是否存在重复的保单明细，存在则不再存入数据库
                list.add(orderDetail);

                keySet.add(primaryKey);
            }
        }
        return list;
    }
}

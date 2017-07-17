package web.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import mybatis.pojo.User;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 宝超 on 2017/6/10.
 */
public class ReadUserExcel {

    public List<User> readUserExcel(String excelPath) {
        List<User> list = new ArrayList<User>();
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
                User user=new User();
                xssfRow.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                XSSFCell cell = xssfRow.getCell(0);
                if (cell == null) {
                    continue;
                }
                //System.out.println(cell.getStringCellValue());
                String key1=cell.getStringCellValue();
                user.setVipNo(cell.getStringCellValue());

                cell = xssfRow.getCell(1);
                if (cell == null) {
                    continue;
                }
                user.setVipLevel(cell.getStringCellValue());

                cell = xssfRow.getCell(2);
                if (cell == null) {
                    continue;
                }
                user.setVipName(cell.getStringCellValue());

                xssfRow.getCell(3).setCellType(Cell.CELL_TYPE_STRING);

                cell = xssfRow.getCell(3);
                if (cell == null) {
                    continue;
                }
                String key2=cell.getStringCellValue();
                user.setIDNo(cell.getStringCellValue());

                cell = xssfRow.getCell(4);
                if (cell == null) {
                    continue;
                }
                user.setTelephone(cell.getStringCellValue());
                xssfRow.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(5);
                if (cell == null) {
                    continue;
                }

                user.setVehicleType(cell.getStringCellValue());


                //xssfRow.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(6);
                if (cell == null) {
                    continue;
                }
                //System.out.println(cell.getStringCellValue());

                user.setCarLicenseNo(cell.getStringCellValue());

                cell = xssfRow.getCell(7);
                if (cell == null) {
                    continue;
                }
                user.setChassisNo( cell.getStringCellValue());
                xssfRow.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(8);
                if (cell == null) {
                    continue;
                }

                user.setInsuranceStartTime(cell.getStringCellValue());
                xssfRow.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
                cell = xssfRow.getCell(9);
                if (cell == null) {
                    continue;
                }
                user.setInsuranceDuration(cell.getStringCellValue());
                cell = xssfRow.getCell(10);
                if (cell == null) {
                    continue;
                }
                user.setPolicyNo(cell.getStringCellValue());

                cell = xssfRow.getCell(11);
                if (cell == null) {
                    continue;
                }
                user.setPremium(cell.getNumericCellValue());


                cell = xssfRow.getCell(12);
                if (cell == null) {
                    continue;
                }
                user.setOwnershipInstitution(cell.getStringCellValue());
                cell = xssfRow.getCell(13);
                if (cell == null) {
                    continue;
                }
                user.setSource(cell.getStringCellValue());
                cell = xssfRow.getCell(14);
                if (cell == null) {
                    continue;
                }
                user.setAssignProvider(cell.getStringCellValue());
                cell = xssfRow.getCell(15);
                if (cell == null) {
                    continue;
                }
                user.setVipValue(cell.getNumericCellValue());
                cell = xssfRow.getCell(16);
                if (cell == null) {
                    continue;
                }
                user.setVAS_paint((int)cell.getNumericCellValue());
                cell = xssfRow.getCell(17);
                if (cell == null) {
                    continue;
                }
                user.setVAS_maintenance((int)cell.getNumericCellValue());
                cell = xssfRow.getCell(18);
                if (cell == null) {
                    continue;
                }
                user.setVAS_wash((int)cell.getNumericCellValue());
                cell = xssfRow.getCell(19);
                if (cell == null) {
                    continue;
                }
                user.setVAS_AnnualInspection((int)cell.getNumericCellValue());
                cell = xssfRow.getCell(20);
                if (cell == null) {
                    continue;
                }
                user.setVAS_other1((int)cell.getNumericCellValue());
                cell = xssfRow.getCell(21);
                if (cell == null) {
                    continue;
                }
                user.setVAS_other2((int)cell.getNumericCellValue());
                cell = xssfRow.getCell(22);
                if (cell == null) {
                    continue;
                }
                user.setMemo(cell.getStringCellValue());
                if(!keySet.contains(key1+key2)){
                keySet.add(key1+key2);
                list.add(user);}
                else {System.out.println("重复列"+key1+key2);}
            }
        }
        return list;
    }
}

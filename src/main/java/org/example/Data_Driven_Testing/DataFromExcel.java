package org.example.Data_Driven_Testing;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

//Excel File--->Workbook--->Sheets--->Rows----Cells

public class DataFromExcel {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\ASUS\\Desktop\\ERP_Project\\TestScenarios.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int totalRows = sheet.getLastRowNum(); // Excludes header row
        int totalCells = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[totalRows][totalCells];

        for (int r = 1; r <= totalRows; r++) { // Start from 1 to skip header
            XSSFRow currentRow = sheet.getRow(r);
            for (int c = 0; c < totalCells; c++) {
                XSSFCell cell = currentRow.getCell(c);
                data[r - 1][c] = (cell != null) ? cell.toString() : ""; // Avoid nulls
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}
/*
  @Test(dataProvider = "LoginData", dataProviderClass = ReadingDataFromExcel.class)
    public void verify_loginDDT(String email, String password, String exp) {

        logger.info("**** Starting TC_003_LoginDDT *****");

        try {
            // Home page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin(); // Login link under MyAccount

            // Login page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(password);
            lp.clickLogin();
 */

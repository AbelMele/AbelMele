package Excel;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class Excel2 {
        public static void main(String[] args) {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet("https://dummyjson.com/product");
                CloseableHttpResponse response = httpClient.execute(request);
                 int statusCode = response.getStatusLine().getStatusCode();

                // Retrieve the JSON response body
                String responseBody = EntityUtils.toString(response.getEntity());

                // Prettify the JSON data
               ObjectMapper objectMapper = new ObjectMapper();
                Object json = objectMapper.readValue(responseBody, Object.class);
                String prettifiedJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);

                // Print the prettified JSON data
                System.out.println("Prettified JSON Data:");
                System.out.println(prettifiedJson);

                // Create Excel workbook and sheet

               Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("JSON Data");
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Prettified JSON Data");

                // Create cell to store JSON data
                Row dataRow = sheet.createRow(1);
                Cell dataCell = dataRow.createCell(0);
                dataCell.setCellValue(prettifiedJson);

                // Save Excel file
                String filePath = "src/File/excel.xlsx"; // Relative path to src/File directory
                try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                    workbook.write(outputStream);
                }

                System.out.println("Excel file saved successfully.");

                // Close the HttpClient
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


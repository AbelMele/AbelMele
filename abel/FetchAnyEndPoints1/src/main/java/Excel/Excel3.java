package Excel;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

    public class Excel3 {
        public static void main(String[] args) {
            try {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpGet request = new HttpGet("https://dummyjson.com/product");
                CloseableHttpResponse response = httpClient.execute(request);

                String responseBody = EntityUtils.toString(response.getEntity());
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(responseBody);

                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Products");

                int rowNum = 0;
                Row headerRow = sheet.createRow(rowNum++);
                headerRow.createCell(0).setCellValue("Title");
                headerRow.createCell(1).setCellValue("Description");
                headerRow.createCell(2).setCellValue("Price");
                headerRow.createCell(3).setCellValue("Discount Percentage");
                headerRow.createCell(4).setCellValue("Rating");
                headerRow.createCell(5).setCellValue("Stock");
                headerRow.createCell(6).setCellValue("Brand");
                headerRow.createCell(7).setCellValue("Category");
                headerRow.createCell(8).setCellValue("Thumbnail");

                JsonNode productsNode = jsonNode.get("products");
                if (productsNode.isArray()) {
                    for (JsonNode productNode : productsNode) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(productNode.get("title").asText());
                        row.createCell(1).setCellValue(productNode.get("description").asText());
                        row.createCell(2).setCellValue(productNode.get("price").asDouble());
                        row.createCell(3).setCellValue(productNode.get("discountPercentage").asDouble());
                        row.createCell(4).setCellValue(productNode.get("rating").asDouble());
                        row.createCell(5).setCellValue(productNode.get("stock").asInt());
                        row.createCell(6).setCellValue(productNode.get("brand").asText());
                        row.createCell(7).setCellValue(productNode.get("category").asText());
                        row.createCell(8).setCellValue(productNode.get("thumbnail").asText());
                    }
                }

                // Save the workbook to a file
                try (FileOutputStream fileOut = new FileOutputStream("src/File/excel.xlsx")) {
                    workbook.write(fileOut);
                }

                // Close resources
                response.close();
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



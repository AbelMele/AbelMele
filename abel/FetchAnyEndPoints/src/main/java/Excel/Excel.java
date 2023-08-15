package Excel;
//Abel
//8/10/2023

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    public static void main(String[] args) {
        try {

                    CloseableHttpClient httpClient = HttpClients.createDefault();
                    HttpGet request = new HttpGet("https://dummyjson.com/products");
                    CloseableHttpResponse response = httpClient.execute(request);

                    String responseBody = EntityUtils.toString(response.getEntity());
                    ObjectMapper objectMapper = new ObjectMapper();
                   // Object json = objectMapper.readValue(responseBody, Object.class);
                    JsonNode jsonData = objectMapper.readTree(responseBody);



                    //System.out.println(prettifiedJson);

                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("products Data");

                   // headerRow.createCell(0).setCellValue("Prettified JSON Data");
                   int rowIdx = 1;

                   Row headerRow = sheet.createRow(rowIdx++);
                   //Row dataRow = sheet.createRow(1);
                    String [] headers= {"Id","Title", "Description", "Price", "DiscountPercentage", "Rating", "Stock", "Thumbnail", "Image"};
                    for (int i =0; i < headers.length; i++){
                        headerRow.createCell(i).setCellValue(headers[i]);
                    }

                    List<products> productsList = new ArrayList<>();

                    for ( JsonNode productNode : jsonData.get("products")) {
                        productsList.add(objectMapper.treeToValue(productNode, products.class));


                        // dataCell.setCellValue(prettifiedJson);
                        Row dataRow = sheet.createRow(rowIdx);
                        dataRow.createCell(0).setCellValue(products.getId());
                        dataRow.createCell(1).setCellValue(products.getTitle());
                        dataRow.createCell(2).setCellValue(products.getDescription());
                        dataRow.createCell(3).setCellValue(products.getPrice());
                        dataRow.createCell(4).setCellValue(products.getDiscountPercentage());
                        dataRow.createCell(5).setCellValue(products.getRate());
                        dataRow.createCell(6).setCellValue(products.getStock());
                        dataRow.createCell(7).setCellValue(products.getBrand());
                        dataRow.createCell(8).setCellValue(products.getCategory());
                        dataRow.createCell(9).setCellValue(products.getThumbnail());
                        dataRow.createCell(10).setCellValue(products.getImage());

                    }
                    for (int i = 0; i< productsList.size(); i++) {
                    System.out.println("product Title:" + products.getTitle());
                    }



                    String filePath = "src/File/excel.xlsx";
                    try (FileOutputStream outputStream = new FileOutputStream(filePath)){
                        workbook.write(outputStream);
                    }
                    System.out.println("Excel file saved successfully.");

                    httpClient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

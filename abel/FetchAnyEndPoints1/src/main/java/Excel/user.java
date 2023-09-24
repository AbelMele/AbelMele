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


public class user {
    public static void main(String[] args) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpGet request = new HttpGet("https://dummyjson.com/users");
            CloseableHttpResponse response = httpClient.execute(request);

            String responseBody = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("users");



            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("First Name"); // Adjust column headers
            headerRow.createCell(1).setCellValue("Last Name");
            headerRow.createCell(2).setCellValue("Age");
            headerRow.createCell(3).setCellValue("Gender");
            headerRow.createCell(4).setCellValue("Email");
            headerRow.createCell(5).setCellValue("Phone");
            headerRow.createCell(6).setCellValue("Username");
            headerRow.createCell(7).setCellValue("Birth Date");
            headerRow.createCell(8).setCellValue("Image");
            headerRow.createCell(9).setCellValue("Blood Group");
            headerRow.createCell(10).setCellValue("Height");
            headerRow.createCell(11).setCellValue("Weight");
            headerRow.createCell(12).setCellValue("Eye Color");
            headerRow.createCell(13).setCellValue("Hair Color");
            headerRow.createCell(14).setCellValue("Hair Type");
            headerRow.createCell(15).setCellValue("Domain");
            headerRow.createCell(16).setCellValue("IP");
            headerRow.createCell(17).setCellValue("Address");
            headerRow.createCell(18).setCellValue("City");
            headerRow.createCell(19).setCellValue("Postal Code");
            headerRow.createCell(20).setCellValue("State");
            headerRow.createCell(21).setCellValue("MAC Address");
            headerRow.createCell(22).setCellValue("University");
            headerRow.createCell(23).setCellValue("Card Expiry Date");
            headerRow.createCell(24).setCellValue("Card Number");
            headerRow.createCell(25).setCellValue("Card Type");
            headerRow.createCell(26).setCellValue("Currency");
            headerRow.createCell(27).setCellValue("IBAN");
            headerRow.createCell(28).setCellValue("Company Address");
            headerRow.createCell(29).setCellValue("Company City");
            headerRow.createCell(30).setCellValue("Company Postal Code");
            headerRow.createCell(31).setCellValue("Company State");
            headerRow.createCell(32).setCellValue("Department");
            headerRow.createCell(33).setCellValue("Company Name");
            headerRow.createCell(34).setCellValue("Job Title");
            headerRow.createCell(35).setCellValue("EIN");
            headerRow.createCell(36).setCellValue("SSN");
            headerRow.createCell(37).setCellValue("User Agent");

            JsonNode usersNode = jsonNode.get("users"); // Change to "users"
            if (usersNode != null && usersNode.isArray()) {
                for (JsonNode userNode : usersNode) { // Change to "userNode"
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(userNode.get("firstName").asText());
                    row.createCell(1).setCellValue(userNode.get("lastName").asText());
                    row.createCell(2).setCellValue(userNode.get("age").asInt());
                    row.createCell(3).setCellValue(userNode.get("gender").asText());
                    row.createCell(4).setCellValue(userNode.get("email").asText());
                    row.createCell(5).setCellValue(userNode.get("phone").asText());
                    row.createCell(6).setCellValue(userNode.get("username").asText());
                    row.createCell(7).setCellValue(userNode.get("birthDate").asText());
                    row.createCell(8).setCellValue(userNode.get("image").asText());
                    row.createCell(9).setCellValue(userNode.get("bloodGroup").asText());
                    row.createCell(10).setCellValue(userNode.get("height").asDouble());
                    row.createCell(11).setCellValue(userNode.get("weight").asDouble());
                    row.createCell(12).setCellValue(userNode.get("eyeColor").asText());
                    row.createCell(13).setCellValue(userNode.get("hair").get("color").asText());
                    row.createCell(14).setCellValue(userNode.get("hair").get("type").asText());
                    row.createCell(15).setCellValue(userNode.get("domain").asText());
                    row.createCell(16).setCellValue(userNode.get("ip").asText());
                    row.createCell(17).setCellValue(userNode.get("address").get("address").asText());
                    row.createCell(18).setCellValue(userNode.get("address").get("city").asText());
                    row.createCell(19).setCellValue(userNode.get("address").get("postalCode").asText());
                    row.createCell(20).setCellValue(userNode.get("address").get("state").asText());
                    row.createCell(21).setCellValue(userNode.get("macAddress").asText());
                    row.createCell(22).setCellValue(userNode.get("university").asText());
                    row.createCell(23).setCellValue(userNode.get("bank").get("cardExpire").asText());
                    row.createCell(24).setCellValue(userNode.get("bank").get("cardNumber").asText());
                    row.createCell(25).setCellValue(userNode.get("bank").get("cardType").asText());
                    row.createCell(26).setCellValue(userNode.get("bank").get("currency").asText());
                    row.createCell(27).setCellValue(userNode.get("bank").get("iban").asText());
                    row.createCell(28).setCellValue(userNode.get("company").get("address").get("address").asText());
                    JsonNode companyCityNode = userNode.get("company").get("address").get("city");
                    if (companyCityNode != null && companyCityNode.isTextual()){
                        row.createCell(29).setCellValue(userNode.get("company").get("address").get("city").asText());
                    }
                    else {
                        row.createCell(29).setCellValue("");

                    }
                    row.createCell(30).setCellValue(userNode.get("company").get("address").get("postalCode").asText());
                    row.createCell(31).setCellValue(userNode.get("company").get("address").get("state").asText());
                    row.createCell(32).setCellValue(userNode.get("company").get("department").asText());
                    row.createCell(33).setCellValue(userNode.get("company").get("name").asText());
                    row.createCell(34).setCellValue(userNode.get("company").get("title").asText());
                    row.createCell(35).setCellValue(userNode.get("ein").asText());
                    row.createCell(36).setCellValue(userNode.get("ssn").asText());
                    row.createCell(37).setCellValue(userNode.get("userAgent").asText());
                }

            }
            else {
                System.out.println("No, 'users' node found in JSON response or it is not array.");
            }

            try (FileOutputStream fileOut = new FileOutputStream("src/File/users.xlsx")) {
                workbook.write(fileOut);
            }

            response.close();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

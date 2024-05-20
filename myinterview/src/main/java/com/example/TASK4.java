package com.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * AWS s3 bucket => interview-digiage
 *
 */
public class TASK4 {
	private static final String API_ENDPOINT = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";
    private static final String BUCKET_NAME = "interview-digiage";
    private static final String FILE_NAME = "gender_count_bruno_silverio.txt";
    
    public static void main(String[] args) {
    	try {
    		// Save the JSON with all the records from employees to the string json
            String json = endpointApi(API_ENDPOINT);
            System.out.println("\nJSON File from AWS S3: " + json);

            // Count employees by gender
            Map<String, Integer> countGender = countEmployeesByGender(json);
            System.out.println("\nHow many records exists for each gender: " + countGender);
            
            // Save the counts to a file
            String filePath = saveCountsToFile(countGender);
            System.out.println("\nFile Path: " + filePath);

            // Upload the file to S3
            uploadFileToS3(filePath, BUCKET_NAME, FILE_NAME);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /* [
     *   {
     *		"emp_no": 10001,
     * 		"first_name": "Georgie",
     *		"last_name": "Facello",
     *		"gender": "M"
  	 *	 },
  	 *	 ...
     * 	Return the JSON with all the employees
     * */
    private static String endpointApi(String apiUrl) throws IOException {
    	
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
        	
            HttpGet request = new HttpGet(apiUrl);
            HttpResponse response = httpClient.execute(request);
            
            return EntityUtils.toString(response.getEntity());
        }
    }

    // Return the employees group by gender
    private static Map<String, Integer> countEmployeesByGender(String json) throws IOException {
    	
        Map<String, Integer> countGender = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);
        
        for (JsonNode node : rootNode) {
            String gender = node.path("gender").asText();
            countGender.put(gender, countGender.getOrDefault(gender, 0) + 1);
        }
        
        return countGender;
    }
    
    // Save the gender count (M / F) in the file
    private static String saveCountsToFile(Map<String, Integer> genderCounts) throws IOException {
    	
        StringBuilder data = new StringBuilder();
        
        for (Map.Entry<String, Integer> entry : genderCounts.entrySet()) {
            data.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        
        String filePath = System.getProperty("java.io.tmpdir") + FILE_NAME;
        Files.write(Paths.get(filePath), data.toString().getBytes());
        
        return filePath;
    }

    // Reference: https://docs.aws.amazon.com/AmazonS3/latest/userguide/upload-objects.html
    private static void uploadFileToS3(String filePath, String bucketName, String fileName) {
    	
        S3Client s3 = S3Client.builder().region(Region.US_WEST_2).credentialsProvider(DefaultCredentialsProvider.create()).build();

        PutObjectRequest putObjectRequest = PutObjectRequest.builder().bucket(bucketName).key(fileName).build();

        s3.putObject(putObjectRequest, RequestBody.fromFile(Paths.get(filePath)));
    }
}
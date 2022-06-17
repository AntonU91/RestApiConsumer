import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Consumer {
    public static void main(String[] args) throws IOException {
     RestTemplate restTemplate = new RestTemplate();
////        String url ="https://reqres.in/api/users/2";
////       String response = restTemplate.getForObject(url, String.class);
////        System.out.println(response);
//
//        String url = "https://reqres.in/api/users";
//        Map<String, String> newUser = new HashMap<>();
//        newUser.put("name", "Test user");
//        newUser.put("age", "testAge");
//        HttpEntity<Map<String, String>> request = new HttpEntity<>(newUser);
//
//
//        String response = restTemplate.postForObject(url, request, String.class);
//        System.out.println(response);

        /////////////////////
        Scanner scanner = new Scanner(System.in);
        String lineForTranslating=  scanner.nextLine();

        String url = "https://translation.googleapis.com/language/translate/v2";
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add( "Authorization","Bearer "+ "ya29.c.b0AXv0zTOHvjt_0fwBYJB79C_sPczuq9WfN1MNXcyPYIOQ-oqN5QaaT3ZNaBv6wYfnrb9fJY-ktGouSgkybyYLn0UY5GI_dzKZe8W5vc8a4P9GjrcWqSceJzwy9k4h6qtUhm7u5bfV4UZzDFx6c0nL-duRcJA3mXei9DVdEusOKcIqEXQRQCSaV_jFAlsSb30C8-Xjv8zU88jfZJdoC2Id-N_Ta8AoRRg");
        Map<String,String> jsonData = new HashMap<>();
        jsonData.put("q",  lineForTranslating);
        jsonData.put("target", "en");

        // Парсим полученны jason c помощью jackson




//        File file =new File("translate.json");
//        FileReader fileReader = new FileReader(file);
//       int symbol = fileReader.read();
//       while (symbol!=1) {
//
//       }



        HttpEntity< Map<String,String>> request =  new HttpEntity<>(jsonData,headers);
       GoogleResponse response = restTemplate.postForObject(url,request, GoogleResponse.class);
       // System.out.println(response);
//
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode obj = mapper.readTree(response);
       // System.out.println(obj.get("data").get("translations").get(0).get("translatedText"));

    System.out.println(response.getData().getTranslations().get(0).getTranslatedText());


    }
}

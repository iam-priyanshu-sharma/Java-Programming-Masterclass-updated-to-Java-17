package com.timbuchalka;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by timbuchalka on 8/5/17.
 */
public class ApacheTest {
    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://example.org");
        request.addHeader("User-Agent", "Chrome");

        CloseableHttpResponse response = httpClient.execute(request);

        try {
            System.out.println("response code = " + response.getStatusLine().getStatusCode());

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line;

            while((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();

        } catch(IOException e) {
            System.out.println("IOException = " + e.getMessage());
        } finally {
            response.close();
        }

    }
}

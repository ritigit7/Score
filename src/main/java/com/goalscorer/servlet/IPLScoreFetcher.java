package com.goalscorer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IPLScoreFetcher extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type of the response
        response.setContentType("text/plain");

        // Get PrintWriter object
        PrintWriter out = response.getWriter();

        // Build the HTTP request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.sportmonks.com/:version/:sport/leagues"))
                .GET()
                .build();

        // Send the HTTP request and process the response
        try {
            HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());

            // Write the response body to PrintWriter
            out.println(httpResponse.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close PrintWriter
            out.close();
        }
    }
}

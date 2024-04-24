package com.goalscorer.servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Scrap extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
 List<String> liveMatches = fetchLiveMatches();
        
        for (String match : liveMatches) {
            out.println(match);
        }
    }
    public static List<String> fetchLiveMatches() {
        List<String> liveMatches = new ArrayList<>();
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        
        try {
            URL url = new URL("https://www.cricbuzz.com/cricket-match/live-scores");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            
            StringBuilder response = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            
            // Regular expression to extract live match information
            String regex = "<div class=\"cb-scr-wll-chvrn cb-lv-scrs-col\">(.*?)</div>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(response.toString());
            
            while (matcher.find()) {
                String match = matcher.group(1).trim();
                liveMatches.add(match);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        
        return liveMatches;
    }
}

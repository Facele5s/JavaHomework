package edu.hw6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private static final String URL_TOP_STORIES = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String URL_ITEM = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private static final int HTTP_SUCCESSFUL = 200;

    private HackerNews() {

    }

    public static long[] hackerNewsTopStories() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_TOP_STORIES))
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HTTP_SUCCESSFUL) {
                String[] stringIds = response.body().replaceAll("[\\[\\]]", "")
                    .split(",");
                long[] newsIds = new long[stringIds.length];

                for (int i = 0; i < newsIds.length; i++) {
                    newsIds[i] = Long.parseLong(stringIds[i]);
                }

                return newsIds;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new long[0];
    }

    public static String news(long id) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(URL_ITEM, id)))
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HTTP_SUCCESSFUL) {
                Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
                Matcher matcher = pattern.matcher(response.body());

                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}

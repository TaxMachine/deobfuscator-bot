package dev.maxtachine.utils.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.maxtachine.utils.webhook.objects.DiscordWebhook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Discord {
    private String webhookUrl;

    public Discord(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    public DiscordWebhook get() throws IOException, URISyntaxException {
        URL url = new URI(webhookUrl).toURL();
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result.toString(), DiscordWebhook.class);
    }

    public boolean isValidWebhook() {
        try {
            URL url = new URI(webhookUrl).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException | URISyntaxException e) {
            return false;
        }
    }
}

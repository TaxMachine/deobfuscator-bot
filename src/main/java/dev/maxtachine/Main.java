package dev.maxtachine;

import dev.maxtachine.listeners.SlashCommandListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final Dotenv dotenv = Dotenv.load();
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static List<String> getResourceFolderFiles (String folder) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(folder);
        assert url != null;
        String path = url.getPath();
        List<String> names = new ArrayList<>();
        File[] list = new File(path).listFiles();
        assert list != null;
        for (File file : list) {
            if (file.isDirectory()) continue;
            names.add(file.getName());
        }
        return names;
    }

    public static void main(String[] args) {
        final GatewayDiscordClient client = DiscordClientBuilder.create(Objects.requireNonNull(dotenv.get("TOKEN"))).build()
                .login()
                .block();


        List<String> commands = getResourceFolderFiles("commands");
        try {
            new GlobalCommandRegistrar(client.getRestClient()).registerCommands(commands);
        } catch (Exception e) {
            LOGGER.error("Error trying to register slash commands", e);
        }

        client.on(ChatInputInteractionEvent.class, SlashCommandListener::handle)
                .then(client.onDisconnect())
                .block();
    }
}
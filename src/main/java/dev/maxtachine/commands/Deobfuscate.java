package dev.maxtachine.commands;

import dev.maxtachine.utils.Deobfuscation;
import dev.maxtachine.utils.DeobfuscationResults;
import dev.maxtachine.utils.webhook.Discord;
import dev.maxtachine.utils.webhook.objects.DiscordWebhook;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import discord4j.core.spec.EmbedCreateFields;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Deobfuscate implements SlashCommand {
    @Override
    public String getName() {
        return "deobfuscate";
    }

    @Override
    public Mono<Void> handle(ChatInputInteractionEvent event) {
        String downloadLink = event.getOption("url")
                .flatMap(ApplicationCommandInteractionOption::getValue)
                .map(ApplicationCommandInteractionOptionValue::asString)
                .get();

        URI download;

        try {
            download = new URI(downloadLink);
        } catch (URISyntaxException e) {
            return event.reply()
                    .withEphemeral(true)
                    .withContent("Invalid URL");
        }

        DeobfuscationResults deobfuscationResults;

        try {
            deobfuscationResults = Deobfuscation.Deobfuscate(download.toString());
        } catch (IOException | InterruptedException e) {
            return event.reply()
                    .withEphemeral(true)
                    .withContent(e.getMessage());
        }

        EmbedCreateSpec.Builder builder = EmbedCreateSpec.builder()
                .title("Deobfuscation Results")
                .addField("Type", deobfuscationResults.getType(), true)
                .addField("PyInstaller Version", deobfuscationResults.getPyinstallerVersion(), true)
                .addField("Python Version", deobfuscationResults.getPythonVersion(), true)
                .addField("Webhook", deobfuscationResults.getWebhook(), false)
                .footer(EmbedCreateFields.Footer.of("Deobfuscator Bot", ""))
                .url("https://github.com/TaxMachine");

        if (deobfuscationResults.getWebhook().contains("discord")) {
            try {
                Discord discord = new Discord(deobfuscationResults.getWebhook());
                if (discord.isValidWebhook()) {
                    DiscordWebhook discordWebhook = discord.get();
                    builder.addField("Valid?", "True", false);
                    builder.addField("Webhook Name", discordWebhook.getName(), true);
                    builder.addField("Webhook ID", discordWebhook.getId(), true);
                    builder.addField("Webhook Guild ID", discordWebhook.getGuildId(), true);
                    builder.addField("Webhook Author Name", discordWebhook.getUser().getUsername(), true);
                    builder.addField("Webhook Author ID", discordWebhook.getUser().getId(), true);
                    builder.color(Color.GREEN);
                }
            } catch (IOException | URISyntaxException e) {
                builder.addField("Valid?", "False", false);
                builder.color(Color.RED);
            }
        }

        return event.reply()
                .withEmbeds(builder.build());
    }
}

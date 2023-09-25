package dev.maxtachine.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Deobfuscation {
    public static DeobfuscationResults Deobfuscate(String filename) throws IOException, InterruptedException {
        String results = CommandRun.run(".\\deobf.dist\\deobf.exe", "-d", filename, "-j");

        System.out.println("deobfuscation results: " + results);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(results, DeobfuscationResults.class);
    }
}

package dev.maxtachine.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CommandRun {
    public static String run(String ...command) throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec(command);
        System.out.println("executing " + Arrays.toString(command));
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        System.out.println("Reading output...");
        System.out.println(r);
        while ((line = r.readLine()) != null) {
            output.append(r.readLine());
        }

        p.waitFor();

        return line;
    }
}

package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileLineExtractor {

    private static final String INPUT_FOLDER = "D:\\dbs\\RuneScape"; // Replace with your folder path
    private static final String OUTPUT_FILE = "sample_output.txt"; // File to save the extracted lines
    private static final int LINES_TO_COPY = 5;

    public static void main(String[] args) {
        try {
            File folder = new File(INPUT_FOLDER);

            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("Invalid folder path: " + INPUT_FOLDER);
                return;
            }

            File outputFile = new File(OUTPUT_FILE);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                processFolder(folder, writer);
            }

            System.out.println("Sample lines copied to: " + OUTPUT_FILE);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void processFolder(File folder, BufferedWriter writer) throws IOException {
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found in folder: " + folder.getAbsolutePath());
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // Process subfolders recursively
                processFolder(file, writer);
            } else {
                // Process individual files
                processFile(file, writer);
            }
        }
    }

    private static void processFile(File file, BufferedWriter writer) {
        System.out.println("Processing file: " + file.getName());

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            writer.write("File: " + file.getAbsolutePath());
            writer.newLine();

            int linesRead = 0;
            String line;

            while ((line = reader.readLine()) != null && linesRead < LINES_TO_COPY) {
                writer.write(line);
                writer.newLine();
                linesRead++;
            }

            writer.newLine(); // Add an empty line between files
        } catch (IOException e) {
            System.out.println("Error processing file: " + file.getName() + " - " + e.getMessage());
        }
    }
}
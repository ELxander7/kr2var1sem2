package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String logFileName = "C:\\javaprojects\\firstyear\\eldar2\\eldar2\\files\\cw2\\v1\\v1.log";
        String combinedFileName = "C:\\javaprojects\\firstyear\\eldar2\\eldar2\\files\\cw2\\v1\\v1.txt";
        StringBuilder log = new StringBuilder();
        List<FileData> fileDatas = new ArrayList<>();

        try (FileWriter writer = new FileWriter(logFileName)) {
            File[] files = new File("C:/javaprojects/firstyear/eldar2/eldar2/files/cw2/v1").listFiles();
            List<FileReaderThread> threads = new ArrayList<>();

            for (File file : files) {
                FileReaderThread thread = new FileReaderThread(file, log, fileDatas);
                threads.add(thread);
                thread.start();
            }

            for (FileReaderThread thread : threads) {
                thread.join();
            }

            String combinedText = DataManager.combineText(fileDatas);

            writer.write(log.toString());
            writer.flush();

            try (FileWriter combinedWriter = new FileWriter(combinedFileName)) {
                combinedWriter.write(combinedText);
                combinedWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


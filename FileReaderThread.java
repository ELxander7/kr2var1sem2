package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class FileReaderThread extends Thread {
    private File file;
    private StringBuilder log;
    private List<FileData> fileDatas;

    public FileReaderThread(File file, StringBuilder log, List<FileData> fileDatas) {
        this.file = file;
        this.log = log;
        this.fileDatas = fileDatas;
    }

    @Override
    public void run() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(file.getPath()));

            FileData fileData = new FileData(0, new String(data, "UTF-8"), 0, 0);
            synchronized (fileDatas) {
                fileDatas.add(fileData);
            }

            synchronized (log) {
                log.append("прочитали файл " + file.getName() + ", кол-во байт данных: " + data.length
                        + ", кол-во считанных символов: " + fileData.getS().length() + ", контрольное число: "
                        + fileData.getD() + ", номер части: " + fileData.getP() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


package org.example;

import java.util.List;

public class DataManager {

    public static String combineText(List<FileData> fileDatas) {
        StringBuilder combinedText = new StringBuilder();

        for (FileData fileData : fileDatas) {
            combinedText.append(fileData.getText());
        }

        return combinedText.toString();
    }

}

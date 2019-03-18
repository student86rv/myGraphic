package com.company;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class FileHelper {

    public static void writeToFile(Board board, String fileName) {
        Gson gson = new Gson();
        String jsonBoard = gson.toJson(board);
        try {
            FileUtils.writeStringToFile(new File(fileName), jsonBoard, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Board readFromFile(String fileName) {

        String jsonBoard = "";
        try {
            jsonBoard = FileUtils.readFileToString(new File(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.fromJson(jsonBoard, Board.class);
    }
}

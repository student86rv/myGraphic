package com.company;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class FileHelper {

    public static void writeToFile(PrimitiveShape.PrimitiveBoard primitiveBoard, String fileName) {
        Gson gson = new Gson();
        String jsonBoard = gson.toJson(primitiveBoard);
        try {
            FileUtils.writeStringToFile(new File(fileName), jsonBoard, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.log("Game saved to file");
    }

    public static PrimitiveShape.PrimitiveBoard readFromFile(String fileName) {

        String jsonBoard = "";
        try {
            jsonBoard = FileUtils.readFileToString(new File(fileName), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.fromJson(jsonBoard, PrimitiveShape.PrimitiveBoard.class);
    }
}

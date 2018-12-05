package controller;

import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class WorkWithFiles {
    final private static Logger logger = Logger.getLogger(WorkWithFiles.class);

    static ArrayList<String> readFileByName (String fileName) {
        ArrayList<String> result = new ArrayList<>();

        try {
            Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach(result::add);
            logger.info("File was read");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    static void writeInFile (String fileName, ArrayList<String> lines) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
            writer.flush();
            logger.info("File was written");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}

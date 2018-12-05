package controller;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UserInput {
    private BufferedReader reader;

    final private static Logger logger = Logger.getLogger(UserInput.class);

    UserInput () {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String readString () {
        String result = "";

        try  {
            String str = reader.readLine();
            if (str != null) result = str;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    int readInteger () {
        StringBuilder string = null;
        boolean isDigit = false;

        while (!isDigit) {
            string = new StringBuilder(readString());
            isDigit = string.chars().allMatch(Character::isDigit);
        }

        logger.info("Integer was read");
        return Integer.parseInt(string.toString());
    }

    double readDouble () {
        String string = "";
        boolean isDigit = false;

        while (!isDigit) {
            string = readString();

            if (string.split(".").length <= 2) {
                for (String str : string.split("\\.")) {
                    isDigit = str.chars().allMatch(Character::isDigit);
                }
            }
        }

        logger.info("Double was read");
        return Double.parseDouble(string);
    }

    void closeReader () {
        try {
            reader.close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}

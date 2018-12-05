package controller;

import org.apache.log4j.Logger;

import java.util.ArrayList;

class DataWriter {
    private UserInput userInput;
    private ArrayList<String> lines;

    final private static Logger logger = Logger.getLogger(DataWriter.class);

    DataWriter (UserInput userInput) {
        this.userInput = userInput;
    }

    void getLinesAndWrite (String fileName) {
        lines = new ArrayList<>();
        int i = 0;

        logger.info("Read parameters from user");
        while (i < 10) {
            System.out.println("Enter type of new sweet: \n" +
                    "enter 1 for: Candy      enter 2 for: Candy Bar     enter 3 for: Cookie");
            firstLine();

            System.out.println("Enter name: ");
            lines.add(userInput.readString());

            System.out.println("Enter weight: ");
            lines.add(userInput.readInteger() + "");

            System.out.println("Enter cost: ");
            lines.add(userInput.readDouble() + "");

            System.out.println("Enter last parameter(unique for every class. Only string!): ");
            lines.add(userInput.readString());
            lines.add("\n");
            i++;
        }

        logger.info("Write parameters in file");
        WorkWithFiles.writeInFile(fileName, lines);
    }

    private void firstLine () {
        boolean ok = false;

        while (!ok) {
            int chose = userInput.readInteger();
            switch (chose) {
                case 1:
                    lines.add("Candy");
                    ok = true;
                    break;
                case 2:
                    lines.add("Candy Bar");
                    ok = true;
                    break;
                case 3:
                    lines.add("Cookie");
                    ok = true;
                    break;
                default:
                    logger.warn("Wrong number!");
            }
        }

        logger.info("Find type of object");
    }
}

package controller;

import model.Model;
import view.View;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private Model model;
    private View view;
    private int sortType = 0;
    private UserInput userInput;

    private String sweetsDataFile;
    private String serializedGift;
    private String searchAndParamFile;
    private String serializedSweet;

    final private static Logger logger = Logger.getLogger(Controller.class);

    public Controller () {
        logger.info("Creating model");
        this.model = new Model();

        logger.info("Creating view");
        this.view = new View(this);

        logger.info("Open User Input");
        userInput = new UserInput();

        String initFile = "/home/azathoth/IdeaProjects/New_Year_gift/src/main/resources/Init";
        logger.info("Initialization file is " + initFile);

        logger.info("Read work files from initialization file");
        sweetsDataFile = WorkWithFiles.readFileByName(initFile).get(0);
        serializedGift = WorkWithFiles.readFileByName(initFile).get(1);
        searchAndParamFile = WorkWithFiles.readFileByName(initFile).get(2);
        serializedSweet = WorkWithFiles.readFileByName(initFile).get(3);
    }

    public void writeDataFromUser() {
        logger.info("write user parameters");
        DataWriter data = new DataWriter(userInput);
        view.printMessage("Write parameters of sweets: ");
        data.getLinesAndWrite(sweetsDataFile);

        logger.warn("Creating objects from user parameters");
        model.createSweets(WorkWithFiles.readFileByName(sweetsDataFile));
        view.viewSave();
    }

    public void fillAndSaveGift() {
        logger.warn("Sort and save object");
        sortType = userInput.readInteger();
        model.fillAndSaveGift(serializedGift, sortType);
        view.foundView();
    }

    public void findSweet() {
        int type = userInput.readInteger();

        view.printMessage("Enter name: ");
        String name = userInput.readString();

        view.printMessage("Enter weight: ");
        int weight = userInput.readInteger();

        view.printMessage("Enter cost: ");
        double cost = userInput.readDouble();

        logger.warn("Find and save user searching object");
        WorkWithFiles.writeInFile(searchAndParamFile,
                new ArrayList<>(Arrays.asList(sortType + "", type + "", name, weight + "", cost + "")));

        model.findSweet(serializedGift, serializedSweet, type, name, weight, cost);

        userInput.closeReader();
    }
}

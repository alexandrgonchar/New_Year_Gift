package view;

import controller.Controller;

public class View {
    private Controller controller;

    public View (Controller controller) {
        this.controller = controller;
    }

    public void printMessage (String message) {
        System.out.println(message);
    }

    public void viewSave () {
        printMessage("Write sorting type: ");
        controller.fillAndSaveGift();
    }

    public void foundView () {
        printMessage("Write type of sweet, name of sweet, weight of sweet and cost of sweet");
        printMessage("Chose from: \n" +
                "enter 1 for: Candy      enter 2 for: Candy Bar     enter 3 for: Cookie");

        controller.findSweet();
    }
}

package model;

import model.sweets.*;

import java.util.ArrayList;

public class Model {
    private ArrayList<Sweet> sweets;
    private Gift gift;

    public void createSweets (ArrayList<String> list) {
        DataReader dataReader = new DataReader(list);
        sweets = dataReader.getSweetFormData();
    }

    public void fillAndSaveGift (String fileName, int compareChose) {
        gift = new Gift(20, sweets);
        sortGift(compareChose);
        SerializeObject.serialize(fileName, gift);
    }

    public void findSweet (String fileName, String serializedFile,
                           int type, String name, int weight, double cost) {

        Sweet result = null;

        Gift gift = (Gift)SerializeObject.deserialize(fileName);

        for (Sweet sweet : gift.getGift()) {
            if (getType(type).equals(sweet.getClass().getName())) {
                if (sweet.getName().equals(name) && sweet.getWeight() == weight
                        && sweet.getCost() == cost)
                    result = sweet;
            }
        }

        SerializeObject.serialize(serializedFile, result);
    }

    private void sortGift (int compareChose) {
        switch (compareChose) {
            case 1:
                gift.getGift().sort((sweet1, sweet2) ->
                        (sweet1.getName()).compareToIgnoreCase(sweet2.getName()));
                break;
            case 2:
                gift.getGift().sort((sweet1, sweet2) ->
                        (sweet1.getWeight() - sweet2.getWeight()));
                break;
            case 3:
                gift.getGift().sort((sweet1, sweet2) ->
                        (Double.compare(sweet1.getCost(), sweet2.getCost())));
                break;
        }
    }

    private String getType (int type) {
        String res = Object.class.getName();

        switch (type) {
            case 1:
                res = Candy.class.getName();
                break;
            case 2:
                res = CandyBar.class.getName();
                break;
            case 3:
                res = Cookie.class.getName();
                break;
        }

        return res;
    }
}

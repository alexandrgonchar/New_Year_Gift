package model.sweets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Gift implements Serializable {
    private int maxWeight;
    private ArrayList<Sweet> gift = new ArrayList<>();

    public Gift (int maxWeight, List<Sweet> sweets) {
        this.maxWeight = maxWeight;
        giftFill(sweets);
    }

    private void giftFill (List<Sweet> sweets) {
        for (Sweet sweet : sweets) {
            if (maxWeight > 0) {
                maxWeight -= sweet.getWeight();
                gift.add(sweet);

            } else {
                System.out.println("The gift is full");
                break;
            }
        }
    }

    public List<Sweet> getGift () {
        return gift;
    }
}

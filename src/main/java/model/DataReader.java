package model;

import model.sweets.Candy;
import model.sweets.CandyBar;
import model.sweets.Cookie;
import model.sweets.Sweet;

import java.util.ArrayList;

class DataReader {
    private ArrayList<String> data;

    DataReader (ArrayList<String> data) {
        this.data = data;
    }

    ArrayList<Sweet> getSweetFormData () {
        ArrayList<Sweet> result = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            switch (data.get(i).toLowerCase()) {
                case "candy":
                    result.add(new Candy(data.get(i + 1),
                            Integer.parseInt(data.get(i + 2)),
                            Double.parseDouble(data.get(i + 3)),
                            data.get(i + 4)));
                    i = i + 6;
                    break;

                case "candy bar":
                    result.add(new CandyBar(data.get(i + 1),
                            Integer.parseInt(data.get(i + 2)),
                            Double.parseDouble(data.get(i + 3)),
                            data.get(i + 4)));
                    i = i + 6;
                    break;

                case "cookie":
                    result.add(new Cookie(data.get(i + 1),
                            Integer.parseInt(data.get(i + 2)),
                            Double.parseDouble(data.get(i + 3)),
                            data.get(i + 4)));
                    i = i + 6;
                    break;
            }
        }

        return result;
    }
}

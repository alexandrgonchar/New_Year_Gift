package model;

import java.io.*;

public class SerializeObject {

    public static void serialize (String fileName, Object object) {
        try (FileOutputStream outStream = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(outStream)) {

            oos.writeObject(object);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize (String fileName) {
        Object object = null;

        try (FileInputStream inStream = new FileInputStream(fileName);
             ObjectInputStream inputStream = new ObjectInputStream(inStream)) {

            object = inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }
}

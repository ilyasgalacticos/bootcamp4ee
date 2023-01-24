package kz.bitlab.javaee.db;

import kz.bitlab.javaee.db.model.User;

public class Main {

    public static void main(String[] args) {

        Speaker<String> speaker = new Speaker<String>();
        speaker.setMyObj("Ilyas");
        speaker.addObj("Serik");
        speaker.addObj("Berik");
        speaker.addObj("Erik");
        speaker.addObj("Zhanat");
        System.out.println(speaker.getObj());

        speaker.printAll();

        User c1 = new User(1, "Ilyas", 33, "Almaty");
        User c2 = new User(2, "Serik", 31, "Shymkent");
        User c3 = new User(3, "Berik", 32, "Taraz");
        User c4 = new User(4, "Erik", 35, "AStana");

        Speaker<User> mySpeaker = new Speaker<>();
        mySpeaker.addObj(c1);
        mySpeaker.addObj(c2);
        mySpeaker.addObj(c3);
        mySpeaker.addObj(c4);

        mySpeaker.printAll();

    }
}

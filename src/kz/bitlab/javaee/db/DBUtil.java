package kz.bitlab.javaee.db;

import kz.bitlab.javaee.db.model.User;

import java.util.ArrayList;

public class DBUtil {

    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<String> cities = new ArrayList<>();
    private static int id = 7;

    static {

        users.add(new User(1, "Berik", 34, "Almaty"));
        users.add(new User(2, "Serik", 38, "Taraz"));
        users.add(new User(3, "Erik", 13, "Aktobe"));
        users.add(new User(4, "Zhanik", 31, "Pavlodar"));
        users.add(new User(5, "Madina", 35, "Issyk"));
        users.add(new User(6,"Darkhan", 31, "Shymkent"));

        cities.add("Almaty");
        cities.add("Astana");
        cities.add("Semey");
        cities.add("Taraz");
        cities.add("Shymkent");
        cities.add("Karaganda");
        cities.add("Aktobe");
        cities.add("Atyrau");
        cities.add("Pavlodar");
        cities.add("Aktau");
        cities.add("Petropavl");
        cities.add("Oral");

    }

    public static void addUser(User user){
        user.setId(id);
        users.add(user);
        id++;
    }

    public static ArrayList<User> getUsers(){
        return users;
    }

    public static User getUser(int id){
//        for(ClientUser clientUser : users){
//            if(id == clientUser.getId()) return clientUser;
//        }
//        return null;
        return users.stream()
                .filter(clientUser -> id == clientUser.getId())
                .findFirst()
                .orElse(null);
    }

    public static ArrayList<String> getCities(){
        return cities;
    }

}
package kz.bitlab.javaee.db.mysql;

import kz.bitlab.javaee.db.model.City;
import kz.bitlab.javaee.db.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/bootcamp_4_db", "root", "root"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getAllUsers(){

        ArrayList<User> users = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT usr.id, usr.name, usr.age, cit.id AS city_id, cit.name AS city_name, cit.code " +
                    "FROM user_list usr " +
                    "INNER JOIN city_list cit ON usr.city = cit.id " +
                    "ORDER BY usr.age DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                City city = new City();
                city.setId(resultSet.getInt("city_id"));
                city.setName(resultSet.getString("city_name"));
                city.setCode(resultSet.getString("code"));

                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setCity(city);
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));

                users.add(user);

            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static void addUser(User user){

        try {

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO user_list (name, age, city) " +
                            "VALUES (?, ?, ?)"
            );

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setInt(3, user.getCity().getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static User getUser(int id){

        User user = null;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT usr.id, usr.name, usr.age, cit.id AS city_id, cit.name AS city_name, cit.code " +
                    "FROM user_list usr " +
                    "INNER JOIN city_list cit ON usr.city = cit.id " +
                    "WHERE usr.id = ? LIMIT 1");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                City city = new City();
                city.setId(resultSet.getInt("city_id"));
                city.setName(resultSet.getString("city_name"));
                city.setCode(resultSet.getString("code"));

                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setCity(city);
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void updateUser(User user){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE user_list SET name = ?, age = ?, city = ? " +
                    "WHERE id = ?");

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setInt(3, user.getCity().getId());
            statement.setInt(4, user.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteUser(int id){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM user_list " +
                    "WHERE id = ?");

            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<City> getCities(){
        ArrayList<City> cities = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM city_list ORDER BY name");

            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setCode(resultSet.getString("code"));
                cities.add(city);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cities;
    }

    public static City getCity(int id){
        City city = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM city_list WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setCode(resultSet.getString("code"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return city;
    }
}

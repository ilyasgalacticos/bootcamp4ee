package kz.bitlab.javaee.db.mysql;

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
                    "SELECT * FROM user_list ORDER BY age DESC");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setCity(resultSet.getString("city"));
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
            statement.setString(3, user.getCity());

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
                    "SELECT * FROM user_list WHERE id = ? LIMIT 1");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setCity(resultSet.getString("city"));
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
            statement.setString(3, user.getCity());
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

}

package com.example.individualproject.Repository;

import com.example.individualproject.DALInterfaces.IUserDAL;
import com.example.individualproject.Model.UserAccount;
import com.example.individualproject.ServiceInterface.IUser;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class UserDalJDBC extends JDBCRepository implements IUserDAL {


    @Override
    public ArrayList<IUser> getAllUsers() {

        ArrayList<IUser> accounts = new ArrayList<IUser>();
        Connection connection = this.getDatabaseConnection();
        String sql = "SELECT * from user";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                IUser account = new UserAccount(id, username, password,email,firstName,lastName);
                accounts.add(account);
            }

            connection.commit();
            connection.close();

        } catch (SQLException throwable) {System.out.println("Ne sum swyrzan");}

        return accounts;
    }

    @Override
    public IUser getUserById(int id) {

        String sql = "SELECT * from user WHERE ID = ?" ;
        Connection connection = this.getDatabaseConnection();
        IUser account = null;
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int accountId = resultSet.getInt("ID");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            account = new UserAccount(accountId, username, password,email,firstName,lastName);


            connection.commit();
            connection.close();

        } catch (SQLException throwable) {System.out.println("Ne sum swyrzan");}

        return account;
    }

    @Override
    public IUser getUserByUsername(String username) {

        String sql = "SELECT * from user WHERE username = ?" ;
        Connection connection = this.getDatabaseConnection();
        IUser account = null;
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int accountId = resultSet.getInt("ID");
            String accountName = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            account = new UserAccount(accountId, accountName, password,email,firstName,lastName);


            connection.commit();
            connection.close();

        } catch (SQLException throwable) {System.out.println("Ne sum swyrzan");}

        return account;
    }


    @Override
    public void addUser(IUser account) {
        Connection connection = this.getDatabaseConnection();
        String sql = "INSERT INTO user (`ID`, `first_name`, `last_name`, `username`, `password`, `email`) VALUES (NULL, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getUsername());
            statement.setString(4, account.getPassword());
            statement.setString(5, account.getEmail());

            statement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (SQLException throwable) {}
    }

}
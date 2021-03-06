package com.example.individualproject.Repository;

import com.example.individualproject.DALInterfaces.IUserDAL;
import com.example.individualproject.Model.UserAccount;
import com.example.individualproject.ServiceInterface.IUser;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class UserDalJDBC extends JDBCRepository implements IUserDAL {


    @Override
    public ArrayList<IUser> getAllUsers() {

        ArrayList<IUser> accounts = new ArrayList<IUser>();
        Connection connection = this.getDatabaseConnection();
        Statement statement = null;

        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from user");


            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String role = resultSet.getString("role");

                IUser account = new UserAccount(id, username, password,email,firstName,lastName, role);
                accounts.add(account);
            }

        } catch (SQLException throwable) {System.out.println("Ne sum swyrzan");}
        finally {
            try{
                if(statement != null ) {
                    statement.close();
                }
                connection.commit();
                connection.close();
            }
            catch (SQLException throwable){
                System.out.println("Can't close connection");
            }
        }

        return accounts;
    }

    @Override
    public IUser getUserById(int id) {
        Connection connection = this.getDatabaseConnection();
        IUser account = null;
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("SELECT * from user WHERE ID = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int accountId = resultSet.getInt("ID");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String role = resultSet.getString("role");

            account = new UserAccount(accountId, username, password,email,firstName,lastName, role);


        } catch (SQLException throwable) {System.out.println("Can't get account by id");}
        finally {
            try{
                if(statement != null ) {
                    statement.close();
                }
                connection.commit();
                connection.close();
            }
            catch (SQLException throwable){
                System.out.println("Can't close connection");
            }
        }

        return account;
    }

    @Override
    public IUser getUserByUsername(String username) {
        Connection connection = this.getDatabaseConnection();
        IUser account = null;
        PreparedStatement statement = null;
        try {

            statement = connection.prepareStatement("SELECT * from user WHERE username = ?" );
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int accountId = resultSet.getInt("ID");
            String accountName = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String role = resultSet.getString("role");

            account = new UserAccount(accountId, accountName, password,email,firstName,lastName, role);

        } catch (SQLException throwable) {System.out.println("Can't get account by username");}
        finally {
            try{
                if(statement != null ) {
                    statement.close();
                }
                connection.commit();
                connection.close();
            }
            catch (SQLException throwable){
                System.out.println("Can't close connection");
            }
        }

        return account;
    }


    @Override
    public boolean addUser(IUser account) {
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO user (`ID`, `first_name`, `last_name`, `username`, `password`, `email`, `role`) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, account.getFirstName());
            statement.setString(2, account.getLastName());
            statement.setString(3, account.getUsername());
            statement.setString(4, account.getPassword());
            statement.setString(5, account.getEmail());
            statement.setString(6, account.getRole());

            statement.executeUpdate();

        } catch (SQLException throwable) {}
        finally {
            try{
                if(statement != null ) {
                    statement.close();
                }
                connection.commit();
                connection.close();
            }
            catch (SQLException throwable){
                System.out.println("Can't close connection");
            }
        }
        return false;
    }

    @Override
    public void editUserDetails(int id, String email, String firstName, String lastName) {
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE `user` SET `email` = ?, `first_name` = ?, `last_name` = ? WHERE `user`.`ID` = ?");
            statement.setString(1, email);
            statement.setString(2, firstName);
            statement.setString(3, lastName);

            statement.setInt(4, id);

            statement.executeUpdate();



        } catch (SQLException throwable) {}
        finally {
            try{
                if(statement != null ) {
                    statement.close();
                }
                connection.commit();
                connection.close();
            }
            catch (SQLException throwable){
                System.out.println("Can't close connection");
            }
        }
    }

}
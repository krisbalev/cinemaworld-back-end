package com.example.individualproject.Repository;

import com.example.individualproject.DALInterfaces.ITheatreDAL;
import com.example.individualproject.Model.Movie;
import com.example.individualproject.Model.Theatre;
import com.example.individualproject.ServiceInterface.IMovie;
import com.example.individualproject.ServiceInterface.ITheatre;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TheatreDalJDBC extends JDBCRepository implements ITheatreDAL {

   @Override
   public List<ITheatre> getAllTheatres(){
       List<ITheatre> theatres = new ArrayList<>();

       Connection connection = this.getDatabaseConnection();

       Statement statement = null;

       try {

           statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT * from theatres");


           while (resultSet.next()) {
               int id = resultSet.getInt("id");
               String name = resultSet.getString("name");
               String address = resultSet.getString("address");

               ITheatre theatre = new Theatre(id, name, address);
               theatres.add(theatre);
           }
       }

       catch (SQLException throwable) {

           System.out.println("Can't get all theatres");
       }

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

       return theatres;
   }

    @Override
    public ITheatre getTheatreById(int id) {
        Connection connection = this.getDatabaseConnection();
        ITheatre theatre = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * from theatres WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int theatreId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");

            theatre = new Theatre(theatreId, name, address);

        } catch (SQLException throwable) {
            System.out.println("Can't get theatre by id");

        }
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
        return theatre;
    }

    @Override
    public void addTheatre(Theatre theatre){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("INSERT INTO `theatres` (`id`, `name`, `address`) VALUES (NULL, ?, ?);");
            statement.setString(1, theatre.getName());
            statement.setString(2, theatre.getAddress());

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

    @Override
    public void deleteTheatre(int id){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("DELETE FROM `theatres` WHERE `theatres`.`id` = ?");
            statement.setInt(1, id);

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

    @Override
    public void editTheatre(Theatre theatre){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("UPDATE `theatres` SET `name` = ?, `address` = ? WHERE `theatres`.`id` = ?");
            statement.setString(1, theatre.getName());
            statement.setString(2, theatre.getAddress());
            statement.setInt(3, theatre.getId());

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

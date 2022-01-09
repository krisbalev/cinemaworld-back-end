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

       String sql = "SELECT * from theatres";

       Statement statement = null;

       try {

           statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);


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
        String sql = "SELECT * from theatres WHERE id = ?";
        Connection connection = this.getDatabaseConnection();
        ITheatre theatre = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
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
}

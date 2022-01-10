package com.example.individualproject.Repository;

import com.example.individualproject.DALInterfaces.IMovieDAL;
import com.example.individualproject.Model.Movie;
import com.example.individualproject.ServiceInterface.IMovie;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class MovieDalJDBC extends com.example.individualproject.Repository.JDBCRepository implements IMovieDAL {

    @Override
    public List<IMovie> getAllMovies(){

        List<IMovie> movies = new ArrayList<>();

        Connection connection = this.getDatabaseConnection();

        Statement statement = null;

        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from movies");


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date releaseDate = resultSet.getDate("release_date");


                IMovie movie = new Movie(id, title, description, releaseDate);
                movies.add(movie);
            }
        }

        catch (SQLException throwable) {

                System.out.println("Can't get all movies");
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

            return movies;
        }

    @Override
    public IMovie getMovieById(int id) {
        Connection connection = this.getDatabaseConnection();
        IMovie movie = null;

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * from movies WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int movieId = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            Date releaseDate = resultSet.getDate("release_date");

            movie = new Movie(movieId, title, description, releaseDate);

        } catch (SQLException throwable) {
            System.out.println("Can't get movie by id");

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
        return movie;
    }

    @Override
    public String getPhotoByMovieId(int id) {
        Connection connection = this.getDatabaseConnection();
        String path = "";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * from movie_photos WHERE movie_ID = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            path = resultSet.getString("path");


        }
        catch (SQLException throwable) {System.out.println("Can't get photo of movie");}

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

        return path;
    }

    @Override
    public String getPosterByMovieId(int id) {
        Connection connection = this.getDatabaseConnection();
        String path = "";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * from movie_posters WHERE movie_ID = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            path = resultSet.getString("path");


        }
        catch (SQLException throwable) {System.out.println("Can't get photo of movie");}

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

        return path;
    }

}

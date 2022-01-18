package com.example.individualproject.Repository;

import com.example.individualproject.DALInterfaces.IMovieDAL;
import com.example.individualproject.Model.Movie;
import com.example.individualproject.ServiceInterface.IMovie;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

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

    @Override
    public String getTrailer(int id){
        Connection connection = this.getDatabaseConnection();
        String url = "";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT trailer_url from trailers WHERE movie_id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            url = resultSet.getString("trailer_url");


        }
        catch (SQLException throwable) {System.out.println("Can't get trailer of movie");}

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

        return url;
    }

    @Override
    public void addMovie(Movie movie){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("INSERT INTO `movies` (`id`, `title`, `release_date`, `description`) VALUES (NULL, ?, ?, ?);");
            statement.setString(1, movie.getTitle());
            statement.setDate(2, movie.getReleaseDate());
            statement.setString(3, movie.getDescription());

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
    public void addTrailer(int movieId,String trailer){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("INSERT INTO `trailers` (`id`, `movie_id`, `trailer_url`) VALUES (NULL, ?, ?);");
            statement.setInt(1, movieId);
            statement.setString(2, trailer);

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
    public void deleteMovie(int id){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("DELETE FROM `movies` WHERE `movies`.`id` = ?");
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
    public void deleteTrailer(int id){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("DELETE FROM `trailers` WHERE `trailers`.`movie_id` = ?");
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
    public void editMovie(Movie movie){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("UPDATE `movies` SET `title` = ?, `release_date` = ?, `description` = ? WHERE `movies`.`id` = ?");
            statement.setString(1, movie.getTitle());
            statement.setDate(2, movie.getReleaseDate());
            statement.setString(3, movie.getDescription());
            statement.setInt(4, movie.getId());

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
    public void editTrailer(String url, int id){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("UPDATE `trailers` SET `trailer_url` = ? WHERE `trailers`.`movie_id` = ?");
            statement.setString(1, url);
            statement.setInt(2, id);

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

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
public class MovieDalJDBC extends com.example.projectbackend.Repository.JDBCRepository implements IMovieDAL {

    @Override
    public List<IMovie> getAllMovies(){

        List<IMovie> movies = new ArrayList<>();

        Connection connection = this.getDatabaseConnection();

        String sql = "SELECT * from movies";

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Date releaseDate = resultSet.getDate("release_date");


                IMovie movie = new Movie(id, title, description, releaseDate);
                movies.add(movie);
            }

            connection.commit();
            connection.close();

        } catch (SQLException throwable) {System.out.println("Ne sum swyrzan");}

        return movies;
    }

    @Override
    public IMovie getMovieById(int id) {
        String sql = "SELECT * from movies WHERE id = ?";
        Connection connection = this.getDatabaseConnection();
        IMovie movie = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            int movieId = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            Date releaseDate = resultSet.getDate("release_date");

            movie = new Movie(movieId, title, description, releaseDate);

            connection.commit();
            connection.close();

        } catch (SQLException throwable) {System.out.println("Ne sum swyrzan");}

        return movie;
    }

}

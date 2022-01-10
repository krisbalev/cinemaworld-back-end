package com.example.individualproject.Repository;

import com.example.individualproject.DALInterfaces.IReservationDAL;
import com.example.individualproject.Model.Reservation;
import com.example.individualproject.ServiceInterface.IReservation;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Repository
public class ReservationDalJDBC extends JDBCRepository implements IReservationDAL {

    @Override
    public List<IReservation> getAllReservations(){
        List<IReservation> reservations = new ArrayList<>();

        Connection connection = this.getDatabaseConnection();

        Statement statement = null;

        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from reservations");


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String movieName = resultSet.getString("movie_name");
                Date date = resultSet.getDate("date");
                Time time = resultSet.getTime("time");
                int numberOfTickets = resultSet.getInt("tickets");
                String theatreName = resultSet.getString("theatre");


                IReservation reservation = new Reservation(id, username, movieName, date, time, numberOfTickets, theatreName);
                reservations.add(reservation);
            }
        }

        catch (SQLException throwable) {

            System.out.println("Can't get all reservations");
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

        return reservations;
    }

    @Override
    public void reserve(Reservation reservation){
        Connection connection = this.getDatabaseConnection();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement("INSERT INTO `reservations` (`id`, `username`, `movie_name`, `date`, `time`, `tickets`, `theatre`) VALUES (NULL, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, reservation.getUsername());
            statement.setString(2, reservation.getMovieName());
            statement.setDate(3, reservation.getDate());
            statement.setTime(4, reservation.getTime());
            statement.setInt(5, reservation.getNumberOfTickets());
            statement.setString(6, reservation.getTheatreName());

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
    public List<IReservation> getReservationsByUser(String username){
        List<IReservation> reservations = new ArrayList<>();

        Connection connection = this.getDatabaseConnection();

        PreparedStatement statement = null;

        try {

            statement = connection.prepareStatement("SELECT * from reservations WHERE username = ? ORDER BY id desc");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String reserverName = resultSet.getString("username");
                String movieName = resultSet.getString("movie_name");
                Date date = resultSet.getDate("date");
                Time time = resultSet.getTime("time");
                int numberOfTickets = resultSet.getInt("tickets");
                String theatreName = resultSet.getString("theatre");


                IReservation reservation = new Reservation(id, reserverName, movieName, date, time, numberOfTickets, theatreName);
                reservations.add(reservation);
            }
        }

        catch (SQLException throwable) {

            System.out.println("Can't get all user reservations");
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

        return reservations;
    }
}

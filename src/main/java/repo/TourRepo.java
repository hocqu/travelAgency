package repo;

import Entities.Customer;
import Entities.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourRepo {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/travel_Agency?serverTimezone=UTC", "root", "root");

    public TourRepo() throws SQLException {
    }

    public List<Tour> findAll() {
        List<Tour> tours = new ArrayList<>();
        Tour tour = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM Tour");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                tour = new Tour(rs.getInt(1),rs.getInt(8), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getInt(6), rs.getBoolean(7));
                tours.add(tour);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return tours;
    }

    public List<Tour> findByCustomerID(Integer id) {
        List<Tour> tours = new ArrayList<>();
        Tour tour = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM tour WHERE id_customer=?");
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                tour = new Tour(rs.getInt(1),rs.getInt(8),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getString(5),
                        rs.getInt(6),rs.getBoolean(7));
                tours.add(tour);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return tours;
    }

    public List<Tour> findByCustomer(Customer customer) {
        List<Tour> tours = new ArrayList<>();
        Tour tour = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM tour WHERE id_customer=?");
            pr.setInt(1, customer.getId());
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                tour = new Tour(rs.getInt(1),rs.getInt(8),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getString(5),
                        rs.getInt(6),rs.getBoolean(7));
                tours.add(tour);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tours;
    }

    public Tour findById(Integer id) {
        Tour tour = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM tour WHERE id=?");
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                tour = new Tour(rs.getInt(1),rs.getInt(8),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getString(5),
                        rs.getInt(6),rs.getBoolean(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tour;
    }
    public Tour findByCity(String city) {
        Tour tour = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM tour WHERE city=?");
            pr.setString(1, city);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                tour = new Tour(rs.getInt(1),rs.getInt(8),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getString(5),
                        rs.getInt(6),rs.getBoolean(7));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tour;
    }

    public void add(Tour tour) {
        try {
            PreparedStatement pr = connection.prepareStatement("INSERT INTO tour(id_customer,tourType,departureDate" +
                    ",daysInTour,city,cost,burning) VALUES (?,?,?,?,?,?,?)");
            pr.setInt(1, tour.getCustomer_id());
            pr.setString(2, tour.getTourType());
            pr.setString(3, tour.getDepartureDate());
            pr.setInt(4, tour.getDaysInTour());
            pr.setString(5, tour.getCity());
            pr.setInt(6, tour.getCost());
            pr.setBoolean(7, tour.getBurning());
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            PreparedStatement pr = connection.prepareStatement(" DELETE FROM Tour" + " WHERE id =?;");
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}


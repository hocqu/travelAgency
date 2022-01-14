package repo;

import Entities.Customer;
import Entities.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo extends BaseRepo {

    public CustomerRepo() throws SQLException {
    }

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }

    public Customer findById(Integer id) {
        Customer customer = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    public Customer findByEmail(String email) {
        Customer customer = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM Customer WHERE email=?");
            pr.setString(1, email);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }


    public void add(Customer customer) {
        try {
            PreparedStatement pr = connection.prepareStatement("INSERT INTO customer(name,phone,email,sale) VALUES (?,?,?,?)");
            pr.setString(1, customer.getName());
            pr.setString(2, customer.getPhone());
            pr.setString(3, customer.getEmail());
            pr.setInt(4, customer.getSale());
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Integer id, String name, String phone) {
        try {
            PreparedStatement pr = connection.prepareStatement("UPDATE customer SET name=?, phone=? WHERE id=?");
            pr.setString(1, name);
            pr.setString(2, phone);
            pr.setInt(3, id);
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSale(Integer id, int sale) {
        try {
            PreparedStatement pr = connection.prepareStatement("UPDATE customer SET sale=? WHERE id=?");
            pr.setInt(1, sale);
            pr.setInt(2, id);
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Integer id) {
        try {
            PreparedStatement pr = connection.prepareStatement(" DELETE FROM Customer" + " WHERE id =?;");
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

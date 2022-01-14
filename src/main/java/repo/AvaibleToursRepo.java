package repo;

import Entities.AvaibleTours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvaibleToursRepo extends BaseRepo {

    public AvaibleToursRepo() throws SQLException {
    }

    public void delete(Integer id) {
        try {
            PreparedStatement pr = connection.prepareStatement(" DELETE FROM allTours" + " WHERE id =?;");
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(AvaibleTours avaibleTour) {
        try {
            PreparedStatement pr = connection.prepareStatement("INSERT INTO allTours(city,cost) VALUES (?,?)");
            pr.setString(1, avaibleTour.getCity());
            pr.setInt(2, avaibleTour.getCost());
            pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public AvaibleTours findById(Integer id) {
        AvaibleTours avaibleTours = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM allTours WHERE id=?");
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                avaibleTours = new AvaibleTours(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return avaibleTours;
    }
    public AvaibleTours findByCity(String city) {
        AvaibleTours avaibleTours = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM allTours WHERE city=?");
            pr.setString(1, city);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                avaibleTours = new AvaibleTours(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return avaibleTours;
    }


    public List<AvaibleTours> findAll() {
        List<AvaibleTours> avaibleList = new ArrayList<>();
        AvaibleTours avaibleTours = null;
        try {
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM allTours");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                avaibleTours = new AvaibleTours(rs.getInt(1), rs.getString(2), rs.getInt(3));
                avaibleList.add(avaibleTours);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return avaibleList;
    }
}

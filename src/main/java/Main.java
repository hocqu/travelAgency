import Entities.Tour;
import Service.ImportToJSON;
import menu.AdminMenu;
import menu.Menu;
import repo.TourRepo;


import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        ImportJSON importJSON = new ImportJSON();
//        ImportToJSON importToJSON=new ImportToJSON();
//        importToJSON.add();
//        importJSON.importTours();
        final Menu adminMenu = AdminMenu.getInstance();
        adminMenu.getMenu();
    }
}

import Service.EmailInput;
import Utils.PhoneNumber;
import menu.AdminMenu;
import menu.Menu;

import java.sql.SQLException;

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

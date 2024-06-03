package bankappdemo.business.concretes;

import bankappdemo.business.abstracts.AdminService;
import bankappdemo.dataAccess.AdminRepository;
import bankappdemo.entities.Admin;
import bankappdemo.entities.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminManager implements AdminService{
    private AdminRepository adminRepository = new AdminRepository();
    
    @Override
    public void insert(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        adminRepository.removeData(id);
    }

    @Override
    public ArrayList<Customer> getCustomer() {
        try {
            return adminRepository.getCustomer();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public String getIBAN() {
        Random random = new Random();
        String iban = "TR21 0006 1005 ";

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i != 4) {
                    iban = (iban.concat(String.valueOf(random.nextInt(0, 10))));
                } else if ((i == 4) && (j < 3)) {
                    iban = (iban.concat(String.valueOf(random.nextInt(0, 10))));
                } else {
                    break;
                }
            }
        }
        return iban;
    }
    
}

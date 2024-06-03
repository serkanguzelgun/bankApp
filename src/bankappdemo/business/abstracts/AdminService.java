package bankappdemo.business.abstracts;

import bankappdemo.entities.Admin;
import bankappdemo.entities.Customer;
import java.util.ArrayList;

public interface AdminService {
    public void insert(Admin admin);
    public void update(Admin admin);
    public void delete(int id);
    public ArrayList<Customer> getCustomer();
}

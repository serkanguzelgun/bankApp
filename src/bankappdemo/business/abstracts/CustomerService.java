package bankappdemo.business.abstracts;

import bankappdemo.entities.Customer;

public interface CustomerService {
    public void insert(Customer customer);
    public void update(Customer customer);
    public Customer getByIdCustomer(int id);
    public Customer getByIdentityCustomer(String identity);
    public Customer getByIBANCustomer(String iban);
    public boolean checkLogin(String identity, String password);
    public boolean existsCustomer(String identity);
    public boolean existsIBAN(String iban);
}

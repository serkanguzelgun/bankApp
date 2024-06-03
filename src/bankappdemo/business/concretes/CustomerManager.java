package bankappdemo.business.concretes;

import bankappdemo.business.abstracts.CustomerService;
import bankappdemo.dataAccess.CustomerRepository;
import bankappdemo.entities.Customer;

public class CustomerManager implements CustomerService{
    private CustomerRepository customerRepository = new CustomerRepository();
    
    @Override
    public void insert(Customer customer) {
        customerRepository.insertData(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.updateData(customer);
    }

    @Override
    public Customer getByIdCustomer(int id) {
       return customerRepository.getByIdCustomer(id);
    }

    @Override
    public Customer getByIdentityCustomer(String identity) {
        return customerRepository.getByIdentityCustomer(identity);
    }

    @Override
    public boolean checkLogin(String identity, String password) {
        return customerRepository.checkLogin(identity, password);
    }
    
    public boolean passwordCheck(String password) {
        if (password.length() == 6) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {

                } else {
                    return false;
                }
            }

        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean existsCustomer(String identity) {
        return customerRepository.existCustomer(identity);
    }

    @Override
    public Customer getByIBANCustomer(String iban) {
        return customerRepository.getByIBANCustomer(iban);
    }

    @Override
    public boolean existsIBAN(String iban) {
        return customerRepository.existIBAN(iban);
    }
    
}

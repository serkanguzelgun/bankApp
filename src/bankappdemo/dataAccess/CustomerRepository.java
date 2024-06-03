package bankappdemo.dataAccess;

import bankappdemo.entities.Customer;
import bankappdemo.entities.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRepository implements PersonRepository{
    private DbHelper dbHelper = new DbHelper();

    
    

    @Override
    public void insertData(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbHelper.getConnection();
            String sql = "insert into customer (Name,Password,Balance,IBAN,Identity) values (?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getPassword());
            statement.setDouble(3, customer.getBalance());
            statement.setString(4, customer.getIban());
            statement.setString(5, customer.getIdentity());
            statement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void updateData(Person person) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "update customer set Name = ?, Password = ?, Balance = ?, IBAN = ? where ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setDouble(3, person.getBalance());
            preparedStatement.setString(4, person.getIban());         
            preparedStatement.setInt(5, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
    }
    
    public Customer getByIdCustomer(int id){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        String sql = "select * from bank.customer where ID = ";
        Customer customer = new Customer();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql.concat(String.valueOf(id)));

            while (resultSet.next()) {
                //lblBalance.setText(String.valueOf(resultSet.getDouble("Balance")));
                customer.setId(id);
                customer.setName(resultSet.getString("Name"));
                customer.setPassword(resultSet.getString("Password"));
                customer.setBalance(resultSet.getDouble("Balance"));
                customer.setIban(resultSet.getString("IBAN"));
                customer.setIdentity(resultSet.getString("Identity"));
            }
            return customer;

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
        return customer;
    }
    
    public Customer getByIdentityCustomer(String identity){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        String sql = "select * from bank.customer where IDENTITY = ";
        Customer customer = new Customer();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql.concat(identity));

            while (resultSet.next()) {
                //lblBalance.setText(String.valueOf(resultSet.getDouble("Balance")));
                customer.setId(resultSet.getInt("ID"));
                customer.setName(resultSet.getString("Name"));
                customer.setPassword(resultSet.getString("Password"));
                customer.setBalance(resultSet.getDouble("Balance"));
                customer.setIban(resultSet.getString("IBAN"));
                customer.setIdentity(identity);
            }
            return customer;

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
        return customer;
    }
    
    public Customer getByIBANCustomer(String iban){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        String sql = "select * from bank.customer where IBAN = ";
        Customer customer = new Customer();
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql.concat("'" + iban + "'"));

            while (resultSet.next()) {
                //lblBalance.setText(String.valueOf(resultSet.getDouble("Balance")));
                customer.setId(resultSet.getInt("ID"));
                customer.setName(resultSet.getString("Name"));
                customer.setPassword(resultSet.getString("Password"));
                customer.setBalance(resultSet.getDouble("Balance"));
                customer.setIban(resultSet.getString("IBAN"));
                customer.setIdentity(resultSet.getString("Identity"));
            }
            return customer;

        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
        }
        return customer;
    }
    
    public boolean checkLogin(String identity, String password){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;


        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from bank.customer");

            if ((identity.equals("")) && (password.equals(""))) {
                
            } else {
                //int check = 0;
                while (resultSet.next()) {
                    if (resultSet.getString("Identity").equals(identity)) {
                        System.out.println("Success");
                        //check = 1;
                        if (resultSet.getString("Password").equals(password)) {
                            //JOptionPane.showMessageDialog(null, "Login Successful");
                            return true;
                            //new HomeGUI(infoName).isVisible(true);
                            /*if (resultSet.getInt("ID") == 1) {
                                AdminHomeGUI adminHomeGUI = new AdminHomeGUI();
                                adminHomeGUI.show();
                                dispose();
                            } else {
                                HomeGUI homeGUI = new HomeGUI(resultSet.getString("Name"), resultSet.getInt("ID"));
                                homeGUI.show();
                                dispose();
                            }*/
                            
                        } else {
                            //JOptionPane.showMessageDialog(null, "Password is Wrong");
                            //lblErrorPassword.setText("* Password is Wrong");
                            return false;
                        }
                    } else {
                        //JOptionPane.showMessageDialog(null, "Login Unsuccessful");
                        //break;
                    }
                }
                /*if (check == 0) {
                    //JOptionPane.showMessageDialog(null, "Name is Wrong ");
                    //lblErrorIdentity.setText("* Identity is Wrong");
                }*/
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
    }
        return false;

}
    public boolean existCustomer(String identity){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from bank.customer");
                while (resultSet.next()) {
                    if (resultSet.getString("Identity").equals(identity)) {
                        System.out.println("Success");
                        return true;      
            }
                    }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
    }
        return false;
    }
    
    public boolean existIBAN(String iban){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from bank.customer");
                while (resultSet.next()) {
                    if (resultSet.getString("IBAN").equals(iban)) {
                        System.out.println("Success");
                        return true;      
            }
                    }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
            }
    }
        return false;
    }
}

package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class creates a CustomerList object. The CustomerList object is an observable list of all customer objects.
 * Customer objects are built from the SQL data.
 * @author Joseph Lawter
 */
public class CustomerList {
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    /**
     *
     * @param customer the customer object that will be added to the list.
     */
    public void addCustomer(Customer customer) {
        this.customerList.add(customer);
    }

    /**
     *
     * @param customerId the ID number of the customer being searched for.
     * @return the customer object that matches the ID.
     */
    public Customer lookupCustomer(int customerId) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerID() == customerId)
                return customerList.get(i);
        }
        return customerList.get(0);
    }

    /**
     *
     * @param customerName the name, first or last, of the customer being searched for.
     * @return the customer object that matches the name.
     */
    public Customer lookupCustomer(String customerName) {
        for (int i = 0; i < customerList.size(); i++){
            if (customerList.get(i).getFirstName().equals(customerName)
            || customerList.get(i).getLastName().equals(customerName)){
                return customerList.get(i);
            }
        }
        return customerList.get(0);
    }

    /**
     *
     * @param index the customerID of the customer to be updated.
     * @param updatedCustomer the updated customer object. This replaces the current customer object at index.
     */
    public void updateCustomer(int index, Customer updatedCustomer) {
        this.customerList.set(index, updatedCustomer);
    }

    /**
     *
     * @param customerToDelete the passed customerObject. The remove function looks for the object that matches
     *                         the passed object and removes it from the ObservableList.
     * @return this method returns true if the delete is successful and false if it is not successful.
     */
    public boolean deleteCustomer(Customer customerToDelete){
        try {
            this.customerList.remove(customerToDelete);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    /**
     *
     * @return the customerList object. this object is used to populate the customer table view.
     */
    public ObservableList<Customer> getCustomerList(){
        return this.customerList;
    }

}

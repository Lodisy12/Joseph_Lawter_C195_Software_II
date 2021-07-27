package Model;

/**
 * This class creates a customer object which tracks customer
 * information.
 * @author Joseph Lawter
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String postalCode;
    private String phoneNumber;
    private Integer id;
    private String city;
    private String country;

    /*
    Setter Methods
     */
    /**
     * @param name the customer's first name.
     */
    public void setFirstName(String name){
        this.firstName = name;
        return;
    }

    /**
     * @param name the customer's last name.
     */
    public void setLastName(String name){
        this.lastName = name;
        return;
    }

    /**
     * @param address the customer's street address
     */
    public void setAddress(String address){
        this.streetAddress = address;
    }

    /**
     * @param postal_code the customer's postal code
     */
    public void setPostalCode(String postal_code){
        this.postalCode = postal_code;
    }

    /**
     * @param phone_number the customer's phone number, including the area code.
     */
    public void setPhoneNumber(String phone_number){
        this.phoneNumber = phone_number;
    }

    /**
     * @param id the id number of the customer. Note: id numbers are
     *           auto-generated by the program.
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * @param city the city where the customer resides.
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * @param country the country where the customer resides.
     */
    public void setCountry(String country){
        this.country = country;
    }

    /*
    Getter Methods
     */
    /**
     * @return the first name of the customer.
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     *
     * @return the last name of the customer.
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     *
     * @return the street address of the customer.
     */
    public String getStreetAddress() {
        return this.streetAddress;
    }

    /**
     *
     * @return the postal code of the customer.
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    /**
     *
     * @return the customer's phone number, including the area code.
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     *
     * @return The id number of the customer. Note: id numbers are
     * auto-generated by the program.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     *
     * @return the city where the customer resides.
     */
    public String getCity() {
        return this.city;
    }

    /**
     *
     * @return the country where the customer resides.
     */
    public String getCountry(){
        return this.country;
    }
}

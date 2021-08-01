package Model;

import javafx.collections.ObservableList;
import utils.DBConnection;
import utils.DBQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DBPull {
    public static void appointmentFiller(AppointmentList appointmentList) {
        int appointmentID;
        String title;
        String description;
        String location;
        String contact;
        String type;
        LocalDateTime start;
        LocalDateTime end;
        int customerID;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointments, contacts " +
                "WHERE appointments.Contact_ID = contacts.Contact_ID;";
        try {
            DBQuery.setPreparedStatement(conn, selectStatement);
            PreparedStatement ps = DBQuery.getPreparedStatement();
            ps.execute(); // execute prepared statement
            System.out.println(ps.getUpdateCount());
            ResultSet results = ps.getResultSet();
            while (results.next()) {
                appointmentID = results.getInt("Appointment_ID");
                title = results.getString("Title");
                description = results.getString("Description");
                location = results.getString("Location");
                contact = results.getString("Contact_Name");
                type = results.getString("Type");
                start = results.getTimestamp("Start").toLocalDateTime();
                end = results.getTimestamp("End").toLocalDateTime();
                customerID = results.getInt("Customer_ID");

                appointmentList.addAppointment(new Appointment(appointmentID, title, description, location, contact,
                        type, start, end, customerID));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void customerFiller(CustomerList customerList){
        int customerID;
        String firstName;
        String lastName;
        String address;
        String state;
        String country;
        String phoneNumber;
        String postalCode;
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM customers, first_level_divisions, countries " +
                "WHERE customers.Division_ID = first_level_divisions.Division_ID AND " +
                "first_level_divisions.COUNTRY_ID = countries.Country_ID";
        try {
            DBQuery.setPreparedStatement(conn, selectStatement);
            PreparedStatement ps = DBQuery.getPreparedStatement();
            ps.execute(); // execute prepared statement
            System.out.println(ps.getUpdateCount());
            ResultSet results = ps.getResultSet();
            while (results.next()) {
                customerID = results.getInt("Customer_ID");
                String[] splitName = results.getString("Customer_name").split(" ");
                firstName = splitName[0];
                lastName = splitName[1];
                address = results.getString("Address");
                state = results.getString("Division");
                country = results.getString("Country");
                phoneNumber = results.getString("Phone");
                postalCode = results.getString("Postal_Code");

                customerList.addCustomer(new Customer(customerID, firstName, lastName, address, state,
                        country, phoneNumber, postalCode));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//        String firstCountry = "Westeros";
//        String countryName = "Alpha Centauri";
//        //String createDate = "2021-07-30";
//        String createdBy = "admin";
//        //String lastUpdatedBy = "admin";

        // Get keyboard input
//        Scanner keyboard = new Scanner(System.in);
//        System.out.print("input country to enter: ");
        //countryName = keyboard.nextLine();

        // key-value mapping
//        ps.setString(1, countryName);
//        ps.setString(2, createdBy);
//        ps.setString(3, firstCountry);
//



//        DBQuery.setPreparedStatement(conn);
//        Statement statement = DBQuery.getPreparedStatement();
//        String country, createDate, createdBy, lastUpdateBy;
//        String selectStatement = "SELECT * FROM countries " +
//                "WHERE Created_By = 'admin'";
//        country = "'Narnia'";
//        createDate = ", '2021-07-29 00:00:00'";
//        createdBy = ", 'admin'";
//        lastUpdateBy = ", 'admin'";
//        String insertStatement = "INSERT INTO countries(Country, Create_Date" +
//                ", Created_By, Last_Updated_By) " +
//                "VALUES(" + country
//                + createDate +
//                createdBy +
//                lastUpdateBy + ")";
//
//        try {
//            statement.execute(insertStatement);
//            ResultSet results = statement.getResultSet();
//            if(statement.getUpdateCount() > 0){
//                System.out.println(statement.getUpdateCount() + " row(s) affected");
//            }
//            else{
//                System.out.println("No rows affected");
//            }
//
//
////            while (results.next()) {
////                int countryId = results.getInt("Country_ID");
////                String countryName = results.getString("Country");
////                String createdBy = results.getString("Created_by");
////                LocalDate date = results.getDate("Create_Date").toLocalDate();
////                LocalTime time = results.getTime("Create_Date").toLocalTime();
////                LocalDateTime lastUpdate = results.getTimestamp("Last_Update").toLocalDateTime();
////                String updatedBy = results.getString("Last_Updated_By");
////                System.out.println(countryId + " " + countryName + " " + createdBy
////                        + " " + date + " " + time + " " + lastUpdate);
////            }
//        }
//        catch (SQLException e){
//            System.out.println(e);
//        }



}

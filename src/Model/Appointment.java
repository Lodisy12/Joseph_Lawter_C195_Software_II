package Model;

import java.time.LocalDateTime;

/**
 * this class creates appointment objects, which are used to populate the
 * appointmentList ObservableList object, which is used to populate the
 * appointments tableview.
 *
 * @author Joseph Lawter
 */
public class Appointment {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private String contact;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private int customerID;

    public Appointment(int appointmentID, String title, String description, String location,
                       String contact, String type, LocalDateTime start, LocalDateTime end,
                       int customerID){
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.type = type;
        this.start = start;
        this.end = end;
        this.customerID = customerID;

    }

    /*
    Setter Methods
     */

    /**
     *
     * @param ID integer that will be set as the appointment ID. This number
     *           is auto generated and cannot be altered by the user.
     */
    public void setAppointmentID(int ID){
        this.appointmentID = ID;
    }

    /**
     *
     * @param title the appointment's name.
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     *
     * @param description a brief description of the meeting's purpose.
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     *
     * @param location the location of the meeting. meeting room number probably.
     */
    public void setLocation(String location){
        this.location = location;
    }

    /**
     *
     * @param contact the name of the person who represents the customer.
     */
    public void setContact(String contact){
        this.contact = contact;
    }

    /**
     *
     * @param type the meeting type. This will be selected from a combo box
     *             by the user.
     */
    public void setType(String type){
        this.type = type;
    }

    /**
     *
     * @param start a LocalDateTime object that stores the start date and time
     *              of the meeting.
     */
    public void setStart(LocalDateTime start){
        this.start = start;
    }

    /**
     *
     * @param end a LocalDateTime object that stores the date and time when
     *            the meeting should end.
     */
    public void setEnd(LocalDateTime end){
        this.end = end;
    }

    /**
     *
     * @param customerID the id of the customer that will be at the meeting.
     *                   This is drawn from the linked customer object.
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     *
     * @return the id of the appointment
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     *
     * @return the id of the customer
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return the name of the meeting.
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return a brief description of the meeting's purpose.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return the room number or other location of the meeting.
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @return the person who made first contact with the customer.
     */
    public String getContact() {
        return contact;
    }

    /**
     *
     * @return the type of meeting. This is chosen by the user from a combo
     * box.
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return the start date and time of the meeting.
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     *
     * @return the end date and time of the meeting.
     */
    public LocalDateTime getEnd() {
        return end;
    }
}

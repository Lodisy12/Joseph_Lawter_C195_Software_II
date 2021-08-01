package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;

/**
 * this class creates an appointmentList object. the appointmentList object is
 * an ObservableList of appointment objects. It is filled from the sql data
 * and it is used to populate the appointment tableview.
 * @author Joseph Lawter
 */
public class AppointmentList {
    private ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();


    /**
     * @param appointment the appointment object that will be added to the list.
     */
    public void addAppointment(Appointment appointment) {
        this.appointmentList.add(appointment);
    }

    /**
     * @param appointmentID the id of the appointment that user is searching for
     * @return the appointment object that matches the ID.
     */
    public Appointment lookupAppointment(int appointmentID) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getAppointmentID() == appointmentID)
                return appointmentList.get(i);
        }
        return appointmentList.get(0);
    }

    /**
     * @param title the meeting's name.
     * @return the appointment object that matches the title.
     */
    public Appointment lookupAppointment(String title) {
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getTitle().equals(title))
                return appointmentList.get(i);
        }
        return appointmentList.get(0);
    }

    /**
     *
     * @param index the index of the object that will be updated.
     * @param updatedAppointment the updated appointment object. this replaces
     *                           the appointment object at the indicated index.
     */
    public void updateAppointment(int index, Appointment updatedAppointment){
        this.appointmentList.set(index, updatedAppointment);
    }

    /**
     *
     * @param appointmentToDelete the appointment object that should be deleted
     *                            from the ObservableList.
     * @return true if the delete is successful, false if unsuccessful.
     */
    public boolean deleteAppointment(Appointment appointmentToDelete){
        try{
            this.appointmentList.remove(appointmentToDelete);
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public ObservableList<Appointment> getAppointmentList(){
        return this.appointmentList;
    }

}

package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class ComboBoxFiller {



    public static ObservableList<String> contactFiller(AppointmentList appointmentList){
        ObservableList<String> contactNames = FXCollections.observableArrayList();
        for (int i = 0; i < appointmentList.getAppointmentList().size(); i++){
            contactNames.add(appointmentList.getAppointmentList().get(i).getContact());
        }
        return contactNames;
    }

    public static ObservableList<String> customerFiller(CustomerList customerList){
        ObservableList<String> customerNames = FXCollections.observableArrayList();
        for (int i = 0; i < customerList.getCustomerList().size(); i++){
            customerNames.add(customerList.getCustomerList().get(i).getFirstName()+
                    " " + customerList.getCustomerList().get(i).getLastName());
        }
        return customerNames;
    }

    public static ObservableList<String> timeOptionsFiller(){
        ObservableList<String> timeOptions = FXCollections.observableArrayList();
        int h;
        int m;
        String time;
//        String pm;
        for (int i = 0; i < 96;i++) {
            h = i * 15 / 60;
            m = i * 15 % 60;
            if (m == 0 & h == 0)
                time = "00:00";
            else if (m == 0 & h != 0)
                time = String.valueOf(h) + ":00";
            else if (m != 0 & h == 0)
                time = "00:" + String.valueOf(m);
            else if (h < 10 & m == 0)
                time = "0" + String.valueOf(h) + ":00";
            else if (h < 10 & m != 0)
                time = "0" + String.valueOf(h) + ":" + String.valueOf(m);
            else
                time = String.valueOf(h) + ":" + String.valueOf(m);
            timeOptions.add(time);
        }
//        for (int i = 0; i < 48;i++){
//            h = i*15/60;
//            m = i*15%60;
//            if (m == 0 & h == 0)
//                am = "12:" + String.valueOf(m) + "0 AM";
//            else if (m == 0 & h != 0)
//                am = String.valueOf(h) + ":" + String.valueOf(m) + "0 AM";
//            else if (m != 0 & h == 0)
//                am = "12:" + String.valueOf(m) + " AM";
//            else
//                am = String.valueOf(h) + ":" + String.valueOf(m) + " AM";
//            timeOptions.add(am);
//        }
//        for (int i = 0; i < 48; i++){
//            h = i*15/60;
//            m = i*15%60;
//            if (m == 0 & h == 0)
//                pm = "12:" + String.valueOf(m) + "0 PM";
//            else if (m == 0 & h != 0)
//                pm = String.valueOf(h) + ":" + String.valueOf(m) + "0 PM";
//            else if (m != 0 & h == 0)
//                pm = "12:" + String.valueOf(m) + " PM";
//            else
//                pm = String.valueOf(h) + ":" + String.valueOf(m) + " PM";
//            timeOptions.add(pm);
//        }
        return timeOptions;
    }

    public static ObservableList<String> typeOptionsFiller(){
        ObservableList<String> typeOptions = FXCollections.observableArrayList();
        typeOptions.add("Planning Session");
        typeOptions.add("De-Briefing");
        typeOptions.add("Initial Meeting");
        typeOptions.add("Sales Meeting");
        typeOptions.add("Other");

        return typeOptions;
    }

}



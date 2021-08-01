package scenes;

import Model.AppointmentList;
import Model.ComboBoxFiller;
import Model.CustomerList;
import Model.DBPull;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.DBConnection;

import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;


public class mainScreenController implements Initializable {

    public TextField appSearch;
    public TableView appTableView;
    public TableColumn appIdCol;
    public TableColumn appTitleCol;
    public TableColumn appDescriptionCol;
    public TableColumn appLocationCol;
    public TableColumn appContactCol;
    public TableColumn appTypeCol;
    public TableColumn appStartCol;
    public TableColumn appEndCol;
    public TableColumn appCustIdCol;
    public RadioButton appMonthToggle;
    public ToggleGroup appTableToggleGroup;
    public RadioButton appWeekToggle;
    public AppointmentList appointmentData;
    public CustomerList customerData;
    public TableView custTableView;
    public TableColumn custIdCol;
    public TableColumn custFirstNameCol;
    public TableColumn custLastNameCol;
    public TableColumn custAddressCol;
    public TableColumn custStateCol;
    public TableColumn custCountryCol;
    public TableColumn custPhoneCol;
    public TableColumn custPostalCodeCol;
    public TextField appTitleField;
    public RadioButton appCreateToggle;
    public ToggleGroup appUpdateToggleGroup;
    public RadioButton appDeleteToggle;
    public RadioButton appUpdateToggle;
    public TextField appIDField;
    public TextField appDescriptionField;
    public TextField appLocationField;
    public Button appCreateUpdateDeleteButton;
    public ComboBox appTypeCombo;
    public DatePicker appStartDateDatePicker;
    public DatePicker appEndDateDatePicker;
    public ComboBox appContactCombo;
    public ComboBox appCustomerIDField;
    public ComboBox appCustomerNameCombo;
    public ComboBox appStartTimeCombo;
    public ComboBox appEndTimeCombo;
    public TextField appUpcomingAppointmentsField;
    public ObservableList<String> contactNames;
    public String appTitle;
    public String appContactName;
    public String appDescription;
    public String appLocation;
    public String appType;
    public String appCustomerName;
    public LocalDate appStartDate;
    public LocalDate appEndDate;
    public LocalTime appStartTime;
    public LocalTime appEndTime;
    public LocalDateTime appStart;
    public LocalDateTime appEnd;
    public int appCustomerID;
    public ObservableList<String> customerNames;
    public ObservableList<String> timesOptions;
    public ObservableList<String> typeOptions;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection conn = DBConnection.startConnection();
        String selectStatement = "SELECT * FROM appointments";//"Update countries SET Country = ?, Created_By = ? WHERE country = ?";
        appointmentData = new AppointmentList();
        DBPull.appointmentFiller(appointmentData);
        customerData = new CustomerList();
        DBPull.customerFiller(customerData);
        contactNames = ComboBoxFiller.contactFiller(appointmentData);
        customerNames = ComboBoxFiller.customerFiller(customerData);
        timesOptions = ComboBoxFiller.timeOptionsFiller();
        typeOptions = ComboBoxFiller.typeOptionsFiller();
        appContactCombo.setItems(contactNames);
        appCustomerNameCombo.setItems(customerNames);
        appStartTimeCombo.setItems(timesOptions);
        appEndTimeCombo.setItems(timesOptions);
        appTypeCombo.setItems(typeOptions);



//        appTitle = appTitleField.getText();
//        appDescription = appDescriptionField.getText();
//        appLocation = appLocationField.getText();
//        appContactName = appContactCombo.getAccessibleText();
//        appType = appTypeCombo.getAccessibleText();
//        appCustomerName = appCustomerNameCombo.getAccessibleText();
//        appCustomerID = Integer.parseInt(appCustomerIDField.getAccessibleText());
//        appStartTime = LocalTime.parse(appStartTimeCombo.getAccessibleText());
//        appEndTime = LocalTime.parse(appEndTimeCombo.getAccessibleText());
//        appStartDate = appStartDateDatePicker.getValue();
//        appEndDate = appEndDateDatePicker.getValue();
//        appStart = LocalDateTime.of(appStartDate, appStartTime);
//        appEnd = LocalDateTime.of(appEndDate, appEndTime);





        appTableView.setItems(appointmentData.getAppointmentList());

        appIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        appDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        appLocationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        appContactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        appTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        appStartCol.setCellValueFactory(new PropertyValueFactory<>("start"));
        appEndCol.setCellValueFactory(new PropertyValueFactory<>("end"));
        appCustIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));

        custTableView.setItems(customerData.getCustomerList());

        custIdCol.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        custFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        custLastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        custAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        custStateCol.setCellValueFactory(new PropertyValueFactory<>("state"));
        custCountryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        custPhoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        custPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));



    }

    public void appCreateUpdateDelete(ActionEvent actionEvent) {
        try {
            appTitle = appTitleField.getText();
            appDescription = appDescriptionField.getText();
            appLocation = appLocationField.getText();
            appContactName = appContactCombo.getAccessibleText();
            appType = appTypeCombo.getAccessibleText();
            appCustomerName = appCustomerNameCombo.getAccessibleText();
            appCustomerID = customerData.lookupCustomer(appCustomerName).getCustomerID();//Integer.parseInt(appCustomerIDField.getAccessibleText());
            appStartTime = LocalTime.parse(appStartTimeCombo.getValue().toString());
            appEndTime = LocalTime.parse(appEndTimeCombo.getValue().toString());
            appStartDate = appStartDateDatePicker.getValue();
            appEndDate = appEndDateDatePicker.getValue();
            appStart = LocalDateTime.of(appStartDate, appStartTime);
            appEnd = LocalDateTime.of(appEndDate, appEndTime);
        }
        catch (NumberFormatException | NullPointerException e){
            System.out.println("Please fill out all required forms.");
            System.out.println(e);
        }



    }



    public void appChooseCustID(ActionEvent actionEvent) {
    }

    public void appChooseCustName(ActionEvent actionEvent) {
    }
}



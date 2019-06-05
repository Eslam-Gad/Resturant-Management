package resturant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;




public class MainController implements Initializable {

    @FXML
    TextField numMeals;
    @FXML
    TextField numDranks;
    @FXML
    Pane meal;
    @FXML
    Pane drank;
    @FXML
    ComboBox cbo1;
    @FXML
    ComboBox cbo2;
    @FXML
    TextField numMls;
    @FXML
    TextField numMN;
    @FXML
    TextField nameMN1;
    @FXML
    TextField nameMN;
    @FXML
    TextField numD;
    @FXML
    TextField N;
    @FXML
    TextField M;
    @FXML
    Label doneM;
    @FXML
    Button add;
    @FXML
    Button ad;
    @FXML
    TextField nameD;
    @FXML
    TextField costD;
    @FXML
    TextField searshM;
    @FXML
    TextField phone;
    @FXML
    Label doneD;
    @FXML
    Label doneMN;
    @FXML
    Pane bground;
    @FXML
    Pane P3;
    @FXML
    Pane PE;
    @FXML
    Button closeX;
    @FXML
    Button addMN;
    @FXML
    Button addPhon;
    @FXML
    ComboBox cmbMN;
    @FXML
    TextField searshD;
    @FXML
    TextField searshMN;
    @FXML
    Label matchMN;
    @FXML
    TextField IDE;
    @FXML
    PieChart pc;
    @FXML
    Spinner sp;
    @FXML
    ComboBox cmbMN1;
    @FXML
    TextField addressE;
    @FXML
    Button addPhonE;
    @FXML
    TextField phone1;
    @FXML
    TextField searshE;
    @FXML
    Label matchMN1;
    @FXML
    AreaChart charACH;
    @FXML
    Pane char1;
    @FXML
    Pane pane5;
    @FXML
    ComboBox cmbG1;
    @FXML
    ComboBox cmbG2;
    @FXML
    TextField bG;
    @FXML
    TextField chG;
    @FXML
    TextField searchG;

    @FXML
    TableView<Meels> tableM;
    @FXML
    TableColumn<Meels, Integer> numM;
    @FXML
    TableColumn<Meels, String> nameM;
    @FXML
    TableColumn<Meels, String> typeM;
    @FXML
    TableColumn<Meels, Integer> costM;
    ObservableList<Meels> listM;

    @FXML
    TableView<MN> tableMN;
    @FXML
    TableColumn<MN, Integer> numCMN;
    @FXML
    TableColumn<MN, String> nameCN;
    @FXML
    TableColumn<MN, String> CC;
    ObservableList<MN> listMN;

    @FXML
    TableView<Phone> tableP;
    @FXML
    TableColumn<Phone, String> c2;
    ObservableList<Phone> listh;

    @FXML
    TableView<PhoneEmp> tablePE;
    @FXML
    TableColumn<PhoneEmp, String> numsPhone;
    ObservableList<PhoneEmp> listpE;

    @FXML
    TableView tableG;
    @FXML
    TableColumn mnG;
    @FXML
    TableColumn eG;
    @FXML
    TableColumn gG;
    @FXML
    TableColumn dG;
    @FXML
    TableColumn BG;
    @FXML
    TableColumn cG;
    ObservableList listpG;

    @FXML
    TableView<Drinks> tableD;
    @FXML
    TableColumn<Meels, Integer> numDC;
    @FXML
    TableColumn<Meels, String> nameDC;
    @FXML
    TableColumn<Meels, String> typeD;
    @FXML
    TableColumn<Meels, Integer> costDC;
    ObservableList<Drinks> listD;

    @FXML
    TableView<Emp> tableEmp;
    @FXML
    TableColumn<Emp, String> IDEmp;
    @FXML
    TableColumn<Emp, String> nameEmp;
    @FXML
    TableColumn<Emp, String> JOB;
    @FXML
    TableColumn<Emp, Integer> salary;
    @FXML
    TableColumn<Emp, String> Address;
    ObservableList<Emp> listEmp;
    ObservableList name_MN;
    ObservableList name_Emp;
    // some variables...
    int indexM = 0;
    boolean mark = true;
    int now = 0;
    int indexD = 0;
    int indexp = 0;
    int nowD = 0;
    int nownumMN = 0;
    int indexMN = 0;
    boolean markD = true;
    static boolean sure = false;
    static boolean markphone = false;
    static boolean donemn = false;
    static boolean donem = false;
    static boolean doned = false;
    static boolean markPE = false;
    int indexE = 0;
    int indexPE = 0;
    static XYChart.Series d = new XYChart.Series();
    static XYChart.Series d1 = new XYChart.Series();
    static double x = 0, y = 0, z = 0;
    int indexG = 0;

    @FXML
    public void entered(Event e) {
        ((Button) e.getSource()).setScaleX(1.1);
        ((Button) e.getSource()).setScaleY(1.1);
        ((Button) e.getSource()).setTextFill(Color.BLUE);
    }

    public void exited(Event e) {
        ((Button) e.getSource()).setScaleX(1);
        ((Button) e.getSource()).setScaleY(1);
        if (((Button) e.getSource()).getText().equals("تسجيل الخروج")) {
            ((Button) e.getSource()).setTextFill(Color.RED);
        } else {
            ((Button) e.getSource()).setTextFill(Color.BLACK);
        }
    }

    @FXML
    public void meals() {

        meal.setVisible(true);
        drank.setVisible(false);
        bground.setVisible(false);
        P3.setVisible(false);
        N.requestFocus();
        PE.setVisible(false);
        char1.setVisible(false);
        pane5.setVisible(false);

    }

    @FXML
    public void dranks() {
        drank.setVisible(true);
        meal.setVisible(false);
        bground.setVisible(false);
        P3.setVisible(false);
        nameD.requestFocus();
        PE.setVisible(false);
        char1.setVisible(false);
        pane5.setVisible(false);

    }

    @FXML
    public void pane3() {
        drank.setVisible(false);
        meal.setVisible(false);
        bground.setVisible(false);
        P3.setVisible(true);
        nameMN.requestFocus();
        PE.setVisible(false);
        char1.setVisible(false);
        pane5.setVisible(false);

    }

    @FXML
    public void paneE() {

        PE.setVisible(true);
        drank.setVisible(false);
        meal.setVisible(false);
        bground.setVisible(false);
        P3.setVisible(false);
        IDE.requestFocus();
        char1.setVisible(false);
        pane5.setVisible(false);

    }

    @FXML
    public void pane5() {

        PE.setVisible(false);
        drank.setVisible(false);
        meal.setVisible(false);
        bground.setVisible(false);
        P3.setVisible(false);
        char1.setVisible(false);
        pane5.setVisible(true);
    }

    @FXML
    public void Char() throws SQLException {
        meal.setVisible(false);
        drank.setVisible(false);
        bground.setVisible(false);
        P3.setVisible(false);
        PE.setVisible(false);
        char1.setVisible(true);
        pane5.setVisible(false);
        d.getData().clear();
        d1.getData().clear();
        x = (double) DB.getCountTypeCold() / DB.count("typeD", "drink");
        y = (double) DB.getCountTypeM("وسط") / DB.count("typeM", "meals");
        z = (double) DB.getCountTypeM(" صغير") / DB.count("typeM", "meals");
        d.getData().add(new XYChart.Data("المشروبات الباردة", x * 100));
        d.getData().add(new XYChart.Data("المشروبات الساخنة", 100 - (x * 100)));
        d1.getData().add(new XYChart.Data("الوجبات الصغيرة", z * 100));
        d1.getData().add(new XYChart.Data("الوجبات الوسط", y * 100));
        d1.getData().add(new XYChart.Data("الوجبات الكبيرة", 100 - (z * 100 + y * 100)));
    }

    private static boolean validate(String text) {
        //validation...
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(text);
        return m.matches();
    }

    @FXML
    public void clsoe() {
        Platform.exit();
    }

    public static void animate1(Label lb) {
        // animation...
        TranslateTransition tt = new TranslateTransition(Duration.millis(250), lb);
        tt.setToX(15);
        tt.setCycleCount(8);
        tt.setAutoReverse(true);
        tt.play();
    }

    public static void animate2(Label lb) {
        // animation...
        TranslateTransition tt = new TranslateTransition(Duration.millis(250), lb);
        tt.setToX(-15);
        tt.setCycleCount(7);
        tt.setAutoReverse(true);
        tt.play();
    }

    public static void animate3(Circle cr) {
        // animation...
        RotateTransition rt = new RotateTransition(Duration.seconds(2), cr);
        rt.setToAngle(180);
        rt.setCycleCount(20);
        rt.setAutoReverse(true);
        rt.play();
    }

    @FXML
    public void insertmeals() throws SQLException {
        String type = null;
        int Id = Integer.parseInt(numMls.getText());
        String name = N.getText();
        int cost = 0;
        try {
            if (!cbo1.getSelectionModel().getSelectedItem().toString().equals(""));
            {
                type = cbo1.getSelectionModel().getSelectedItem().toString();
                if (!N.getText().equals("")) {

                    if (validate(M.getText()) && !(M.getText().equals(""))) {
                        cost = Integer.parseInt(M.getText());
                        if (!DB.insert("meals", Id, name, type, cost)) {
                            listM.add(new Meels(Id, name, type, cost));
                            animate1(doneM);
                            animate2(doneM);
                            doneM.setText("تمت الاضافة");
                            doneM.setVisible(true);
                            numMeals.setText(Integer.parseInt(numMeals.getText()) + 1 + "");
                            numMls.setText(Integer.parseInt(numMls.getText()) + 1 + "");
                            M.setText("");
                            N.setText("");
                            N.requestFocus();
                        } else {
                            N.requestFocus();
                        }
                    } else {
                        doneM.setText("أدخل سعر صحيح");
                        doneM.setVisible(true);
                        M.requestFocus();
                    }
                } else {
                    doneM.setText("أختر اسم الوجبة");
                    doneM.setVisible(true);
                    N.requestFocus();
                }
            }
        } catch (Exception e) {
            doneM.setText("أختر نوع الوجبة");
            doneM.setVisible(true);
            cbo1.requestFocus();
        }
    }

    @FXML
    public void insertdranks() throws SQLException {
        String type = null;
        int Id = Integer.parseInt(numD.getText());
        String name = nameD.getText();
        int cost = 0;
        try {
            if (!cbo2.getSelectionModel().getSelectedItem().toString().equals(""));
            {
                type = cbo2.getSelectionModel().getSelectedItem().toString();
                if (!nameD.getText().equals("")) {
                    if (validate(costD.getText()) && !(costD.getText().equals(""))) {
                        cost = Integer.parseInt(costD.getText());
                        if (!DB.insert("drink", Id, name, type, cost)) {
                            listD.add(new Drinks(Id, name, type, cost));
                            listM = DB.getMeals();
                            tableM.setItems(listM);
                            animate1(doneD);
                            animate2(doneD);
                            doneD.setText("تمت الاضافة");
                            doneD.setVisible(true);
                            numDranks.setText(Integer.parseInt(numDranks.getText()) + 1 + "");
                            numD.setText(Integer.parseInt(numD.getText()) + 1 + "");
                            costD.setText("");
                            nameD.setText("");
                            nameD.requestFocus();
                        } else {
                            nameD.requestFocus();
                        }
                    } else {
                        doneD.setText("أدخل سعر صحيح");
                        doneD.setVisible(true);
                        costD.requestFocus();
                    }
                } else {
                    doneD.setText("أختر اسم المشروب");
                    doneD.setVisible(true);
                    nameD.requestFocus();
                }
            }
        } catch (Exception e) {
            doneD.setText("أختر نوع المشروب");
            doneD.setVisible(true);
            cbo2.requestFocus();
        }
    }

    @FXML
    public void getSelectedItem() {

        try {
            if (!donem) {
                now = Integer.parseInt(numMls.getText());
            }
            indexM = tableM.getSelectionModel().getFocusedIndex();
            numMls.setText(numM.getCellData(indexM).toString());
            N.setText(nameM.getCellData(indexM).toString());
            cbo1.getSelectionModel().select(typeM.getCellData(indexM));
            M.setText(costM.getCellData(indexM).toString());
            N.requestFocus();
            mark = false;
            donem = true;
        } catch (Exception ex) {
        }
    }

    @FXML
    public void getSelectedItemD() {
        try {
            if (!doned) {
                nowD = Integer.parseInt(numD.getText());
            }
            indexD = tableD.getSelectionModel().getFocusedIndex();
            numD.setText(numDC.getCellData(indexD).toString());
            nameD.setText(nameDC.getCellData(indexD).toString());
            cbo2.getSelectionModel().select(typeD.getCellData(indexD));
            costD.setText(costDC.getCellData(indexD).toString());
            nameD.requestFocus();
            markD = false;
            doned = true;
        } catch (Exception e) {
        }
    }

    @FXML
    public void getSelectedItemMN() throws SQLException {
        try {
            if (!donemn) {
                nownumMN = Integer.parseInt(numMN.getText());
            }
            indexMN = tableMN.getSelectionModel().getFocusedIndex();
            numMN.setText(numCMN.getCellData(indexMN).toString());
            nameMN.setText(nameCN.getCellData(indexMN).toString());
            cmbMN.getSelectionModel().select(CC.getCellData(indexMN));
            c2.setCellValueFactory(new PropertyValueFactory< Phone, String>("numm"));
            listh = DB.getPhone(Integer.parseInt(numMN.getText()));
            tableP.setItems(listh);
            donemn = true;
        } catch (Exception e) {
        }
    }

    @FXML
    public void getSelectedItemE() throws SQLException {
        try {

            indexE = tableEmp.getSelectionModel().getFocusedIndex();
            IDE.setText(IDEmp.getCellData(indexE).toString());
            nameMN1.setText(nameEmp.getCellData(indexE).toString());
            sp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(salary.getCellData(indexE), 5000, 1200, 100) {
            });
            cmbMN1.getSelectionModel().select(JOB.getCellData(indexE));
            addressE.setText(Address.getCellData(indexE).toString());
            numsPhone.setCellValueFactory(new PropertyValueFactory< PhoneEmp, String>("phone"));
            listpE = DB.getPhoneEmp((IDE.getText()));
            tablePE.setItems(listpE);
            phone1.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void getselectedG() {

        try {
            indexG = tableG.getSelectionModel().getFocusedIndex();
            bG.setText(BG.getCellData(indexG).toString());
            chG.setText(cG.getCellData(indexG).toString());
            cmbG1.getSelectionModel().select(mnG.getCellData(indexG));
            cmbG2.getSelectionModel().select(eG.getCellData(indexG));
        } catch (Exception e) {
        }
    }

    public void pressPhoneCol() {

        try {
            indexp = tableP.getSelectionModel().getFocusedIndex();
            phone.setText(c2.getCellData(indexp).toString());
            markphone = true;
        } catch (Exception e) {
        }
    }

    public void pressPhoneEmpCol() {
        try {
            indexPE = tablePE.getSelectionModel().getFocusedIndex();
            phone1.setText(numsPhone.getCellData(indexPE).toString());
            markPE = true;
        } catch (Exception e) {
        }
    }

    public void deletephone() throws SQLException {

        if (markphone && !phone.getText().equals("")) {
            int result = JOptionPane.showConfirmDialog(null, "حذف رقم التليفون?", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                if (!DB.deletetphone(Integer.parseInt(numMN.getText()), phone.getText())) {
                    listh.remove(indexp);
                    numMN.setText(nownumMN + "");
                    phone.setText("");
                    nameMN.setText("");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "حدد رقم التليفون اولا  'من فضلك '");
        }

    }

    public void deletephoneEmp() throws SQLException {

        if (markPE && !phone1.getText().equals("")) {
            int result = JOptionPane.showConfirmDialog(null, "حذف رقم التليفون?", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                if (!DB.deletetphoneEmp(IDE.getText(), phone1.getText())) {
                    listpE.remove(indexPE);
                    phone1.setText("");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "حدد رقم التليفون اولا  'من فضلك '");
        }

    }

    @FXML
    public void insertEmp() {
        String name = nameMN1.getText();
        String job = null;
        String address = addressE.getText();
        if (addressE.getText().equals("")) {
            address = "______";
        }
        int salary = Integer.parseInt(sp.getValueFactory().getValue().toString());
        try {

            if (validate(IDE.getText()) && IDE.getText().length() == 14 && !IDE.getText().equals("") && !nameMN1.getText().equals("")) {
                String id = IDE.getText();
                job = cmbMN1.getSelectionModel().getSelectedItem().toString();
                if (!DB.insertEmp(id, name, salary, address, job)) {
                    JOptionPane.showMessageDialog(null, "تمت الاضافة");
                    listEmp.add(new Emp(id, name, salary, job, address));
                    name_Emp.add(name);
                    IDE.requestFocus();
                    nameMN1.clear();
                    addressE.clear();
                    IDE.clear();
                }
            } else {
                JOptionPane.showMessageDialog(null, "من فضلك أدخل رقم قومي صحيح وبيانات صحيحة");
                IDE.requestFocus();
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "رقم قومي مكرر");
        }

    }

    @FXML
    public void insertPhoneEmp() {

        String Id = IDE.getText();

        if (markPE) {
            if (validate(phone1.getText()) && phone1.getText().length() == 11) {
                String phone = phone1.getText();
                if (!DB.insertPhoneEmp(Id, phone)) {
                    listpE.add(new PhoneEmp(phone));
                    phone1.clear();

                }
            } else {
                JOptionPane.showMessageDialog(null, "أدخل رقم تليفون صحيح");
            }
        } else {
            JOptionPane.showMessageDialog(null, "أختر رقم تليفون اولا");
        }

    }

    public void deleteM() {
        int where = Integer.parseInt(numMls.getText());
        if (!DB.deleteField("meals", where)) {
            listM.remove(indexM);
            animate1(doneM);
            animate2(doneM);
            doneM.setText("تمت الحذف");
            doneM.setVisible(true);
            M.setText("");
            N.setText("");
            N.requestFocus();
            mark = true;
            numMls.setText(String.valueOf(now));
        }

    }

    public void deleteD() {
        int where = Integer.parseInt(numD.getText());
        if (!DB.deleteField("drink", where)) {
            listD.remove(indexD);
            animate1(doneD);
            animate2(doneD);
            doneD.setText("تمت الحذف");
            doneD.setVisible(true);
            costD.setText("");
            nameD.setText("");
            nameD.requestFocus();
            markD = true;
            numD.setText(String.valueOf(nowD));
        }

    }

    public void deleteMN() {
        int where = Integer.parseInt(numMN.getText());
        if (!DB.deleteField("MN", where)) {
            listMN.remove(indexMN);
            name_MN.remove(indexMN);
            animate1(doneMN);
            animate2(doneMN);
            doneMN.setText("تمت الحذف");
            doneMN.setVisible(true);
            nameMN.setText("");
            nameMN.requestFocus();
            numMN.setText(String.valueOf(nownumMN));
        }

    }

    public void deleteEmp() {
        String where = IDE.getText();
        if (!DB.deleteEmp(where) && !IDE.getText().equals("")) {
            listEmp.remove(indexE);
            name_Emp.remove(indexE);
            nameMN1.setText("");
            IDE.requestFocus();
            IDE.clear();
            addressE.clear();
        }

    }

    public void updateMeals() {

        String type = null;
        int Id = Integer.parseInt(numMls.getText());
        String name = N.getText();
        int cost = 0;
        try {
            if (!cbo1.getSelectionModel().getSelectedItem().toString().equals(""));
            {
                type = cbo1.getSelectionModel().getSelectedItem().toString();
                if (!N.getText().equals("")) {

                    if (validate(M.getText()) && !(M.getText().equals(""))) {
                        cost = Integer.parseInt(M.getText());
                        if (DB.update("meals", Id, name, type, cost)) {
                            listM.set(indexM, new Meels(Id, name, type, cost));
                            animate1(doneM);
                            animate2(doneM);
                            doneM.setText("تمت التعديل");
                            doneM.setVisible(true);
                            M.setText("");
                            N.setText("");
                            nameD.requestFocus();
                            N.requestFocus();
                            mark = true;
                            numMls.setText(String.valueOf(now));

                        } else {
                            N.requestFocus();
                        }
                    } else {
                        doneM.setText("أدخل سعر صحيح");
                        doneM.setVisible(true);
                        M.requestFocus();
                    }
                } else {
                    doneM.setText("أختر اسم الوجبة");
                    doneM.setVisible(true);
                    N.requestFocus();
                }
            }
        } catch (Exception e) {
            doneM.setText("أختر نوع الوجبة");
            doneM.setVisible(true);
            cbo1.requestFocus();
        }

    }

    public void updateDrinks() {

        String type = null;
        int Id = Integer.parseInt(numD.getText());
        String name = nameD.getText();
        int cost = 0;
        try {
            if (!cbo2.getSelectionModel().getSelectedItem().toString().equals(""));
            {
                type = cbo2.getSelectionModel().getSelectedItem().toString();
                if (!nameD.getText().equals("")) {

                    if (validate(costD.getText()) && !(costD.getText().equals(""))) {
                        cost = Integer.parseInt(costD.getText());
                        if (DB.update("drink", Id, name, type, cost)) {
                            listD.set(indexD, new Drinks(Id, name, type, cost));
                            animate1(doneD);
                            animate2(doneD);
                            doneD.setText("تمت التعديل");
                            doneD.setVisible(true);
                            costD.setText("");
                            nameD.setText("");
                            nameD.requestFocus();
                            markD = true;
                            numD.setText(String.valueOf(nowD));

                        } else {
                            nameD.requestFocus();
                        }
                    } else {
                        doneD.setText("أدخل سعر صحيح");
                        doneD.setVisible(true);
                        costD.requestFocus();
                    }
                } else {
                    doneD.setText("أختر اسم المشروب");
                    doneD.setVisible(true);
                    nameD.requestFocus();
                }
            }
        } catch (Exception e) {
            doneD.setText("أختر نوع المشروب");
            doneD.setVisible(true);
            cbo2.requestFocus();
        }

    }

    @FXML
    public void updateMN() {

        String type = null;
        int Id = Integer.parseInt(numMN.getText());
        String name = nameMN.getText();
        try {
            if (!cmbMN.getSelectionModel().getSelectedItem().toString().equals(""));
            {
                type = cmbMN.getSelectionModel().getSelectedItem().toString();
                if (!nameMN.getText().equals("")) {

                    if (DB.update("MN", Id, name, type, 0)) {
                        listMN.set(indexMN, new MN(Id, name, type));
                        name_MN.set(indexMN, name);
                        animate1(doneMN);
                        animate2(doneMN);
                        doneMN.setText("تمت التعديل");
                        doneMN.setVisible(true);
                        nameMN.setText("");
                        nameMN.requestFocus();
                        nameMN.requestFocus();
                        numMN.setText(String.valueOf(nownumMN));

                    } else {
                        nameMN.requestFocus();
                    }

                } else {
                    doneMN.setText("أختر اسم الوجبة");
                    doneMN.setVisible(true);
                    nameMN.requestFocus();
                }
            }
        } catch (Exception e) {
            doneMN.setText("أختر نوع الوجبة");
            doneMN.setVisible(true);
            cmbMN.requestFocus();
        }

    }

    @FXML
    public void report(){
    
        try {
            
            Connection conn = DB.connect();
            String path = "Cherry.jrxml";            
            JasperReport jr  = JasperCompileManager.compileReport(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
            conn.close();
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    
    public void updateEmp() {

        try {
            String job = cmbMN1.getSelectionModel().getSelectedItem().toString();
            String condition = IDE.getText();
            String name = nameMN1.getText();
            String address = addressE.getText();
            int salary = Integer.parseInt(sp.getValueFactory().getValue().toString());

            if (!nameMN1.getText().equals("")) {

                if (DB.updateEmp(condition, name, salary, job, address)) {
                    listEmp.set(indexE, new Emp(condition, name, salary, job, address));
                    name_Emp.set(indexE, name);
                    JOptionPane.showMessageDialog(null, "تمت التعديل");
                    IDE.setText("");
                    IDE.requestFocus();
                    nameMN1.clear();
                    phone1.clear();
                    addressE.clear();

                } else {
                    nameMN1.requestFocus();
                }

            }

        } catch (Exception e) {

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            numM.setCellValueFactory(new PropertyValueFactory<Meels, Integer>("ID"));
            nameM.setCellValueFactory(new PropertyValueFactory<Meels, String>("name"));
            typeM.setCellValueFactory(new PropertyValueFactory<Meels, String>("type"));
            costM.setCellValueFactory(new PropertyValueFactory<Meels, Integer>("cost"));
            listM = DB.getMeals();
            tableM.setItems(listM);

            numDC.setCellValueFactory(new PropertyValueFactory<Meels, Integer>("ID"));
            nameDC.setCellValueFactory(new PropertyValueFactory<Meels, String>("name"));
            typeD.setCellValueFactory(new PropertyValueFactory<Meels, String>("type"));
            costDC.setCellValueFactory(new PropertyValueFactory<Meels, Integer>("cost"));
            listD = DB.getDranks();
            tableD.setItems(listD);

            numCMN.setCellValueFactory(new PropertyValueFactory<MN, Integer>("ID"));
            CC.setCellValueFactory(new PropertyValueFactory<MN, String>("comp"));
            nameCN.setCellValueFactory(new PropertyValueFactory<MN, String>("nameMN"));
            listMN = DB.getMN();
            tableMN.setItems(listMN);

            nameEmp.setCellValueFactory(new PropertyValueFactory<Emp, String>("name_emp"));
            JOB.setCellValueFactory(new PropertyValueFactory<Emp, String>("job"));
            salary.setCellValueFactory(new PropertyValueFactory<Emp, Integer>("salary"));
            Address.setCellValueFactory(new PropertyValueFactory<Emp, String>("address"));
            IDEmp.setCellValueFactory(new PropertyValueFactory<Emp, String>("ID"));
            listEmp = DB.getEmp();
            tableEmp.setItems(listEmp);

            mnG.setCellValueFactory(new PropertyValueFactory<>("name_mng"));
            eG.setCellValueFactory(new PropertyValueFactory<>("name_eg"));
            gG.setCellValueFactory(new PropertyValueFactory<>("g"));
            dG.setCellValueFactory(new PropertyValueFactory<>("d"));
            BG.setCellValueFactory(new PropertyValueFactory<>("buy"));
            cG.setCellValueFactory(new PropertyValueFactory<>("change"));
            listpG = DB.getG();
            tableG.setItems(listpG);

            numMeals.setText(DB.count("numM", "meals") + "");
            numDranks.setText(DB.count("numD", "drink") + "");

            ObservableList obs_M = FXCollections.observableArrayList("وسط ", " كبير ", " صغير");
            cbo1.setItems(obs_M);
            ObservableList obs_D = FXCollections.observableArrayList("بارد  ", " دافيء");
            cbo2.setItems(obs_D);
            ObservableList obs_MN = FXCollections.observableArrayList("كوكاكولا  ", " شيبسي", "جهينة", " خضار", "لحوم  ", " اسماك");
            cmbMN.setItems(obs_MN);
            ObservableList cmbE = FXCollections.observableArrayList("ديلفري  ", " كاشيير", "امن", " شيف", "مساعد شيف  ", " ستيورد", "سواق");
            cmbMN1.setItems(cmbE);
            name_MN = FXCollections.observableArrayList();
            name_MN = DB.getMNname();
            name_Emp = FXCollections.observableArrayList();
            name_Emp = DB.getEmpname();
            cmbG1.setItems(name_Emp);
            cmbG2.setItems(name_MN);

            x = (double) DB.getCountTypeCold() / DB.count("typeD", "drink");
            y = (double) DB.getCountTypeM("وسط") / DB.count("typeM", "meals");
            z = (double) DB.getCountTypeM(" صغير") / DB.count("typeM", "meals");
            d.setName("النسبة المؤية للمشروبات");
            d.getData().add(new XYChart.Data("المشروبات الباردة", x * 100));
            d.getData().add(new XYChart.Data("المشروبات الساخنة", 100 - (x * 100)));
            //d1.setName("النسبة المؤية للوجبات");
            d1.getData().add(new XYChart.Data("الوجبات الصغيرة", z * 100));
            d1.getData().add(new XYChart.Data("الوجبات الوسط", y * 100));
            d1.getData().add(new XYChart.Data("الوجبات الكبيرة", 100 - (z * 100 + y * 100)));
            charACH.getData().addAll(d, d1);
            
            pc.getData().add(new PieChart.Data("كوكاكولا", 35));
            pc.getData().add(new PieChart.Data("جهينة", 10));
            pc.getData().add(new PieChart.Data("خضار", 20));
            pc.getData().add(new PieChart.Data("شيبسي", 15));
            pc.getData().add(new PieChart.Data("لحوم", 10));
            pc.getData().add(new PieChart.Data("أسماك", 10));
            
            

            numMls.setText(DB.AutoNum("meals", "numM") + "");
            numD.setText(DB.AutoNum("drink", "numD") + "");
            numMN.setText(DB.AutoNumMN("MN", "ID") + "");
            sp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1200, 5000, 1200, 100) {
            });
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage());

        }

    }

    @FXML
    public void pressEnter(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER) && mark) {
            add.fire();
        }
    }

    @FXML
    public void pressEnterName(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            cbo1.requestFocus();
        }
    }

    @FXML
    public void pressEnterType(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            M.requestFocus();
        }
    }

    @FXML
    public void pressEnterD(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER) && markD) {
            ad.fire();
        }
    }

    @FXML
    public void pressEnterNameD(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            cbo2.requestFocus();
        }
    }

    @FXML
    public void pressEnterTypeD(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            costD.requestFocus();
        }
    }

    @FXML
    public void pressEnterMN(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            nameMN.requestFocus();
        }
    }

    @FXML
    public void pressEnterIDE(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            nameMN1.requestFocus();
        }
    }

    @FXML
    public void pressEnterMNP(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            addMN.fire();
        }
    }

    @FXML
    public void pressEnterMNC(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            cmbMN.requestFocus();
        }
    }

    @FXML
    public void pressMN(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            addPhon.fire();
        }
    }

    @FXML
    public void pressaddPhoneE(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            addPhonE.fire();
        }
    }

    public static Alert alertWithCheckbox(AlertType type, String title,
            String message, String optOutMessage,
            ButtonType... buttonTypes) {
        CheckBox optOut = new CheckBox();

        Alert alert = new Alert(type);
        alert.getDialogPane().applyCss();
        Node graphic = alert.getDialogPane().getGraphic();
        alert.setDialogPane(new DialogPane() {
            @Override
            protected Node createDetailsButton() {
                optOut.setText(optOutMessage);
                optOut.setOnAction(event -> {

                    if (optOut.isSelected()) {

                        sure = true;
                    } else {
                        sure = false;
                    }
                });
                return optOut;
            }
        });
        alert.getDialogPane().getButtonTypes().addAll(buttonTypes);
        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setExpandableContent(new Group());
        alert.getDialogPane().setExpanded(true);
        alert.getDialogPane().setGraphic(graphic);
        alert.setTitle(title);
        return alert;
    }

    @FXML
    private void showConfirmation() throws IOException {

        Alert alert = alertWithCheckbox(AlertType.CONFIRMATION, "مسح البيانات",
                "هل أنت متاكد انك تريد حذف  جدول الوجبات يمكنك عمل نسخ احتياطي قبل الحذف ؟", "عدم السؤال مجددا ", ButtonType.YES, ButtonType.NO);

        if (alert.showAndWait().filter(t -> t == ButtonType.YES).isPresent()) {
            if (DB.delete("drink")) {
                listD.clear();
                animate1(doneD);
                animate2(doneD);
                doneD.setText("تمت العملية");
                doneD.setVisible(true);
                costD.setText("");
                nameD.setText("");
                nameD.requestFocus();

            }
        }

    }

    @FXML
    public void insertMN() throws SQLException {

        int ID = Integer.parseInt(numMN.getText());
        String name = nameMN.getText();

        try {
            if (!nameMN.getText().equals("")) {
                String comp = cmbMN.getSelectionModel().getSelectedItem().toString();
                if (!DB.insertMN("MN", ID, name, comp)) {
                    name_MN.add(name);
                    listMN.add(new MN(ID, name, comp));
                    numMN.setText(Integer.parseInt(numMN.getText()) + 1 + "");
                    doneMN.setVisible(true);
                    doneMN.setText("تمت الإضافة");
                    animate1(doneMN);
                    animate2(doneMN);
                    nameMN.requestFocus();
                    nameMN.setText("");
                    phone.setText("");
                }
            } else {
                doneMN.setVisible(true);
                doneMN.setText("ادخل اسم المندوب");
                animate1(doneMN);
                animate2(doneMN);
                nameMN.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "أختر السلعة او الشركة");
        }

    }

    @FXML
    public void insertphone() throws SQLException {

        int ID = Integer.parseInt(numMN.getText());
        String pho = phone.getText();
        if (validate(phone.getText()) && phone.getText().length() == 11 && !phone.getText().equals("")) {
            if (!DB.insertphone("phone", ID, pho)) {
                listh.add(new Phone(pho));
                phone.requestFocus();
                phone.setText("");
            }
        } else {
            doneMN.setVisible(true);
            doneMN.setText("رقم غير صحيح");
            animate1(doneMN);
            animate2(doneMN);
            phone.requestFocus();
        }
    }

    @FXML
    public void insertG() {
        try {
            String nameE = cmbG1.getSelectionModel().getSelectedItem().toString();
            String nameMn = cmbG2.getSelectionModel().getSelectedItem().toString();
            int nameMnI = cmbG2.getSelectionModel().getSelectedIndex();
            int buy = Integer.parseInt(bG.getText());
            int change = Integer.parseInt(chG.getText());
            String type = CC.getCellData(nameMnI);
            if (!DB.insertG(nameMn, nameE, type, buy, change)) {
                listpG.add(new G(nameMn, nameE, type, new SimpleDateFormat("dd/MM/yyyy").format(new Date()), buy, change));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "تاكد من ادخال البيانات");
        }
    }

    @FXML
    private void showConfirmationMeals() throws IOException {

        if (new File("C:\\Users\\Teba\\Documents\\Resturant\\import.ser").exists()) {
            try {
                FileInputStream fis = new FileInputStream("C:\\Users\\Teba\\Documents\\Resturant\\import.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                fis.close();
                ois.close();

            } catch (Exception e) {
            }
        }

        if (!new File("C:\\Users\\Teba\\Documents\\Resturant\\import.ser").exists()) {
            Alert alert = alertWithCheckbox(AlertType.CONFIRMATION, "مسح البيانات",
                    "هل أنت متاكد انك تريد حذف  جدول المشروبات يمكنك عمل نسخ احتياطي قبل الحذف ؟", "عدم السؤال مجددا ", ButtonType.YES, ButtonType.NO);

            if (alert.showAndWait().filter(t -> t == ButtonType.YES).isPresent()) {
                if (DB.delete("meals")) {
                    listM.clear();
                    animate1(doneM);
                    animate2(doneM);
                    doneM.setText("تمت العملية");
                    doneM.setVisible(true);
                    M.setText("");
                    N.setText("");
                    N.requestFocus();
                }
            }
        } else {
            listM.clear();
            animate1(doneM);
            animate2(doneM);
            doneM.setText("تمت العملية");
            doneM.setVisible(true);
            M.setText("");
            N.setText("");
            N.requestFocus();
        }
        if (sure) {

            FileOutputStream out = new FileOutputStream("C:\\Users\\Teba\\Documents\\Resturant\\import.ser");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.close();
            oos.flush();
            out.close();
        }
    }

    @FXML
    public void searchMeals() {
        searshM.textProperty().addListener((Observable observable) -> {
            if (searshM.textProperty().get().isEmpty()) {
                tableM.setItems(listM);
                return;
            }
            ObservableList<Meels> item = FXCollections.observableArrayList();
            ObservableList<TableColumn<Meels, ?>> column = tableM.getColumns();
            for (int row = 0; row < listM.size(); row++) {
                for (int col = 0; col < column.size(); col++) {
                    TableColumn colVar = column.get(col);
                    String cellValue = colVar.getCellData(listM.get(row)).toString();
                    if (cellValue.contains(searshM.getText()) || cellValue.startsWith(searshM.getText())) {
                        item.add(listM.get(row));
                        break;
                    }
                }
            }
            tableM.setItems(item);
        });
    }

    public void searchDrinks() {
        searshD.textProperty().addListener((Observable observable) -> {
            if (searshD.textProperty().get().isEmpty()) {
                tableD.setItems(listD);
                return;
            }
            ObservableList<Drinks> item = FXCollections.observableArrayList();
            ObservableList<TableColumn<Drinks, ?>> column = tableD.getColumns();
            for (int row = 0; row < listD.size(); row++) {
                for (int col = 0; col < column.size(); col++) {
                    TableColumn colVar = column.get(col);
                    String cellValue = colVar.getCellData(listD.get(row)).toString();
                    if (cellValue.contains(searshD.getText()) || cellValue.startsWith(searshD.getText())) {
                        item.add(listD.get(row));
                        break;
                    }
                }
            }
            tableD.setItems(item);
        });
    }

    public void searchMN() {
        searshMN.textProperty().addListener((Observable observable) -> {
            if (searshMN.textProperty().get().isEmpty()) {
                tableMN.setItems(listMN);
                matchMN.setVisible(false);
                return;
            }
            ObservableList<MN> item = FXCollections.observableArrayList();
            ObservableList<TableColumn<MN, ?>> column = tableMN.getColumns();
            for (int row = 0; row < listMN.size(); row++) {
                for (int col = 0; col < column.size(); col++) {
                    TableColumn colVar = column.get(col);
                    String cellValue = colVar.getCellData(listMN.get(row)).toString();
                    if (cellValue.contains(searshMN.getText()) || cellValue.startsWith(searshMN.getText())) {
                        item.add(listMN.get(row));
                        break;
                    }
                }
            }
            tableMN.setItems(item);
            matchMN.setVisible(true);
            matchMN.setText("المتطابق" + ": " + item.size());

        });
    }

    @FXML
    public void searchEmp() {
        searshE.textProperty().addListener((Observable observable) -> {
            if (searshE.textProperty().get().isEmpty()) {
                tableEmp.setItems(listEmp);
                matchMN1.setVisible(false);
                return;
            }
            ObservableList<Emp> item = FXCollections.observableArrayList();
            ObservableList<TableColumn<Emp, ?>> column = tableEmp.getColumns();
            for (int row = 0; row < listEmp.size(); row++) {
                for (int col = 0; col < column.size(); col++) {
                    TableColumn colVar = column.get(col);
                    String cellValue = colVar.getCellData(listEmp.get(row)).toString();
                    if (cellValue.contains(searshE.getText()) || cellValue.startsWith(searshE.getText())) {
                        item.add(listEmp.get(row));
                        break;
                    }
                }
            }
            tableEmp.setItems(item);
            matchMN1.setVisible(true);
            matchMN1.setText("المتطابق" + ": " + item.size());

        });
    }
    
    public void searchG() {
        searchG.textProperty().addListener((Observable observable) -> {
            if (searchG.textProperty().get().isEmpty()) {
                tableG.setItems(listpG);
                return;
            }
            ObservableList item = FXCollections.observableArrayList();
            ObservableList<TableColumn<G , ?>> column = tableG.getColumns();
            for (int row = 0; row < listpG.size(); row++) {
                for (int col = 0; col < column.size(); col++) {
                    TableColumn colVar = column.get(col);
                    String cellValue = colVar.getCellData(listpG.get(row)).toString();
                    if (cellValue.contains(searchG.getText()) || cellValue.startsWith(searchG.getText())) {
                        item.add(listpG.get(row));
                        break;
                    }
                }
            }
            tableG.setItems(item);
      
        });
    }

    public void backup() throws IOException {

        FileReader in = null;
        FileWriter out = null;
        String name = "الوجبات";

        try {
            in = new FileReader("C:\\Users\\Teba\\Documents\\Resturant\\rest.accdb");
            out = new FileWriter("C:\\Users\\Teba\\Desktop\\" + name + ".accdb");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            JOptionPane.showMessageDialog(null, "تم عمل نسخ احتياطي بنجاح");

        } catch (Exception e) {

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}

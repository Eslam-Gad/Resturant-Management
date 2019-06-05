package resturant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController implements Initializable {

    @FXML
    TextField txt;
    @FXML
    PasswordField pass;
    @FXML
    Button btn;

    @FXML
    public void pressEnter(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            pass.requestFocus();
        }
    }

    @FXML
    public void PasspressEnter(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            btn.fire();
        }

    }

    @FXML
    public void actionbtn(Event e) {

        try {
            if (txt.getText().trim().matches("admin") && pass.getText().equals("123")) {

                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                String x = "                                                                                                              ";
                stage.setTitle(x + "الرئيسية");
                Rectangle2D rd = Screen.getPrimary().getVisualBounds();
                stage.setX((rd.getWidth() - stage.getWidth()) / 2);
                stage.setY((rd.getHeight() - stage.getHeight()) / 2);

            } else {
                JOptionPane.showMessageDialog(null, "تحقق من اسم المرور وكلمة السر");

            }
        } catch (Exception ex) {
        }
    }

    @FXML
    public void exit() {
        int result = JOptionPane.showConfirmDialog(null, "Close The program now?", "Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            System.exit(0);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}

package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import sample.entity.Member;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberController implements Initializable {

    @FXML
    private JFXTextField txtAvatar;

    @FXML
    private TableColumn<Member, String> columnUsername;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private TableColumn<Member, String> columnRemainTime;

    @FXML
    private JFXTextField txtRemainTime;

    @FXML
    private JFXButton btnDeactive;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<Member> tableView;

    @FXML
    private TableColumn<Member, ImageView> columnAvatar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tableView.setRowFactory(new Callback<TableView<Member>, TableRow<Member>>() {
            @Override
            public TableRow<Member> call(TableView<Member> param) {
                TableRow<Member> memberTableRow = new TableRow<>();
                memberTableRow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!memberTableRow.isEmpty()) {
                            Member member = memberTableRow.getItem();
                            txtUsername.setText(member.getUsername());
                        }
                    }
                });
                return memberTableRow;
            }
        });

        this.columnAvatar.setCellValueFactory(new PropertyValueFactory<>("imageAvatar"));
        this.columnUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.columnRemainTime.setCellValueFactory(new PropertyValueFactory<>("remainTime"));
        this.tableView.setItems(loadStudents());
    }

    private ObservableList<Member> loadStudents() {
        ObservableList<Member> members = FXCollections.observableArrayList();
        return members;
    }
//    @FXML
//    void saveStudent(ActionEvent event) {
//        Student student = new Student(txtRollnumber.getText(), txtName.getText(), txtAvatar.getText());
//        for (int i = 0; i < this.tableView.getItems().size(); i++) {
//            Student st = this.tableView.getItems().get(i);
//            if(st.getRollNumber().equals(student.getRollNumber())){
//                this.tableView.getItems().remove(i);
//            }
//        }
//        tableView.getItems().add(student);
//    }
//
//    @FXML
//    void doDelete(ActionEvent event) {
//        Student student = this.tableView.getSelectionModel().getSelectedItem();
//        this.tableView.getItems().remove(student);
//    }

}

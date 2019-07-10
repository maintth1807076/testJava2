package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.entity.Member;
import sample.model.MemberModel;

public class MemberFormController {

    @FXML
    private JFXPasswordField txtpassword;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXTextField txtfullName;

    @FXML
    private JFXTextField txtremainTime;

    @FXML
    private JFXTextField txtavatar;

    @FXML
    private JFXTextField txtusername;

    @FXML
    void add(ActionEvent event) {
        MemberModel model = new MemberModel();
        String username = txtusername.getText();
        String password = txtpassword.getText();
        String fullName = txtfullName.getText();
        String avatar = txtavatar.getText();
        long remainTime = Long.parseLong(txtremainTime.getText());
        Member member = new Member(username,password,fullName,avatar,remainTime,1);
        model.create(member);
    }

    @FXML
    void reset(ActionEvent event) {

    }

}

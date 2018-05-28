/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.fxui.view;

import com.mycompany.copycenter.tools.Messanger;
import com.mycompany.copycenter.tools.interfaces.MessangerMenu;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author max19
 */
public abstract class Messages extends BorderPane implements MessangerMenu{
    
    private StackPane topPane;
    protected StackPane centerPane;
    protected HBox bottomPane;
    
    public Messages(String post) {
        initNodes(post);
        layoutNodes();
    }

    private void initNodes(String post) {
        topPane = new StackPane();
        centerPane = new StackPane();
        bottomPane = new HBox();
        
        topPane.getChildren().add(new Label("Messages for you:"));

        TextArea msgArea = new TextArea();
        msgArea.setEditable(false);
        Messanger msg  = new Messanger(post);
        msgArea.setText(msg.getMsgText());
        centerPane.getChildren().add(msgArea);
        
        Button btn = new Button("Refresh messages");
        btn.setOnAction((ActionEvent t) -> updateMsgArea());
        bottomPane.getChildren().add(btn);
    }

    private void layoutNodes() {
        this.setTop(topPane);
        this.setCenter(centerPane);
        this.setBottom(bottomPane);
    }

    @Override
    abstract public void updateMsgArea();
    
}

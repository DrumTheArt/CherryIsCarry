package com.wachs.main.views.GUIElementsGenerators;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class CreateMenuBar {

    private MenuItem firstItem;
    private MenuItem secondItem;
    private MenuItem thirdItem;

    public MenuBar getMenuBar(String menuBarName, String menuItem1, String menuItem2, String menuItem3) {

        Menu m = new Menu(menuBarName);

        firstItem = new MenuItem(menuItem1);
        secondItem = new MenuItem(menuItem2);
        thirdItem = new MenuItem(menuItem3);

        m.getItems().add(firstItem);
        m.getItems().add(secondItem);
        m.getItems().add(thirdItem);

        MenuBar mb = new MenuBar();

        mb.getMenus().add(m);

        return mb;
    }

    public void setEventFirstItem(EventHandler<ActionEvent> event) {

        firstItem.setOnAction(event);
    }

    public void setEventSecondItem(EventHandler<ActionEvent> event) {

        secondItem.setOnAction(event);
    }

    public void setEventThirdItem(EventHandler<ActionEvent> event) {

        thirdItem.setOnAction(event);
    }
}
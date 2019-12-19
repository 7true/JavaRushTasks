package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class EditUserView implements View {
    private Controller controller;
    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:\n" +
                "\t" + modelData.getActiveUser()
        + "\n===================================================");

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }


}

package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("A" ,1, 1));
        users.add(new User("B", 2, 1));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        UserService userService = new UserServiceImpl();
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
}

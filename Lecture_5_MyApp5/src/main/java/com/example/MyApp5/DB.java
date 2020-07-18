package com.example.MyApp5;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private ArrayList<User> userTable =
            new ArrayList<>();
    public DB(){
        userTable.add(new User(101,"Shakal",30));
        userTable.add(new User(102,"Ramu",35));
    }

    public boolean addAUser(User user){
        userTable.add(user);
        return true;
    }

    public List<User> getAllUsers(){
        return userTable;
    }

    public User findAUser(int id){
        for(User user : userTable){
            if(user.getId()==id) return user;
        }
        System.out.println("Couldn't find the user");
        return null;
    }
    public boolean updateAUser(User inputUser){
        for(User user : userTable){
            if(user.getId()==inputUser.getId()) {
                user.setAge(inputUser.getAge());
                user.setName(inputUser.getName());
                return true;
            }
        }
        return false;
    }

    public boolean deleteAUser(int id){
        for(User user : userTable){
            if(user.getId()==id) {
               userTable.remove(user);
                return true;
            }
        }
        return false;
    }

}

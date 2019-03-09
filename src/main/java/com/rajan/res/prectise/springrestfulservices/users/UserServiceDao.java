package com.rajan.res.prectise.springrestfulservices.users;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserServiceDao {

    private static List<User> users = new ArrayList<User>();
    private static int count = 3;
    static {
        users.add(new User("rajan",1,new Date()));
        users.add(new User("sandeep",2,new Date()));
        users.add(new User("bhagat",3,new Date()));
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User addUser(User user){
        if(user.getId()== 0){
            user.setId(++count);
            users.add(user);
        }else{
            users.add(user);
        }
        return user;
    }

    public User getUser(int id){
        for(User user : users){
            if(user.getId()==id){
                return  user;
            }
        }
        return null;
    }


    public User delete(int id) {

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}

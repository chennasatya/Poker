package com.example.lovelyhearts.poker;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lovelyhearts on 5/3/2015.
 */
public class UserManager {

    private static List<User> users;

    public UserManager() {
        users = new ArrayList<User>();
        User u1 = new User();

        u1.setName("u");
        u1.setPassword("u");
        u1.setEmail("user@gmail.com");
        u1.setAddress1("UMN");
        u1.setAddress2("MN");
        u1.setPhone("123-3443-54645");
        u1.setIsAdmin(true);

        User u2 = new User();
        u2.setName("User2");
        u2.setPassword("User2");
        u2.setIsAdmin(false);

        users.add(u1);
        users.add(u2);
    }
    public User GetUser(String mId)
    {
        try {
            return getUserById(mId);
        }
        catch (Exception ex) {
            Log.w("GetContact", "No Contact with id=[" + mId + "]");
            return null;
        }
    }

    public User getUserById(String id) throws UserNotFoundException {
        Iterator<User> itr = users.iterator();

        while (itr.hasNext()) {
            User curr = itr.next();
            if (curr.getName().equals(id)) {
                return curr;
            }
        }
        throw new UserNotFoundException("Exception: No contact found with id [" + id + "]");
    }

    private class UserNotFoundException extends Exception {
        public UserNotFoundException(String msg) {
            super(msg);
        }
    }
}

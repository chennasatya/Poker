package com.example.lovelyhearts.poker;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ryan on 4/21/15.
 */
public class ServiceResult {
    private String status;
    private String message;
    private Group group;
    private List<Location> locations;
    private Location location;
    private List<User> users;
    private User user;

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }


    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        String value = "";
        //comment

        try {
            Iterator i = this.getUsers().iterator();

            while (i.hasNext()) {
                User curr = (User) i.next();
                String line = "[id: " + curr.getId() + "]\n[login: " + curr.getLogin() + "]\n" +
                        "[password: " + curr.getPassword() + "]\n[isAdmin: " + curr.getIsAdmin() + "]\n" +
                        "[name: " + curr.getName() + "]\n[email: " + curr.getEmail() + "]\n" +
                        "[address1: " + curr.getAddress1() + "]\n[address2: " + curr.getAddress2() + "]\n" +
                        "[city: " + curr.getCity() + "]\n[state: " + curr.getState() + "]\n" +
                        "[zip: " + curr.getZip() + "]\n[phone: " + curr.getPhone() + "]\n\n";
                value = value + line;
            }
        } catch (Exception e) {
            User curr = this.getUser();
            String line = "[id: " + curr.getId() + "]\n[login: " + curr.getLogin() + "]\n" +
                    "[password: " + curr.getPassword() + "]\n[isAdmin: " + curr.getIsAdmin() + "]\n" +
                    "[name: " + curr.getName() + "]\n[email: " + curr.getEmail() + "]\n" +
                    "[address1: " + curr.getAddress1() + "]\n[address2: " + curr.getAddress2() + "]\n" +
                    "[city: " + curr.getCity() + "]\n[state: " + curr.getState() + "]\n" +
                    "[zip: " + curr.getZip() + "]\n[phone: " + curr.getPhone() + "]\n\n";
            value = value + line;
        }
        value = value + "[message: " + message + "]";
        value = value + "[status: " + status + "]";
        value = value + "[group: " + group + "]";
        return value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public class Group {
        private String key;
        private String name;
        private String id;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}

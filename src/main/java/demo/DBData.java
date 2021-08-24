package demo;

import models.Login;

import java.util.ArrayList;

public class DBData {
    public ArrayList<Login> getLogins() {
        ArrayList<Login> loginList = new ArrayList<>();

        loginList.add(new Login("admin", "admin"));
        loginList.add(new Login("Ash-broccoli", "dream123"));

        return loginList;
    }
}

package demo;

import models.DreamType;
import models.Login;

import java.util.ArrayList;

public class DBData {
    public ArrayList<Login> getLogins() {
        ArrayList<Login> loginList = new ArrayList<>();

        loginList.add(new Login("admin", "admin"));

        return loginList;
    }

    public ArrayList<DreamType> getTypes(){
        ArrayList<DreamType> typeList = new ArrayList<>();

        typeList.add(new DreamType("Dream"));
        typeList.add(new DreamType("Lucid dream"));
        typeList.add(new DreamType("Nightmare"));
        typeList.add(new DreamType("Lucid Nightmare"));

        return typeList;
    }
}

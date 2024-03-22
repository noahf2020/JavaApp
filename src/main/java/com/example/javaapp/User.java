package com.example.javaapp;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

public class User implements Serializable {
    // Class fields
    static ArrayList<User> allUsers;

    // Object fields
    private String GymID;
    private String Visitorname;
    private Boolean IsManager;
    private String VisitorPicture;
    private int amountofVisits;
    private Boolean Standing;
    private int RealStanding;
    private Boolean SignedIn;
    private int LastSignin;

    public User(String GymID, String Visitorname, Boolean IsManager, String VisitorPicture, int amountofVisits, Boolean Standing, int RealStanding, Boolean SignedIn, int LastSignin) {
        this.GymID = GymID;
        this.Visitorname = Visitorname;
        this.IsManager = IsManager;
        this.VisitorPicture = VisitorPicture;
        this.amountofVisits = amountofVisits;
        this.Standing = Standing;
        this.RealStanding = RealStanding;
        this.SignedIn = SignedIn;
        this.LastSignin = LastSignin;
        if (allUsers == null) {
            allUsers = new ArrayList<User>();
        }
        allUsers.add(this);
    }

    public String getGymID() {
        return GymID;
    }

    public void setGymID(String gymID) {
        GymID = gymID;
    }

    public String getVisitorname() {
        return Visitorname;
    }

    public void setVisitorname(String visitorname) {
        Visitorname = visitorname;
    }

    public Boolean getManager() {
        return IsManager;
    }

    public void setManager(Boolean manager) {
        IsManager = manager;
    }

    public String getVisitorPicture() {
        return VisitorPicture;
    }

    public void setVisitorPicture(String visitorPicture) {
        VisitorPicture = visitorPicture;
    }

    public int getAmountofVisits() {
        return amountofVisits;
    }

    public void setAmountofVisits(int amountofVisits) {
        this.amountofVisits = amountofVisits;
    }

    public Boolean getStanding() {
        return Standing;
    }

    public void setStanding(Boolean standing) {
        Standing = standing;
    }

    public int getRealStanding() {
        return RealStanding;
    }

    public void setRealStanding(int realStanding) {
        RealStanding = realStanding;
    }

    public Boolean getSignedIn() {
        return SignedIn;
    }

    public void setSignedIn(Boolean signedIn) {
        SignedIn = signedIn;
    }

    public int getLastSignin() {
        return LastSignin;
    }

    public void setLastSignin(int lastSignin) {
        LastSignin = lastSignin;
    }

    public static void readData() throws Exception {
        if (User.allUsers == null) {
            User.allUsers = new ArrayList<>();
        }

        File dataFile = new File("src/main/java/com/example/javaapp/Students.txt");
        Scanner dataScanner = new Scanner(dataFile);
        dataScanner.useDelimiter("\t|\n");
        while (dataScanner.hasNext()) {
            String Name = dataScanner.next();
            String gymID = dataScanner.next();
            System.out.println(Name);
            System.out.println(gymID);


            boolean isMan = false;
            if (gymID.equals("8831651")) {
                isMan = true;
            }
            System.out.println("isMan " +  isMan);

           new User(gymID,Name,isMan, null,0,null,0,null,0);
        }
    }
}

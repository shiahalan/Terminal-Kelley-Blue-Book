package adapter;

import model.*;
import scale.EditOptions;
import util.*;
import java.io.*;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public abstract class proxyAutomobile {
    private static LHMAuto<Automobile> LHM = new LHMAuto<Automobile>();


    public Automobile getAuto(String modelName) {
        Automobile a1 = LHM.findAuto(modelName);
        return a1;
    }

    public String findModel(int x) {
        return LHM.iterateFromInt(x);
    }

    public String getAllAutos() {
        return LHM.iterate();
    }

    public void BuildAuto(String fname, String fileType, Properties p1) {
        FileIO utility = new FileIO(fname);
        
        if (fileType.equals(".txt")) {
            
            Automobile a1 = utility.buildAutoObject();
            LHM.addAuto(a1.getMake() + " " + a1.getModel(), a1);
        }
        else if (fileType.equals(".properties")) {
            System.out.println("Properties file received!");
     
            Automobile a1 = utility.buildProperties(p1);
            System.out.println("Adding automobile to LHM!");
            LHM.addAuto(a1.getMake() + " " + a1.getModel(), a1);
     
        }
        
    }

    public void editOption(String modelName, String optsetName, String opt, String setOpt) {  // Edit option method with threads

        Lock l = new ReentrantLock();
        l.lock();

        try {
            EditOptions editor = new EditOptions(LHM.findAuto(modelName), optsetName, opt, setOpt);
            Thread thrd = new Thread(editor);
            thrd.start();
            thrd.join();  // Join
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally{
            l.unlock();
        }

        

    }



    public void printAuto(String modelName) {
        Automobile a1 = LHM.findAuto(modelName);
        a1.printData();
    }

    public void updateOptionSetName(String modelName, String optionSetname, String newName) {
        Automobile a1 = LHM.findAuto(modelName);
        a1.updateOptSetName(optionSetname, newName);
        if (a1.findOptSetIndex(optionSetname) != -1) {
            a1.setOptSetName(a1.findOptSetIndex(optionSetname), newName);
        }
    }

    public void updateOptionPrice(String modelName, String optionSetName, String option, double newPrice) {
        Automobile a1 = LHM.findAuto(modelName);
        a1.updateOptPrice(option, newPrice);
    }

    public String getOptionChoice(String modelName, String setName) {
        Automobile a1 = LHM.findAuto(modelName);
        return a1.getOptionChoice(setName);
    }

    public double getOptionChoicePrice(String modelName, String setName) {
        Automobile a1 = LHM.findAuto(modelName);
        return a1.getOptionChoicePrice(setName);
    }

    public void setOptionChoice(String modelName, String setName, String optName) {
        Automobile a1 = LHM.findAuto(modelName);
        a1.setOptionChoice(setName, optName);
    }

    public double getTotalPrice(String modelName) {
        Automobile a1 = LHM.findAuto(modelName);
        return a1.getTotalPrice();
    }



}


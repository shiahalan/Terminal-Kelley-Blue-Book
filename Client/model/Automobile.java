package model;



import java.io.Serializable; //  Import Serializable interface to implement into Automobile class to serialize
import java.lang.reflect.Array;
import java.util.Arrays; // Import arrays class to use array methods, such as fill method

import adapter.Choices;

import java.util.Arrays;
import model.Optionset.Option;
import java.util.ArrayList;

public class Automobile implements Serializable {
    // Instance variables for a car for the Automobile class
    private String make, model;
    private double basePrice;
    private ArrayList<Optionset> optset;
    private ArrayList<Option> choices = new ArrayList<Option>();

    public Automobile() {  // Default constructor
        make = "Ford's Focus Wagon";
        model = "ZTW";
        basePrice = 18445.0;
        this.optset = new ArrayList<Optionset>();
    }

    public Automobile(String make, String model, double basePrice) {  // Overloaded constructor
        this.make = make;
        this.model = model;
        this.basePrice = basePrice;
        this.optset = new ArrayList<Optionset>();
    }

/*
 * GETTER AND SETTER METHODS
 */

    public synchronized String getChoiceName(Option c1) {
        return c1.getName();
    }


    public synchronized ArrayList<Option> getChoiceArray(Optionset o1) {
        return o1.getOpt();
    }

    public synchronized String getOptSetName(Optionset o1) {
        return o1.getSetName();
    }

    public synchronized String getOptionChoice(String setName) {
        return optset.get(findOptSetIndex(setName)).getOptionChoice().getName();
    }

    public synchronized double getOptionChoicePrice(String setName) {
        return optset.get(findOptSetIndex(setName)).getOptionChoice().getPrice();
    }

    public synchronized void setOptionChoice(String setName, String optName) {
        optset.get(findOptSetIndex(setName)).setOptionChoice(optName);
        
        
        Option c1 = optset.get(findOptSetIndex(setName)).getOptionChoice();
        
        
        choices.add(c1);
    }

    public synchronized double getTotalPrice() {
        double total = 0;
        for (int i  = 0; i < choices.size(); i++) {
            total += choices.get(i).getPrice();
        }
        return total;

        // double total = 0;
        // for (int i = 0; i < optset.size(); i++) {
        //     total += optset.get(i).getOptionChoice().getPrice();
        // }
        // return total;
    }

    public synchronized String getMake() {  // Get make
        return make;
    }

    public synchronized void setMake(String make) {  // Set make
        this.make = make;
    }

    public synchronized String getModel() {  // Get model
        return model;
    }

    public synchronized void setModel(String model) {  // Set model
        this.model = model;
    }

    public synchronized double getBasePrice() {  // Get baseprice
        return basePrice;
    }

    public synchronized void setBasePrice(double basePrice) {  // Set baseprice
        this.basePrice = basePrice;
    }

    public synchronized Optionset getOneOptSet(int x) {  // Get one optionset
        return optset.get(x);
    }

    public synchronized ArrayList<Optionset> getOptSet() {  // Return optset array
        return optset;
    }

    public synchronized int getOptSetLength() {  // Get length of optionset
        return optset.size();
    }


    public synchronized int getOptLength(int x) {
        return optset.get(x).getOptLength(); //Get the length of an optionsets options
    }

    public synchronized void setOneOptSet(Optionset set, int x) {  // Set an option set's option
        this.optset.add(x, set);
    }

    public synchronized void setOptSet(ArrayList<Optionset> optset) {  // Set the optionset array
        this.optset = optset;
    }

    public synchronized String getOptSetName(int x) {  // Get the name of an optionset
        return optset.get(x).getSetName();
    }

    public synchronized void setOptSetName(int x, String setName) {  // Set the name of an optionset
        this.optset.get(x).setSetName(setName);
    }

    public synchronized String getOptName(int x, int y) {  // Get option name of optionset 
        return optset.get(x).getOptName(y);
    }

    public synchronized void setOptName(int x, int y, String optName) {  // Set the option name of an optionset option
        this.optset.get(x).setOptName(y, optName);
    }

    public synchronized double getOptPrice(int x, int y) {  // Get the price of a specific option
        return optset.get(x).getOptPrice(y);
    }

    public synchronized void setOptPrice(int x, int y, double optPrice) {  // Set the price of an option
        this.optset.get(x).setOptPrice(y, optPrice);
    }

    public synchronized void setOneOptSetOpt(int x, int y, String name, double price) {  // Build an option 
        this.optset.get(x).buildOption(y, name, price); //
    }

/*
 * PRINT METHODS
 */
    public synchronized void printMake() {  // print out the make;
        System.out.println(make);
    }

    public synchronized void printModel() {  // Print out the model;
        System.out.println(model);
    }

    public synchronized void printBasePrice() {  // Print out of the baseprice in neat format
        System.out.printf("Baseprice: $%.2f\n", basePrice);
    }

    public synchronized void printMakeModel() {  // Print out the make and model of a car
        printMake();
        printModel();
    }

    public synchronized void printOptSet() {  // Print out the optionsets for the optset array
        for (int i = 0; i < this.getOptSetLength(); i++) {
            this.printOneOptSet(i);
        }
    }

    public synchronized void printOneOptSet(int x) {  // Print out one option set
        optset.get(x).printdata();
    }

    public synchronized void printOneOpt(int x, int y) {  // Print out one option sets options
        optset.get(x).printOneOpt(y);
    }

    public synchronized void printData() {  // Print out general data
        this.printMakeModel();
        this.printBasePrice();
        this.printOptSet();

    }

/*
 * UPDATE METHODS
 */
    public synchronized void updateOptSetName(String x, String newSetName) {  // Update the set name
        if (this.findOptSetIndex(x) != -1) {
            this.setOptSetName(findOptSetIndex(x), newSetName);
        }
    }

    public synchronized void updateOptName(String setName, String x, String newOptName) {  // Update an option name
        for (int i = 0; i < this.getOptSetLength(); i++) {
            if (getOptSetName(i).equals(setName)) {
                for (int j = 0; j < optset.get(i).getOptLength(); j++) {
                    if (getOptName(i, j).equals(x)) {
                        setOptName(i, j, newOptName);
                    }
                }
            }
        }
    }


    public synchronized void updateOptPrice(String x, double newOptPrice) {  // Update option price
        for (int i = 0; i < this.getOptSetLength(); i++) {
            if (optset.get(i).findOptIndex(x) != -1) {
                optset.get(i).setOptPrice(optset.get(i).findOptIndex(x), newOptPrice);
            }
        }
    }


/*
 * DELETE METHODS
 */

    public synchronized void deleteOptSet(int x) {  // Delete optionset given index
        this.setOneOptSet(null, x);
    }

    public synchronized void deleteOptSet(String x) {  // Delete an option set given name
        if (this.findOptSetIndex(x) != -1) {
            this.setOneOptSet(null, this.findOptSetIndex(x));
        }
    }

    public synchronized void deleteOpt(int x, int y) { // Delete option given two indees
        optset.get(x).setOneOpt(null, y);
    }

    public synchronized void deleteOpt(String x) {  // Delete option given an option name
        for (int i = 0; i < this.getOptSetLength(); i++) {
            if (optset.get(i).findOptIndex(x) != -1) {
                optset.get(i).setOneOpt(null, optset.get(i).findOptIndex(x));
            }
        }
    }

/*
 * FIND METHODS
 */

    public synchronized int findOptSetIndex(String name) {  // Find the index of an optionset given the name
        for (int i = 0; i < this.getOptSetLength(); i++) {
            if (optset.get(i).getSetName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

}
package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.ArrayList;

public class Optionset implements Serializable{
    // instance variables for optionsets
    private String setName;
    private ArrayList<Option> opt;
    private Option choice;

    // Default constructor
    public Optionset() {
        this.setName = "N/A";
        this.opt = new ArrayList<Option>();
    }

    // Overloaded constructor
    public Optionset(String name) {
        this.setName = name;
        this.opt = new ArrayList<Option>();
        
    }

    /*
     * GETTER AND SETTER METHODS
     */
    protected Option getOptionChoice() {
        return this.choice;
    }

    protected void setOptionChoice(String optionName) {
        this.choice = opt.get(findOptIndex(optionName));
    }

    protected String getSetName() {  // Get the name of the set
        return setName;
    }

    protected void setSetName(String setName) {  // Set the set name
        this.setName = setName;
    }

    protected Option getOneOpt(int x) {  // Get one option
        return opt.get(x);
    }

    protected ArrayList<Option> getOpt() {  // Get the option array
        return opt;
    }

    protected void setOneOpt(Option opt, int x) {  // Set one option
        this.opt.add(x, opt);

    }

    protected void setOpt(ArrayList<Option> opt) {  // Set the option array
        this.opt = opt;
    }

    protected int getOptLength() {  // Get the length of the option array
        return opt.size();
    }

    protected void buildOption(int x, String name, double price) {  // Build an option using constructor
        opt.add(x, new Option(name, price));
    }

    protected String getOptName(int x) {  // Get the name of an option
        return opt.get(x).getName();
    }

    protected void setOptName(int x, String newOptName) {  // Set the name of an option
        this.opt.get(x).setName(newOptName);
    }

    protected double getOptPrice(int x) {  // Get the price of a option

        return opt.get(x).getPrice();
    }

    protected void setOptPrice(int x, double newOptPrice) {  // Set a new option price
        this.opt.get(x).setPrice(newOptPrice);
    }

    protected void printdata() {  // Print the data of the options
        System.out.println("Option set name: " + setName);
        System.out.println("Option: ");
        for (int i = 0; i < this.getOptLength(); i++) {
            this.printOneOpt(i);
            System.out.println("----");
        }
        System.out.println();
    }

    /*
     * Print METHOD
     */
    protected void printOneOpt(int x) {  // Print out one option's data
        opt.get(x).printdata();

    }

    /*
     * Find methods
     */
    protected int findOptIndex(String x) {  // find the index of an option
        for (int i = 0; i < this.getOptLength(); i++) {
            if(opt.get(i).getName().equals(x)) {
                return i ;
            }
        }
        return -1;
    }

    /*
     * OPTION Class
     */
    public class Option implements Serializable { 
        // Instance variables
        private String name;
        private double price;
        // Constructors
        public Option()  {
            this.name = "Default";
            this.price = 0.0f;
        }
        // Overloaded constructors
        public Option(String name, double price) {
            this.name = name;
            this.price = price;
        }

        // Getter and setter methods
        protected String getName() {  // Get name
            return name;
        }

        protected void setName(String n) { // Set name
            this.name = n;
        }

        protected double getPrice() { // Get price 
            return price;
        }

        protected void setPrice(double p) {  // Set price
            this.price = p;
        }

        // Print out the data
        protected void printdata() {  // Prints relevant object data
            System.out.println("Option Name: " + name);
            System.out.println("Option Price: $" + price);
        }
    }

}
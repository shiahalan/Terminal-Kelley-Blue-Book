// package Util;
package util;

import java.util.Properties;

import model.*;
import exception.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

import model.Automobile;

public class FileIO {
    // Instance variables
    private String fname;
    private boolean DEBUG;
    // Default constructors
    public FileIO() {
        fname = "";
        this.DEBUG = false;
    }
    // Overloaded constructors
    public FileIO(String fname) {
        this.fname = fname;
        this.DEBUG = false;
    }

    public Automobile buildProperties(Properties props) {
        // Properties props = new Properties();

        // FileInputStream input = new FileInputStream(fname);
        // props.load(input);
        // props.load(p1);
        

        String carMake = props.getProperty("CarMake");
        if (!carMake.equals(null)) {
            
            String carModel = props.getProperty("CarModel");
            
            String carPrice = props.getProperty("CarPrice");
            String option1 = props.getProperty("Option1");
     
            String optionValue1a = props.getProperty("OptionValue1a");
            String optionValue1b = props.getProperty("OptionValue1b");
            String option2 = props.getProperty("Option2");
            String optionValue2a = props.getProperty("OptionValue2a");
            String optionValue2b = props.getProperty("OptionValue2b");

            Automobile a1 = new Automobile(carMake, carModel, Double.parseDouble(carPrice));
            
            a1.setOneOptSet(new Optionset(option1), 0);

            a1.setOneOptSetOpt(0, 0, optionValue1a, 0);
            a1.setOneOptSetOpt(0, 1, optionValue1b, 0);
            a1.setOneOptSet(new Optionset(option2), 1);
            a1.setOneOptSetOpt(1, 0, optionValue2a, 0);
            a1.setOneOptSetOpt(1, 1, optionValue2b, 0);
   
            return a1;
        }
        return null;
        
    }

    public Automobile buildAutoObject() {  // Construct a car object
        Automobile a1 = null;
        try {
            if (fname.equals("")) {
                throw new AutoException(1, "Missing filename");
            }
        } catch (AutoException e) {
            this.fname = e.fix();
        }
        
        try {
            FileReader file = new FileReader(fname);
            BufferedReader buff = new BufferedReader(file);
            String make = buff.readLine();
            String model = buff.readLine();
            String stringPrice = buff.readLine();

            try {
                if (make.equals("")) {
                    throw new AutoException(2, "Missing make");
                }
            } catch (AutoException e) {
                    make = e.fix();
            }

            try {
                if (model.equals("")) {
                    throw new AutoException(3, "Missing model");
                }
            } catch (AutoException e) {
                    model = e.fix();
            }

            try {
                if (stringPrice.equals("")) {
                    throw new AutoException(4, "Missing base price");
                }

            } catch (AutoException e) {
                stringPrice = e.fix();
            }

            Double price = Double.parseDouble(stringPrice);

            String stringSize = buff.readLine();

            try {
                if (stringSize.equals("")) {
                    throw new AutoException(6, "Missing optionset array size");
                }
            } catch (AutoException e) {
                stringSize = e.fix();
            }

            int size = Integer.parseInt(stringSize);
            a1 = new Automobile(make, model, price);  // REMOVED SIZE HERE

            for (int i = 0; i < size; i++) {
                String line = buff.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "|");

                try {
                    if (tokenizer.countTokens() != 2) {
                        throw new AutoException(5, "Missing option set name or length");
                    }
                } catch (AutoException e) {
                    tokenizer = new StringTokenizer(e.fix(), "|");
                }
                

                String optname = tokenizer.nextToken();
                String optsize = tokenizer.nextToken();
                a1.setOneOptSet(new Optionset(optname), i);
                line = buff.readLine();
                tokenizer = new StringTokenizer(line, "|");
                a1 = this.buildOptSet(a1, countTokens(line), line, i);
            }
            buff.close();

        }
        catch (IOException e) {
            System.out.println("Error: " + e.toString());
            System.out.println("File does not exist \nFailed, quitting application");
            this.DEBUG = false;
            System.exit(1);
        }
        return a1;
    }


    public Automobile buildOptSet(Automobile a1, int x, String line, int y) {  // Build an option set
        StringTokenizer tokenizer = new StringTokenizer(line, "|");
        for (int i = 0; i < x/2; i++) {
            a1.setOneOptSetOpt(y, i, tokenizer.nextToken(), Double.parseDouble(tokenizer.nextToken())); //
        }
        return a1;
        
    }

    public int countTokens(String line) {  // Count the number of tokens in a line
        StringTokenizer tokenizer = new StringTokenizer(line, "|");
        int count = 0;
        while (tokenizer.hasMoreTokens()) {
            tokenizer.nextToken();
            count++;
        }
        return count;
    }

    public String writeData(Automobile a1) {  // Serialize data using object stream
        String fname = "car.ser";

        try {
            FileOutputStream file = new FileOutputStream(fname);
            ObjectOutputStream outstream = new ObjectOutputStream(file);
            outstream.writeObject(a1);
            outstream.close();
            file.close();
            System.out.println("Serialized...");
        } catch (Exception e) {
            System.out.println("Error" + e);
            System.out.println("Something went wrong...");
            System.exit(1);
        }
        return fname;
    }

    public Automobile readData(String serfname) {  // Deserialize data using object stream
        Automobile newa1 = null;
        try {
            FileInputStream file = new FileInputStream(serfname);
            ObjectInputStream instream = new ObjectInputStream(file);
            newa1 = (Automobile) instream.readObject();
            file.close();
            instream.close();
            System.out.println("Object deserialized...");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something went wrong...");
            System.exit(1);
        }
        return newa1;
    }

        
}

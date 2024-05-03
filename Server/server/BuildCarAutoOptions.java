package server;
import java.util.Properties;

import adapter.*;
import model.Automobile;

public class BuildCarAutoOptions implements ServerAuto{
    
    private static final int WAIT = 0;  // Wait for client
    private static final int REQUEST_BUILD = 1;  // Option 1
    private static final int REQUEST_CONFIGURE = 2;  // Option

    private int state = WAIT;  // Current state of the server, wait by default

    public Object processRequest(Object object) {

        Object toClient = null;

        if (state == REQUEST_BUILD) {
            Properties p1 = (Properties) object;
            CreateAuto a1 = new BuildAuto();
            System.out.println("TEST 1" + object);
            a1.BuildAuto("...", ".properties", p1);

            toClient = "Car created and added to database\nPress any button to return to menu\n>"; // If state changes to request build option
            System.out.println("TEST 2" + object);
    
            

            a1.printAuto("Toyota");
            System.out.println("HELLO>>");

        } else if (state == REQUEST_CONFIGURE) {
            // configure auto
        } else {

        }

        this.state = WAIT;

        return toClient;
    }

    public String setRequest(int i) {
        String output = null;

        if (i == 1) {
            this.state = REQUEST_BUILD;
            output = "Upload file to create Automobile";
        }

        else if (i == 2) {
            this.state = REQUEST_CONFIGURE;
            output = "Select an Automobile to configure\n>";
            // Display automobiles in linked hash map

        } else {
            output = "Invalid request";
        }

        return output;

    }

}
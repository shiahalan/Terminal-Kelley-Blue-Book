package server;
import java.util.Properties;

import adapter.*;
import model.Automobile;

public class BuildCarAutoOptions extends proxyAutomobile{
    
    private static final int WAIT = 0;  // Wait for client
    private static final int REQUEST_BUILD = 1;  // Option 1
    private static final int REQUEST_CONFIGURE = 2;  // Option

    private int state = WAIT;  // Current state of the server, wait by default

    public Object processRequest(Object object) {

        Object toClient = null;

        if (state == REQUEST_BUILD) {
            Properties p1 = (Properties) object;

            CreateAuto a1 = new BuildAuto();
            a1.BuildAuto("...", ".properties", p1);

            toClient = "Car created and added to database\n\nPress any button to return to menu"; // If state changes to request build option

        } else if (state == REQUEST_CONFIGURE) {
            int optIndex = (Integer) object - 1;
            String optName = findModel(optIndex);
            toClient = getAuto(optName);
            

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
            output = "Select an Automobile to configure\n" + getAllAutos();
            

        } else {
            output = "Invalid request";
        }

        return output;

    }

}
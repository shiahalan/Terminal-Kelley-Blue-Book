//OUTPUT LOCATED AT THE BOTTOM

package driver;
import adapter.*;
import exception.*;
import scale.*;
import client.DefaultSocketClient;
public class Driver_5part2 {
    
    public static void main(String[] args) {  
        DefaultSocketClient s1 = new DefaultSocketClient("127.0.0.1", 4444);
        s1.run();
    }

}

/*
 * Enter your option:
 * 0 to end connection
 * 1 to upload an automobile
 * 2 to configure an existing automobile
 * 
 * 
 * 1
 * 
 * Upload file to create Automobile
 * 
 * properties.properties
 * 
 * Car created and added to database
 * Press any button to return to menu
 */
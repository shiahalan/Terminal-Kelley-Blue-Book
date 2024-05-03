//OUTPUT LOCATED AT THE BOTTOM

package driver;
import adapter.*;
import exception.*;
import scale.*;
import server.DefaultServerSocket;
public class Driver_5 {
    
    public static void main(String[] args) {  
        DefaultServerSocket s1 = new DefaultServerSocket(4444);
        s1.run();
    }

}

/*
 * Connection Established
 * WE GOT PROPERTIES!
 */
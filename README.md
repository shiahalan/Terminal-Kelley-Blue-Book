# Terminal-Kelley-Blue-Book

A program that allows you to run a server-side and client-side. The server-side will await incoming connections. Upon connection from the client-side, the client-side will be able to send a .properties file to be processed server-side. The server-side will then receive the file, interpret it, and then store the data accordingly. The client-side will have the options to either upload .properties files (representing cars), or view the data of current cars which the server-side will serve.


## Usage
Two folders labelled Client and Server will be available. Please open both on different IDE windows, since they are running two separate programs. From the Server folder, please locate the driver folder. Then run serverRun.java. This will start up the server. On the other window, from the Client folder, please locate the driver folder. Then run the clientRun.java program, which will have the client connect to your already running server. Upon connection being established, the server-side window will display "Connection Established," while the client-side will display a menu in the terminal. 

You may then upload example.properties to send a file with car data.

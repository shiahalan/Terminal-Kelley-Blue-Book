package exception;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import adapter.FixAuto;

public class AutoException extends Exception implements FixAuto {
    int errNo;
    String errMsg;
    public AutoException(int errNo, String errMsg) {
        super(errMsg);
        this.errNo = errNo;
        this.errMsg = errMsg;
        exceptionLog("log.txt", errMsg, errNo);
    }

    public void exceptionLog(String fileName, String errMsg, int errNo) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String tStamp = date.format(new Date());
        try {
            FileWriter file = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(file);
            writer.write("Time Stamp: " + tStamp + " ::: Err No.: " + errNo + " ::: " + errMsg + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }

    public int getErrNo() {
        return this.errNo;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrNo(int i) {
        this.errNo = i;
    }

    public void setErrMsg(String msg) {
        this.errMsg = msg;
    }

    public String fix() {  // Fix method to fix exceptions that occur based on error number
        Fix1to100 f1 = new Fix1to100();

        switch(this.errNo) {
            case 1:
                return f1.fix1();
            
            case 2:
                return f1.fix2();
                
            case 3:
                return f1.fix3();
                
            case 4:
                return f1.fix4();
                
            case 5:
                return f1.fix5();
            
            case 6:
                return f1.fix6();
            
        }

        return null;

    }


}
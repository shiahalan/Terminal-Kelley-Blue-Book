package exception;

public class Fix1to100 {

    // Missing filename
    public String fix1() {
        System.out.println("MISSING OR WRONG FILENAME, DEFAULT FILENAME TO FordZTW.txt");
        return "FordZTW.txt";
    }

    // Missing Make
    public String fix2() {
        System.out.println("MISSING MAKE, DEFAULTING TO TOYOTA");
        return "Toyota";
    
    }

    // Missing Model
    public String fix3() {
        System.out.println("MISSING MODEL, DEFAULTING TO PRIUS");
        return "Prius";
        
    }

    // Missing Baseprice
    public String fix4() {
        System.out.println("MISSING BASEPRICE, DEFAULTING TO $20000");
        return "20000";
        
    }

    // Missing optionset name or option length (Detects if less than or greater than 2 tokens on line)
    public String fix5() {
        System.out.println("MISSING OPTION SET NAME OR LENGTH, DEFAULTING TO Colors name length 10");
        return "Colors|10";
        
    }

    // Missing optionset array length
    public String fix6() {
        System.out.println("MISSING OPTION SET ARRAY LENGTH, DEFAULTING TO 5");
        return "5";
    }

}
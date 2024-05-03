package client;

import java.util.Scanner;
import model.*;
import java.util.ArrayList;
import model.Optionset.Option;

public class SelectCarOptions {
    
    private Scanner input = new Scanner(System.in);

    public void configureAuto(Object obj) {
        Automobile a1 = (Automobile) obj;
        ArrayList<Optionset> optSets = a1.getOptSet();

        for (int i = 0; i < optSets.size(); i++) {
            Optionset o1 = optSets.get(i);
            String optSetName = a1.getOptSetName(o1);
            System.out.println("Select your " + optSetName + " choice!");
            
            ArrayList<Option> options = a1.getChoiceArray(o1);

            for (int j = 0; j < options.size(); j++) {
                System.out.println(Integer.toString(j + 1)  + ") " + a1.getChoiceName(options.get(j)));
            }
            int selectedOpt = input.nextInt() - 1;
            
            a1.setOptionChoice(optSetName, a1.getChoiceName(options.get(selectedOpt)));
            System.out.println("You selected " + a1.getOptionChoice(optSetName));
            
        }
        System.out.println("Press any button to return to menu");
    } 

    public boolean isAutomobile(Object obj) {
        
        boolean isAutomobile = false;

        try {
            Automobile a1 = (Automobile) obj;
            isAutomobile = true;
        }
        catch (ClassCastException e) {
            isAutomobile = false;
        }

        return isAutomobile;
    }

}
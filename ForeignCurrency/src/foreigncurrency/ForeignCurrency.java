
package foreigncurrency;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author George Liu 
 */
public class ForeignCurrency {
    
    static Scanner sc = new Scanner(System.in);
    static double rEUR, rGBP, rJPY, rCAD, rRUB;
            
    public static void main(String[] args) {
        System.out.println("Welcome to George's Foreign Currency Calculator. ");
        
        
        getRates();
        doValuation();
        
        
        
        System.out.println("Thanks for using George's Foreign Currency Calculator. ");
        
    } // end main 
    
    public static void getRates(){
        System.out.println("Enter the currency value per US $ ");
        
        rEUR = getOneRate("EUR"); 
        rGBP = getOneRate("GBP");
        rJPY = getOneRate("JPY");
        rCAD = getOneRate("CAD");
        rRUB = getOneRate("RUB");
    }
    
    
    public static double getOneRate(String currency){
        double rate = 0.00; 
        
        do {
        try {
        System.out.print("What is the rate for " + currency + " ? ");
        rate = sc.nextDouble();
        
        if (rate <= 0){
        System.out.println("You must enter a positive exchange rate. Try again.");
        }
            
        } catch (Exception e){
            System.out.println("Illegal input: not a valid exchange rate. Try again.");
            sc.nextLine(); 
            rate = -1;
        
        }
        
        }
        while (rate <= 0); 
            
       
        sc.nextLine(); // optional
        
        return rate; 
    }
    
    
    
    public static void doValuation() {
        int choice, quantity;
        double cVal=0, totalCVal=0;
        NumberFormat curr = NumberFormat.getCurrencyInstance(); 
        // units is array of length 5
        int[] units = new int[5]; 
        for (int i=0; i < 5; i++){ // initialize each element of array to 0 
            units[i] = 0; 
        }
        
        // second array for currency totals 
        double[] ctot = new double[5]; 
        for (int i=0; i < 5; i++){
            ctot[i]=0.00; 
        }
        
        choice = getChoice();
        while (choice != 0){
            cVal = 0; 
            switch (choice){
                case 1:
                    quantity = getQty("Euros");
                    cVal = quantity * rEUR; 
                    System.out.println(quantity + " Euros has a value of: " + curr.format(cVal) ); 
                    units[0] += quantity;
                    ctot[0] += cVal;
                    break;
                case 2:
                    quantity = getQty("Pounds Sterling");
                    cVal = quantity * rGBP;
                    System.out.println(quantity + " pounds Sterling has a value of: " + curr.format(cVal) );
                    units[choice-1] += quantity;
                    ctot[choice-1] += cVal; 
                    break;
                case 3:
                    quantity = getQty("Yen");
                    cVal = quantity * rJPY;
                    System.out.println(quantity + " yen has a value of: " + curr.format(cVal) );
                    units[choice-1] += quantity;
                    ctot[choice-1] += cVal; 
                    break;
                case 4: 
                    quantity = getQty("Canadian Dollars");
                    cVal = quantity * rCAD;
                    System.out.println(quantity + " Canadian dollars has a value of: " + curr.format(cVal) );
                    units[choice-1] += quantity;
                    ctot[choice-1] += cVal; 
                    break;
                case 5: 
                    quantity = getQty("Rubles");
                    cVal = quantity * rRUB;
                    System.out.println(quantity + " rubles has a value of: " + curr.format(cVal) );
                    units[choice-1] += quantity;
                    ctot[choice-1] += cVal; 
                    break;
                case 9:
                    getRates();
                    break;
                default: 
                    System.out.println("Error: choice not recognized. ");
                    break;
                
                
            } //end of switch 
            
            totalCVal += cVal; 
            
            choice=getChoice(); 
        } //end of while
        
        String[] cnames = { "EUR", "GBP", "JPY", "CAD", "RUB"}; 
        for(int i=0; i < 5; i++){
            System.out.println(cnames[i] + ": " + units[i] + " units costing: " + curr.format(ctot[i]));
            
        }
        System.out.println("The total of all currencies purchases was: " + curr.format(totalCVal)); 
    
    } // end of dovaluation 
    
    public static int getChoice(){
    // method to return currency purchase choice . like makechange getcents
        int c = -1;
        do {
            try {
                System.out.print("Currency? (1=EUR, 2=GBP, 3=JPY, 4=CAD, 5=RUB, 9=new rates, 0=quit): "); 
                c = sc.nextInt();
                if (c < 0 || (c > 5 && c != 9)){
                    System.out.println("Choice is out of bounds. Enter 0-5 or 9 only. ");
                }
            } catch (Exception e){
                System.out.println("Illegal input. Not an integer. ");
                sc.nextLine(); 
                c=-1; 
                    
                
            }
    
        } while (c < 0 || (c > 5 && c != 9) );
        return c; 
    }
    
    public static int getQty(String currency){
        int q = -1; 
        
        do {
            try {
                System.out.print("How many " + currency + " are you buying?" ); 
                q = sc.nextInt(); 
                if (q<0){
                    System.out.println("You must enter a non-negative integer. Try again.");
                    }
                } catch (Exception e){
                    System.out.println("Illegal input: not an integer. Try again."); 
                    sc.nextLine(); 
                    q = -1;
                    }
            } 
        
        while (q<0);
        
        sc.nextLine(); // not necessary?
        
        
        return q; 
    
    }
    
}


package makechange;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author George Liu
 */
public class MakeChange {
    
    static Scanner sc = new Scanner(System.in);
    static boolean givehd = false; // global boolean

    public static void main(String[] args) {
        int cents;
        String choice;
        
        Random rnd = new Random(); //new random number generator 
        
        System.out.println("Welcome to George's Make Change program. ");
        
        System.out.print("Do you want half-dollars? Enter (Y/N) ");
        choice = sc.nextLine(); 
        if (choice.toUpperCase().startsWith("Y")) {
            givehd = true;
        }
        
        
        
        cents = getCents();
        while (cents !=0 ){
            
            if (rnd.nextInt(2) == 0)  {
                makeChangeAddMethod(cents); // Additive algorithm with cents parameter
            } else {
            
                makeChangeDivMethod(cents); 
            }
            
            cents = getCents();
            
        } // end while
        
        System.out.println("Thanks for using Make Change Program");
        
    } // end of main
    
    public static int getCents(){
        int c = 0; // user input
        do {
            try {
                System.out.println("Change for?(Enter 1-500 or 0=quit) ");
                c=sc.nextInt();
                if (c<0){
                    System.out.println("Value must be non-negative. ");
                } else if (c>500){
                    System.out.println("I can only give up to $5 (500 cents). ");
                }
                
            } catch (Exception e){
                System.out.println("Illegal input: Input must be integer between 0-500. ");
                sc.nextLine(); // clear bad value
                c = -1; // force loop to repeat
                        
            
            }
        } while (c < 0 || c > 500); 
        return c; 
    }
    
    public static void makeChangeAddMethod(int cents) {
        // System.out.println("I can't make change for " + cents + "cents. ");
        int hd=0, q=0, d=0, n=0, p=0; 
        int t=0; // variable to keep running total
        
        if (givehd == true ){
            while (t+50 <= cents){
                hd++;
                t += 50; 
            }
        }
        //loop for quarters
        while (t+25 <= cents ){
            q++;
            t=t+25;
        }
        
        while (t+10 <= cents){
            d++;
            t += 10; // t=t+10
        
        }
        
        while (t+5 <= cents){
            n++;
            t += 5;
        }
        
        p = cents - t; 
        
        System.out.print("By additive method, for " + cents + " cents, I give: "); 
        
        if (givehd) {
            System.out.print(hd + " half-dollars, ");
        }
        
        System.out.println(q + " quarters " + d + " dimes "
            + n + " nickels and " + p + " pennies. ");
           
    } // end of make change add method
    public static void makeChangeDivMethod(int cents){
        int hd=0,q=0, d=0, n=0, p=0; 
        int t = cents;
        
        if (givehd){
            hd = t / 50; 
            t -= (50 * hd);
        }
        
        q = t / 25; 
        t = t - (25 * q);
        
        d = t / 10;
        t -= (10 * d);
        
        n = t / 5;
        t -= (5 * n);
        
        p = t; 
        
        System.out.println("By division method, for " + cents + " cents, I give: ");
        if (givehd) {
            System.out.print(hd + " half-dollars, ");
        }
        System.out.print(q + " quarters " + d + " dimes "
            + n + " nickels and " + p + " pennies. ");
                
    }
} // end of class file

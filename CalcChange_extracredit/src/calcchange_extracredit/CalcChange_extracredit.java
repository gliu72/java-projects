/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcchange_extracredit;

import java.util.Scanner;

/**
 *
 * @author 13147
 */

public class CalcChange_extracredit {

// global variables here
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        // local vairables here
        String choice;
        int h, q, d, n, p; 
        int final_cents;
        final_cents=0;   
        System.out.println("Welcome to George's Change Calculator!");
        
        //priming read
        System.out.print("Do you have any change? Enter (Y/N)"); 
        choice = sc.nextLine();
        while (choice.equalsIgnoreCase("Y") ){
            //method calls to get coin counts
            h = getCoin("Half-dollars");
            q = getCoin("Quarters"); 
            d = getCoin("Dimes");
            n = getCoin("Nickles");
            p = getCoin("Pennies");
            
            coinTotal(h,q,d,n,p);
            
            final_cents=final_cents + (50*h) + (25*q) + (10*d) + (5*n) + (1*p);
            
            //input to exit
            System.out.print("Do you have more change? Enter (Y/N)" );
            choice = sc.nextLine(); 
        }
        
        coinTotal(final_cents); 
    } // end of main
    public static int getCoin(String cointype){
        int coincount=0;
        
        do {
            try {
                System.out.print("How many " + cointype + " do you have?" ); 
                coincount = sc.nextInt(); 
                if (coincount<0){
                    System.out.println("You must enter a non-negative integer. Try again.");
                    }
                } catch (Exception e){
                    System.out.println("Illegal input: not an integer. Try again."); 
                    sc.nextLine(); 
                    coincount = -1;
                    }
            } 
        
        while (coincount<0);
        
        sc.nextLine(); 
              
        return coincount; 
    }
    public static void coinTotal(int h, int q, int d, int n, int p){
        int total_cents, dollars, cents; 
        
        total_cents= (50*h) + (25*q) + (10*d) + (5*n) + (1*p);
        dollars=total_cents / 100; 
        cents=total_cents % 100;
        
        System.out.println("You have " + total_cents + "cent(s)." + " This means you have " + dollars +
                    " dollar(s) and " + cents + " cent(s)."); 
    }
    
    public static void coinTotal(int total){
        int total_cents, final_dollars, final_cents;
        total_cents=total;
        final_dollars=total_cents / 100;
        final_cents=total_cents % 100;
                
        System.out.print("You entered a grand total of " + total_cents + " cent(s). This means you have a grand total of " + final_dollars
            + " dollar(s) and " + final_cents + " cent(s). Thanks for using George's Change Calculator!"); 
    }
    
} // end of class (end of program)


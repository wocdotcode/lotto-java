
package main;

//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author subzer0
 */
public class Collections {
    
    public static final int NUMBERS = 6;
    
    public static final int MAX_NUMBERS = 54;
    
    public static final int PRIZE = 100;
    
    
    //generates a set of the winning lotto numbers
    public static void main(String[] args) {
        
        
        //Getting winning number and ticket sets
        Set<Integer> winningNumber = createWinningNumbers();
        Set<Integer> ticket = getTicket();
        
        
        // Keeping only winning numbers from user's ticket
        // using retainAll() to remove non common numbers
        Set<Integer> matches = new TreeSet<>(ticket);
        matches.retainAll(winningNumber);
        
        System.out.println("Your ticket number: " + ticket);
        System.out.println("The Winning Numbers: " + winningNumber);
        
        if (matches.size() > 0) {
            double prize = PRIZE * Math.pow(2, matches.size());
            System.out.println("Matched Numbers: " + matches);
            System.out.printf("Your prize is $%.2f\n", prize);
        }

    }
    
    //Reading the player's lottery ticket from the console
    public static Set<Integer> createWinningNumbers(){
        Set<Integer> winning = new TreeSet<>();
        Random random = new Random();
        
        while(winning.size() < NUMBERS) {
            int number = random.nextInt(MAX_NUMBERS) + 1;
            winning.add(number);
        }
        
        
        return winning;
    }
    
    
    public static Set<Integer> getTicket() {
        
        Set<Integer> ticket = new TreeSet<>();
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter " + NUMBERS + " lotto numbers");
        
        while(ticket.size() < NUMBERS) {
            int number = scan.nextInt();
            if (number <= MAX_NUMBERS) {
                 ticket.add(number);
            }
           
        }
        
        return ticket;
        
    }
    
    
    
    
    
    
}

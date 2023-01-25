import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        
        int card1 = drawRandomCard();
        int card2 = drawRandomCard();

        System.out.println("\n You get a \n" + (cardString(card1)) + "\n and a \n" + cardString(card2));
       
        int handValue = Math.min(card1, 10) + Math.min(card2, 10); // face cards count as 10
        System.out.println("Your total is: " + handValue);

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();

        System.out.println("The dealer shows \n" + (cardString(dealerCard1)) + "\nand has a card facing down\n" + faceDown());

        int dealerHandValue = Math.min(dealerCard1, 10) + Math.min(dealerCard2,10);

        System.out.println("\nThe dealer's toal is hidden");

        while (true) { // will loop forever until stay is entered or user busts.
            String answer = hitOrStay();    

            if (answer.equals("stay")){
                break;
            }
            // hit is the other option in hitOrStay funciton.  So a new card is drawn.
            int newCard = drawRandomCard();
            handValue += Math.min(newCard, 10);
            System.out.println("\nYou get a \n" + cardString(newCard));
            System.out.println("Your total is: " + handValue);

            if (handValue > 21) {
                System.out.println("BUST: You lose.");
                System.exit(0);
            }
        }

        System.out.println("Dealer's turn\n");
        System.out.println("The dealer's cards are\n" + cardString(dealerCard1) + "\nand a\n" + cardString(dealerCard2));
        System.out.println("Dealer's total is: " + dealerHandValue);

        while(dealerHandValue < 17){
            int newCard = drawRandomCard();
            
            dealerHandValue += Math.min(newCard, 10);
            System.out.println("\nDealer gets a\n" + cardString(newCard));
            System.out.println("\nDealer's total is: " + dealerHandValue);
        }
            if (dealerHandValue > 21) {
                System.out.println("BUST: Dealer loses.");
                System.exit(0);
            }

            if (handValue > dealerHandValue) {
                System.out.println("You win!");
            } else if (handValue < dealerHandValue){
                System.out.println("Dealer Wins!");
            } else {
                System.out.println("Push!");
            }     

        scan.close();

    }

    /**
     * Function name – drawRandomCard
     * 
     * @return (int)
     *
     *         Inside the function:
     *         1. Gets a random number between 1 and 13.
     *         2. Returns a card.
     */

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        return (int) randomNumber;
    }

    /** 
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */

     public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return
                   "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";
          
            case 2:
                return

                    "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";
                  
            case 3:
                return
                  "   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____E|\n";

            case 4:
                return
                   "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n";

            case 5: 
                return
                    "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";

            case 6:
                return
                    "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";

            case 7:
                return
                    "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
          
            case 8:
                return
                    "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
             
            case 9:
                return
                    "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";

            case 10:
                return
                    "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            
            case 11:
                return
                    "   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n";
            
            case 12:
                 return
                    "   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n";
              
            case 13: 
                return
                    "   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";
            
            default: 
            return "This can't happen";
        }
     }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    /**
     * Function name – hitOrStay
     * 
     * @return (String)
     *
     *         Inside the function:
     *         1. Asks the user to hit or stay.
     *         2. If the user doesn't enter "hit" or "stay", keep asking them to try
     *         again by printing:
     *         Please write 'hit' or 'stay'
     *         3. Returns the user's option
     */

     public static String hitOrStay() {
        System.out.println("hit or stay?");
        String answer = scan.nextLine();
        
        while (!(answer.equals("hit") || answer.equals("stay"))){
            System.out.println("Please write 'hit' or 'stay'");
            answer = scan.nextLine();
        }
        return answer;
     }
}

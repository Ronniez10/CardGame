package MainGame;


import java.util.*;

public class Main {

    static   Map<String, Integer> suiteValues = new HashMap<>() ;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //  Initializing the value for the Suites
        initializeSuiteValues();


        List<Player> players = new ArrayList<>();


        Deck deck = new Deck();

        System.out.println("---------------------------------------------");
        System.out.println(deck);

        System.out.println("Please Enter the Number of Players in the Game:");
        int n =sc.nextInt();

        //Creating the Players
        for(int i=0;i<n;i++)
        {
            players.add(new Player(i+1));
        }

        deck.shuffle();


        System.out.println("-----------Game is going to be Started Next---------------");
        startGame(players,deck);

        System.out.println("-------------Printing the Player Hands");
        printPlayerHands(players);

        System.out.println("-----------The Winner of the Game is-----------------------:");
        Player winner=getWinner(players);

        System.out.println(winner);

        System.out.println("-------------Returning Cards to Deck------------------");
        returnCardsToDeck(players,deck);
        System.out.println(deck);

        System.out.println("------------Games has Ended---------------");

        //Just a Dummy Feature added for Continuing the Game if user wants to.
        System.out.println("Do you want to Play Again ? Enter 1 for YES and 0 for NO");
        int choice = sc.nextInt();

        if(choice==1)
            main(new String[]{});
        else
            System.exit(0);

    }

    //Function for returning the Cards to the Deck
    private static void returnCardsToDeck(List<Player> players, Deck deck) {

        for(Player player:players)
        {
            deck.returnCardToDeck(player.getHand());
        }
    }

    //Function for initializing the Suite Values
    private static void initializeSuiteValues() {

        suiteValues.put("DIAMOND",1);
        suiteValues.put("CLUB",2);
        suiteValues.put("HEART",3);
        suiteValues.put("SPADE",4);
    }

    //Function for Deciding the winner of the Game
    private static Player getWinner(List<Player> players) {

        int maxValue =Integer.MIN_VALUE;

        Player winner=null;

        for(Player player:players)
        {
            if(player.getHand().getValue()>maxValue) {
                maxValue = player.getHand().getValue();
                winner=player;
            }
            else if(player.getHand().getValue()==maxValue)
            {
                 winner =suiteValues.get(player.getHand().getSuite().toString()) > suiteValues.get(winner.getHand().getSuite().toString()) ? player:winner;
                 maxValue = winner.getHand().getValue();
            }
        }

        return winner;
    }

    //Function for Printing the Player's Hand
    private static void printPlayerHands(List<Player> players) {

        for(Player player:players)
        {
            System.out.println(player);
        }
    }

    //Function which helps in starting the Game.
    private static void startGame(List<Player> players,Deck deck) {

        //Each Player is drawing a card
        for(Player player:players)
        {
            deck.dealCard(player);
        }
    }
}

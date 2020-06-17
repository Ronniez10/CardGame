package MainGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> cardDeck;

    public Deck() {
        this.cardDeck = new ArrayList<Card>();
        for(int value = 1 ; value <= 13 ; value++){
            for(SUITE suite : SUITE.values()){
                cardDeck.add(new Card(value,suite));
            }
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardDeck=" + cardDeck +
                '}';
    }

    //Shuffle Algorithm for shuffling the Cards
    public void shuffle(){
        Random rand = new Random();
        //Generate two random numbers between 0 to 51
        for(int i = 0 ; i < 20 ; i ++){
            int firstCard = rand.nextInt(52);
            int secondCard = rand.nextInt(52);
            Collections.swap(cardDeck,firstCard,secondCard);
        }
        System.out.println("Deck is Shuffled");
    }

    public void dealCard(Player player){
        //Get next card and assign it to hand of the player
        Card removedCard = cardDeck.remove(0);
        player.setHand(removedCard);
    }

    public void returnCardToDeck(Card card)
    {
        cardDeck.add(card);
    }

    //Returns the Size of the Deck
    public int getSizeOfDeck(){
        return cardDeck.size();
    }
}

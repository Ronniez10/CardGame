package MainGame;

//Currently we care considering that it will be Single Card Game.We can easily change  the hand
// to be  a List<Card> for making it a multicard Game.
public class Player {

    int playerNumber;
    Card hand;

    public Player(int playerNumber) {
        this.playerNumber=playerNumber;
    }

    public Card getHand() {
        return hand;
    }

    public void setHand(Card hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber=" + playerNumber +
                ", hand=" + hand +
                '}';
    }
}

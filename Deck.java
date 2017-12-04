
import java.util.ArrayList;
import java.util.Random;

public class Deck {

	// TODO Auto-generated method stub
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	private ArrayList<Card> openCard;
	public int nUsed = -1;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		
		cards = new ArrayList<Card>();
		usedCard = new ArrayList<Card>();
		openCard = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end
		for (int n = 0; n < nDeck; n++) {
			// ��Deck����
			for (Card.Suit s : Card.Suit.values()) {
				// ���4蝔株�
				for (int y = 1; y < 14; y++) {
					// ���13撘萇��
					Card card = new Card(s, y);
					cards.add(card);
					// 靘��cards鋆�
				}
			}
		}
		shuffle();
	}

	// TODO: Please implement the method to print all cards on screen (10
	// points)
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5
		// points)
		for (int i = 0; cards.size() > i; i++) {
			Card card = new Card(cards.get(i).getSuit(), cards.get(i).getRank());
			card.printCard();
			// 靘��嗾���＊蝷箏蝯���
		}
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

	public void shuffle() {
		ArrayList<Card> scard = new ArrayList<Card>(52);
		Random random = new Random();
		Card c;
		for (int i = 1; i < 53; i++) {
			do {
				c = cards.get(random.nextInt(52));
			} while (scard.contains(c));
			scard.add(c);
		}
		
		cards.clear();
		cards = scard;
		nUsed = 0;
		openCard.clear();
	}

	public Card getOneCard(boolean isOpened) {

		nUsed = nUsed + 1;
		if (nUsed == 52) {
			usedCard.clear();
			shuffle();
		}
		if (isOpened) {
			openCard.add(cards.get(nUsed));
		}
		usedCard.add(cards.get(nUsed));
		return cards.get(nUsed);

	}

	public ArrayList<Card> getOpenCard() {
		return openCard;
	}
}
package global;

import global.*;
import global.card.*;
import global.card.dungeon_card.*;
import global.card.dungeon_card.enumeration.*;
import global.card.treasure_card.*;
import global.card.treasure_card.enumeration.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A heap of cards.
 * In the Munchkin there is 2 kinds of heap : the dungeon and the treasure. 
 * Each heap is used in differents phase of the scenario of the game.
 * @author dazyj
 *
 */

public class Heap 
	{
		/**
		 * The heap : a list of cards.
		 */
		private List<Card> deck;
		
		/**
		 * the type of cards in the heap.
		 */
		private final String cardType;
		
		/**
		 * Create a heap.
		 * @param type
		 */
		public Heap(CardType type)
		{
			this.cardType = type.getType();
			this.deck = new ArrayList<Card>();

		}

		/**
		 * return the list of the cards of the heap.
		 * @return
		 */
		public List<Card> getDeck()
			{
				return this.deck;
			}

		/**
		 * remove a first class on this packet
		 * 
		 * @return C
		 */
		public Card RemoveFirstCard()
			{
				return this.deck.remove(0);
			}

		/**
		 * Return the card type of the heap.
		 * @return
		 */
		public String getCardType()
			{
					return this.cardType;
			}

	}

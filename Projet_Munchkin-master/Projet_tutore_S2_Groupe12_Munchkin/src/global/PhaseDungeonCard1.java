package global;

import java.util.Random;

import global.*;
import global.card.*;
import global.card.dungeon_card.*;
import global.card.dungeon_card.enumeration.*;
import global.card.treasure_card.*;
import global.card.treasure_card.enumeration.*;

/**
 * The phase Dungeon Card 1 of a Move.
 * This phase threat the events about the putting of the first Dungeon Card.
 * IF it is a monster, we launch a fight.
 * If it is a CardCurse, we apply the curse to the player.
 * If it is a MonsterCurse, a Job or a Race, the player can put the card in his hand.
 * @author Jérémie
 *
 */
public class PhaseDungeonCard1
{
	/**
	 * Boolean that determine if there had a fight during the phase.
	 */
	private static boolean toFight ;
	
	/**
	 * Launch the phase.
	 */
	public static void start()
	{
		Player[] tabOfPlayers = Munchkin.getTabOfPlayers();
		Card firstCardDungeon = (Card) Munchkin.getGameOfMunchkin().getDungeonHeap().RemoveFirstCard();
		firstCardDungeon.setHiddenFace(false);
		// TODO Afficher la carte
		if (firstCardDungeon instanceof Monster)
		{
			Monster monster = (Monster) firstCardDungeon;
			Munchkin.getGameOfMunchkin().fight(monster);
		}
		if (firstCardDungeon instanceof Job || firstCardDungeon instanceof Race || firstCardDungeon instanceof MonsterCurse)
		{
			tabOfPlayers[Move.getIdPlayersMove()].sendCardHand(firstCardDungeon);
		}
		if (firstCardDungeon instanceof CardCurse)
		{
			for(int numberDiscardCard = 0; numberDiscardCard <= ((CardCurse) firstCardDungeon).getNumberCardRemove(); numberDiscardCard++);
			{	
			Random randomGenerator = new Random();
			tabOfPlayers[Move.getIdPlayersMove()].discard(randomGenerator.nextInt(tabOfPlayers[Move.getIdPlayersMove()].getHand().getHandPlayer().size()));
			}		
		}
	}
	
	/**
	 * return toFight
	 * @return
	 */
	public static boolean isToFight()
	{
		return toFight;
	}
	
	/**
	 * edit toFight.
	 * @param toFight
	 */
	public static void setToFight(boolean toFight)
	{
		PhaseDungeonCard1.toFight = toFight;
	}
}

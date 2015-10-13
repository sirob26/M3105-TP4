package global;

import global.*;
import global.card.*;
import global.card.dungeon_card.*;
import global.card.dungeon_card.enumeration.*;
import global.card.treasure_card.*;
import global.card.treasure_card.enumeration.*;

/**
 * The object that recap a fight.
 * In the FightTab we can find all the informations (editable) about a fight and his components. 
 * The objective of this class is to access easily to the data from the fight.
 * @author dazyj
 *
 */

public class FightTab
	{
		/**
		 * The player that fight.
		 */
		private static Player player;

		/**
		 * The player that help the player that fight.
		 */
		private static Player helper;

		/**
		 * The monster that the player (and the helper) fight.
		 */
		private static Monster monster;

		/**
		 * The boolean that tell if the fight is win or not.
		 */
		private static boolean isWin;


		/**
		 * Edit the player of FightTab.
		 * @param pPlayer
		 */
		public static void editPlayer(Player pPlayer)
			{
				player = pPlayer;
			}

		/**
		 * Edit the helper of FightTab.
		 * @param pHelper
		 */
		public static void editHelper(Player pHelper)
			{
				helper = pHelper;
			}
	
		/**
		 * Edit the Monster of FightTab.
		 * @param pMonster
		 */
		public static void editMonster(Monster pMonster)
			{
				monster = pMonster;
			}

		/**
		 * Edit isWin in FightTab;
		 * @param b
		 */
		public static void editIsWin(boolean b)
		{
			isWin = b;
		}
		
		/**
		 * Read isWin in FightTab;
		 * @return
		 */
		public static boolean readIsWin()
		{
			return isWin;
		}
		
		/**
		 * Read the player of FightTab;
		 * @return
		 */
		public static Player readPlayer()
			{
				return player;
			}

		/**
		 * read the helper of FightTab.
		 * @return
		 */
		public static Player readHelper()
			{
				return helper;
			}

		/**
		 * Read the monster of FightTab.
		 * @return
		 */
		public static Monster readMonster()
			{
				return monster;
			}
	
	}

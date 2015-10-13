package global;

import java.util.Random;
import java.util.Scanner;

import global.*;
import global.card.*;
import global.card.dungeon_card.*;
import global.card.dungeon_card.enumeration.*;
import global.card.treasure_card.*;
import global.card.treasure_card.enumeration.*;

/**
 * The main object of the Munchkin.
 * This class allow the Player to play a game of Munchkin. It contains all the methods that control the game's phases or the actions relatives to the game (fight, etc...)
 * 
 * @author dazyj
 *
 */

public class Game
	{
		/**
		 * The heap Dungeon. 
		 * It is a heap of cards that contains exclusively cards of type "Dungeon".
		 */		
		private Heap Dungeon;

		/**
		 * The heap Treasure. 
		 * It is a heap of cards that contains exclusively cards of type "Treasure".
		 */	
		private Heap Treasure;

		/**
		 * Create an object of type Game, with his heaps.
		 */
		public Game()
			{
				this.Dungeon = new Heap(CardType.dungeon);
				this.Treasure = new Heap(CardType.treasure);
			}

		/**
		 * Start the game, and verify before each move of the game, if a player has won the game.
		 */
		public void start()
		{
			if (Move.getNbMove() == 0)
			{
				this.initialize();
			}
			boolean win = false;
			int idSave = 0;
			for (int i = 0; i < Munchkin.getNbPlayer(); i++)
			{
				if (Munchkin.getTabOfPlayers()[i].getLevel() == 10)
				{
					win = true;
					idSave = i;
				}
			}
			while (!win)
			{
				Move.start();
			}
			
			System.out.println("F�licitations " + Munchkin.getTabOfPlayers()[idSave].getPseudo() + "Vous avez remport� la partie !");
		}

		/**
		 * Initialize the game.
		 * It distribute the cards to the players at the begin of the game.
		 */
		public void initialize()
			{
				for (int j = 0; j < Munchkin.getNbPlayer(); j++)
					{
						for (int k = 0; k < 4; k++)
						{
							Munchkin.getTabOfPlayers()[j].sendCard(getDungeonHeap());
							Munchkin.getTabOfPlayers()[j].sendCard(getTreasureHeap());
						}
					}
			}

		/**
		 * Give the Dungeon Heap.
		 * @return
		 */
		public Heap getDungeonHeap()
			{
				return this.Dungeon;
			}

		/**
		 * Give the Treasure Heap.
		 * @return
		 */
		public Heap getTreasureHeap()
			{
				return this.Treasure;
			}

		/**
		 * It identify a player with his id.
		 * The method use the if of the player to find it in the tabOfPlayers of the game and to return it.
		 * @param id
		 * @return
		 */
		public Player identifyPlayerById(int id)
			{
				for (int i = 0; i < Munchkin.getNbPlayer(); i++)
					{
						Player player = Munchkin.getTabOfPlayers()[i];
						if (player.getId() == id)
							return player;
					}
				return null;
			}

		/**
		 * Add buffs to Monster at the begin of a fight.
		 * We consult all the player to know if they want put a card to improve the monster.
		 * @param monster
		 */
		public void addBuffToMonster(Monster monster)
		{
			for (int i = 0; i < Munchkin.getNbPlayer(); i++)
				{
					String iString = String.valueOf(i);
					Scanner sc1 = new Scanner(System.in);
					String answer = "OUI";
					int compare = "OUI".compareTo(answer);
					while (compare == 0)
					{
						System.out.println("Bonjour joueur " + iString + " Voulez-vous ajouter un bonus au monstre ?");
						// TODO AFficher les cartes de la main
						answer = sc1.nextLine();
						sc1.close();
						answer.toUpperCase();
						switch (answer)
						{
							case "OUI":
								System.out.println("Choisissez une carte � poser. Rentrer le nom de la carte.");
								String name = sc1.nextLine();
								sc1.close();
								name.toUpperCase();
								Card card = Munchkin.getTabOfPlayers()[i].chooseCardToPut(name);
								if (card instanceof ConsumableItem)
								{
									ConsumableItem itemCard = (ConsumableItem) card;
									FightTab.readMonster().setLevel(FightTab.readMonster().getLevel() + itemCard.getBonus());
								}
								if (card instanceof MonsterCurse)
								{
									MonsterCurse monsterCurseCard = (MonsterCurse) card;
									FightTab.readMonster().setLevel(
									FightTab.readMonster().getLevel() + monsterCurseCard.getMonsterLevelEffect());
									FightTab.readMonster().setTreasureGain(FightTab.readMonster().getTreasureGain() + monsterCurseCard.getTreasureCardEffect());
								}
								// TODO Afficher Monstre
								compare = "OUI".compareTo(answer);
							case "NON":
								compare = "OUI".compareTo(answer);
						}
					}
				}
		}
		
		/**
		 * Add buffs to a player.
		 * We consult the player 2 times to ask him if he want add a buff different?
		 * The consumable item : it adds a value to the strength of the player that is considered just for the fight.
		 * The class Bonus : If the player's class is different from "human", he can remove a number of cards to add a bonus to his strength.
		 * If the player is a dwarf, we add him a bonus of strength.
		 * @param player
		 */
		public void addBufferToPlayer(Player player)
		{
			String answer = "OUI";
			int compare = "OUI".compareTo(answer);
			while (compare == 0)
			{
				System.out.println(player.getPseudo()+ ", Voulez-vous rajouter des bonus � vos d�g�ts ?");
				Scanner sc1 = new Scanner(System.in);
				answer = sc1.nextLine();
				sc1.close();
				answer.toUpperCase();
				switch (answer)
				{
					case "OUI":
						System.out.println("Voulez-vous ajouter un bonus de carte ? (consommable)?");
						String bonus = sc1.nextLine();
						sc1.close();
						bonus.toUpperCase();
						int test = "OUI".compareTo(bonus);
						if (test == 0)
						{
							System.out.println("Choisissez une carte � poser. Rentrer le nom de la carte.");
							String name = sc1.nextLine();
							sc1.close();
							name.toUpperCase();
							Card card = player.chooseCardToPut(name);
							if (card instanceof ConsumableItem)
							{
								ConsumableItem itemCard = (ConsumableItem) card;
								player.setStrength(player.getStrength() + itemCard.getBonus());
							}
						}
						if (player.getJob().getName() != null)
						{
							System.out.println("Voulez-vous ajouter un bonus de classe (Guerrier, Voleur, Pr�tre)?");
							bonus = sc1.nextLine();
							sc1.close();
							bonus.toUpperCase();
							if (test == 0)
							{
								String maxString = String.valueOf(player.getJob().getNbMaxCardBurnable());
								String bonusString = String.valueOf(player.getJob().getBonus());
								System.out.println("Vous pouvez d�fausser " + maxString + " cartes utilisant chacune un bonus de " + bonusString);
								System.out.println("Combien de cartes voulez-vous d�fausser ?");
								int nbCardToBurn = sc1.nextInt();
								sc1.close();
								if (nbCardToBurn < player.getJob().getNbMaxCardBurnable())
								{
									int bonusHit = player.getJob().getBonus() * nbCardToBurn;
									player.setStrength(player.getStrength() + bonusHit);
								}							
							}
						}
						String nameRace = player.getRace().getName();
						int test2 = nameRace.compareTo("dwarf");
						if (test2 > 0)
						{
							player.setStrength(player.getStrength() + 1);	
						}							
						System.out.println(player.toString());
						compare = "OUI".compareTo(answer);
					case "NON":
						compare = "OUI".compareTo(answer);
			
				}
			}
		}
		
		/**
		 * Ask to the player gave from the player of the fight if he wants help him.
		 * If he accept, we apply the buff adder to them and see the issue of the fight.
		 * If he refuse we apply the buff adder to the player of the fight alone and see the issue of the fight. 
		 * @param help
		 * @param monster
		 */
		public void askHelpToFight(String help, Monster monster)
		{
			Player playerOfTheFight = FightTab.readPlayer();
			Player helperOfTheFight = FightTab.readHelper();
			switch (help)
			{
			case "OUI":
				System.out.println("Indiquez le pseudo du joueur concern�.");
				Scanner sc1 = new Scanner(System.in);
				String nickname;
				nickname = sc1.nextLine();
				nickname.toUpperCase();
				sc1.close();
				for (int i = 0; i < Munchkin.getNbPlayer(); i++)
				{
					if (nickname == Munchkin.getTabOfPlayers()[i].getPseudo().toUpperCase())
						{
							System.out.println(nickname + ", �tes vous OK pour aider " + playerOfTheFight.getPseudo() + "?");
							String ok = sc1.nextLine();
							ok.toUpperCase();
							sc1.close();
							switch (ok)
							{
								case "OUI":
									FightTab.editHelper(Munchkin.getTabOfPlayers()[i]);
								case "NON":
									FightTab.editHelper(null);
							}
						}
						
				}
				this.addBufferToPlayer(playerOfTheFight);
				this.addBufferToPlayer(helperOfTheFight);
				if (playerOfTheFight.getStrength() + helperOfTheFight.getStrength() > monster.getLevel())
				{
					FightTab.editIsWin(true);
				}
				else
				{
					FightTab.editIsWin(false);
				}
				String jobPlayer = playerOfTheFight.getClass().getName();
				int test3 = jobPlayer.compareTo("Warrior");
				if (test3 == 0)
				{
					if (playerOfTheFight.getStrength() == monster.getLevel())
					{
						FightTab.editIsWin(true);
					}
				}
				
			case "NON":
				FightTab.editHelper(null);
				this.addBufferToPlayer(playerOfTheFight);
				if (playerOfTheFight.getStrength() > monster.getLevel())
					{
						FightTab.editIsWin(true);
					}
					else
					{
						FightTab.editIsWin(false);
					}
				jobPlayer = playerOfTheFight.getClass().getName();
				int test4 = jobPlayer.compareTo("Warrior");
				if (test4 == 0)
				{
					if (playerOfTheFight.getStrength() == monster.getLevel())
					{
						FightTab.editIsWin(true);
					}
				}
			}
		}
		
		/**
		 * Launch a fight against a monster.
		 * We ask if someone want help the player.
		 * @param monster
		 */
		public void fight(Monster monster)
		{
			System.out.println("Le Combat commence.");
			FightTab.editIsWin(false);
			FightTab.editPlayer(this.identifyPlayerById(Move.getIdPlayersMove()));
			FightTab.editMonster(monster);
			System.out.println(monster.toString());
			this.addBuffToMonster(monster);
			
			System.out.println("Voulez-vous qu'un joueur vous aide ?");
			Scanner sc1 = new Scanner(System.in);
			String help;
			help = sc1.nextLine();
			sc1.close();
			help.toUpperCase();
			this.askHelpToFight(help, monster);
		}
		
		/**
		 * Kill a player. 
		 * If a player is killed his level come back to the first and his hand is removed.
		 * @param playerdeath
		 */
		public void deathPlayer(Player playerdeath)
		{
			while (!playerdeath.getHand().getHandPlayer().isEmpty())
			{
				playerdeath.getHand().getHandPlayer().remove(0);
			}
			playerdeath.setLevel(1);
		}
		
		/**
		 * Calculate the gain of the helper after the victory of a fight.
		 * @param monsterGain
		 * @param helper
		 * @return
		 */
		public int calculateGainHelper(int monsterGain ,Player helper)
		{
			if(helper.getRace().getName() == "Elf")
				return (monsterGain/2) +1;
			return monsterGain/2;
		}
		/**
		 * Calculate the gain of a player after the victory of a fight.
		 * @param monsterGain
		 * @param player
		 * @return
		 */
		public int calculateGainPlayer(int monsterGain, Player player)
		{
			if(player.getRace().getName() == "Elf")
				return (monsterGain - (monsterGain/2)) + 1;
			return monsterGain - (monsterGain/2);
		}
		/**
		 * The method that try for a player to flee if he lose a fight.
		 * @param player
		 * @return
		 */
		public boolean tryFlee(Player player)
		{
			Random thimble = new Random();
			int thimbledodge = thimble.nextInt(6) + 1;
			if(player.getJob().getName() == "Priest")
				{
				thimbledodge += 1;
				}
			if(thimbledodge >=5)
				{
					return true;
				}
			else
				return false;
		}
		
		public void createAllCardMonster()
            {
                    MonsterSpecification[] myPossibleMonster =MonsterSpecification.values();
                    for(int indexTableau = 0; indexTableau < myPossibleMonster.length; indexTableau++ )
                    {
                            Munchkin.getGameOfMunchkin().getDungeonHeap().getDeck().add(new Monster(myPossibleMonster[indexTableau]));
                    }
            }
            /**
             * 
             */
            public void createAllCardCurse()
                    {
                            CardCurseSpecification[] myPossibleCardCurse =CardCurseSpecification.values();
                            for(int indexTableau = 0; indexTableau < myPossibleCardCurse.length; indexTableau++ )
                            {
                                    Munchkin.getGameOfMunchkin().getDungeonHeap().getDeck().add(new CardCurse(myPossibleCardCurse[indexTableau]));
                            }
                    }
            /**
             * 
             */
            public void createAllCardJob()
                    {
                            JobSpecification[] myPossibleJob =JobSpecification.values();
                            for(int indexTableau = 0; indexTableau < myPossibleJob.length; indexTableau++ )
                            {
                                    Munchkin.getGameOfMunchkin().getDungeonHeap().getDeck().add(new Job(myPossibleJob[indexTableau]));
                            }
                    }
            /**
             * 
             */
            public void createAllCardMonsterCurse()
                    {
                            MonsterCurseSpecification[] myPossibleMonsterCurse =MonsterCurseSpecification.values();
                            for(int indexTableau = 0; indexTableau < myPossibleMonsterCurse.length; indexTableau++ )
                            {
                                    Munchkin.getGameOfMunchkin().getDungeonHeap().getDeck().add(new MonsterCurse(myPossibleMonsterCurse[indexTableau]));
                            }
                    }
            /**
             * 
             */
            public void createAllCardRace()
                    {
                            RaceSpecification[] myPossibleRace =RaceSpecification.values();
                            for(int indexTableau = 0; indexTableau < myPossibleRace.length; indexTableau++ )
                            {
                                    Munchkin.getGameOfMunchkin().getDungeonHeap().getDeck().add(new Race(myPossibleRace[indexTableau]));
                            }
                    }
            public void createAllCardConsumableItem()
                    {
                            ConsumableItemSpecification[] myPossibleCards = ConsumableItemSpecification.values();
                            for(int indexTableau = 0; indexTableau < myPossibleCards.length; indexTableau++ )
                            {
                                    Munchkin.getGameOfMunchkin().getTreasureHeap().getDeck().add(new ConsumableItem(myPossibleCards[indexTableau]));
                            }
                    }
            
            public void createAllCardEquipment()
                    {
                            EquipmentSpecification[] myPossibleCards = EquipmentSpecification.values();
                            for(int indexTableau = 0; indexTableau < myPossibleCards.length; indexTableau++ )
                            {
                                    Munchkin.getGameOfMunchkin().getTreasureHeap().getDeck().add(new Equipment(myPossibleCards[indexTableau]));
                            }
                    }
            
            public void createAllCardLevelEffect()
                    {
                            LevelEffectSpecification[] myPossibleCards = LevelEffectSpecification.values();
                            for(int indexTableau = 0; indexTableau < myPossibleCards.length; indexTableau++ )
                            {
                                    Munchkin.getGameOfMunchkin().getTreasureHeap().getDeck().add(new LevelEffect(myPossibleCards[indexTableau]));
                            }
                    }
}


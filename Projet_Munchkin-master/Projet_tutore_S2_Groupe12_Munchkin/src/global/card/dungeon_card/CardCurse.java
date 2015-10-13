package global.card.dungeon_card;

import global.HandPlayer;
import global.card.DungeonCard;
import global.card.dungeon_card.enumeration.CardCurseSpecification;
import global.card.dungeon_card.enumeration.DungeonCardCategory;


public class CardCurse extends DungeonCard
	{
		
		private final DungeonCardCategory category;
		
		private final int numberCardRemove;
		

		public CardCurse(CardCurseSpecification name)
			{
				super(name.getName());
				this.category = DungeonCardCategory.card_curse;
				this.numberCardRemove = name.getNumberCardRemove();
			}
		
		public void useCurse( HandPlayer handOtherPlayer)
		{
			
			
		}

		public DungeonCardCategory getCategory()
			{
					return this.category;
			}

		public int getNumberCardRemove()
			{
					return this.numberCardRemove;
			}
		
		

	}

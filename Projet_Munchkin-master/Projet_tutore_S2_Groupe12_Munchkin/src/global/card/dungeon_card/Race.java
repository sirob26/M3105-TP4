package global.card.dungeon_card;

import global.card.Card;
import global.card.DungeonCard;
import global.card.dungeon_card.enumeration.DungeonCardCategory;
import global.card.dungeon_card.enumeration.RaceSpecification;

/**
 * {@link Race} is a race for a player.
 * 
 * @author Zyra
 *
 */
public class Race extends DungeonCard
	{
		/**
		 * category of this {@link Card}
		 */
		private final String category;

		public Race(RaceSpecification specification)
			{
				super(specification.getName());
				this.category = DungeonCardCategory.race.getName();
			}

		public void power(String name)
			{
				
			}

		public String getCategory()
			{
				return this.category;
			}

	}

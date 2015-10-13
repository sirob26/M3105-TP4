package global.card;

import global.*;
import global.card.*;
import global.card.dungeon_card.*;
import global.card.dungeon_card.enumeration.*;
import global.card.treasure_card.*;
import global.card.treasure_card.enumeration.*;

public abstract class Card
	{
		/**
		 * Say if the card's face his hidden or not.
		 */
		private final String name;
		
		private boolean hiddenFace;

		public Card(String name)
			{
				this.name = name;
				this.hiddenFace = false;
			}

		public boolean getHiddenFace()
			{
					return this.hiddenFace;
			}

		public void setHiddenFace(boolean hiddenFace)
			{
					this.hiddenFace = hiddenFace;
			}

		public String getName()
			{
					return this.name;
			}
				
		public boolean equals(Object objectTest)
		{
			if (objectTest == this)
				{
					return true;
				}
			if (objectTest instanceof Card)
				;
				{
					Card CastObject = (Card) objectTest;

					if (this.name != CastObject.name)
						{
							return false;
						}
				}
			return true;

		}
		

	}

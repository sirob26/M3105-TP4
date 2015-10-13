package global.card.dungeon_card.enumeration;

import global.*;
import global.card.*;
import global.card.dungeon_card.*;
import global.card.dungeon_card.enumeration.*;
import global.card.treasure_card.*;
import global.card.treasure_card.enumeration.*;

public enum MonsterSpecification
	{
		bailiff("bailiff",6,0,2);
		
		private final String name;
		
		private final int level;
		
		private final int levelGain;
		
		private final int treasureGain;
		
		private MonsterSpecification(String name, int level, int levelGain, int treasureGain)
		{
			this.name = name;
			this.level = level;
			this.levelGain = levelGain;
			this.treasureGain = treasureGain;
		}

		public int getLevel()
			{
					return this.level;
			}

		public int getLevelGain()
			{
					return this.levelGain;
			}

		public int getTreasureGain()
			{
					return this.treasureGain;
			}

		public String getName()
			{
					return this.name;
			}

		

	}

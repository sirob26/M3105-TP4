package global.card.dungeon_card.enumeration;

public enum MonsterCurseSpecification
	{
		mad("mad",5, 1), huge("huge",10, 2), baby("baby",-5, -1);
		private final String name;
		
		private final int monsterLevelEffect;
		
		private final int treasureCardEffect;
		
		private MonsterCurseSpecification(String name,int monsterLevelEffect, int treasureCardEffect)
		{
			this.name = name;
			this.monsterLevelEffect = monsterLevelEffect;
			this.treasureCardEffect = treasureCardEffect;
		}

		public int getMonsterLevelEffect()
			{
					return this.monsterLevelEffect;
			}

		public int getTreasureCardEffect()
			{
					return this.treasureCardEffect;
			}

		public String getName()
			{
					return name;
			}

	}

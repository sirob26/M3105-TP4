package global.card.dungeon_card.enumeration;

public enum DungeonCardCategory
	{
		race("race"), job("job"), monster("monster"), monster_curse(
				"monster curse"), card_curse("card curse"),equipment("equipment");

		private final String name;

		private DungeonCardCategory(String name)
			{
				this.name = name;
			}

		public String getName()
			{
				return name;
			}
	}

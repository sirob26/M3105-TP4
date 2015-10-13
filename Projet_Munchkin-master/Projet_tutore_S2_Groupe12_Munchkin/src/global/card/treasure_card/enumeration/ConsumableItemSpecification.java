package global.card.treasure_card.enumeration;

public enum ConsumableItemSpecification
	{
		explosive_potion("explosive potion",3),magic_missile("magic missile",5);
		
		private final String name;
		
		private final int bonus;

		private ConsumableItemSpecification(String name, int bonus)
			{
				this.name = name;
				this.bonus = bonus;
			}

		public String getName()
			{
					return name;
			}

		public int getBonus()
			{
					return bonus;
			}
		
		

	}

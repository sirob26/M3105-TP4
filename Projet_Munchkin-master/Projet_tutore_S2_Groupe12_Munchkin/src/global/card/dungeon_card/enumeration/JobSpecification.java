package global.card.dungeon_card.enumeration;

public enum JobSpecification
	{
		Noob("Noob",0,0),
		Warrior("Warrior",2,3),
		Rogue("Rogue",3,3),
		priest("Priest",1,3);
		
		private final String name;
		
		private final int bonus;
		
		private final int nbMaxCardBurnable;
		
		private JobSpecification(String name, int bonus, int nbMaxCard)
		{
			this.name = name;
			this.bonus= bonus;
			this.nbMaxCardBurnable = nbMaxCard;
		}

		public String getName()
			{
					return name;
			}

		public int getNbMaxCardBurnable()
			{
					return nbMaxCardBurnable;
			}

		public int getBonus()
			{
					return bonus;
			}
	}

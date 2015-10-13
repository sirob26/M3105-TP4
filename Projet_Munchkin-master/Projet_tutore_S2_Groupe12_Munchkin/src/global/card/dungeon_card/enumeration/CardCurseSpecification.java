package global.card.dungeon_card.enumeration;

public enum CardCurseSpecification
	{
		steal("steal",1),
		amnesia("amnesia",2);
		private final String name;
		
		private final int  numberCardRemove;
		
		
		private CardCurseSpecification(String name, int numberCardRemove)
		{
			this.name = name;
			this.numberCardRemove = numberCardRemove;
		}

		public int getNumberCardRemove()
			{
					return numberCardRemove;
			}

		public String getName()
			{
					return this.name;
			}


	}

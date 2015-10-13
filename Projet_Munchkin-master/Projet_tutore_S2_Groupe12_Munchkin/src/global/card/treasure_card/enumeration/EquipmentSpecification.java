package global.card.treasure_card.enumeration;
/**
 * a equipment is defined by a name, a category of equipment a bonus and a value.
 * @author Zyra
 *
 */
public enum EquipmentSpecification
	{
		sword_of_bastard("bastard (of) sword",2,400);

		private final String name;
		
		private final int bonus;
		
		private final int value;

		private EquipmentSpecification(String name,int bonus, int value)
			{
				this.name = name;
				this.bonus = bonus;
				this.value = value;
			}

		public String getName()
			{
					return this.name;
			}


		public int getBonus()
			{
					return bonus;
			}

		public int getValue()
			{
					return value;
			}
		
		
	}

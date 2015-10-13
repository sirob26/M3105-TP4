package global.card.dungeon_card.enumeration;

/**
 * different race possible.
 * 
 * @author Rhuarc
 *
 */

public enum RaceSpecification
	{

		human("human"), dwarf("dwarf"), elf("elf");
		private final String name;

		private RaceSpecification(String name)
			{
				this.name = name;
			}

		public String getName()
			{
					return name;
			}
		
	}

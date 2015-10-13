package global.card.treasure_card.enumeration;

import global.Player;

public enum LevelEffectSpecification
	{
		Steal_Level("Steal level", 1, 1), thousand_Gold_Piece(
				"Thousand Gold Piece", 1, 0), downLevel("Downlevel", 0, 1);

		private final String name;
		/**
		 * number of level who gain the {@link Player}.
		 */
		private final int levelNumberUp;
		/**
		 * number of level who other {@link Player} can lose.
		 */
		private final int levelNumberDown;

		private LevelEffectSpecification(String name, int levelNumberUp,
				int levelNumberDown)
			{
				this.name = name;

				this.levelNumberUp = levelNumberUp;

				this.levelNumberDown = levelNumberDown;
			}

		public int getLevelNumberUp()
			{
				return levelNumberUp;
			}

		public int getLevelNumberDown()
			{
				return levelNumberDown;
			}

		public String getName()
			{
					return name;
			}

	}

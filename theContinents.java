package patternComboCA;

//Narcisus Perejan 2016441
//Collaborator - Amilcar Aponte 
//https://github.com/imthedion/CA-patterncombo

public enum theContinents {
	
		AFRICA("Africa"), 
		ANTARCTICA("Antarctica"), 
		ASIA("Asia"), 
		EUROPE("Europe"), 
		NORTH_AMERICA("North America"),
		OCEANIA("Oceania"),
		SOUTH_AMERICA("South America");

		public final String eachContinent;		//eachContinent is a final string parallel to the theContinents enum

		
		private theContinents(String continents) {
			this.eachContinent = continents;
		}

		@Override
		public String toString() {
			return this.eachContinent;
		}

	}

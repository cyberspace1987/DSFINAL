package dsf;

public class Drug {
	
	// Declaring variables for my drug class
		private String nameOfDrug;
		private String uses;
		private String issuedDate;
		private String expDate;

		// Constructors
		public Drug() {
			super();
		}

		public Drug(String nameOfDrug, String uses, String issuedDate, String expDate) {
			super();
			this.nameOfDrug = nameOfDrug;
			this.uses = uses;
			this.issuedDate = issuedDate;
			this.expDate = expDate;
		}

		// Getters and setters
		public String getNameOfDrug() {
			return nameOfDrug;
		}

		public void setNameOfDrug(String nameOfDrug) {
			this.nameOfDrug = nameOfDrug;
		}

		public String getUses() {
			return uses;
		}

		public void setUses(String uses) {
			this.uses = uses;
		}

		public String getIssuedDate() {
			return issuedDate;
		}

		public void setIssuedDate(String issuedDate) {
			this.issuedDate = issuedDate;
		}

		public String getExpDate() {
			return expDate;
		}

		public void setExpDate(String expDate) {
			this.expDate = expDate;
		}

		// toString method
		@Override
		public String toString() {
			return "\t" + nameOfDrug + "\t" + uses + "\t" + issuedDate + "\t" + expDate;
		}


}

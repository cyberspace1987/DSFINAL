package dsf;

public class Patient {
	
	// Declaring variables for patient class
		private String id;
		private String name;
		private String dateOfBirth;
		private String insurance;

		// The constructors
		public Patient() {
			super();
		}

		public Patient(String id, String name, String dateOfBirth, String insurance) {
			this.id = id;
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.insurance = insurance;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getInsurance() {
			return insurance;
		}

		public void setInsurance(String insurance) {
			this.insurance = insurance;
		}

		// The toString method
		@Override
		public String toString() {
			return id + "\t" + name + "\t" + dateOfBirth + "\t" + insurance;
		}


}

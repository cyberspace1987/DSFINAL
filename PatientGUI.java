package dsf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PatientGUI extends JFrame{
	
	// Creating the text area and for the GUI
		JTextArea patientTextArea = new JTextArea();

		JLabel idLabel = new JLabel("ID: ");
		JTextField idTextField = new JTextField(10);

		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameTextField = new JTextField(10);

		JLabel dateOfBirthLabel = new JLabel("Date of Birth: ");
		JTextField dateOfBirthTextField = new JTextField(10);

		JLabel insuranceLabel = new JLabel("Insurance: ");
		JTextField insuranceTextField = new JTextField(10);

		JLabel nameOfDrugLabel = new JLabel("Name of Drug: ");
		JTextField nameOfDrugTextField = new JTextField(10);

		JLabel usesLabel = new JLabel("Uses: ");
		JTextField usesTextField = new JTextField(10);

		JLabel issuedDateLabel = new JLabel("Issued Date: ");
		JTextField issuedDateTextField = new JTextField(10);

		JLabel expDateLabel = new JLabel("Exp. Date: ");
		JTextField expDateTextField = new JTextField(10);

		// The buttons
		JButton addButton = new JButton("Add Patient");
		JButton deleteButton = new JButton("Delete Patient");
		JButton displayAllButton = new JButton("Display All");
		JButton sortButton = new JButton("Sort");
		JButton exitButton = new JButton("Exit");

		// Creating the linked list for the student
		List<Patient> patientLinkedList = new LinkedList<Patient>();

		public PatientGUI() {
			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

			JPanel gridPanel = new JPanel(new GridLayout(2, 1));
			JPanel gridPanel2 = new JPanel(new GridLayout(2, 1));

			patientTextArea.setEditable(false);

			// Adding buttons, labels and text fields to the window
			panel1.add(idLabel);
			panel1.add(idTextField);
			panel1.add(nameLabel);
			panel1.add(nameTextField);
			panel1.add(dateOfBirthLabel);
			panel1.add(dateOfBirthTextField);
			panel1.add(insuranceLabel);
			panel1.add(insuranceTextField);

			panel2.add(nameOfDrugLabel);
			panel2.add(nameOfDrugTextField);
			panel2.add(usesLabel);
			panel2.add(usesTextField);
			panel2.add(issuedDateLabel);
			panel2.add(issuedDateTextField);
			panel2.add(expDateLabel);
			panel2.add(expDateTextField);

			panel3.add(addButton);
			panel3.add(deleteButton);
			panel3.add(displayAllButton);
			panel3.add(sortButton);
			panel3.add(exitButton);

			gridPanel.add(panel1);
			gridPanel.add(panel2);
			gridPanel2.add(panel3);

			add(gridPanel, BorderLayout.NORTH);
			add(patientTextArea, BorderLayout.CENTER);
			add(gridPanel2, BorderLayout.SOUTH);

			// buttons functional
			addButton.addActionListener(event -> addPatient());
			displayAllButton.addActionListener(event -> displayAll());
			deleteButton.addActionListener(event -> deletePatient());
			sortButton.addActionListener(event -> sortPatient());
			exitButton.addActionListener(event -> exitOut());

		}

		// To check if the patient ID exists in the linked list
		private boolean isIDInLinkedList(String str) {
			boolean isIDdifferent = true;

			// If the patient ID matches
			for (Patient std : patientLinkedList) {
				if (std.getId().compareToIgnoreCase(str) == 0) {
					isIDdifferent = false;
				}
			}
			return isIDdifferent;
		}

		private void addPatient() {

			// Show error message if the ID is in the database
			if (isIDInLinkedList(idTextField.getText()) == false) {
				JOptionPane.showMessageDialog(null,
						"The patient ID " + idTextField.getText() + " is already in the database. Try again");

			} else {
				// Adding all information and displaying message to user that
				patientLinkedList.add(new Patient(idTextField.getText(), nameTextField.getText(), dateOfBirthTextField.getText(),
						insuranceTextField.getText() + new Drug(nameOfDrugTextField.getText(), usesTextField.getText(),
								issuedDateTextField.getText(), expDateTextField.getText())));
				JOptionPane.showMessageDialog(null, "Patient " + idTextField.getText()
						+ " has been added to the database. Please press the display button to update the list.");
				JOptionPane.showMessageDialog(null, "Important: Please sort the list before displaying it!");

				// Reseting all the text fields
				idTextField.setText("");
				nameTextField.setText("");
				dateOfBirthTextField.setText("");
				insuranceTextField.setText("");
				nameOfDrugTextField.setText("");
				usesTextField.setText("");
				issuedDateTextField.setText("");
				expDateTextField.setText("");

			}
		}

		private void deletePatient() {
			// If the patient ID cannot be found to be deleted
			if (isIDInLinkedList(idTextField.getText()) == true) {
				JOptionPane.showMessageDialog(null,
						"The patient ID " + idTextField.getText() + " is not in the database. Cannot be deleted.");
			} else {
				// Retrieve the current ID and compare other ID's from text fields
				for (int i = 0; i < patientLinkedList.size(); i++) {
					String currentID = patientLinkedList.get(i).getId();

					if (currentID.compareToIgnoreCase(idTextField.getText()) == 0) {
						patientLinkedList.remove(i);
					}
				}
				// Displaying message to user that the patient has been deleted 
				JOptionPane.showMessageDialog(null, "Patient " + idTextField.getText()
						+ " has been deleted! Please press the display button for updated list");

				// Reseting all text fields 
				idTextField.setText("");
				nameTextField.setText("");
				dateOfBirthTextField.setText("");
				insuranceTextField.setText("");
				nameOfDrugTextField.setText("");
				usesTextField.setText("");
				issuedDateTextField.setText("");
				expDateTextField.setText("");
			}
		}

		private void displayAll() {
			patientTextArea.setText("");
			for (Patient std : patientLinkedList) {
				patientTextArea.append(std + "\n");
			}
		}
		public void sortPatient() {
			patientLinkedList.sort(Comparator.comparing(Patient::getId)); // Sorting the patients by ID
		}
		
		private void exitOut() {
			System.exit(0); // Closing the application
		}


}

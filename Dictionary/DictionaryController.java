import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DictionaryController extends CreateDictionary {


	@FXML
	private TextField definition;

	@FXML
	private TextField key;


	public void initialize() {

	}

	@FXML
	void addDef(ActionEvent event) throws IllegalArgumentException {
		if(doubleCheck(key,definition))
			addVal(dict,key.getText(),definition.getText());

	}

	@FXML
	void removeDef(ActionEvent event) {
		if(singleCheck(key))
			removeVal(dict,key.getText());
	}

	@FXML
	void searchDef(ActionEvent event) {
		System.out.println(dict);
		if(singleCheck(key))
			searchVal(dict,key.getText());
	}

	@FXML
	void updateDef(ActionEvent event) {
		if(doubleCheck(key,definition))
			updateVal(dict,key.getText(),definition.getText());
	}

	private boolean doubleCheck(TextField key,TextField definition) throws IllegalArgumentException{
		if(key.getText().isEmpty() || definition.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Key or definition cannot be empty", "Error!", 0);
			throw new IllegalArgumentException("Key or definition cannot be empty");
		}
		return true;

	}

	private boolean singleCheck(TextField key) throws IllegalArgumentException{
		if(key.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Key cannot be empty", "Error!", 0);
			throw new IllegalArgumentException("Key cannot be empty");
		}
		return true;

	}
}

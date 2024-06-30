import java.util.TreeMap;
import javax.swing.JOptionPane;

public class CreateDictionary{
	protected TreeMap<String,String> dict;
	private String key;
	private String definition;

	public CreateDictionary() {
		this.dict = new TreeMap<String,String>();
		this.key = null;
		this.definition = null;
	}

	public CreateDictionary(TreeMap<String,String>dict,String key,String definition) {
		this.key = key;
		this.definition = definition;
		this.dict = dict;
	}


	public String getKey() {
		return key;
	}

	public String getDefinition() {
		return definition;
	}

	public void addVal(TreeMap<String,String>dict,String key,String definition) throws IllegalArgumentException {
		if(!dict.containsKey(key)) {
			dict.put(key,definition);
		}else {
			Found();
			throw new IllegalArgumentException("Key Is Already in the dictionary");
		}
	}

	public void removeVal(TreeMap<String,String>dict ,String key)throws IllegalArgumentException {

		if(dict.containsKey(key))
			dict.remove(key);
		else {
			notFound();
			throw new IllegalArgumentException("Key Isn't found in the dictionary");
		}
	}

	public void updateVal(TreeMap<String,String>dict,String key,String definition) throws IllegalArgumentException {

		if(dict.containsKey(key)) {
			removeVal(dict,key);
			addVal(dict,key,definition);
		}else {
			notFound();
			throw new IllegalArgumentException("Key Isn't found in the dictionary");
		}
	}

	public void searchVal(TreeMap<String,String>dict,String key)throws IllegalArgumentException {

		if(dict.containsKey(key)) {
			String definition = dict.get(key);
			JOptionPane.showMessageDialog(null,"The Definition Of '"+key + "' is: "+definition,"Dictionary",1);
		}else {
			notFound();
			throw new IllegalArgumentException("Key Isn't found in the dictionary");
		}
	}

	private void notFound() {
		JOptionPane.showMessageDialog(null, "Key Isn't found in the dictionary", "Error", 0, null);
	}

	private void Found() {
		JOptionPane.showMessageDialog(null, "Key Is already in the dictionary", "Error", 0, null);
	}
}


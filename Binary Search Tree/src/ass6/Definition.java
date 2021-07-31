package ass6;

public class Definition {
	private String word;
	private String description;


	public Definition(String word, String description) {
		this.word = word;
		this.description = description;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return word + ": " + description;
	}
	
	public boolean same(Definition d) {
		return (d.getWord().equals(word) && d.getDescription().equals(description));
		
	}
	
}

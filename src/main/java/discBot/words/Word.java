package discBot.words;

import java.util.HashSet;
import java.util.Set;

public class Word {

	private String word;
	private Set<Description> descriptions;
	
	public Word(String word) {
		this.word = word;
		descriptions = new HashSet<Description>();
	}
	
	public void merge(Word w) {
		for(Description description:w.descriptions) {
			descriptions.add(description);
		}
	}
	
	public boolean isSameWord(Word w) {
		return w.word.equals(this.word);
	}
}

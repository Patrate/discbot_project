package discBot.words;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {

	Set<Word> words;
	
	public Dictionary() {
		words = new HashSet<Word>();
	}
	
	public boolean addWord(Word word) {
		return words.add(word);
	}
}

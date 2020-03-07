package discBot.words;

import java.util.Arrays;
import java.util.List;

public abstract class WordHelper {

	public static List<String> parseSentence(String sentence){
		return Arrays.asList(sentence.split("\\s"));
	}
	
}

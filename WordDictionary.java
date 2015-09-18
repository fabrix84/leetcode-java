public class WordDictionary {
	private Map<Character,WordDictionary> children;
	private boolean isWord = false;
	public WordDictionary() {
		this.children = new HashMap<Character,WordDictionary>();
	}
    public void addWord(String word) {
    	if(word==null || word.length()==0) return;
        char[] chars = word.toCharArray();
        WordDictionary current = this;
        for(char c: chars) {
        	if(!current.children.containsKey(c)) current.children.put(c, new WordDictionary());
        	current = current.children.get(c);
        }
        current.isWord = true;
    }
    public boolean search(String word) {
    	if(word==null) return false;
    	return search(word,0);
    }
    public boolean search(String word, int from) {
    	char[] chars = word.toCharArray();
    	WordDictionary current = this;
    	for(int i=from; i<chars.length; i++) {
    		char c = chars[i];
			if(c == '.') {
				if(i==chars.length-1) {
					for(char wd: current.children.keySet()) if(current.children.get(wd).isWord) return true;
				} else {
	    			for(char wd: current.children.keySet()) if(current.children.get(wd).search(word,i+1)) return true;
				}
    			return false;
    		} else {
    			if(current.children.containsKey(c)) current = current.children.get(c);
    			else return false;
    		}
    	}
        return current.isWord;
    }
}

public class Solution {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }
	
    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
	boolean[] dp = new boolean[word.length() + 1];
	dp[0] = true;
	for (int i = 1; i <= word.length(); i++) {
	    for (int j = 0; j < i; j++) {
		if (!dp[j]) continue;
		if (dict.contains(word.substring(j, i))) {
		    dp[i] = true;
		    break;
		}
	    }
	}
	return dp[word.length()];
    }
}


//or 


public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (w1, w2) -> (w1.length() - w2.length()));
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String w : words) {
            boolean[] dp = new boolean[w.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= w.length(); i++) {
                for (int j = i; j > -1; j--) {
                    if (dp[j] && dict.contains(w.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            if (w.length() > 0 && dp[w.length()]) ans.add(w);
            dict.add(w);
        }
        return ans;
    }



//or  dynamic programming and DFS



public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> list = new ArrayList<String>();
    Set<String> set = new HashSet(Arrays.asList(words));

    for(String word : words) {
        set.remove(word);
        if(dfs(word, set, "")) list.add(word);
        set.add(word);
    }
    return list;
}

private boolean dfs(String word, Set<String> set, String previous) {
    if(!previous.equals("")) set.add(previous);
    if(set.contains(word)) return true;
    
    for(int i = 1; i < word.length(); i++) {
        String prefix = word.substring(0,i);
        if(set.contains(prefix) && 
            dfs(word.substring(i,word.length()), set, previous+prefix)) {
            return true;
        }
    }
    return false;
}
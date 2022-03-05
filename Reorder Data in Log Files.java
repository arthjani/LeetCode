class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                // split each log into two parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                // case 1). both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    // first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0)
                        return cmp;
                    // logs of same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                // case 2). one of logs is digit-log
                if (!isDigit1 && isDigit2)
                    // the letter-log comes before digit-logs
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                else
                    // case 3). both logs are digit-log
                    return 0;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}

//or
//best memory distribution 

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, (String a, String b) -> {
            int firstCharA = a.indexOf(" ") + 1;
            int firstCharB = b.indexOf(" ") + 1;
            
            // digit log == true, letter log == false
            boolean aType = Character.isDigit(a.charAt(firstCharA));
            boolean bType = Character.isDigit(b.charAt(firstCharB));
            
            if (aType && bType) {
                // Rule 3: maintain relative digit log order
                return 0;
            } else if (bType) {
                // Rule 1: digit logs follow letter logs
                return -1;
            } else if (aType) {
                // Rule 1: digit logs follow letter logs
                return 1;
            }
            // Rule 2a: letter logs sorted lexicographically
            int comp = a.substring(firstCharA).compareTo(b.substring(firstCharB));
            // Rule 2b: letter logs sorted by ids if tied
            return comp != 0 ? comp : a.compareTo(b);
        });
        return logs;
    }
}



//or 
//best runtime code


class Solution {
   public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstCharacter = s1.charAt(s1SpaceIndex+1);
                char s2FirstCharacter = s2.charAt(s2SpaceIndex+1);
                
                if (s1FirstCharacter <= '9') {
                    if (s2FirstCharacter <= '9') return 0;
                    else return 1;
                }
                if (s2FirstCharacter <= '9') return -1;
                
                int preCompute = s1.substring(s1SpaceIndex).compareTo(s2.substring(s2SpaceIndex));
                if (preCompute == 0) 
                    return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                return preCompute;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}
class uniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i ++) {
            set.add(parseEmail(emails[i]));
        }
        return set.size();
    }
    public String parseEmail(String email) {
        String localName = email.split("@")[0];
        String domainName = email.split("@")[1];
        for (int i = 0; i < localName.length(); i ++) {
            if (localName.charAt(i) == '.') {
                localName = localName.substring(0, i) + localName.substring(i + 1, localName.length());
            }
            if (localName.charAt(i) == '+') {
                localName = localName.substring(0, i);
                break;
            }
        }
        return localName + "@" + domainName;
    } 
}



/*
Solution one: Two for loop
n is the number of emails
m is the length of each email
time: O(n * m) contains method and repalce method will go through the string
space: O(n) 


Solution two: Apply indexOf method in String class
time and space complexity is the same as the solution one.


Tips:
1. This problem is mainly about how to parse a String. We need to know the basic methods to deal with string. Be careful with the parameters(sometimes it must be character, sometimes must be string, sometimes it's regex)
Some common methods in java.lang.String
split(String regex)
substring(int beginIndex)
substring(int beginIndex, int endIndex)
indexOf(int ch)
contains(CharSequence s)
replaceAll(String regex, String replacement)
replace(CharSequence target, CharSequence replacement)
To see more methods in java.lang.String, go to https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

2.know about regex


*/
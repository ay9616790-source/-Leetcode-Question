class Solution {
    public boolean detectCapitalUse(String word) {
        int n=word.length();
        int upperCase=0;
        for(int i=0;i<n;i++){
            if(Character.isUpperCase(word.charAt(i))){
                upperCase++;
            }
        }
        return upperCase==n || upperCase==0 || (upperCase==1 && Character.isUpperCase(word.charAt(0)));
    }
}
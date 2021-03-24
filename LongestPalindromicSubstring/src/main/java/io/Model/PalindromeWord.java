package io.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PalindromeWord {
    @Id
    private String word;

    private String longestPalindromicSubstring;

    public PalindromeWord() {
    }

    public PalindromeWord(String word, String longestPalindromicSubstring) {
        this.word = word;
        this.longestPalindromicSubstring = longestPalindromicSubstring;
    }

    public String getWord() {
        return word;
    }

    public String getLongestPalindromicSubstring() {
        return longestPalindromicSubstring;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setLongestPalindromicSubstring(String longestPalindromicSubstring) {
        this.longestPalindromicSubstring = longestPalindromicSubstring;
    }
}

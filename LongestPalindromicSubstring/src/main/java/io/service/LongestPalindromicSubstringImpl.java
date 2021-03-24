package io.service;

import io.Model.CreatePalindrome;
import io.Model.PalindromeWord;
import io.repository.LongestPalindromicSubstringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LongestPalindromicSubstringImpl implements LongestPalindromicSubstring {

    @Autowired
    LongestPalindromicSubstringRepository repository;

    public String findLongestPalindromicSubstring(CreatePalindrome input) {
        Optional<PalindromeWord> palindromeWord = repository.findByWord(input.getWord());

        if (palindromeWord.isPresent()) {
            return palindromeWord.get().getLongestPalindromicSubstring();
        } else {
            if (input == null || input.getWord().length() < 1 || input.getWord().length() > 1000) return null;
            int startingIndex = 0, endingIndex = 0;

            for (int i = 0; i < input.getWord().length(); i++) {
                int firstLength = findSubstringlength(input.getWord(), i, i);
                int secondLength = findSubstringlength(input.getWord(), i, i + 1);
                int length = Math.max(firstLength, secondLength);
                if (endingIndex - startingIndex < length) {
                    startingIndex = i - (length - 1) / 2;
                    endingIndex = i + length / 2;
                }
            }
            PalindromeWord pw = new PalindromeWord();
            pw.setWord(input.getWord());
            pw.setLongestPalindromicSubstring(input.getWord().substring(startingIndex, endingIndex + 1));
            repository.save(pw);
            return pw.getLongestPalindromicSubstring();
        }
    }

    @Override
    public String getLongestPalindromicSubstring(String inputString) {
        Optional<PalindromeWord> palindromeWord = repository.findByWord(inputString);

        if (palindromeWord.isPresent()) {
            return palindromeWord.get().getLongestPalindromicSubstring();
        } else {
            CreatePalindrome createPalindrome = new CreatePalindrome();
            createPalindrome.setWord(inputString);
            return findLongestPalindromicSubstring(createPalindrome);
        }
    }

    int findSubstringlength(String input, int s, int e) {
        while (s >= 0 && e < input.length() && input.charAt(s) == input.charAt(e)) {
            s--;
            e++;
        }
        return e - (s + 1);
    }
}

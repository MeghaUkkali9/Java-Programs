package io.repository;

import io.Model.PalindromeWord;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LongestPalindromicSubstringRepository extends CrudRepository<PalindromeWord, String> {
    Optional<PalindromeWord> findByWord(String input);
}

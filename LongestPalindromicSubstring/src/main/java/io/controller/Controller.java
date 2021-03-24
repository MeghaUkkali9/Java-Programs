package io.controller;

import io.Model.CreatePalindrome;
import io.service.LongestPalindromicSubstringImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    LongestPalindromicSubstringImpl service;

    @RequestMapping(method = RequestMethod.POST, value = "/findLongestSubstring",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String findLongestSubstring(@RequestBody CreatePalindrome input) {
        return service.findLongestPalindromicSubstring(input);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getLongestSubstring/{inputString}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLongestPalindromicSubstring(@PathVariable("inputString") String inputString){
        return service.getLongestPalindromicSubstring(inputString);
    }
}

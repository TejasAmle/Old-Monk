package com.example.oldmonk;
import java.util.regex.*;
import java.util.*;

public class ValidatoLoginTest {
    public boolean checkEmail(String email) {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return (matcher.matches());
    }


}

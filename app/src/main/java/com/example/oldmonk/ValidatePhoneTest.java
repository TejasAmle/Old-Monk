package com.example.oldmonk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneTest {

    public boolean checkPhone(String num){

        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(num);

        return (m.matches());
    }
}

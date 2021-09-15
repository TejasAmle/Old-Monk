package com.example.oldmonk;


import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

    @Test
    public void loginInput(){
        boolean emailBool = new ValidatoLoginTest().checkEmail("tejas_amle@yahoo.com");
        Assert.assertTrue(emailBool);
    }
}
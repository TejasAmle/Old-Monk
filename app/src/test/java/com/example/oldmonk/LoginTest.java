package com.example.oldmonk;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void validEmail() {
        boolean emailBool1 = new ValidatoLoginTest().checkEmail("tejas_amle@yahoo.com");
        Assert.assertEquals(true,emailBool1);
    }

    @Test
    public void validEmail1() {
        boolean emailBool2 = new ValidatoLoginTest().checkEmail("tejas.amle@moveinsync.com");
        Assert.assertEquals(true, emailBool2);
    }

    @Test
    public void onlyDomain() {
        boolean emailBool3 = new ValidatoLoginTest().checkEmail("@yahoo.com");
        Assert.assertEquals(false, emailBool3);
    }

    @Test
    public void noAt() {
        boolean emailBool4 = new ValidatoLoginTest().checkEmail("tejas_amleyahoo.com");
        Assert.assertEquals(false, emailBool4);
    }

    @Test
    public void noCom() {
        boolean emailBool5 = new ValidatoLoginTest().checkEmail("tejas_amle@yahoo");
        Assert.assertEquals(true, emailBool5);
    }


}
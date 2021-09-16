package com.example.oldmonk;

import org.junit.Assert;
import org.testng.annotations.Test;

public class PhoneTest {

    @Test
    public void validPhone(){
        boolean phone1 = new ValidatePhoneTest().checkPhone("9910282204");
        Assert.assertEquals(true,phone1);
    }
}

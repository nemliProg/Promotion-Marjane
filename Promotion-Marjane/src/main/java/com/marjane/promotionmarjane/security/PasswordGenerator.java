package com.marjane.promotionmarjane.security;
import java.security.SecureRandom;
import java.math.BigInteger;

public final class PasswordGenerator {
    private SecureRandom random = new SecureRandom();

    public String nextPassword() {
        return new BigInteger(130, random).toString(32);
    }

    public String message(String password) {
    	return "Your Password is "+password+" . For better privacy assurance please delete this message.";
    }
}
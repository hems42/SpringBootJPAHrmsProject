package cap_software.hrms.core.verification;

import cap_software.hrms.entities.concretes.verifications.EmailVerification;

import java.sql.Date;

public class EmailVerify {

    public static EmailVerification getEmailVerify()
    {
        EmailVerification emailVerification= new EmailVerification();
        emailVerification.setVerifed(false);
        emailVerification.setExpiryDate(Date.valueOf("2021-06-01"));
        emailVerification.setToken("n56+df54g56df455645d64fg56df4g5s" +
                "d4f5s6f4s56f4sd5645w6e456sd4f56sd4f65sd4f56sf" +
                "sd6s5ad56as4d6s4ad6+as4d6as45d56as4d56a4s5d64as5d4as56");

        return emailVerification;
    }
}

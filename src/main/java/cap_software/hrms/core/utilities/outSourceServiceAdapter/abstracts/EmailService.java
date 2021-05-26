package cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts;



public interface EmailService
{

    void sendMail(String  mesaj);

    boolean checkMail(String email);

}

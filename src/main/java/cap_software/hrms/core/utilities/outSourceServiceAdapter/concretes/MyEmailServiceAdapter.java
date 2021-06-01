package cap_software.hrms.core.utilities.outSourceServiceAdapter.concretes;

import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.EmailService;

public class MyEmailServiceAdapter implements EmailService {

    @Override
    public void sendMail(String mesaj) {



    }

    @Override
    public boolean checkMail(String email) {
        return true;
    }
}

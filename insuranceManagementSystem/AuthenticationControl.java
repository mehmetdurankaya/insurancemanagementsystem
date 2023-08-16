package insuranceManagementSystem;

import java.util.Scanner;

public class AuthenticationControl {
    private User user;

    public enum AuthenticationStatus {
        SUCCESS, FAIL
    }

    public AuthenticationControl(User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AuthenticationStatus login() {

        Scanner input = new Scanner(System.in);
        System.out.print("E-mail adresi: ");
        String mail = input.next();
        System.out.print("Şifre        : ");
        String pw = input.next();

        if (user.getEmail().equals(mail) && user.getPassword().equals(pw)) {
            return AuthenticationStatus.SUCCESS;
        } else {
            return AuthenticationStatus.FAIL;
        }
    }
}

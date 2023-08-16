package insuranceManagementSystem;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import insuranceManagementSystem.AuthenticationControl.AuthenticationStatus;

public class AccountManager {
    private Set<Account> dataList = new TreeSet<>(new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o1.getUser().getName().compareTo(o2.getUser().getName());
        }
    });

    public Set<Account> getDataList() {
        return dataList;
    }

    public void setDataList(Set<Account> dataList) {
        this.dataList = dataList;
    }

    public void login(String email, String password) throws InvalidAuthenticationException {

        for (Account account : dataList) {
            AuthenticationControl ctrl = new AuthenticationControl(account.getUser());
            if (account.getUser().getPassword().equals(password) && account.getUser().getEmail().equals(email)) {
                if ((ctrl.login() == AuthenticationStatus.FAIL)) {
                    throw new InvalidAuthenticationException("HATA: Geçersiz e-mail ya da şifre!");
                } else {
                    account.showUserInfo();
                }
            }
        }
    }
}

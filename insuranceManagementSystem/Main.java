package insuranceManagementSystem;

public class Main {
    public static void main(String[] args) throws InvalidAuthenticationException {

        AccountManager accountManager = new AccountManager();

        User user1 = new User("MehmetDuran", "Kaya", "mehmetdurankaya@gmail.com", "123", "Full-Stack Developer", 46);

        user1.getInsurances().add(new CarInsurance(100000));
        user1.getInsurances().add(new HealthInsurance(75000));
        user1.getInsurances().add(new ResidenceInsurance(250000));
        user1.getInsurances().add(new TravelInsurance(50000));


        AddressManager addressManager = new AddressManager(user1);
        addressManager.addAddress((new HomeAddress("Türkiye","Hatay","Antakya", "A","B")));
        addressManager.addAddress((new BusinessAddress("Türkiye","Adana","Yüreğir", "C","D")));

        Account account1 = new Individual(user1);

        accountManager.getDataList().add(account1);

        accountManager.login("mehmetdurankaya@gmail.com", "123");

    }
}
class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException(String message) {
        super(message);
    }
}

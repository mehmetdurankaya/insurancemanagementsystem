package insuranceManagementSystem;

public abstract class Account {
    private User user;

    public final void showUserInfo() {
        System.out.println("\n-------------- Müşteri Bilgileri ---------------");
        System.out.println("Ad      : " + user.getName());
        System.out.println("Soyad   : " + user.getSurname());
        System.out.println("E-Mail  : " + user.getEmail());
        System.out.println("Yaş     : " + user.getAge());
        System.out.println("Meslek  : " + user.getJob());
        System.out.println("-----------------------------------------------");
        System.out.println("\n--------------- Adres Listesi ---------------");
        for (int i = 0; i < user.getAddressList().size(); i++) {
            System.out.print((i + 1) + ". adres: ");
            System.out.print(user.getAddressList().get(i).getNeighborhood() + ", " + user.getAddressList().get(i).getStreet()
                    + ", " + user.getAddressList().get(i).getTown() + ", " + user.getAddressList().get(i).getCity() + ", " + user.getAddressList().get(i).getCountry() + "\n");
        }
        System.out.println("-----------------------------------------------");
        System.out.println("\n--------------- Sigorta Listesi ---------------");
        for (Insurance i : user.getInsurances()) {
            System.out.println("Sigorta İsmi            : " + i.getClass().getSimpleName());
            System.out.println("Sigorta Ücreti          : " + i.calculate());
            System.out.println("Sigorta Başlangıç Tarihi: " + i.getStartDate());
            System.out.println("Sigorta Bitiş Tarihi    : " + i.getFinishDate());
            System.out.println("-----------------------------------------------");
        }
    }

    public Account(User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

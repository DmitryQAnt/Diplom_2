public class CustomerCredentials {
    private String email;
    private String password;


    public CustomerCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public CustomerCredentials() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static CustomerCredentials from(Customer customer) {
        return new CustomerCredentials(customer.getEmail(), customer.getPassword());
    }


}

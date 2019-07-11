public class LoginSession {
    String email;
    boolean isLogedIn = false;

    public LoginSession() {
        this.email = "default";
        isLogedIn = true;
    }

    public LoginSession(String email, boolean isLogedIn) {
        this.email = email;
        this.isLogedIn = isLogedIn;
    }

    @Override
    public String toString() {
        return "loginSession{" +
                "email='" + email + '\'' +
                ", isLogedIn? " + isLogedIn +
                '}';
    }
}

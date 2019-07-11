public class loginSession {
    String email;
    boolean isLogedIn = false;

    public loginSession() {
        this.email = "default";
        isLogedIn = true;
    }

    public loginSession(String email, boolean isLogedIn) {
        this.email = email;
        this.isLogedIn = isLogedIn;
    }

    @Override
    public String toString() {
        return "loginSession{" +
                "email='" + email + '\'' +
                ", isLogedIn=" + isLogedIn +
                '}';
    }
}

import java.util.HashMap;
import java.util.Map;

public class Users {
    public Map<String, User> users = new HashMap();

    public Users() {
        loadUsers();
    }

    private void loadUsers(){
        users.put("Me@Islam", new User("Me@Islam","Pass"));
        users.put("Me2@Islam", new User("Me2@Islam","Pass2"));
        users.put("me@islam", new User("me@islam","pass"));
    }
}

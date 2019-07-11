import java.util.HashMap;
import java.util.Map;

public class Users {
    Map<String, User> users = new HashMap();
    private void loadUsers(){
        users.put("Me", new User("Me@Islam","Pass"));
        users.put("Me", new User("Me2@Islam","Pass2"));
        users.put("Me", new User("me@islam","pass"));
    }
}

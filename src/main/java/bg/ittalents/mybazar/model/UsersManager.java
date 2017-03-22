package bg.ittalents.mybazar.model;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Daskalski on 3/21/17.
 */
public class UsersManager {

    private HashMap<User.Role, HashSet<User>> registeredUsers;

    private static UsersManager ourInstance;

    public static UsersManager getInstance() {
        if(ourInstance == null){
            ourInstance = new UsersManager();
        }
        return ourInstance;
    }

    private UsersManager() {
        registeredUsers = new HashMap<>();
    }

    public boolean validLogin(User.Role role, String username, String password){
        if(registeredUsers.get(role) == null){
            return false;
        }
        for(User u : registeredUsers.get(role)){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void addUser(User u){
        if(!registeredUsers.containsKey(u.getRole())){
            registeredUsers.put(u.getRole(), new HashSet<User>());
        }
        registeredUsers.get(u.getRole()).add(u);

    }

}

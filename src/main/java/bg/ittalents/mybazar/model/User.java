package bg.ittalents.mybazar.model;

import java.io.Serializable;

/**
 * Created by Daskalski on 3/21/17.
 */

public class User implements Serializable{

    private String username;
    private String password;
    protected Role role;
    public enum Role{ SELLER, CLIENT};

    public User(String username, String password) {
        if(username != null && !username.isEmpty()) {
            this.username = username;
        }
        if(password != null && !password.isEmpty()) {
            this.password = password;
        }
        this.role = Role.CLIENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null)
            return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

package com.bsu;

import java.util.Objects;
class Users {
    private String username;
    private String login;
    private String password;
    private String email;
    private boolean ifAdmin;
    public Users(String[] args) throws Exception {
        this.username = args[0];
        this.login= args[1];
        this.email = args[2];
        this.password = args[3];
        this.ifAdmin=true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,login,password);
    }

    public boolean equalUser(Object t) {
        if (this == t) return true;
        if (t == null || getClass() != t.getClass()) return false;
        Users a = (Users) t;
        return Objects.equals(username, a.username) &&
                Objects.equals(password, a.password) ;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    public void setLogin(String login) {
        this.login= login;
    }

    public void setEmail(String email) {
        this.email= email;
    }

    public void setPassword(String password) {
        this.password= password;
    }


    public String getUsername() {
        return username;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }




}
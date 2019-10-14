package cha03_pk01.user;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("add user.");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user.");
    }

    @Override
    public void queryUser(String username) {
    	System.out.println("query user: " + username);
    }
}

package JAVA_SLMS;

public class Accounts {
    private User user;
    private BorrowedList borrowedList; // Add a list of books borrowed per user

    // Constructor
    public Accounts() {
        user = null;
        borrowedList = null;
    }

    // TODO create a linked list to add users
    public Accounts addUser(){

        return this;
    }
    // TODO method to check login
    public boolean login(String username, String password){
        return true;
    }
    // TODO method to get the user type
    public String getUserType(){

    }
}
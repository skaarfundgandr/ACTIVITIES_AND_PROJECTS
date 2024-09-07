package JAVA_SLMS;

public class User {
    private String username;
    private String password;
    private String userType;
    
    public BorrowedList borrowedBooks;
    public User nextUser; // Linked list: points to next user

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        borrowedBooks = new BorrowedList();
        setUserType(userType); // Ensure valid userType is set
    }

    // Getter and Setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for userType
    public String getUserType() {
        return userType;
    }
    //conditions for user types
    public void setUserType(String userType) throws IllegalArgumentException {
        if (userType.equalsIgnoreCase("librarian") || userType.equalsIgnoreCase("user")) {
            this.userType = userType;
        } else {
            throw new IllegalArgumentException("User type must be either 'librarian' or 'user'");
        }
    }

    // sisplay details/info
    public void displayUser() {
        System.out.println("Username: " + username);
        System.out.println("User Type: " + userType);
    }
}

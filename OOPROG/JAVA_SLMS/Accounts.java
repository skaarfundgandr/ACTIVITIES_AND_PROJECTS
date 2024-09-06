package JAVA_SLMS;

public class Accounts {
    private User firstUser;
    
    public Accounts() {
        firstUser = null; 
    }

    // Add a user to the linked list---ambot hahahahh
    public Accounts addUser(String username, String password, String userType) {
        // Check if the username already exists
        if (!isUnique(username)) {
            System.out.println("User with username " + username + " already exists.");
            return this; // Return without adding the duplicate user
        }

        User newUser = new User(username, password, userType);
        newUser.nextUser = null;

        if (firstUser == null) {
            firstUser = newUser; // If the list is empty, i-set ang new user as the firstUser
        } else {
            User current = firstUser;
            while (current.nextUser != null) {
                current = current.nextUser; 
            }
            current.nextUser = newUser; 
        }

        return this;
    }

    // log in process
    public boolean logIn(String username, String password) {
        User current = firstUser;
        while (current != null) {
            if (current.getUsername().equals(username) && current.getPassword().equals(password)) {
                return true; 
            }
            current = current.nextUser; // Move to the next user
        }
        return false; // Login failed
    }

    // Get the user type by username
    public String getUserType(String username) {
        User current = firstUser;
        while (current != null) {
            if (current.getUsername().equals(username)) {
                return current.getUserType(); // Return user type if found
            }
            current = current.nextUser; // Move to the next user
        }
        return null; // Username not found
    }

    // Check if a username is  walay duplicates / unique
    private boolean isUnique(String username) {
        User current = firstUser;
        username = username.trim();

        while (current != null) {
            if (current.getUsername().equals(username)) {
                return false; // Username already exists
            }
            current = current.nextUser; // Move to the next user
        }

        return true;
    }
}

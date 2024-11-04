import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements Runnable {
    private File file;
    private Thread task;
    private Contacts contacts;
    private char mode;

    public FileHandler(File f, Contacts contacts, char mode) {
        this.file = f;
        this.mode = mode;
        this.contacts = contacts;
    }

    public void setMode(char mode) {
        this.mode = mode;
    }

    private void updateFileContents() {
        try (FileWriter fw = new FileWriter(file, false)) {
            String[] arrStrings = contacts.toArrStrings();

            for (String string : arrStrings) {
                fw.write(string + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addContactToFile() {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(contacts.peek() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readContacts() {
        try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
            while (contacts.addContact(bReader.readLine())) {}
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        switch (mode) {
            case 'r':
                readContacts();
                break;
            case 'w':
                updateFileContents();
                break;
            case 'a':
                addContactToFile();
                break;
            default:
                break;
        }
    }

    public void start(){
        task = new Thread(this);
        task.run();
    }
}
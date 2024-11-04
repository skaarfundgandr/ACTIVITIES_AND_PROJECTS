import java.util.ArrayList;

class Contact {
    Contact previous;
    String name;
    Contact next;

    public Contact(String name) {
        this.name = name;
    }
}

public class Contacts {
    private Contact head;
    private Contact tail;

    public synchronized boolean addContact(String name) {
        if (name == null) {
            return false;
        }

        Contact newContact = new Contact(name);

        if (head == null) {
            head = tail = newContact;
        } else {
            newContact.previous = tail;
            tail.next = newContact;
            tail = newContact;
        }

        return true;
    }

    public void readContacts() {
        Contact current = head;

        if (isEmpty()) {
            System.out.println("Contacts is empty!");
        } else {
            System.out.println("Contacts:");
            while (current != null) {
                System.out.println(current.name);
                current = current.next;
            }
        }
    }

    public void updateContact(String name, String newName) throws ContactNotFoundException {
        Contact currContact = head;

        while (currContact != null) {
            if (currContact.name.equals(name)) {
                break;
            }
            currContact = currContact.next;
        }

        if (currContact == null) {
            throw new ContactNotFoundException("Contact " + name + " not found");
        } else {
            currContact.name = newName;
        }
    }

    public void deleteContact(String name) throws ContactNotFoundException {
        Contact currContact = head;

        while (currContact != null) {
            if (currContact.name.equals(name)) {
                break;
            }
            currContact = currContact.next;
        }

        if (currContact == null) {
            throw new ContactNotFoundException("Contact " + name + " not found");
        } else if (currContact == head) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }
        } else if (currContact == tail) {
            tail = tail.previous;
            tail.next = null;
        } else {
            currContact.previous.next = currContact.next;
            currContact.next.previous = currContact.previous;
        }

        currContact = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String peek() {
        return tail.name;
    }

    public String[] toArrStrings() {
        Contact currContact = head;
        ArrayList<String> arrayList = new ArrayList<String>();

        while (currContact != null){
            arrayList.add(currContact.name);
            currContact = currContact.next;
        }

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
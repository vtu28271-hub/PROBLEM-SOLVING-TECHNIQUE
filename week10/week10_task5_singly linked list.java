
import java.util.Scanner;

class Node {
    String song;
    Node next;

    Node(String song) {
        this.song = song;
        this.next = null;
    }
}

public class singly linked list {
    static Node head = null;
    static void addSong(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        System.out.println(song + " added to playlist.");
    }
    static void removeSong(String song) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.song.equalsIgnoreCase(song)) {
            head = head.next;
            System.out.println(song + " removed from playlist.");
            return;
        }

        Node temp = head;

        while (temp.next != null &&
               !temp.next.song.equalsIgnoreCase(song)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Song not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println(song + " removed from playlist.");
        }
    }
    static void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;
        System.out.println("\nMusic Playlist:");

        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();
                    addSong(song);
                    break;

                case 2:
                    System.out.print("Enter song to remove: ");
                    String remove = sc.nextLine();
                    removeSong(remove);
                    break;

                case 3:
                    displayPlaylist();
                    break;

                case 4:
                    System.out.println("Exiting playlist.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}

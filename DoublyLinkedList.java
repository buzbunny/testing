import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addSong(Song song) {// Method to add songs to the linkedlist. To make it more practical, I only
                                    // adopted adding new nodes to the end of the list rather than inbetween or at
                                    // the beginning to assumue the practicality of real music application and how
                                    // they update playlists
        Node newNode = new Node(song);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void removeSong(int pos) {// algorithm for this method was borrowed from class slides
        if (pos == 1) {
            if (head != null) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
                size--;
            }
        } else if (pos == size) {
            if (tail != null) {
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
                size--;
            }
        } else {
            Node current = head;
            int count = 1;

            while (count < (pos - 1) && current != null) {
                current = current.next;
                count++;
            }

            if (current != null && current.next != null) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                }
                size--;
            }
        }
    }

    public void play() {// this method plays the songs starting from the head of the list
        if (head != null) {
            System.out.println("Now playing: " + "\n"
                    + head.data.toString());
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    public Song playNext(int pos) {// traverses the list from the head
        // Check if the specified position is out of range
        if (pos <= 0 || pos >= size) {
            return null; // Return null if the position is invalid
        }

        Node current = head;
        int count = 0;

        // Move to the song at the specified position
        while (count < (pos - 1)) {
            current = current.next;
            count++;
        }

        // Check if there's a song after the current one
        if (current.next != null) {
            System.out.println(">>> Now playing... " + "\n"
                    + current.next.data.toString());
            return current.next.data;// return the data(song) stored in the node of the one after current
        } else {
            System.out.println("End of playlist");
            return null; // Return null if there's no next song
        }
    }

    public Song playPrev(int pos) {// This method also uses similar operation to traverse the linkedlist, but
                                   // instead of finding the next node from current, it finds and returns the
                                   // previous, it also traverses from the tail
        if (pos <= 0 || pos > size) {
            return null;
        }

        Node current = tail; // Start from the tail
        int count = size;

        while (count > pos) {
            current = current.prev;
            count--;
        }

        if (current.prev != null) {
            System.out.println("<<< now playing... " + "\n"
                    + current.prev.data.toString());
            return current.prev.data;
        } else {
            System.out.println("End of playlist");
            return null;
        }
    }

    public void shuffle() {
        // Check if there are less than 2 songs in the playlist
        if (size < 2) {
            System.out.println("Not enough songs to shuffle.");
            return; // Exit the method if there are not enough songs to shuffle
        }

        // Create an array to temporarily store songs
        Song[] songsArray = new Song[size];
        Node current = head;
        int count = 0;

        // Iterate through the playlist and store songs in the array
        while (current != null) {
            songsArray[count] = current.data;
            current = current.next;
            count++;
        }

        // Shuffle the array of songs
        List<Song> songList = Arrays.asList(songsArray);
        Collections.shuffle(songList);
        songsArray = songList.toArray(new Song[0]);

        // Update the playlist with the shuffled songs
        current = head;
        count = 0;

        while (current != null) {
            current.data = songsArray[count];
            current = current.next;
            count++;
        }

        // Print a message to indicate that the playlist has been shuffled
        System.out.println("Playlist shuffled.");
    }

    public void displayPlaylist() {// This method loops through the linkedlist and displays the data in every
                                   // single node
        if (size == 0) {
            System.out.println("The playlist is empty.");
        } else {

            System.out.println("_______________________PLAYLIST_______________________");
            Node current = head;
            int count = 1;

            while (current != null) {
                Song song = current.data;
                System.out.println("# " + count + " on playlist");
                System.out.println("Title: " + song.getTitle());
                System.out.println("Artist: " + song.getArtist());
                System.out.println("Album: " + song.getAlbum());
                System.out.println("Duration: " + song.getDuration() + " seconds");
                System.out.println("______________________________________________________");
                current = current.next;
                count++;

            }
        }
    }

}

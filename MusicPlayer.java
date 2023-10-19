import java.util.Scanner;

public class MusicPlayer {
    public static void main(String[] args) {
        DoublyLinkedList favorites = new DoublyLinkedList();
        Scanner input = new Scanner(System.in);
        int userOption;

        System.out.println("_____MY PLAYLIST_____");
        System.out.println("1. Add song to playlist");
        System.out.println("2. Remove song from playlist");
        System.out.println("3. Play song");
        System.out.println("4. Play next song");
        System.out.println("5. Play previous song");
        System.out.println("6. Shuffle songs");
        System.out.println("7. Display songs");
        System.out.println("8. Exit");
        System.out.println("Enter option...");

        while (input.hasNextInt()) {
            userOption = input.nextInt();
            if (userOption >= 0 && userOption <= 7) {
                if (userOption == 1) {
                    addSongsLoop(input, favorites);
                } else if (userOption == 2) {
                    System.out.print("Enter song to be deleted's position on list: ");
                    int pos = input.nextInt();
                    favorites.removeSong(pos);
                } else if (userOption == 3) {
                    favorites.play();
                } else if (userOption == 4) {
                    System.out.print("Enter current song's position on list >>>: ");
                    int pos = input.nextInt();
                    favorites.playNext(pos);
                } else if (userOption == 5) {
                    System.out.print("Enter current song's position on list <<<: ");
                    int pos = input.nextInt();
                    favorites.playPrev(pos);
                } else if (userOption == 6) {
                    favorites.shuffle();
                } else if (userOption == 7) {
                    favorites.displayPlaylist();
                } else {
                    break;
                }
                System.out.println("Enter another option or 8 to exit: ");
            } else {
                System.out.println("Invalid input. Please enter a valid option from the menu:");
            }
        }

    }

    private static void addSongsLoop(Scanner input, DoublyLinkedList favorites) {
        while (true) {
            String title;
            String artist;
            String album;
            int duration;

            System.out.print("Enter song title: ");
            title = input.next();

            System.out.print("Enter artist: ");
            artist = input.next();

            System.out.print("Enter album: ");
            album = input.next();

            while (true) {
                System.out.print("Enter duration: ");
                if (input.hasNextInt()) {
                    duration = input.nextInt();
                    break;

                } else {
                    System.out
                            .println("Invvalid input, please enter an interger for the duration of song in seconds: ");
                    input.next();
                }
            }

            Song newSong = new Song(title, artist, album, duration);
            favorites.addSong(newSong);

            System.out.print("Would you like to add another song? (y/n): ");
            String anotherInput = input.next();
            System.out.println(" ");
            if (!"y".equalsIgnoreCase(anotherInput)) {
                break;
            }
        }
    }
}

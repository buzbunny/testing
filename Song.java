public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return "______________________________________________________________" + "\n" +
                "Title: " + title + "\n" +
                "Artist: " + artist + "\n" +
                "Album: " + album + "\n" +
                "Duration: " + duration + " seconds" + "\n" +
                "_____________________________________________________________";
    }

}

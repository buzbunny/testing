public class Cache {
    private int maxSize;
    private int ID;
    private String storedData;

    public Cache(int maxSize, int ID, String storedData) {
        this.maxSize = maxSize;
        this.ID = ID;
        this.storedData = storedData;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStoredData() {
        return storedData;
    }

    public void setStoredData(String storedData) {
        this.storedData = storedData;
    }

    public String toString() {
        return "______________________________________________________________" + "\n" +
                "ID: " + ID + "\n" +
                "Maximun Size: " + maxSize + "\n" +
                "Stored Data : " + storedData + "\n" +
                "______________________________________________________________";
    }
}

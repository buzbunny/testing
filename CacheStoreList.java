public class CacheStoreList {
    cNode head;
    cNode tail;
    int size;

    public CacheStoreList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addItem(Cache cache) { // Method to add items to the cache library from the head of the linked list
        cNode newNode = new cNode(cache);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public Cache getItem(int ID) {
        cNode current = head;

        // Iterate through the linked list to find the item with the specified ID
        while (current != null) {
            if (current.data.getID() == ID) {
                if (current != head) {
                    // Only update references if the item is not already at the front
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } // first remove the node from its current location and link the surrounding
                      // nodes

                    current.next = head;
                    current.prev = null;
                    head = current;
                    // move the current node to occupy the head
                }
                System.out.println("Here is the data you requested" + "\n"
                        + head.data.toString());// returns the data in the node whether the node was already at the
                                                // head,
                                                // or
                                                // that
                                                // the inner loop ran in order to place it there
                return head.data;
            }

            current = current.next;
        }

        return null;// When data with the ID is not found

    }

    public void evictLeastUsedItem() {
        if (head == null && tail == null) {
            System.out.println("No item evicted, the library is empty.");
        } else if (tail != null) {
            tail.data.toString();
            System.out.println(" ");
            tail = tail.prev; // Update the tail to the previous node, effectively evicting the least used
                              // item
            tail.next = null; // Disconnect the next node from the current tail
            size--;
            System.out.println("Least used item has been successfully evicted");
        }
    }

    public void displayCacheLibrary() { // This method loops through the linkedlist and displays the data in every
                                        // single node
        if (size == 0) {
            System.out.println("The library is empty.");
        } else {

            System.out.println("_______________________CACHE LIBRARY____________________");
            cNode current = head;
            int count = size;

            while (current != null) {
                Cache cache = current.data;
                System.out.println("# " + count + " in library");
                System.out.println("ID: " + cache.getID());
                System.out.println("Maximum size: " + cache.getMaxSize());
                System.out.println("Data: " + cache.getStoredData());
                System.out.println("________________________________________________________");

                current = current.next;
                count--;

            }
        }
    }
}

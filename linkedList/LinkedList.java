import java.io.*;

public class LinkedList {
    private Node head;

    public void insert(int key) {
        if(head == null) {
            head = new Node(key);
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(key);
        }
    }

    public void printAll() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.key);
            cur = cur.next;
        }
    }

    public void deleteKey(int key) {
        /*
            if 
                head has key, move head to next node.
            else
                for each node in list
                    if node.next.key has key
                        node.next = node.next.next
        */
        Node cur = head;
        if (cur.key == key) {
            head = cur.next;
        } else {
            while (cur.next != null && cur.next.key != key) {
                cur = cur.next;
            }
            if (cur.next != null && cur.next.key == key) {
                cur.next = cur.next.next;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        LinkedList ll = new LinkedList();
        while (num-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            ll.insert(temp);
        }

        System.out.println("Deleting now");
        int key = Integer.parseInt(br.readLine());
        ll.deleteKey(key);
        System.out.println("Printing");
        ll.printAll();
    } 
}
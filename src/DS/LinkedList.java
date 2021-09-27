package DS;

public class LinkedList<T> {

    Node<T> head;

    public int length = 0;

    static class Node<T> {

        T val;
        Node<T> next;

        public Node(T val)
        {
            this.val = val;
            this.next = null;
        }
    }

    public void insert(T data)
    {
        Node<T> new_node = new Node<>(data);
        if (this.head == null)  this.head = new_node;
        else {
            Node<T> last = this.head;
            while (last.next != null) last = last.next;
            last.next = new_node;
        }
        ++this.length;
    }

    public void printList()
    {
        Node<T> currNode = this.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.val + " ");

            currNode = currNode.next;
        }
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.printList();
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int len;
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= len) {
            return -1;
        }
        Node curr = head;
        for(int i = 0 ; i < index ; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        len++;
        Node x = new Node(val);
        x.next = head;
        head = x;
        if(head.next == null) tail = head;
    }
    
    public void addAtTail(int val) {
        len++;
        Node x = new Node(val);
        if(head == null) {
            head = x;
            tail = x;
        }else{
            tail.next = x;
            tail  =  x;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > len) {
            return; // Invalid index
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if(index == len){
            addAtTail(val);
            return;
        }
        len++;
        Node curr = head;
        for(int i = 0 ; i < index - 1 ; i++){
                curr = curr.next;
        }
        Node temp = new Node(val);
        temp.next = curr.next;
        curr.next = temp;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) {
            return; // Invalid index
        }
        len--;
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        if(curr.next == null){
            tail = curr;
        }
    }
}
class Node{
    Node next;
    int val;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
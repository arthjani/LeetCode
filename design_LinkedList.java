class LL {
 
   Node head;
   private int size;
 
   LL () {
       size = 0;
   }
 
   public class Node {
       String data;
       Node next;
 
       Node(String data) {
           this.data = data;
           this.next = null;
           size++;
       }
   }
 
   public void addFirst(String data) {
       Node newNode = new Node(data);
       newNode.next = head;
       head = newNode;
   }
 
   public void addLast(String data) {
       Node newNode = new Node(data);
 
       if(head == null) {
           head = newNode;
           return;
       }
 
       Node lastNode = head;
       while(lastNode.next != null) {
           lastNode = lastNode.next;
       }
 
       lastNode.next = newNode;
   }
 
   public void printList() {
       Node currNode = head;
 
       while(currNode != null) {
           System.out.print(currNode.data+" -> ");
           currNode = currNode.next;
       }
 
       System.out.println("null");
        }
 
   public void removeFirst() {
       if(head == null) {
           System.out.println("Empty List, nothing to delete");
           return;
       }
 
       head = this.head.next;
       size--;
   }
 
   public void removeLast() {
       if(head == null) {
           System.out.println("Empty List, nothing to delete");
           return;
       }
 
       size--;
       if(head.next == null) {
           head = null;
           return;
       }
 
       Node currNode = head;
       Node lastNode = head.next;

        while(lastNode.next != null) {
           currNode = currNode.next;
           lastNode = lastNode.next;
       }
 
       currNode.next = null;
   }
 
   public int getSize() {
       return size;
   }
public static void main(String args[]) {
       LL list = new LL();
       list.addLast("is");
       list.addLast("a");
       list.addLast("list");
       list.printList();
 
       list.addFirst("this");
       list.printList();
       System.out.println(list.getSize()); 
 
       list.removeFirst();
        list.printList();
 
       list.removeLast();
       list.printList();
   }
}
public void addInMiddle(int index, String data) {
       if(index > size || index < 0) {
           System.out.println("Invalid Index value");
           return;
       }
       size++;
 
       Node newNode = new Node(data);
       if(head == null || index == 0) {
           newNode.next = head;
           head = newNode;
           return;
       }
        Node currNode = head;
       for(int i=1; i<size; i++) {
           if(i == index) {

 Node nextNode = currNode.next;
               currNode.next = newNode;
               newNode.next = nextNode;
               break;
           }
           currNode = currNode.next;
       }
   }




//



class MyLinkedList {
    Node head;
    int size;
    
    class Node{
        int val;
        Node next;
        
        Node(int val){
            this.val=val;
        }
    }

    public MyLinkedList() {
        size=0;
        head = new Node(0);
    }
    
    public int get(int index) {
        
       if (index < 0 || index >= size) return -1;
        
        Node curr = head;
        for(int i = 0; i<index+1;++i) curr=curr.next;
        return curr.val;
        
    }
    
    public void addAtHead(int val) {
        // Node newNode = new Node(val);
        // size++;
        // if (head==null){
        //     head=newNode;
        // }
        // newNode.next=head;
        // newNode=head;
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
//          Node newNode = new Node(val);
//         size++;
         
//          if (head==null){
//             head=newNode;
//         }
//         Node currNode=head;
//         while(currNode!=null){
//             currNode=currNode.next;
//         }
//        currNode.next=newNode;
         addAtIndex(size, val);
        
    }
    
    public void addAtIndex(int index, int val) {
        
        if(index>size) return;
        
        if(index<0) index=0;
        size++;
        
        Node pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;
         
        Node toAdd = new Node(val);
        toAdd.next= pred.next;
        pred.next=toAdd;
        
        
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
         Node pred = head;
    for(int i = 0; i < index; ++i) pred = pred.next;
         pred.next = pred.next.next;
        
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
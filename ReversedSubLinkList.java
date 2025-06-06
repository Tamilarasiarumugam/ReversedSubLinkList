package assignments;

public class ReversedSubLinkList { 
	  
    static Node head; 
  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  
    
    static Node reverse(Node node) 
    { 
        Node prev = null; 
        Node current = node; 
          
        while (current != null) { 
            Node next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    } 
    
static  Node reverseBetween(Node head, int m, int n) 
{ 
    if (m == n) 
        return head; 
  
   
    Node revs = null, revs_prev = null; 
    Node revend = null, revend_next = null; 
  
    
    int i = 1; 
    Node curr = head; 
    while (curr!=null && i <= n) { 
        if (i < m) 
            revs_prev = curr; 
        if (i == m) 
            revs = curr; 
        if (i == n) { 
            revend = curr; 
            revend_next = curr.next; 
        } 
        curr = curr.next; 
        i++; 
    } 
    revend.next = null; 
     
    revend = reverse(revs); 
    
    if (revs_prev!=null) 
        revs_prev.next = revend; 
   
    else
        head = revend; 
    revs.next = revend_next; 
    return head; 
} 
     
    void printList(Node node) 
    { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
   
    public static void main(String[] args) 
    { 
        ReversedSubLinkList list = new ReversedSubLinkList(); 
        list.head = new Node(10); 
        list.head.next = new Node(20); 
        list.head.next.next = new Node(30); 
        list.head.next.next.next = new Node(40); 
        list.head.next.next.next.next = new Node(50); 
        list.head.next.next.next.next.next = new Node(60); 
        list.head.next.next.next.next.next.next = new Node(70); 
        
        reverseBetween(head,3,6); 
        
        list.printList(head); 
          
    } 
} 



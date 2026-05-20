class node{                  //printing all elements of a linked list using recursion
    int val;
    node next;
    node(int val){
        this.val = val;
    }
}
public class Main{
    public static void printrecursive(node head) {
        if(head==null){
            return;
        }
        System.out.println(head.val);
        printrecursive(head.next);

    }
    public static void main(String[] args){
        node a = new node(20);
        node b = new node(30);
        node d = new node(40);
        node e = new node(50);
        node f = new node(60);
        node g = new node(70);
        a.next = b;
        b.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        printrecursive(b);
    }
}

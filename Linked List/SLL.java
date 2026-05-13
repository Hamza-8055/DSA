class Dnode {
    //creating linked list and linking nodes with each other
    int val;
    Dnode next;
    Dnode prev;

    Dnode(int val) {
        this.val = val;
    }
}

public class Main{
    public static void print(Dnode head) {

        Dnode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static void main(String[] args){
        node  a = new node(20);
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
        print(b);
    }
}


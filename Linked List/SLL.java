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

package LinkedList;              //implemented linked list by self

class SLL{
    node head;
    node tail;
    int size;

    void insertAthead(int val){
        node temp = new node(val);
        if(head==null){
            head=tail=temp;
        }else{
            temp.next = head;
            head = temp;
        }
        size++;
    }
    void inserAttail(int val){
        node temp = new node(val);
        if(head==null){
            head=tail=temp;
        }else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }
    void display(){
        node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    void inserAtidx(int idx, int val){
        node temp = new node(val);
        if(idx==0){
            insertAthead(val);
            return;
        }
        if(idx==size){
            inserAttail(val);
            return;
        }
        if(idx>size){
            System.out.println("Error!");
        }
        node x = head;
        for(int i = 0; i<idx-1;i++){
            x = x.next;
        }
        temp.next = x.next;
        x.next = temp;
        size++;

    }
    int getElement(int idx) throws Error{
        node temp = head;
        if(idx>=size || idx<0){
            throw new Error("Invalid index!");

        }

        for(int i = 0; i<idx;i++){
            temp = temp.next;
        }
        return temp.val;

    }
    void setelement(int idx, int val){

        if(idx >= size || idx<0){
            System.out.println("Error!");
        }

        node temp = head;
        for(int i = 0; i<idx;i++){
            temp = temp.next;
        }
        temp.val = val;
    }

    void deleteelement(int idx){
        node temp = head;
        if(idx==0){
            head = temp.next;
            size--;
            return;
        }
        for(int i = 0; i<idx-1; i++){
            temp = temp.next;
        }
        if(temp.next==tail){
            tail = temp;
        }
        temp.next = temp.next.next;
        size--;
    }
    void size(){
        System.out.println(size);
    }

}

public class Main {
    public static void main(String[] args) {
        SLL ll = new SLL();
        ll.insertAthead(30);
        ll.insertAthead(40);
        ll.insertAthead(50);
        ll.display();
        ll.inserAtidx(1, 100);
        ll.display();
        ll.inserAtidx(3, 200);
        ll.display();
        ll.inserAtidx(5, 300);
        ll.display();
        System.out.println(ll.getElement(3));
        ll.setelement(4, 240);
        ll.display();
        ll.deleteelement(5);
        ll.display();
        ll.size();
        System.out.println(ll.tail.val);
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {   //finding middle element(two pass solution-not so good)
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;

        }
        int mid = len/2 + 1;
        temp = head;
        for(int i = 0; i<mid-1;i++){
            temp = temp.next;
        }
        return temp;
    }
}

class Solution {             //finding middle elemrnt (one pass solution- good)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

void middlenode(){   //finding the left middle node of the linked lists
    if(head==null){
        System.out.println("Error!");
    }
    node fast = head;
    node slow = head;
    while(fast.next != null && fast.next.next !=null ){
        slow = slow.next;
        fast = fast.next.next;
    }
    System.out.println(slow.val+" ");
}

class Solution {        //deleting nth node from last(len-n+1)th nodde from start(basic method)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }

        if(len==n){
            head = head.next;
            return head;
        }
        temp = head;
        for(int i = 1; i<=len-n-1;i++){             //loop will run only len-n-1 times
            temp = temp.next;

        }
        temp.next = temp.next.next;
        return head;
    }
}

class Solution {        //deleting nth node from last(len-n+1)th node from start(slow/fast method)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 1; i<=n;i++){
            fast = fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;


    }
}

class Solution {             //swapping the values of kth node from both side
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i = 1; i<k;i++){
            fast = fast.next;
        }
        ListNode a = fast;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        int temp = a.val;
        a.val = slow.val;
        slow.val = temp;

        return head;
    }
}

public class Solution {                    //finding the intersection of the two ll
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0;
        int lenB = 0;
        while(tempA != null){
            tempA = tempA.next;
            lenA++;
        }
        while(tempB != null){
            tempB = tempB.next;
            lenB++;
        }
        tempA = headA;
        tempB = headB;
        if(lenA>lenB){
            for(int i = 1; i<=lenA-lenB;i++){
                tempA = tempA.next;
            }
        }else{
            for(int i = 1; i<=lenB-lenA;i++){
                tempB = tempB.next;
            }
        }
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}

public class Solution {        //cycle in the linkedlist
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}

public class Solution {       //detecting position from which the cycle starts
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null || head.next==null){
            return null;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return null;
        }
        ListNode temp = head;
        while(temp != slow){
            slow = slow.next;
            temp = temp.next;
        }
        return slow;

    }
}

class Solution {             //removing duplicate elements from the LL
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null){
            return null;
        }
        while(fast != null){
            if(slow.val==fast.val){
                fast = fast.next;
            }else{
                slow.next = fast;
                slow = fast;
            }
        }
        slow.next = fast;
        return head;

    }

}

class Solution {                     //rotaing a LL from k
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        while(slow != null){
            slow = slow.next;
            len++;
        }
        k %= len;
        if(k==0){
            return head;
        }
        slow = head;
        for(int i = 1; i<=k;i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        ListNode h = slow.next;
        slow.next = null;
        head = h;
        return head;

    }

}

class Solution {                      //merging two sorted linked list
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode t1 = list1;
        ListNode t2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                temp.next = t1;
                t1 = t1.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        if(t1 == null){
            temp.next = t2;
        }else{
            temp.next = t1;
        }
        return dummy.next;
    }
}

class Solution {            //reversing ll using iterative method
    public ListNode reverseList(ListNode head) {
        if(head==null ){
            return head;
        }
        ListNode p = null;
        ListNode c = head;
        ListNode n = head;

        while(c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;

    }
}

class Solution {            //reversing ll using recursive method
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null ){
            return head;
        }
        ListNode a = head.next;
        ListNode newhead = reverseList(a);
        a.next = head;
        head.next = null;
        return newhead;

    }
}

class Solution {      // checking palindrone using brute force method
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null ){
            return head;
        }
        ListNode a = head.next;
        ListNode newhead = reverseList(a);
        a.next = head;
        head.next = null;
        return newhead;

    }
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode newhead = new ListNode(head.val);
        ListNode t1 = head.next;
        ListNode t2 = newhead;
        while(t1 != null){
            ListNode temp = new ListNode(t1.val);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }
        newhead = reverseList(newhead);
        t1 = head;
        t2 = newhead;
        while(t1 != null){
            if(t1.val != t2.val){
                return false;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return true;

    }
}

class Solution {      // checking palindrone using good method
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null ){
            return head;
        }
        ListNode a = head.next;
        ListNode newhead = reverseList(a);
        a.next = head;
        head.next = null;
        return newhead;

    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode j = reverseList(slow);
        ListNode i = head;
        while(j != null){
            if(i.val != j.val){
                return false;
            }
            i = i.next;
            j = j.next;
        }
        return true;
    }
}

class Solution {       //maximum twin sum of a ll
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null ){
            return head;
        }
        ListNode a = head.next;
        ListNode newhead = reverseList(a);
        a.next = head;
        head.next = null;
        return newhead;

    }
    public int pairSum(ListNode head) {
        if(head == null || head.next == null){
            return head.val;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode j = reverseList(slow);
        ListNode i = head;
        int sum = 0;

        while(j != null){
            int tempsum = i.val + j.val;
            if(tempsum > sum){
                sum = tempsum;
            }
            i = i.next;
            j = j.next;
        }
        return sum;
    }
}

class Solution {       //reversing the required part of the ll
    public void reverseList(ListNode head) {
        ListNode p = null;
        ListNode c = head;
        ListNode n = head;
        while(c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left==right){
            return head;
        }
        ListNode temp = head;
        ListNode a = null , b = null, c = null, d = null;
        int pos = 1;

        while(temp != null){
            if(pos == left-1){
                a = temp;
            }
            if(pos == left){
                b = temp;
            }
            if(pos == right){
                c = temp;
            }
            if(pos == right+1){
                d = temp;
            }
            temp = temp.next;
            pos++;
        }

        if(a != null){
            a.next = null;
        }
        if(c != null){
            c.next = null;
        }
        reverseList(b);
        if(a != null){
            a.next = c;
        }
        b.next = d;

        if(a==null){
            return c;
        }

        return head;
    }
}

class Solution {    //reordering a LL
    public ListNode reverseList(ListNode head) {
        if(head==null ){
            return head;
        }
        ListNode p = null;
        ListNode c = head;
        ListNode n = head;
        while(c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode t2 = slow.next;
        slow.next = null;

        t2 = reverseList(t2);
        ListNode t1 = head;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(t1 != null && t2 != null){
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;
            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }
        if(t1==null){
            temp.next = t2;
        }else{
            temp.next = t1;
        }
        head = dummy.next;

    }
}

class Solution {        //adding numbers of two ll
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;


        int carry = 0;

        while(l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
            }
            if(l2 != null){
                val2 = l2.val;
            }

            int num = val1 + val2 + carry;
            ListNode node = new ListNode(num%10);


            temp.next = node;
            temp = temp.next;

            if(num > 9) carry = 1;
            else carry = 0;


            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

        }

        if(carry == 1){
            ListNode node = new ListNode(1);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;

    }
}


class Solution {        //finding maximum and minimum distance b/w two critical points
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
        ListNode mid = head.next;
        ListNode right = head.next.next;

        int first = -1 , last = -1;
        int idx = 1;
        int arr[] = {-1,-1};
        int mindist = Integer.MAX_VALUE;

        while(right != null){
            if(mid.val<left.val && mid.val <right.val || mid.val>left.val && mid.val>right.val) {
                if(first == -1){
                    first = idx;
                }
                if(last != -1){
                    int dist = idx - last;
                    mindist = Math.min(mindist,dist);
                }
                last = idx;

            }
            idx++;
            left = left.next;
            mid = mid.next;
            right = right.next;

        }
        if(first == last ){
            return arr;
        }
        int maxdist = last-first;
        arr[0] = mindist;
        arr[1] = maxdist;

        return arr;

    }
}

class DLL{
    Dnode head;
    Dnode tail;
    int size;

    void display(){
        Dnode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void insertAttail(int val ){
        Dnode temp = new Dnode(val);
        if(size==0){
            head=tail=temp;
        }else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            size++;
        }
    }

    void insertAthead(int val){
        Dnode temp = new Dnode(val);
        if(size==0){
            head = tail = temp;
        }else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    void insertAtidx(int idx , int val){
        Dnode temp = new Dnode(val);
        Dnode x = head;
        for(int i = 0;i<idx-1;i++){
            x = x.next;
        }
        Dnode y = x.next;

        x.next = temp;
        temp.prev = x;
        temp.next = y;
        y.prev = temp;

        size++;
    }

    void deleteidx(int idx){
        if(idx==0){
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        if(idx == size-1){
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        Dnode temp = head;
        for(int i = 0; i<idx-1;i++){
            temp = temp.next;

        }
        temp.next = temp.next.next;
        temp = temp.next;
        temp.prev = temp.prev.prev;
        size--;

    }

}
public class Main{

    public static void main(String[] args){
        DLL list = new DLL();

        list.insertAthead(20);
        list.insertAthead(30);
        list.insertAthead(40);
        list.insertAthead(50);
        list.display();
        list.insertAttail(60);
        list.display();
        list.insertAtidx(2,100);
        list.display();
        list.deleteidx(0);
        list.display();
    }
}

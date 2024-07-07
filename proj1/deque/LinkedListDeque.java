package deque;

public class LinkedListDeque<T> implements Deque<T> {
    public class TNode {
        public TNode pre;
        public T data;
        public TNode next;

        public TNode(T d, TNode p, TNode n) {
            data = d;
            pre = p;
            next = n;
        }
    }

    private TNode first;
    private TNode last;
    private int size;

    public LinkedListDeque() {
        first = new TNode(null, null, null);
        last = new TNode(null, null, null);
        first.next = last;
        last.pre = first;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        size += 1;
//        TNode tmp = first.next;
//        first.next = new TNode(item, first, tmp);
//        tmp.pre = first.next;
        TNode tmp = new TNode(item, null, null);
        tmp.next = first.next;
        tmp.pre = first;
        first.next.pre = tmp;
        first.next = tmp;

    }

    @Override
    public void addLast(T item) {
        size += 1;
//        TNode tmp = last.pre;
//        last.pre =  new TNode(item, tmp, last);
//        tmp.next = last.pre;
        TNode tmp = new TNode(item, null, null);
        tmp.pre = last.pre;
        tmp.next = last;
        last.pre.next = tmp;
        last.pre = tmp;
    }

//    @Override
//    public boolean isEmpty() {
//        if(size==0)
//            return true;
//        else
//            return false;
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        TNode p = first;
        for(int i=1; i<size; i++) {
            System.out.print(p.next.data + " ");
            p = p.next;
        }
        System.out.println(p.data);
    }

    @Override
    public T removeFirst() {
        if(size==0)
            return null;
        else {
            size--;
            T tmp = first.next.data;
            first.next = first.next.next;
            if(first.next != null) {
                first.next.pre = first;
            }
            return tmp;
        }
    }

    @Override
    public T removeLast() {
        if(size==0)
            return null;
        else {
            size--;
            T tmp = last.pre.data;
            last.pre = last.pre.pre;
            last.pre.next = last;
            return tmp;
        }
    }

    @Override
    public T get(int index) {
        if(index>size)
            return null;
        TNode p = first;
        for(int i=0; i<index; i++) {
            p = p.next;
        }
        return p.next.data;
    }

    public T getRecursiveHelper(int index, TNode t) {
        if(index>size)
            return null;
        if(index==0)
            return t.next.data;
        else
            return getRecursiveHelper(index-1, t.next);
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, first);
    }
}

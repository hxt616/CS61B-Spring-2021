package deque;

public class ArrayDeque<T> implements Deque<T> {
    private T[] list;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        size = 0;
        first = last = 0;
        list = (T[])new Object[8];
    }

    public void resizing(int container) {
        T[] a = (T[]) new Object[container];
        for(int i=0; i<size; i++) {
            a[i] = list[(first+i)%list.length];
        }
        list = a;
        first = 0;
        last = size-1;
    }

    @Override
    public void addFirst(T item) {
        if (size == list.length) {
            resizing(size * 2);
        }
        list[first] = item;
        first = (first-1+list.length)%list.length;
        size+=1;
    }

    @Override
    public void addLast(T item) {
        if (size == list.length) {
            resizing(size * 2);
        }
        list[last] = item;
        last = (last+1)% list.length;
        size+=1;
    }

//    @Override
//    public boolean isEmpty() {
//        if(size==0)
//            return true;
//        return false;
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int i = first;
        while(i!=(last-1)%list.length) {
            System.out.println(list[i]+" ");
            i = (i+1)%list.length;
        }
        System.out.println(list[(last-1)%list.length]);
    }

    @Override
    public T removeFirst() {
        if(size < list.length/4 && (list.length >= 16)) {
            resizing(size+1);
        }
        if(isEmpty())
            return null;

        size-=1;
        T tmp = list[(first+1) % list.length];
        first = (first+1)% list.length;
        return tmp;

    }

    @Override
    public T removeLast() {

        if(size < list.length/4 && (list.length >= 16)) {
            resizing(size+1);
        }
        if(isEmpty())
            return null;
        else {
            size-=1;
            T tmp = list[(last + list.length -1) % list.length];
            last = (last + list.length - 1)% list.length;
            return tmp;
        }
    }

    @Override
    public T get(int index) {
        if(index>size)
            return null;
        else
            return list[(first+index)%list.length];
    }


}

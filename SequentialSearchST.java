import java.util.ArrayList;
public class SequentialSearchST<Key, Value> {
    /**
     * Initializes an empty symbol table.
     */
    Node head;
    int size;

    public class Node{
        public Key key;
        public Value val;
        public Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }

    }
    

    
    public SequentialSearchST() {


    
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return size;
    
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty( ) {
        if(size()==0){
            return true;
        }
        else{
            return false;
        }
    
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if(key==null) throw new IllegalArgumentException ("Contais null value");
        return  get(key) !=null;
    
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if(key ==null) throw new IllegalArgumentException("It contains null value");
        for (Node newest = head; newest != null; newest = newest.next) {
            if (key.equals(newest.key))
                return newest.val;
        }
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if(key==null) throw new IllegalArgumentException("The symboltable is empty");
        if (val == null) {
            delete(key);
            return;
        }
        for (Node newest = head; newest != null; newest = newest.next) {
            if (key.equals(newest.key)) {
                newest.val = val;
                return ;
            }
        }
        head = new Node(key, val, head);
       
        size++;
    
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete( Key key) {
        if(size== 0) throw new IllegalArgumentException("Symbol table is empty. NOTHING to delete");
       head = delete(head, key);


    
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node newest, Key key) {

        if(key.equals(newest.key)){
            size--;
            return newest.next;
          
        }
        newest.next=delete(newest.next, key);
        return newest;

    
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys()  {
        ArrayList<Key> array = new ArrayList <Key>();
        for (Node newest = head; newest != null; newest = newest.next)
           array.add(newest.key);
        return array;
    }
    /**
         main method
     */
    public static void main(String[] args) {

        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        st.put("bhutan", 1);
        st.put("india", 2);
        st.put("bhutan", 1);
        st.put("chaina",5);
        st.delete("chaina");

        assert(st.isEmpty() == false);



       st.put("a",8);
       st.delete("a");
       System.out.println(st.keys());

        
       System.out.println(st.isEmpty());
       System.out.println(st.size());
       System.out.println("All test passed");
        

        
    }
}
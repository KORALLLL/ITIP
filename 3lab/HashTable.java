import java.util.LinkedList;

public class HashTable<K, V>{ //generic(обобщённый) class. V, k - parameterized types. I can use different types in this hash table in the future
    private static final int DEFAULT_CAPACITY = 10;
    private LinkedList<Entry<K, V>>[] table; 
    //our hashtable is Linkedlist LinkedLists with Entry<K, V> as type.
    // class Entry<K, V> returns value V using key K
    private int size;

    public HashTable(){
        this(DEFAULT_CAPACITY); //call of the constrcutor with arguments
    }

    public HashTable(int capacity){
        table = new LinkedList[capacity]; //creating table and value adjusting
        size = 0;
    }

    private int hash(K key){ //generate hash values for
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value){
        int index = hash(key);
        if (table[index]==null){
            table[index] = new LinkedList<>();
        } //if element doesnt exist i create element as LinkedList

        for (Entry<K, V> entry:table[index]){//iteration
            if (entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }//if keys equal i update value
        }
        table[index].add(new Entry<K, V>(key, value));
        size++; //if keys doesnt equal i add values using chain method
    }

    public V get(K key){
        int index = hash(key);
        LinkedList<Entry<K, V>> subLinkedList = table[index];
        if (subLinkedList != null){
            for (Entry<K, V> entry: subLinkedList){
                if (entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key){
        int index = hash(key);
        LinkedList<Entry<K, V>> subLinkedList = table[index];
        if (subLinkedList != null){
            for (Entry<K, V> entry: subLinkedList){
                if (entry.getKey().equals(key)){
                   subLinkedList.remove(entry);
                   size--;
                   return;
                }
            }
        }
    }

    public int getSize(){
        return size;
    }

    public boolean getIsEmpty(){
        return size==0;
    }



    private static class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue(){
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }
    }

    public static void main(String[] args){
        HashTable<String, Book> library = new HashTable<>();
        System.out.println(library.getIsEmpty());

        Book book1 = new Book("978-5-8159-1709-5", "Бакунин", "Роман Гуль", 5000);
        
        library.put(book1.getIsbn(), book1);
        System.out.println(library.getSize());
        Book foundedBook = library.get(book1.getIsbn());
        if (foundedBook!=null){
            System.out.print(foundedBook.getTitle()+" "+foundedBook.getAuthor()+" "+foundedBook.getCopies()+"\n");
        }
        else{
            System.out.println("the book isnt found");
        }
        System.out.println(library.getIsEmpty());

        library.remove(book1.getIsbn());
        System.out.println(library.getSize());

        Book removedBook = library.get(book1.getIsbn());
        if (removedBook!=null){
            System.out.print(removedBook.getTitle()+" "+removedBook.getAuthor()+" "+removedBook.getCopies()+"\n");
        }
        else{
            System.out.println("the book isnt found");
        }
        System.out.println(library.getIsEmpty());
    }
}

class Book{
    private String isbn;
    private String title;
    private String author;
    private int copies;

    public Book(String isbn, String title, String author, int copies){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getCopies(){
        return copies;
    }

    public void setIsbn(String isbn_val){
        isbn = isbn_val;
    }

    public void setTitle(String title_val){
        title = title_val;
    }

    public void setAuthor(String author_val){
        author = author_val;
    }

    public void setCopies(int copies_val){
        copies = copies_val;
    }
}
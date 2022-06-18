
//ArrayList
        ArrayList list=new ArrayList();


        list.add("mary");
        list.add(23);
        list.add(true);
        System.out.println(list);

//list
String tag = "tag1,tag2";
String[] tags = target.split(",");

list<Stirng> list = Lists.newArrayList(tags);
        for (String item : list) {
            System.out.println(item);

          
//LinkedList
    public LinkedList() {
        header.next = header.previous = header;
    }
    public LinkedList(Collection<? extends E> c) {
	this();
	addAll(c);
    }
          
//Map

public class MapTest {
    HashMap<String, String> myMap = new HashMap<String, String>() {{
        put("aa", "a1");
        put("bb", "b1");

//HashMap
public HashMap(int initialCapacity, float loadFactor) {
    
    if (initialCapacity < 0)
        throw new IllegalArgumentException(Illegal initial capacity:  + initialCapacity);
    
    if (initialCapacity > MAXIMUM_CAPACITY)
        initialCapacity = MAXIMUM_CAPACITY;
        
    
    if (loadFactor <= 0 || Float.isNaN(loadFactor))
        throw new IllegalArgumentException(Illegal load factor:  + loadFactor);
                                           
    this.loadFactor = loadFactor;
    this.threshold = tableSizeFor(initialCapacity);
}

//TreeMap
TreeMap<String, String> treeMap = new TreeMap<>();
new TreeMap<String, Long>(new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
});








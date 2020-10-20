import Map.LinkedListMap;

public class LinkedListMapTest {
    public static void main(String[] args) {
        LinkedListMap<Integer, String> map = new LinkedListMap<Integer, String>();
        map.add(1,"zhang");
        map.add(2,"zhao");
        map.add(3,"qian");
        map.add(4,"sun");
        map.add(5,"li");
        map.add(6,"zhou");
        System.out.println(map);
        map.add(3, "qi");
        System.out.println(map);
        map.remove(3);
        System.out.println(map);
    }
}

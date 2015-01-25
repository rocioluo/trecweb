package edu.pitt.sis.infsci2140.index;
import java.util.HashMap;
import java.util.Map;
public class  TestMap {
public static void main(String[] args) {
System.out.println("start£º");
Map<Integer, String> map = new HashMap<Integer, String>();
map.put(220180, null);
map.put(220181, "mr");
System.out.println("get()result£º");
System.out.print("------ " + map.get(220180));
System.out.print("    " + map.get(220181));
System.out.println("    " + map.get(220182));
System.out.println("containsKey()result£º");
System.out.print("------ " + map.containsKey(220180));
System.out.print("    " + map.containsKey(220181));
System.out.println("    " + map.containsKey(220182));
System.out.println("end£¡");
}
}


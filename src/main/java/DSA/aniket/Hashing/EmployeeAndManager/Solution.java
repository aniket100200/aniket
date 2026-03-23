package DSA.aniket.Hashing.EmployeeAndManager;

import java.util.*;

public class Solution {

  class Node {
    String name;
    List<Node> child;
    boolean isCounted;
    int count = 0;

    public Node(String name) {
      this.child = new ArrayList<>();
      this.name = name;
      this.isCounted = false;
      this.count = 0;
    }

    public int getCount() {
      if (isCounted) return count;
      // get count of childs
      // System.out.println(this);
      int total = 0;
      for (Node node : child) {
        total += 1 + node.getCount();
      }

      this.isCounted = true;
      count = total;

      return total;
    }

    @Override
    public String toString() {
      String val = "{name : " + this.name + ", childs :[" + this.child + "]}";
      return val;
    }
  }

  public void EmpUnderManager(Map<String, String> emp) {
    Map<String, Node> map = new HashMap<>();

    for (String str : emp.keySet()) {
      String manager = emp.get(str);
      if (str.equals(manager)) {
        Node managerNode = map.getOrDefault(manager, new Node(manager));
        map.put(manager, managerNode);
        continue;
      }

      Node managerNode = map.getOrDefault(manager, new Node(manager));
      Node empNode = map.getOrDefault(str, new Node(str));
      managerNode.child.add(empNode);
      map.put(manager, managerNode);
      map.put(str, empNode);
    }

    for (String key : map.keySet()) {
      System.out.println(key + " " + map.get(key).getCount());
    }

    // It'll be creating

  }
}

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    n = sc.nextInt();
    Map<String, String> emp = new HashMap<String, String>();
    for (int i = 0; i < n; ++i) {
      emp.put(sc.next(), sc.next());
    }
    Solution Obj = new Solution();
    Obj.EmpUnderManager(emp);
  }
}

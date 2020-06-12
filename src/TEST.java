import java.util.*;
class Employee {
    private int id;
    private String name;
    Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    @Override
    public boolean equals(Object anObject) {
        if (!(anObject instanceof Employee)) {
            return false;
        }
        Employee otherMember = (Employee)anObject;
        return otherMember.getId() == this.getId();
    }
}
class Test {
    public static void main(String[] args) {
        List<Employee> A = createEmployeeList(1,2,3);
        List<Employee> B = createEmployeeList(1,2,4);
        List<Employee> cA = copyEmployeeList(A);
        List<Employee> cB = copyEmployeeList(B);
        List<Employee> intersectionA = copyEmployeeList(A);
        List<Employee> intersectionB = copyEmployeeList(B);
        List<Employee> intersection = intersection(intersectionA,intersectionB);
        List<Employee> union = union(intersectionA,intersectionB);

        System.out.print("A: ");print(A);
        System.out.print("B: ");print(B);
        System.out.print("A/B: ");A.removeAll(B);print(A);
        System.out.print("B/A: ");cB.removeAll(cA);print(cB);
        System.out.print("A^B: ");print(intersection);
        System.out.print("AUB: ");print(union);
    }
    private static void print(List<Employee> A) {
        System.out.print("[");
        for (int i = 0; i < A.size(); i++) {
            if (i == A.size()-1) {
                System.out.print(A.get(i).getId());
            } else {
                System.out.print(A.get(i).getId() +",");
            }
        }
        System.out.println("]");
    }
    private static List<Employee> differencesBetweenTwoArrays(List<Employee>e1,List<Employee>e2){
        e1.removeAll(e2);
        return e1;
    }

    private static List<Employee> createEmployeeList(int x,int y,int z){
        Employee e1   = new Employee(x, "Approved");
        Employee e112 = new Employee(y, "Approved");
        Employee e113 = new Employee(z, "Approved");
        return new ArrayList<Employee>(Arrays.asList(e1,e112,e113));
    }
    private static List<Employee> copyEmployeeList(List<Employee> employees){
        List<Employee> ee= new ArrayList<>();
        ee.addAll(employees);
        return ee;
    }
    private static  <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<T>(set);
    }

    private static <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();
        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
}

class Lis {

}
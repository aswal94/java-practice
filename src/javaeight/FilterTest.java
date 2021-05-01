package javaeight;

import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        new FilterTest().test();
    }

    public void test() {
        populateEmployees();
    }

    List<Employee> employeeList;

    public void populateEmployees() {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee("Amit Aswal", 20));
        employeeList.add(new Employee("Dheeraj Pundir", 23));
        employeeList.add(new Employee("Pappu Bahadur", 21));
        employeeList.add(new Employee("Anuj Rana", 20));
        employeeList.add(new Employee("Amit Rawat", 23));

        Arrays.asList()
        // filter list age > 20 then print names
        List<String> filteredList = employeeList.stream()
                .filter(employee -> employee.getAge() > 20)
                .map(Employee::getName) // method reference
                .collect(Collectors.toList());

        System.out.println(filteredList);

        // same (another approach)
        employeeList.stream()
                .filter(employee -> employee.getAge() > 20)
                .map(Employee::getName) // method reference
                .forEach(name -> System.out.println(name)); // consumer function


        //------------------------------
        // count employe with age > 20
        long count = employeeList.stream()
                .filter(e -> e.getAge() > 20)
                .count();
        System.out.println("Employe with age greater than 20: " + count);

        //---------------
        // find employee with name dheeraj
        Optional<Employee> e = employeeList.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase("Dheeraj Pundir"))
                .findAny();

        if (e.isPresent()) {
            System.out.println("Found: " + e.get().getName());
        }

        // --------------
        // find maximum age of employee
        OptionalInt max = employeeList.stream()
                .mapToInt(Employee::getAge)
                .max();

        if (max.isPresent()) {
            System.out.println("Max age: " + max.getAsInt());
        }

        // ------------
        // sort on basis of age

        System.out.println("Sorted by age");
        employeeList.sort((e1, e2) -> e1.getAge() - e2.getAge());
        employeeList.forEach(ex -> System.out.println(ex.getName() + ", " + ex.getAge()));

        // -------------------
        // join employees names with ","

        List<String> emloyeesNameList = employeeList.stream()
                .map(Employee::getName) // method references
                .collect(Collectors.toList());
        System.out.println("Names: " + String.join(",", emloyeesNameList));

        //--------------------------
        // given list of numbers square them -> filter them (>1000) -> find Average
        Integer[] arr = new Integer[]{100, 23, 13, 44, 53, 225, 40, 115};
        List<Integer> integerList = Arrays.asList(arr);
        OptionalDouble average = integerList.stream()
                .mapToInt(integer -> integer * integer)
                .filter(integer -> integer > 1000)
                .average();

        if (average.isPresent()) {
            System.out.println(average.getAsDouble());
        }

        // --------------
        // remove duplicates from an integer list
        // way 1 -> using set
        Integer[] xarr = new Integer[]{1, 2, 3, 2, 1, 4 ,5,1};

        List<Integer> listWithDuplicates = Arrays.asList(xarr);
        Set<Integer> setWithoutDup = listWithDuplicates.stream()
                .collect(Collectors.toSet());

        setWithoutDup.forEach(i -> System.out.println(i));

        // another way without using set
        List<Integer> noDup = listWithDuplicates.stream().distinct().collect(Collectors.toList());
                noDup.forEach(i -> System.out.println(i));
        //--------------
        // grouping elements by name

        Map<String, List<Employee>> empMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));

        empMap.forEach((name, empList) -> {
            System.out.print(name + ", ");
            empList.stream().forEach(exx -> System.out.println(exx.getName()));
        });

        // handling empty names
        employeeList.add(new Employee(null, 23));
        employeeList.add(new Employee("test", 20));

//        employeeList.stream()
//                .map(emp -> {
//                    if(emp.getName().equals(null)){
//                        emp.setName("");
//                    }
//                    return emp;
//                    );

    }
List<String> wordsList = new ArrayList<>();

    public int f(String prefix, String suffix) {

        Optional< fWord =
                wordsList.stream()
                        .filter(word -> word.startsWith(prefix) && word.endsWith(suffix))
                        .sorted((w1, w2) -> w1.length() > w2.length() ? -1 : 1)
                        .findFirst();

        if(foundWords.size() > 0){
            wordsList.indexOf(foundWords.get(0));
        }else{
            return -1;
        }
    }
}

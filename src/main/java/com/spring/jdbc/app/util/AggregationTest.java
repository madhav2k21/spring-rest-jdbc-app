package com.spring.jdbc.app.util;

public class AggregationTest {
    public static void main(String[] args) {
        aggregation();
    }

    private static void aggregation() {
        Address address = new Address();
        address.setAddrsLine1("Address Line-1");
        address.setAddrsLine2("Address Line-2");
        address.setCity("Hyderabad");
        address.setStreet("Vivekanada Nagar");

        Employee employee = new Employee();
        employee.setEmpId("101");
        employee.setFirstName("madhav");
        employee.setLastName("anupoju");
        employee.setAge(26);
        employee.setAddress(address);

        System.out.println(employee);
        employee = null;
        System.out.println(address);


    }
}

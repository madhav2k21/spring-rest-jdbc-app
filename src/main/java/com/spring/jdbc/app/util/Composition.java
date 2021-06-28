package com.spring.jdbc.app.util;

public class Composition {
    public static void main(String[] args) {
        composition();
    }

    private static void composition(){
        Person person=new Person();
        person.setId("101");
        person.setFirstName("madhav");
        person.setLastName("anupoju");
        person.getAddress().setAddrsLine1("AddressLine-1");
        person.getAddress().setAddrsLine2("AddressLine-2");
        person.getAddress().setCity("Hyderabad");
        person.getAddress().setStreet("Vivekananda Nagar");
        System.out.println(person);
        person=null;
        System.out.println("=================");
        System.out.println(person);
        if(null!=person){
            System.out.println(person.getAddress());
        }else{
            System.out.println("Address does not exist");
        }
    }
}

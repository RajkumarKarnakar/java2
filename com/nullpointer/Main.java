package com.nullpointer;

public class Main {
    public static void main(String[] args) {
        // ArrayList<Integer> list = null;
        // list.add(5);

        User user1 = new User("Rajkumar");
        System.out.println("name: "+user1.getName());
        System.out.println("address:"+user1.getAddress().getCity());


    }

} class User{
    String name;
    Address address;

    public User(String name) {
        this.address = null;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

}


class Address {
    String city;
    
        public Address(String address) {
            this.city = address;
        }
    
        public String getCity() {
            return city;
        }
    
    
    }

package org.example.Records;

record Person(int id, String name, int age, String address, String city, String state)  implements Employee {
    static String  companyname="abc";
    public void display() {
        System.out.println("id=" + id() + " name=" + name() + " age=" + age() + " address=" +
                address() + " city=" + city() + " state=" + state()+ " companyname=" + companyname);
    }

    @Override
    public void show() {
        System.out.println("Employee details");
    }


}

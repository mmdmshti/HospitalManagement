public class Person {
    static String name;
    static int age;
    static int id;


    void setName(String name){
        Person.name = name;

    }
     String getName(){
        return Person.name;
    }
    void setAge(int age){
        Person.age = age;
    }
    int getAge(){
        return Person.age;
    }
    void setID(int id){
        Person.id = id;

    }
    int getID(){
        return Person.id;
    }
}

package mypackage;

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Object type \"Person\"\n{name: " + name +"}";
    }


    public static void main(String[] args) {

    }
}
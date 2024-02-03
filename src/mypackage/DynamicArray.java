package mypackage;

import java.util.Arrays;

public class DynamicArray<T> {
        Object[] objectArray;
        int availableSpace;

    public DynamicArray(int availableSpace) {
        objectArray = new Object[availableSpace];
        this.availableSpace = availableSpace;
    }

    public void start(Class<T> elementType) {

        System.out.println("___________START OF PROGRAM___________\n\nCreated a dynamic array instance of type \""+ elementType.getName() +"\" with " + availableSpace + " available spaces");
    }

    public void printArray() {
        System.out.println("\nThe array looks like this:\n" + Arrays.toString(objectArray));
    }

    public void set(int index, T object) {
        objectArray[index] = object;
    }

    public void remove() {
        System.out.println("\nRemoved one index from the end of the array. Array length decreased from " + objectArray.length + " to " + (objectArray.length - 1) + " and the object:\n{\n" + objectArray[objectArray.length - 1] + "\n}\nwas removed." );

        Object[] newObjectArray = new Object[objectArray.length - 1];
        System.arraycopy(objectArray, 0, newObjectArray, 0, objectArray.length - 1);
        objectArray = newObjectArray;
    }

    public void remove(int index) {
        try {
            if(index > objectArray.length - 1) {
                throw new ArrayIndexOutOfBoundsException();
            }

            System.out.println("\nArray length decreased from " + objectArray.length + " to " + (objectArray.length - 1) + " and the object:\n" + objectArray[index] + "\nwas removed." );

            Object[] newObjectArray = new Object[objectArray.length - 1];

            if(index != 0) {
                System.arraycopy(objectArray, 0, newObjectArray, 0, index);
                System.arraycopy(objectArray, (index + 1), newObjectArray, index, objectArray.length - index - 1);
            } else {
                System.arraycopy(objectArray, 1, newObjectArray, 0, objectArray.length - 1);
            }

            objectArray = newObjectArray;

        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("\nCannot REMOVE index: " + index + " The array has indexes from 0 to " + (objectArray.length - 1) + " so index: " + index + " does not exist.");
        }
    }

    public int size() {
        int count = 0;

        for(int i = 0; i < objectArray.length; i++) {
            if(objectArray[i] != null) {
                count++;
            }
        }

        System.out.println("\nThis is the amount of objects in the array: " + count);

        return count;
    }

    public void add(T object) {
        Object[] newObjectArray = new Object[objectArray.length + 1];
        System.arraycopy(objectArray, 0, newObjectArray, 1, objectArray.length);
        objectArray = newObjectArray;
        objectArray[0] = object;

        System.out.println("\nAdded +1 index to the array. The length grew from " + (objectArray.length - 1) + " to " + objectArray.length);
    }

    public T get(int index) {
        try {
            if(index > objectArray.length - 1) {
                throw new ArrayIndexOutOfBoundsException();
            }

            @SuppressWarnings("unchecked")
            T element = (T) objectArray[index];

            System.out.println("\nThis is the " + index + " index object:\n" + element);

            return element;
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("\nCannot GET index: " + index + " The array has indexes from 0 to " + (objectArray.length - 1) + " so index: " + index + " does not exist.");

            return null;
        }
    }

    public void clear() {
        Object[] newObjectArray = new Object[objectArray.length];
        objectArray = newObjectArray;

        System.out.println("\nYou just cleared the array out. The entire array has null at every index.");
    }

    public static void main(String[] args) {
        DynamicArray<Person> myDynamicArray = new DynamicArray<>(3);
        myDynamicArray.start(Person.class);

        myDynamicArray.add(new Person("Daniel"));
        myDynamicArray.add(new Person("Oliver"));
        myDynamicArray.add(new Person("Anna"));

        myDynamicArray.set(0, new Person("NewDaniel"));
        myDynamicArray.remove();
        myDynamicArray.remove(1);
        myDynamicArray.size();
        myDynamicArray.get(0);
        myDynamicArray.clear();
        myDynamicArray.printArray();

        System.out.println("\n___________END OF PROGRAM___________");
    }
}
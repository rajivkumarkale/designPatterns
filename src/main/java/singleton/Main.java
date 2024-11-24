package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Serialization Example");
            exampleSerialization();

            System.out.println("Reflection Example");
            exampleReflection();
        }
        catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }

    private static void exampleSerialization() throws IOException, ClassNotFoundException {
        // 1. Breaking Singleton Pattern with serialization
        // i) Breaking
        LazySingleton lazySingleton = LazySingleton.getInstance();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("SingletonObject.obj"));
        objectOutputStream.writeObject(lazySingleton);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("SingletonObject.obj"));
        LazySingleton lazySingletonDeserialized = (LazySingleton) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("lazySingleton : " + lazySingleton.hashCode());
        System.out.println("lazySingletonDeserialized : " + lazySingletonDeserialized.hashCode());

        // ii) Fixing
        SerializableSingleton serializableSingleton = SerializableSingleton.getInstance();

        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream("SerializableSingletonObject.obj"));
        objectOutputStream1.writeObject(serializableSingleton);
        objectOutputStream1.close();

        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream("SerializableSingletonObject.obj"));
        SerializableSingleton serializableSingletonDeserialized = (SerializableSingleton) objectInputStream1.readObject();
        objectInputStream1.close();

        System.out.println("serializableSingleton : " + serializableSingleton.hashCode());
        System.out.println("serializableSingletonDeserialized : " + serializableSingletonDeserialized.hashCode());
    }

    private static void exampleReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
        // Knowing that we have only one constructor, so taking it using index
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);

        LazySingleton lazySingleton = (LazySingleton) constructor.newInstance();
        LazySingleton instance = LazySingleton.getInstance();

        // i) Breaking
        System.out.println(lazySingleton.hashCode());
        System.out.println(instance.hashCode());

        // ii) Fixing
        EnumSingleton.INSTANCE.doSomething();

        // iii) There is one more fix the Reflection problem , instead of using the enum Class:
        /*
            In the private constructor of our serializableSingleton class
            private SerializableSingleton() {
                // Prevent reflection from creating another instance
                if (instance != null) {
                    throw new IllegalStateException("Instance already exists");
                }
            }
         */
    }
}

package abstractfactory;

import abstractfactory.uifactory.MacOSFactory;
import abstractfactory.uifactory.WindowsFactory;

/*
    The Abstract Factory Design Pattern is an extension of the Factory Pattern.
        It provides a way to create families of related objects without specifying their concrete classes.

    Purpose
    => To create groups (or families) of related objects.
    => To ensure consistency between objects that belong to the same family.
 */
public class Main {
    public static void main(String[] args) {
        // Use Dependency Injection to get the factory dynamically
        GUIFactory factory = configureFactory();

        // Create the Application using the injected factory
        Application app = new Application(factory);

        // Render the UI components
        app.paint();
    }

    private static GUIFactory configureFactory() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return new WindowsFactory();
        }
        else if (osName.contains("mac")) {
            return new MacOSFactory();
        }
        else {
            throw new UnsupportedOperationException("Unsupported OS: " + osName);
        }
    }
}

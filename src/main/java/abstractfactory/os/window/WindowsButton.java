package abstractfactory.os.window;

import abstractfactory.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows Button drawn on Screen");
    }
}

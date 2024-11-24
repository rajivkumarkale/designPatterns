package abstractfactory.os.window;

import abstractfactory.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Windows Checkbox drawn on the screen");
    }
}

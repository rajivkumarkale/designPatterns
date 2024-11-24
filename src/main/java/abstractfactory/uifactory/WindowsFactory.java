package abstractfactory.uifactory;

import abstractfactory.Button;
import abstractfactory.Checkbox;
import abstractfactory.GUIFactory;
import abstractfactory.os.window.WindowsButton;
import abstractfactory.os.window.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

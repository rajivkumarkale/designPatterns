package abstractfactory.uifactory;

import abstractfactory.Button;
import abstractfactory.Checkbox;
import abstractfactory.GUIFactory;
import abstractfactory.os.mac.MacOSButton;
import abstractfactory.os.mac.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }

    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}

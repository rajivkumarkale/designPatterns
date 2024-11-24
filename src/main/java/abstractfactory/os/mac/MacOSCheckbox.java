package abstractfactory.os.mac;

import abstractfactory.Checkbox;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("MacOS Checkbox drawn on the Screen");
    }
}

package abstractfactory.os.mac;

import abstractfactory.Button;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("MacOS Button Drawn on Screen");
    }
}

package legacy;

import java.util.function.Consumer;

public class LoginContext {
    //This class is not suitable for being instantiated during tests.
    //It will create alot of other objects and try to open a connection to some external servers.
    public LoginContext(String login, Consumer<String> callBack) {
    }

    public void doThis() {
    }

    public void doThat() {
    }
}

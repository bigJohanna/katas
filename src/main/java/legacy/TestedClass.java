package legacy;

public class TestedClass {

//    private final LoginContextFactory loginContextFactory;
//
//    public TestedClass(final LoginContextFactory loginContextFactory) {
//        this.loginContextFactory = loginContextFactory;
//    }

    public LoginContext login(String user, String password) {
//        LoginContext lc = loginContextFactory.createLoginContext();
        LoginContext lc = new LoginContext("login", System.out::println);
        lc.doThis();
        lc.doThat();
        return lc;
    }
}

//interface LoginContextFactory {
//    LoginContext createLoginContext();
//}

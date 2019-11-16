package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonHooks {

    @Before()
    public void cleanDatabase(){
        System.out.println("**********Me ejecuto antes del escenario y antes de backgroun**********");
    }

    /*
    @After
    public void afterHook(){
        System.out.println("**********Me ejecuto despues del escenario**********");
    }*/
}

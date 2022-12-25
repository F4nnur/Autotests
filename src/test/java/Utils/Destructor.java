package Utils;

import org.junit.Assert;
import com.example.UntitledTestSuite.AppManager;

public class Destructor {
    public static Thread addDestructor(Runnable runnable) {
        Thread hook = new Thread(runnable);
        Runtime.getRuntime().addShutdownHook(hook);
        return hook;
    }

    public static boolean removeDestructor(Thread hook) {
        return Runtime.getRuntime().removeShutdownHook(hook);
    }

    public static Thread addManagerDestructor(AppManager appManager) {
        return addDestructor(() -> {
            try {
                appManager.getDriver().quit();
            } catch (Exception ignored) {
            } finally {
                String verificationErrorString = appManager.getVerificationErrors().toString();
                if (!verificationErrorString.equals("")) {
                    Assert.fail(verificationErrorString);
                }
            }
        });
    }
}



public class DriverManagerFactory {

    public static DriverManager getManager(DriverTypes type) {

        DriverManager driverManager = null;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriver();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriver();
                break;
        }
        return driverManager;

    }
}

package config;

public class DriverManagerFactory {

  public static DriverManager getManager(DriverType type) {
    DriverManager manager = null;
    switch (type) {
      case CHROME:
        manager = new ChromeDriverManager();
        break;
      //TODO: add Drivers
      default:
        System.out.println("Invalid browser");
        break;
    }
    return manager;
  }
}

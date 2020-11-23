import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
	public static void WAIT_LOAD_PAGE_COMPLETED(WebDriver driver) {
		WAIT_LOAD_PAGE_COMPLETED(driver, 100);
	}
	
	public static void WAIT_LOAD_PAGE_COMPLETED(WebDriver driver, int interval) {
		long start = System.currentTimeMillis();
		int length = 0;
		try {
			while (true) {
				Thread.sleep(interval);
				int current = driver.getPageSource().length();
				if (length < current) {
					length = current;
				} else {
					System.out.println(String.format("WAIT_LOAD_PAGE_COMPLETED = %d", (System.currentTimeMillis() - start)));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

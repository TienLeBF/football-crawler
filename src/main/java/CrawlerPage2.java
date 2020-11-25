import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CrawlerPage2 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            System.setProperty("webdriver.chrome.driver", "/home/le/seleniumdriver/chromedriver");
            ChromeOptions op = new ChromeOptions();
            //			op.addArguments("--headless");
            driver = new ChromeDriver(op);
            String url = "file:///home/le/Desktop/test.html";
            driver.manage().window().maximize();
            driver.get(url);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement vongBangs = driver.findElement(By.id("z"));
            System.out.println(vongBangs);
            String tenDoi = vongBangs.findElement(By.cssSelector("div.ellipsisize > span")).getText();
            System.out.println(driver.getPageSource());

            System.out.println("Ten doi: " + tenDoi);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("clean");
            if (null != driver) {
                driver.close();
            }
        }
    }

    public void process() {

        // 1. vòng bảng - trong div id =
        // "liveresults-sports-immersive__updatable-league-matches" co class =
        // "OcbAbf"
        // 1.1. tên vòng bảng, tag div co class = "lr-imso-scroll GVj7ae
        // imso-medium-font qJnhT imso-ani"
        // 1.2. tran dau trong trong tag table co class = "imspo_mt__mit"
        // 1.2.1 link anh doi bong 1 trong tag tr class = "imspo_mt__tr" trong tag td
        // class "imspo_mt__lgc
        // lc" tai tag img gia tri thuoc tinh src
        // 1.2.2 doi bong 1 trong tag tr class = "imspo_mt__tr" trong tag td class =
        // "tns-c imspo_mt__tt-w
        // imspo_mt__dt-t", div ellipsisize class "ellipsisize" tai tagspan
        // 1.2.3 so ban thang 1 doi bong 1 trong tag tr class = "imspo_mt__tr" trong tag
        // td class = "tns-c
        // imspo_mt__tt-w
        // imspo_mt__dt-t", div ellipsisize class "imspo_mt__t-sc" tai tagspan
        // 1.2.4 link anh doi bong 2 Lap lai doi 1
        // 1.2.3 doi bong 2 Lap lai doi 1
        // 1.2.4 so ban thang 2 Lap lai doi 1
        // 1.2.5 thong tin chot
        // 1.2.5.1 ti so chung cuoc trong tag div class = "imspo_mt__cm-s
        // imspo_mt__ndl-p imso-medium-font
        // imspo_mt__match-status"
        // 1.2.5.2 ngay thi dau trong tag div co class = imspo_mt__cmd, la value span
        // 1.2.5.3 link ảnh xem truoc cua video trong tag div class = "imspo_mt__vr-tc
        // imspo_mt__ndl-p" tai
        // the a thuoc tinh "aria-label"
        // 1.2.5.4 link video tag div class = "imspo_mt__vr-tc imspo_mt__ndl-p" tai the
        // a thuoc tinh
        // "aria-label"
        // 1.2.5.4 thoi gian video tag div class = "imspo_mt__vr-tc imspo_mt__ndl-p"
        // trong the a tai the
        // span
        // youtube ben trong nhom class, co class = "imspo_mt__match-sc imspo_mt__wt"
        // the a gia tri href
    }

}

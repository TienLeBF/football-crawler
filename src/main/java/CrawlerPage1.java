import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CrawlerPage1 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // init driver
            // System.setProperty("webdriver.gecko.driver", "/home/le/seleniumdriver/geckodriver");
            FirefoxOptions option = new FirefoxOptions();
            option.addArguments("--headless");
            // driver = new FirefoxDriver(option);

            System.setProperty("webdriver.chrome.driver", "/home/le/seleniumdriver/chromedriver");
            ChromeOptions op = new ChromeOptions();
            op.addArguments("--headless");
            driver = new ChromeDriver(op);
            // info crawl
            // String url =
            // "https://www.google.com/search?sxsrf=ALeKk02SuH34OswVCiUwOVJjOM5dhEDXwQ%3A1605506341928&ei=JRWyX7KNOIaJmAWzn7eoBQ&q=africa+cup+2019&oq=afr&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMgQIIxAnMgQIIxAnMgcIABDJAxBDMgQILhBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAA6BwgjEMkDECc6BwguELEDEEM6CAgAELEDEIMBOg0ILhCxAxCDARAUEIcCOgoILhCxAxAUEIcCOgUIABCxA1C-C1i-C2DQEmgAcAB4AIABaYgBzwGSAQMwLjKYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#sie=lg;/m/0r3tvzw;2;/m/01l5zn;mt;fp;1;;";
            String url = "file:///home/le/Desktop/h.html";
            // driver get url
            driver.get(url);
            // process data
            List<WebElement> vongBangs = driver.findElements(By.className("OcbAbf"));
            String tenVongBang = "";
            String avatarDoiBong = "";
            String tenDoi = "";
            String banThang = "";
            String ketQua = "";
            String ngayDa = "";
            String linkAnhXemTruoc = "";
            String linkVideo = "";
            String thoiGianVideo = "";
            Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
            // Lap tung vong bang
            for (WebElement webElement : vongBangs) {
                tenVongBang = webElement
                        .findElement(
                                By.cssSelector("div[class='lr-imso-scroll GVj7ae imso-medium-font qJnhT imso-ani']"))
                        .getText();
                System.out.println("Vong bang: " + tenVongBang);
                // Tran dau trong vong bang
                List<WebElement> tranDaus = webElement.findElements(By.cssSelector("table[class='imspo_mt__mit']"));
                int index = 0;
                for (WebElement tranDau : tranDaus) {
                    System.out.println("Tran dau: " + ++index);
                    List<WebElement> dois = tranDau.findElements(By.cssSelector("tr[class='imspo_mt__tr']"));
                    for (WebElement doi : dois) {
                        avatarDoiBong = doi.findElement(By.cssSelector("td.imspo_mt__lgc > img.imso_btl__mh-logo"))
                                .getAttribute("src");
                        System.out.println("Src: " + avatarDoiBong);
                        tenDoi = doi.findElement(By.cssSelector("div.ellipsisize > span")).getText();
                        System.out.println("Ten doi: " + tenDoi);
                        banThang = doi.findElement(By.cssSelector("div.imspo_mt__tt-w")).getText();
                        System.out.println("Ban thang: " + banThang);
                    }
                    ketQua = tranDau.findElement(By.cssSelector(
                            "div[class='imspo_mt__cm-s imspo_mt__ndl-p imso-medium-font imspo_mt__match-status']"))
                            .getText();
                    ngayDa = tranDau.findElement(By.cssSelector("div[class='imspo_mt__cmd'] > span")).getText();
                    thoiGianVideo = tranDau
                            .findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
                            .findElement(By.cssSelector(" a > span"))
                            .getText();
                    linkAnhXemTruoc = tranDau
                            .findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
                            .findElement(By.cssSelector(" a > img"))
                            .getAttribute("src");
                    linkVideo = tranDau
                            .findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
                            .findElement(By.cssSelector("a"))
                            .getAttribute("href");

                    System.out.println("ketQua: " + ketQua);
                    System.out.println("ngayDa: " + ngayDa);
                    System.out.println("linkAnhXemTruoc: " + linkAnhXemTruoc);
                    System.out.println("thoiGianVideo: " + thoiGianVideo);
                    System.out.println("linkAnhXemTruoc: " + linkAnhXemTruoc);
                    System.out.println("linkVideo: " + linkVideo);
                }
            }
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

        // 1. vòng bảng - trong div id = "liveresults-sports-immersive__updatable-league-matches" co class =
        // "OcbAbf"
        // 1.1. tên vòng bảng, tag div co class = "lr-imso-scroll GVj7ae imso-medium-font qJnhT imso-ani"
        // 1.2. tran dau trong trong tag table co class = "imspo_mt__mit"
        // 1.2.1 link anh doi bong 1 trong tag tr class = "imspo_mt__tr" trong tag td class "imspo_mt__lgc
        // lc" tai tag img gia tri thuoc tinh src
        // 1.2.2 doi bong 1 trong tag tr class = "imspo_mt__tr" trong tag td class = "tns-c imspo_mt__tt-w
        // imspo_mt__dt-t", div ellipsisize class "ellipsisize" tai tagspan
        // 1.2.3 so ban thang 1 doi bong 1 trong tag tr class = "imspo_mt__tr" trong tag td class = "tns-c
        // imspo_mt__tt-w
        // imspo_mt__dt-t", div ellipsisize class "imspo_mt__t-sc" tai tagspan
        // 1.2.4 link anh doi bong 2 Lap lai doi 1
        // 1.2.3 doi bong 2 Lap lai doi 1
        // 1.2.4 so ban thang 2 Lap lai doi 1
        // 1.2.5 thong tin chot
        // 1.2.5.1 ti so chung cuoc trong tag div class = "imspo_mt__cm-s imspo_mt__ndl-p imso-medium-font
        // imspo_mt__match-status"
        // 1.2.5.2 ngay thi dau trong tag div co class = imspo_mt__cmd, la value span
        // 1.2.5.3 link ảnh xem truoc cua video trong tag div class = "imspo_mt__vr-tc imspo_mt__ndl-p" tai
        // the a thuoc tinh "aria-label"
        // 1.2.5.4 link video tag div class = "imspo_mt__vr-tc imspo_mt__ndl-p" tai the a thuoc tinh
        // "aria-label"
        // 1.2.5.4 thoi gian video tag div class = "imspo_mt__vr-tc imspo_mt__ndl-p" trong the a tai the
        // span
        // youtube ben trong nhom class, co class = "imspo_mt__match-sc imspo_mt__wt" the a gia tri href
    }
}

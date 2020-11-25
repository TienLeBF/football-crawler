package com.le.crawler.football.logic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.gson.Gson;
import com.le.crawler.football.modal.CricleMatch;
import com.le.crawler.football.modal.Match;
import com.le.crawler.football.modal.Team;
import com.le.crawler.football.utils.SeleniumUtils;

public class CrawlerPage2 {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // init driver
            // System.setProperty("webdriver.gecko.driver",
            // "/home/le/seleniumdriver/geckodriver");
            // FirefoxOptions option = new FirefoxOptions();
            // option.addArguments("--headless");
            // driver = new FirefoxDriver(option);

            System.setProperty("webdriver.chrome.driver", "/home/le/seleniumdriver/chromedriver");
            ChromeOptions op = new ChromeOptions();
            // op.addArguments("--headless");
            driver = new ChromeDriver(op);
            // info crawl
            String url = "https://www.google.com/search?sxsrf=ALeKk02nHRdKjmNiuHkno7qiEAgKx_evpQ%3A1605265066917&ei=qmauX8a7N8uB-Qa9k5DoBw&q=afc+champion+league&oq=AFC&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMggILhDJAxCRAjIFCAAQkQIyBAgAEEMyBAguEEMyBAgAEEMyBAguEEMyBAgAEEMyBwgAEBQQhwIyCggAELEDEIMBEAo6BwgAEMkDEEM6AgguOgsILhCxAxDHARCjAjoFCAAQsQM6CAgAELEDEIMBOg0ILhCxAxDHARCjAhBDOgoILhDHARCjAhBDOgsILhCxAxDHARCvAToKCC4QxwEQrwEQQzoCCAA6CAguEMcBEK8BOgcIABCxAxBDOgcILhCxAxBDUIA-WPVXYMpkaANwAXgAgAGaAYgBvQaSAQMwLjaYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#sie=lg;/g/11fk8dhgv3;2;/m/042gf2;mt;fp;1;;";
            // driver get url
            driver.manage().window().maximize();
            driver.get(url);
            SeleniumUtils.WAIT_LOAD_PAGE_COMPLETED(driver, 1000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript(
            //             "document.querySelector('div[style*=\"position: fixed; top: 0px; left: 0px; width: 100%; z-index: 1;\"]').style.width = '50%';",
            // "");
            try {
                long start = System.currentTimeMillis();
                int length = 0;
                while (true) {
                    // This will scroll the page till the element is found
                    WebElement xx = driver
                            .findElement(By.id("liveresults-sports-immersive__updatable-league-matches"));
                    System.out.println("ROLLING UP");
                    js.executeScript("arguments[0].scrollIntoView();", xx);
                    int current = driver.getPageSource().length();
                    if (length < current) {
                        length = current;
                    } else {
                        System.out.println(
                                String.format("WAIT_LOAD_PAGE_COMPLETED = %d", (System.currentTimeMillis() - start)));
                        break;
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                long start = System.currentTimeMillis();
                int length = 0;
                while (true) {
                    // This will scroll the page till the element is found
                    WebElement Element = driver.findElement(By.cssSelector("div[class*='imso-ani AA8jgb BOgFNb']"));
                    // This will scroll the page till the element is found
                    js.executeScript("arguments[0].scrollIntoView();", Element);
                    System.out.println("ROLLING DOWN");
                    int current = driver.getPageSource().length();
                    if (length < current) {
                        length = current;
                    } else {
                        System.out.println(
                                String.format("WAIT_LOAD_PAGE_COMPLETED = %d", (System.currentTimeMillis() - start)));
                        break;
                    }
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<WebElement> vongBangs = driver.findElements(By.className("OcbAbf"));
            Team team = new Team();
            Match match = null;
            CricleMatch cricleMatch = new CricleMatch();
            List<CricleMatch> cricleMatchs = new ArrayList<CricleMatch>();
            // Lap tung vong bang
            int index = 0;
            for (WebElement webElement : vongBangs) {
                try {
                    String cricleMatchName = webElement
                            .findElement(By.cssSelector("div.ellipsisize > span"))
                            .getText();
                    cricleMatch = new CricleMatch();
                    index = 0;
                    cricleMatch.setName(cricleMatchName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Tran dau trong vong bang

                List<WebElement> tranDaus = webElement.findElements(By.cssSelector("table[class='imspo_mt__mit']"));
                for (WebElement tranDau : tranDaus) {
                    match = new Match();
                    System.out.println("Tran dau: " + ++index);
                    List<WebElement> dois = tranDau.findElements(By.cssSelector("tr[class='imspo_mt__tr']"));
                    for (WebElement doi : dois) {
                        team = new Team();
                        try {
                            team.setAvatar(doi.findElement(By.cssSelector("td.imspo_mt__lgc > img.imso_btl__mh-logo"))
                                    .getAttribute("src"));
                        } catch (Exception e) {
                            System.out.println("Khong the lay team.setAvatar");
                            // e.printStackTrace();
                        }
                        try {
                            // team.setName(doi.findElement(By.cssSelector("div.ellipsisize > span")).getText());
                            team.setName(doi.findElement(By.cssSelector("div.ellipsisize")).getText());
                        } catch (Exception e) {
                            System.out.println("Khong the lay team.setName");
                            // e.printStackTrace();
                        }
                        try {
                            team.setGoal(doi.findElement(By.cssSelector("div.imspo_mt__tt-w")).getText());
                        } catch (Exception e) {
                            System.out.println("Khong the lay team.setGoal");
                            // e.printStackTrace();
                        }
                        match.getTeams().add(team);
                    }
                    try {
                        match.setResult(tranDau.findElement(By.cssSelector(
                                "div[class='imspo_mt__cm-s imspo_mt__ndl-p imso-medium-font imspo_mt__match-status']"))
                                .getText());
                        match.setDay(
                                tranDau.findElement(By.cssSelector("div[class='imspo_mt__cmd'] > span")).getText());
                    } catch (Exception e) {
                        System.out.println("Khong the lay setResult");
                        //                      e.printStackTrace();
                    }
                    try {
                        match.setVideoTime(
                                tranDau.findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
                                .findElement(By.cssSelector(" a > span")).getText());
                    } catch (Exception e) {
                        System.out.println("Khong the lay setVideoTime");
                        //                        e.printStackTrace();
                    }
                    try {
                        match.setPhotoUrlPreview(
                                tranDau.findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
                                .findElement(By.cssSelector(" a > img")).getAttribute("src"));
                    } catch (Exception e) {
                        System.out.println("Khong the lay setPhotoUrlPreview");
                        //                        e.printStackTrace();
                    }
                    try {
                        match.setVideoUrl(
                                tranDau.findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
                                .findElement(By.cssSelector("a")).getAttribute("href"));
                    } catch (Exception e) {
                        System.out.println("Khong the lay setVideoUrl");
                        //                        e.printStackTrace();
                    }
                    cricleMatch.getMatchs().add(match);
                }
                cricleMatchs.add(cricleMatch);
            }
            Gson gson = new Gson();
            String json = gson.toJson(cricleMatchs);
            System.out.println(json);
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

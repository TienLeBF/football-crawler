package com.le.crawler.footballcrawler.logic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.gson.Gson;
import com.le.crawler.footballcrawler.modal.leaderboard.LeaderBoard;
import com.le.crawler.footballcrawler.modal.leaderboard.LeaderBoardTab;
import com.le.crawler.footballcrawler.modal.leaderboard.Player;
import com.le.crawler.footballcrawler.modal.match.Game;
import com.le.crawler.footballcrawler.modal.match.GameGroup;
import com.le.crawler.footballcrawler.modal.match.MatchTab;
import com.le.crawler.footballcrawler.modal.match.Team;
import com.le.crawler.footballcrawler.modal.news.News;
import com.le.crawler.footballcrawler.modal.news.NewsTab;
import com.le.crawler.footballcrawler.modal.page.Page;
import com.le.crawler.footballcrawler.modal.standing.Group;
import com.le.crawler.footballcrawler.modal.standing.StandingTab;
import com.le.crawler.footballcrawler.utils.SeleniumUtils;

public class CrawlerCommon {
	private WebDriver driver;

	public void openSessionDriver() {
		try {
			// init driver
			// System.setProperty("webdriver.gecko.driver",
			// "/home/le/seleniumdriver/geckodriver");
			// FirefoxOptions option = new FirefoxOptions();
			// option.addArguments("--headless");
			// driver = new FirefoxDriver(option);

			System.setProperty("webdriver.chrome.driver", "/home/le/seleniumdriver/chromedriver");
			ChromeOptions op = new ChromeOptions();
			 op.addArguments("--headless");
			this.driver = new ChromeDriver(op);
			// info crawl
			this.driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeSessionDriver() {
		try {
			if (null != this.driver) {
				this.driver.close();
				System.out.println("DRIVER IS CLEANED");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MatchTab processMatch() {
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

		try {
			// info crawl
			// driver get url
			SeleniumUtils.WAIT_LOAD_PAGE_COMPLETED(this.driver, 1000);
			JavascriptExecutor js = (JavascriptExecutor) this.driver;
			// js.executeScript(
			// "document.querySelector('div[style*=\"position: fixed; top: 0px; left: 0px;
			// width: 100%; z-index:
			// 1;\"]').style.width = '50%';",
			// "");
			try {
				long start = System.currentTimeMillis();
				int length = 0;
				while (true) {
					// This will scroll the page till the element is found
					WebElement xx = this.driver
							.findElement(By.id("liveresults-sports-immersive__updatable-league-matches"));
					System.out.println("ROLLING UP");
					js.executeScript("arguments[0].scrollIntoView();", xx);
					int current = this.driver.getPageSource().length();
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
					WebElement Element = this.driver
							.findElement(By.cssSelector("div[class*='imso-ani AA8jgb BOgFNb']"));
					// This will scroll the page till the element is found
					js.executeScript("arguments[0].scrollIntoView();", Element);
					System.out.println("ROLLING DOWN");
					int current = this.driver.getPageSource().length();
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
			List<WebElement> vongBangs = this.driver.findElements(By.className("OcbAbf"));
			MatchTab matchs = new MatchTab();
			Team team = new Team();
			Game game = null;
			GameGroup gameGroup = new GameGroup();
			List<GameGroup> groupGames = new ArrayList<GameGroup>();
			// Lap tung vong bang
			int index = 0;
			for (WebElement webElement : vongBangs) {
				try {
					String cricleMatchName = webElement
							.findElement(By.cssSelector("div[class*='GVj7ae imso-medium-font qJnhT imso-ani']"))
							.getText();
					gameGroup = new GameGroup();
					index = 0;
					gameGroup.setName(cricleMatchName);
				} catch (Exception e) {
					System.out.println("Khong the lay cricleMatch.setName");
					// e.printStackTrace();
				}
				// Tran dau trong vong bang

				List<WebElement> tranDaus = webElement.findElements(By.cssSelector("table[class='imspo_mt__mit']"));
				for (WebElement tranDau : tranDaus) {
					game = new Game();
					System.out.println("Tran dau: " + ++index);
					List<WebElement> dois = tranDau.findElements(By.cssSelector("tr[class='imspo_mt__tr']"));
					for (WebElement doi : dois) {
						team = new Team();
						try {
							team.setAvatar(doi.findElement(By.cssSelector("td.imspo_mt__lgc > img.imso_btl__mh-logo"))
									.getAttribute("src"));
						} catch (Exception e) {
							System.out.println("Not found team.setAvatar");
						}
						try {
							team.setName(doi.findElement(By.cssSelector("div.ellipsisize > span")).getText());
						} catch (Exception e) {
							System.out.println("Not found team.setName");
						}
						try {
							team.setGoal(doi.findElement(By.cssSelector("div.imspo_mt__tt-w")).getText());
						} catch (Exception e) {
							System.out.println("Not found team.setGoal");
						}
						game.getTeams().add(team);
					}
					try {
						game.setResult(tranDau.findElement(By.cssSelector(
								"div[class='imspo_mt__cm-s imspo_mt__ndl-p imso-medium-font imspo_mt__match-status']"))
								.getText());
					} catch (Exception e) {
						System.out.println("Not found game.setResult");
					}
					try {
						game.setDay(tranDau.findElement(By.cssSelector("div[class='imspo_mt__cmd'] > span")).getText());
					} catch (Exception e) {
						System.out.println("Not found game.setDay");
					}
					try {
						game.setVideoTime(
								tranDau.findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
										.findElement(By.cssSelector(" a > span")).getText());
					} catch (Exception e) {
						System.out.println("Not found game.setVideoTime");
					}
					try {
						game.setPhotoUrlPreview(
								tranDau.findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
										.findElement(By.cssSelector(" a > img")).getAttribute("src"));
					} catch (Exception e) {
						System.out.println("Not found game.setPhotoUrlPreview");
					}

					try {
						game.setVideoUrl(
								tranDau.findElement(By.cssSelector("div[class='imspo_mt__vr-tc imspo_mt__ndl-p']"))
										.findElement(By.cssSelector("a")).getAttribute("href"));
					} catch (Exception e) {
						System.out.println("Not found game.setVideoUrl");
					}
					gameGroup.getGames().add(game);
				}
				groupGames.add(gameGroup);
			}
			matchs.setmatchs(groupGames);
//            Gson gson = new Gson();
//            String json = gson.toJson(matchs);
			// return json;
			return matchs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public NewsTab processNews() {
		// 1. Xep hang trong the div co class = nM4ave
		// 1.1 Tin trong div co class = HCUNre dbsr
		// 1.1.1 Link tin div>a.href
		// 1.1.2 Tieu de div class = nDgy9d
		// 1.1.3 Ten bao span class = wqg8ad
		// 1.1.4 Ngay post truoc do span class = FGlSad
		// 1.1.5 Link anh id = dimg_xp3AX8qhJs7Tz7sP1sWssA41, class rISBZc M4dUYb;
		// div>img.src
		try {
			SeleniumUtils.WAIT_LOAD_PAGE_COMPLETED(this.driver, 1000);
			JavascriptExecutor js = (JavascriptExecutor) this.driver;
			// SCROLL UP DOWN
			WebElement data = this.driver.findElement(By.className("x4NjEf"));
			List<WebElement> eManyNews = data.findElements(By.cssSelector("div[class='HCUNre dbsr']"));
			NewsTab newsPage = new NewsTab();
			List<News> manyNews = new ArrayList<News>();
			News news = null;
			for (WebElement e : eManyNews) {
				news = new News();
				news.setUrl(e.findElement(By.cssSelector("div>a")).getAttribute("href"));
				news.setTitle(e.findElement(By.cssSelector("div[class='nDgy9d']")).getText());
				news.setNamePage(e.findElement(By.cssSelector("span[class='wqg8ad']")).getText());
				news.setDay(e.findElement(By.cssSelector("span[class='FGlSad']")).getText());
				news.setImageUrl(e.findElement(By.cssSelector("img")).getAttribute("src"));
				manyNews.add(news);
			}
			newsPage.setManyNews(manyNews);
//             Gson gson = new Gson();
//             String json = gson.toJson(newsPage);
			// return json;
			return newsPage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public StandingTab processStandings() {

		// 1. Thong tin trong the div co class = sWfpOe
		// 1.1 GroupName trong div co class = fwXO9b XAPH9c
		// 1.2 Danh sach doi bong group trong div class = jXpA9e Ui5IUc
		// 1.3 Doi bong trong tr class = imso-loa imso-hov
		// 1.3.1 stt div class = iU5t0d
		// 1.3.2 imageUrl trong the img attribute = src
		// 1.3.3 Ten doi bong span class = ellipsisize hsKSJe
		// 1.3.4 points td class = e9fBA xkW0Cc
		// 1.3.5 result div class = XqaACe BPu3kf attribute = aria-labelledby -> l5l-w =
		// 1, l5l-l = -1,
		// l5l-np =0

		try {
			SeleniumUtils.WAIT_LOAD_PAGE_COMPLETED(this.driver, 1000);
			JavascriptExecutor js = (JavascriptExecutor) this.driver;
			// SCROLL UP DOWN
			// WebElement d = this.driver
			// .findElement(By.xpath("//*[@id=\"tab-1-3\"]/div/div[1]/div/div[2]/div/div/div/div/div/div[3]"));
			// System.out.println("valule = " + d.getText());
			// System.exit(1);
			WebElement data = this.driver.findElement(By.className("sWfpOe"));
			List<WebElement> groupNames = data.findElements(By.cssSelector("div[class='fwXO9b XAPH9c']"));
			List<WebElement> eGroups = data.findElements(By.cssSelector("div[class='jXpA9e Ui5IUc']"));
			List<WebElement> eTeams = null;
			int index = 0;
			StandingTab standings = new StandingTab();
			List<Group> groups = new ArrayList<Group>();
			Group group = null;
			com.le.crawler.footballcrawler.modal.standing.Team team = null;
			List<com.le.crawler.footballcrawler.modal.standing.Team> teams = new ArrayList<com.le.crawler.footballcrawler.modal.standing.Team>();
			for (WebElement e1 : eGroups) {
				group = new Group();
				group.setName(groupNames.get(index).getText());
				eTeams = e1.findElements(By.cssSelector("tr[class='imso-loa imso-hov']"));
				for (WebElement e : eTeams) {

					team = new com.le.crawler.footballcrawler.modal.standing.Team();
					team.setStt(e.findElement(By.cssSelector("div.iU5t0d")).getText());
					team.setImageUrl(e.findElement(By.cssSelector("img")).getAttribute("src"));
					List<WebElement> ps = e.findElements(By.cssSelector("td[class*='e9fBA xkW0Cc']"));
					String sps = "";
					for (WebElement p : ps) {
						sps += (p.getText().isEmpty() ? "" : (" " + p.getText()));
					}
					team.setPoints(sps);
					List<WebElement> rs = e.findElements(By.cssSelector("div[class='XqaACe BPu3kf']"));
					String srs = "";
					for (WebElement r : rs) {
						if ("l5l-w".equals(r.getAttribute("aria-labelledby"))) {
							srs += " 1";
						} else if ("l5l-l".equals(r.getAttribute("aria-labelledby"))) {
							srs += " -1";
						} else if ("l5l-np".equals(r.getAttribute("aria-labelledby"))) {
							srs += " 0";
						}
					}
					team.setResult(srs);
					teams.add(team);
				}
				group.setTeams(teams);
				groups.add(group);
			}
			standings.setGroups(groups);
//            Gson gson = new Gson();
//            String json = gson.toJson(standings);
//            System.out.println(json);
			return standings;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public LeaderBoardTab processLeaderboard() {

		// 1. LeaderBoard trong div id = v3Iwj88yxmA__leaderboard class imso-ani tb_cbg
		// v3Iwj88yxmA__leaderboard
		// , xpath = //*[@id="v3Iwj88yxmA__leaderboard"]
		// 1.1 Moi leader trong div.div class fUqVOe imso-medium-font
		// 1.1.1 tile leaderboard div class name = mbWiBb
		// 1.1.2 thong tin cau thu trong table
		// table>tbody>tr.Oo683d imso-regular-font imso-loa
		// 1.1.2.1 rank td class = nGqo8b
		// 1.1.2.2 name div class = imso-regular-font imso-hide-overflow
		// 1.1.2.3 imageUrl - img -> src
		// 1.1.2.4 team - span class = R1ZKVe imso-regular-font
		// 1.1.2.4 count td class = Rq9DQd
		try {
			SeleniumUtils.WAIT_LOAD_PAGE_COMPLETED(this.driver, 1000);
			JavascriptExecutor js = (JavascriptExecutor) this.driver;
			// SCROLL UP DOWN
			WebElement data = this.driver.findElement(By.id("v3Iwj88yxmA__leaderboard"));
			LeaderBoardTab result = new LeaderBoardTab();
			List<LeaderBoard> leaders = new ArrayList<LeaderBoard>();
			LeaderBoard leader = null;
			Player player = null;
			List<Player> players = new ArrayList<Player>();
			List<WebElement> eLeaders = data.findElements(By.cssSelector("div[class='fUqVOe imso-medium-font']"));
			for (WebElement e : eLeaders) {
				leader = new LeaderBoard();
				leader.setTitle(e.findElement(By.cssSelector("div.mbWiBb")).getText());
				List<WebElement> ePlayers = e.findElement(By.tagName("table"))
						.findElements(By.cssSelector("tr[class='Oo683d imso-regular-font imso-loa']"));
				for (WebElement eP : ePlayers) {
					player = new Player();
					player.setRank(eP.findElement(By.className("nGqo8b")).getText());
					player.setName(eP.findElement(By.cssSelector("div[class='imso-regular-font imso-hide-overflow']"))
							.getText());
					player.setImageUrl(eP.findElement(By.tagName("img")).getAttribute("src"));
					player.setTeam(eP.findElement(By.cssSelector("span[class='R1ZKVe imso-regular-font']")).getText());
					player.setCounts(eP.findElement(By.cssSelector("td[class='Rq9DQd']")).getText());
					players.add(player);
				}
				leader.setPlayers(players);
				leaders.add(leader);
			}
			result.setLeaderBoards(leaders);
//            Gson gson = new Gson();
//            String json = gson.toJson(result);
//            System.out.println(json);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Page process(String url) {
		try {
			long start = System.currentTimeMillis();
			this.openSessionDriver();
			this.driver.get(url);
//             way to tab match -> already stay at this tab (-> click link li - data-tab_type = LEAGUE_MATCHES)
//			Gson gson = new Gson();
			long startMatchs = System.currentTimeMillis();
			MatchTab matchs = this.processMatch();
//			System.out.println(gson.toJson(matchs));
//             way to tab match new -> click link li - data-tab_type = NEWS
			long startNews = System.currentTimeMillis();
			this.driver.findElement(By.cssSelector("li[data-tab_type='NEWS']")).click();
			NewsTab newsPage = this.processNews();
//			System.out.println(gson.toJson(newsPage));
//             way to tab ranking -> click link li - data-tab_type = STANDINGS
//            SeleniumUtils.WAIT_LOAD_PAGE_COMPLETED(this.driver, 1000);
			long startStanding = System.currentTimeMillis();
			this.driver.findElement(By.cssSelector("li[data-tab_type='STANDINGS']")).click();
			StandingTab standings = this.processStandings();
//			System.out.println(gson.toJson(standings));
			// way to tab tracking -> click link li - data-tab_type = LEADERBOARD
//            SeleniumUtils.WAIT_LOAD_PAGE_COMPLETED(this.driver, 1000);
			long startLeader = System.currentTimeMillis();
			this.driver.findElement(By.cssSelector("li[data-tab_type='LEADERBOARD']")).click();
			LeaderBoardTab leaderBoards = this.processLeaderboard();
//			System.out.println(gson.toJson(leaderboards));
			long convertJson = System.currentTimeMillis();
			Page page = new Page();
			page.setMatchs(matchs);
			page.setNewsTab(newsPage);
			page.setLeaderBoardTab(leaderBoards);
			page.setStandingTab(standings);
			System.out.println(new Gson().toJson(page));
			long end = System.currentTimeMillis();
			System.out.println("=============TIMES LINE====================");
			System.out.println(String.format("Opensession = %f %s",(startMatchs - start)/1000.0, "s"));
			System.out.println(String.format("Crawl MatchTab = %f %s", (startNews - startMatchs)/1000.0, "s"));
			System.out.println(String.format("Crawl NewsTab = %f %s", (startStanding - startNews)/1000.0, "s"));
			System.out.println(String.format("Crawl StandingTab = %f %s", (startLeader - startStanding)/1000.0, "s"));
			System.out.println(String.format("Crawl LeaderBoardTab = %f %s", (convertJson - startLeader)/1000.0, "s"));
			System.out.println(String.format("Crawl ConvertJson = %f %s", (end - convertJson)/1000.0, "s"));
			System.out.println("=============END TIMES LINE================");
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			 this.closeSessionDriver();
		}
	}

	public static void main(String[] args) {
		String url1 = "https://www.google.com/search?sxsrf=ALeKk02SuH34OswVCiUwOVJjOM5dhEDXwQ%3A1605506341928&ei=JRWyX7KNOIaJmAWzn7eoBQ&q=africa+cup+2019&oq=afr&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMgQIIxAnMgQIIxAnMgcIABDJAxBDMgQILhBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAA6BwgjEMkDECc6BwguELEDEEM6CAgAELEDEIMBOg0ILhCxAxCDARAUEIcCOgoILhCxAxAUEIcCOgUIABCxA1C-C1i-C2DQEmgAcAB4AIABaYgBzwGSAQMwLjKYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#sie=lg;/m/0r3tvzw;2;/m/01l5zn;mt;fp;1;;";
		String url2 = "https://www.google.com/search?sxsrf=ALeKk02nHRdKjmNiuHkno7qiEAgKx_evpQ%3A1605265066917&ei=qmauX8a7N8uB-Qa9k5DoBw&q=afc+champion+league&oq=AFC&gs_lcp=CgZwc3ktYWIQARgAMgQIIxAnMggILhDJAxCRAjIFCAAQkQIyBAgAEEMyBAguEEMyBAgAEEMyBAguEEMyBAgAEEMyBwgAEBQQhwIyCggAELEDEIMBEAo6BwgAEMkDEEM6AgguOgsILhCxAxDHARCjAjoFCAAQsQM6CAgAELEDEIMBOg0ILhCxAxDHARCjAhBDOgoILhDHARCjAhBDOgsILhCxAxDHARCvAToKCC4QxwEQrwEQQzoCCAA6CAguEMcBEK8BOgcIABCxAxBDOgcILhCxAxBDUIA-WPVXYMpkaANwAXgAgAGaAYgBvQaSAQMwLjaYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#sie=lg;/g/11fk8dhgv3;2;/m/042gf2;mt;fp;1;;";
		new CrawlerCommon().process(url1);
//		new CrawlerCommon().process(url2);
	}
}

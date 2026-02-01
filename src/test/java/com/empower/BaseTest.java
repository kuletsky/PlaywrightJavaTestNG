package com.empower;

import com.empower.utils.ConfigReader;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    private static final String AUTH_USER = ConfigReader.get("auth.user");
    private static final String AUTH_PASS = ConfigReader.get("auth.pass");
    private static final String BROWSER_TYPE = ConfigReader.get("browser", "chromium");
    private static final boolean HEADLESS = ConfigReader.getBoolean("headless", false);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        playwright = Playwright.create();
        browser = launchBrowser();

//        browser = playwright.chromium().launch(
////         browser = playwright.webkit().launch(
//                new BrowserType.LaunchOptions()
//                        .setHeadless(HEADLESS)
//        );


        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080)
                        .setHttpCredentials(AUTH_USER, AUTH_PASS)
        );


        // --- START TRACING ---
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));


        page = context.newPage();
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);

        System.out.println("\nBrowser started: " + BROWSER_TYPE + (HEADLESS ? " (headless)" : ""));
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (context != null) {

            // --- STOP AND SAVE TRACE ---
            // Saves a zip file named after the test method
            String tracePath = "traces/" + result.getName() + ".zip";
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get(tracePath)));


            System.out.println("Trace saved to: " + tracePath);

            context.close();
        }
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public Page getPage() {
        return page;
    }

    public BrowserContext getContext() {
        return context;
    }

    private Browser launchBrowser() {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(HEADLESS);

        return switch (BROWSER_TYPE.toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(options);
            case "webkit", "safari" -> playwright.webkit().launch(options);
            default -> playwright.chromium().launch(options);
        };
    }
}

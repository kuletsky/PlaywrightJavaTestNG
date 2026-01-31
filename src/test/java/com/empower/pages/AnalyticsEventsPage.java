package com.empower.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Map;

import static com.empower.utils.DataLayerUtil.clickAndCaptureEvent;

public class AnalyticsEventsPage {
    private final Page page;
    private final static String ANALYTICS_PAGE = "https://empwrretiremtstg.prod.acquia-sites.com/empulsify/tp-analytics-events-empulsify";

    public AnalyticsEventsPage(Page page) {
        this.page = page;
        page.navigate(ANALYTICS_PAGE);
    }

//    public Page getPage() {
//        return page;
//    }

    public Map<String, Object> clickAndCaptureEventOfPrimaryButton(String eventType, String eventName) {
        Locator buttonLocator = page.locator("[data-once='click-primary-button empulsify-button-ripple']").nth(0);
        String buttonText = buttonLocator.textContent().trim();

        Map<String, Object> responseMap = clickAndCaptureEvent(page, buttonLocator, eventType, eventName);
        responseMap.put("buttonText", buttonText);

        return responseMap;
    }

    public Map<String, Object> clickAndCaptureEventOfPrimaryButton_PC(String eventType, String eventName) {
        Locator buttonLocator = page.locator("[data-once='click-primary-button empulsify-button-ripple']").nth(1);
        String buttonText = buttonLocator.textContent().trim();

        Map<String, Object> responseMap = clickAndCaptureEvent(page, buttonLocator, eventType, eventName);
        responseMap.put("buttonText", buttonText);

        return responseMap;
    }

    public Map<String, Object> clickAndCaptureEventOfBrandedGoldenBotton(String eventType, String eventName) {
        Locator buttonLocator = page.locator(".layout__region.layout__region--second .branded-btn");
        String buttonText = buttonLocator.textContent().trim();

        Map<String, Object> responseMap = clickAndCaptureEvent(page, buttonLocator, eventType, eventName);
        responseMap.put("buttonText", buttonText);

        return responseMap;
    }

}

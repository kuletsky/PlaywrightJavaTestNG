package com.empower.pages;

import com.empower.utils.DataLayerUtil;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;

import static com.empower.utils.DataLayerUtil.clickAndCaptureEvent;

public class AnalyticsEventsPage {
    private final Page page;
    private final static String ANALYTICS_PAGE = "https://empwrretiremtstg.prod.acquia-sites.com/empulsify/tp-analytics-events-empulsify";
    private Locator currentElement;
    private Map<String, Object> capturedEvent;
    private String elementText;
    private String elementTitle;


    private static final String PRIMARY_BUTTON = "[data-once='click-primary-button empulsify-button-ripple']";
    private static final String BRANDED_BUTTON = ".layout__region.layout__region--second .branded-btn";
    private static final String SECONDARY_BUTTON = "[class] [data-once='click-secondary-light-button empulsify-button-ripple']:nth-of-type(1)";
    private static final String SECONDARY_BUTTON_PC = ".btn.btn--large.btn--light.inline-flex.items-center.justify-center.private-client.secondary-btn.shrink-0 > .z-10";
    private static final String TILE_1 = "[data-history-node-id='4421'] [class='card__heading font-sans text-2xl\\/\\[28\\.8px\\] font-medium text-emp-blue-ocean tracking-\\[-0\\.12px\\] dark\\:text-white']";
    private static final String TILE_2 = "[data-history-node-id='10426'] [class='card__heading font-sans text-2xl\\/\\[28\\.8px\\] font-medium text-emp-blue-ocean tracking-\\[-0\\.12px\\] dark\\:text-white']";
    private static final String TILE_3 = "[data-history-node-id='10316'] [class='card__heading font-sans text-2xl\\/\\[28\\.8px\\] font-medium text-emp-blue-ocean tracking-\\[-0\\.12px\\] dark\\:text-white']";
    private static final String LINK_TEXT = "ol  a";
    private static final String LINK_CARD_TEXT = ".dark-cards\\:prose-dark.prose.prose-base.row-start-2 > p > a";
    private static final String CAROUSEL_NEXT = "[aria-label='Next slide'] [role]";
    private static final String CAROUSEL_PREV = ".group.h-6.owl-tools-prev.tools-nav-disabled > span[role='presentation']";
    private static final String CONTINUE_BUTTON = ".ui-dialog-buttonset > button:nth-of-type(1)";
    private static final String CANCEL_BUTTON = ".ui-dialog-buttonset > button:nth-of-type(2)";
    private static final String SECONDARY_BENTO_BUTTON = "[data-once='click-bento-secondary-button click-secondary-light-button empulsify-button-ripple']";
    private static final String PRIMARY_BENTO_BUTTON = "[data-once='click-bento-primary-button click-primary-button empulsify-button-ripple']";
    private static final String FAQ_EXPAND_CONTRACT = "#accordion-button div:nth-of-type(1) div";
    private static final String DOWNLOAD_APP_STORE = "[data-once='click-app-store-icon-apple'] .svg";
    private static final String DOWNLOAD_GOOGLE_PLAY = "[data-once='click-app-store-icon-google'] .svg";
    private static final String EMPOWER_LOGO = ".empower-logo";
    private static final String FACEBOOK_LOGO = "a[title='Facebook']";
    private static final String X_LOGO = "a[title='X (fka Twitter)']";
    private static final String SNAPCHAT_LOGO = "a[title='Snapchat']";
    private static final String LINKEDIN_LOGO = "a[title='LinkedIn']";
    private static final String INSTAGRAM_LOGO = "a[title='Instagram']";
    private static final String YOUTUBE_LOGO = "a[title='YouTube']";
    private static final String TIKTOK_LOGO = ".block.h-6.icon-social.icon-social-tiktok.indent-\\[-1000px\\].w-6";
//    private static final String DOWNLOAD_GOOGLE_PLAY1 = "";




    public AnalyticsEventsPage(Page page) {
        this.page = page;
        page.navigate(ANALYTICS_PAGE);
    }

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

    public AnalyticsEventsPage findElement(String elementName) {
        currentElement = switch (elementName) {
            case "primaryButton" -> page.locator(PRIMARY_BUTTON).nth(0);
            case "primaryButton_PC" -> page.locator(PRIMARY_BUTTON).nth(1);
            case "brandedGoldButton" -> page.locator(BRANDED_BUTTON);
            case "secondaryButton" -> page.locator(SECONDARY_BUTTON);
            case "secondaryButton_PC" -> page.locator(SECONDARY_BUTTON_PC);
            case "tile_1" -> page.locator(TILE_1);
            case "tile_2" -> page.locator(TILE_2);
            case "tile_3" -> page.locator(TILE_3);
            case "linkText" -> page.locator(LINK_TEXT);
            case "linkCardText" -> page.locator(LINK_CARD_TEXT);
            case "carouselNext" -> page.locator(CAROUSEL_NEXT);
            case "carouselPrev" -> page.locator(CAROUSEL_PREV);
            case "continueButton" -> page.locator(CONTINUE_BUTTON);
            case "cancelButton" -> page.locator(CANCEL_BUTTON);
            case "secondaryBentoButton" -> page.locator(SECONDARY_BENTO_BUTTON);
            case "PrimaryBentoButton" -> page.locator(PRIMARY_BENTO_BUTTON);
            case "faqExpendContract" -> page.locator(FAQ_EXPAND_CONTRACT);
            case "downloadAppStore" -> page.locator(DOWNLOAD_APP_STORE);
            case "downloadGooglePlay" -> page.locator(DOWNLOAD_GOOGLE_PLAY);
            case "empowerLogo" -> page.locator(EMPOWER_LOGO);
            case "facebookButton" -> page.locator(FACEBOOK_LOGO);
            case "xButton" -> page.locator(X_LOGO);
            case "snapchatButton" -> page.locator(SNAPCHAT_LOGO);
            case "linkedinButton" -> page.locator(LINKEDIN_LOGO);
            case "instagramButton" -> page.locator(INSTAGRAM_LOGO);
            case "youtubeButton" -> page.locator(YOUTUBE_LOGO);
            case "tiktokButton" -> page.locator(TIKTOK_LOGO);





            default -> throw new IllegalArgumentException("Unknown element: " + elementName);
        };
//        elementText = currentElement.textContent().trim();
        currentElement.getAttribute("title");

        return this;
    }

    public AnalyticsEventsPage getTextOfElement() {
        elementText = currentElement.textContent().trim();

        return this;
    }

    public AnalyticsEventsPage getTitleOfElement() {
        elementTitle = currentElement.getAttribute("title");
        if (elementTitle == null) elementTitle = "";

        return this;
    }


    public AnalyticsEventsPage clickAndCaptureElement(String eventType, String eventName) {
        capturedEvent = DataLayerUtil.clickAndCaptureEvent(page, currentElement, eventType, eventName);
        if (capturedEvent == null) capturedEvent = new HashMap<>();

        if (elementText != null) capturedEvent.put("expectedElementText", elementText);
        if (elementTitle != null) capturedEvent.put("expectedElementTitle", elementTitle);

        return this;
    }

    public AnalyticsEventsPage clickAndCaptureElementWithText(String eventType, String eventName) {
        clickAndCaptureElement(eventType, eventName);
        capturedEvent.put("expectedElementText", elementText);

        return this;
    }



    public Map<String, Object> getEvent() {
        return capturedEvent;
    }

    public AnalyticsEventsPage clickTextLink() {
        page.locator(LINK_TEXT).click();

        return this;
    }
}

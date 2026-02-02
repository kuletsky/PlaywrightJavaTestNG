package com.empower.pages;

import com.empower.utils.DataLayerUtil;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsEventsPage {
    private final Page page;
    private final static String ANALYTICS_PAGE = "https://empwrretiremtstg.prod.acquia-sites.com/empulsify/tp-analytics-events-empulsify";
    private Locator currentElement;
    private Map<String, Object> capturedEvent;
    private String elementText;
    private String elementTitle;
    private String elementLabel;


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
    private static final String SEC_LINK = "[class] [class='flex flex-row gap-x-3']:nth-of-type(1) [data-once]";
    private static final String ACCESSIBILITY_LINK = "[class] [class='flex flex-row gap-x-3']:nth-of-type(2) [data-once]";
    private static final String CYBERSECURITY_LINK = "div:nth-of-type(1) > .flex.flex-col.gap-4 > li:nth-of-type(1) > .leading-6";
    private static final String ABOUTUS_LINK = "div:nth-of-type(3) > .flex.flex-col.gap-4 > li:nth-of-type(1) > .leading-6";
    private static final String CONTACTUS_LINK = "div:nth-of-type(4) > .flex.flex-col.gap-4  .leading-6";
    private static final String LOGIN_BUTTON = "[data-once='nav-main-login-register-link click-secondary-light-button empulsify-button-ripple'] [class]";
    private static final String REGISTER_BUTTON = "[data-once='nav-main-login-register-link click-primary-button empulsify-button-ripple']";
    private static final String PROD_AND_SERV_MENU = "[aria-label='Products & Solutions']";
    private static final String TOOLS_MENU = "[aria-label='Tools']";
    private static final String LEARN_MENU = "[aria-label='Learn']";
    private static final String WHYEMPOWER_MENU = "[aria-label='Why Empower']";
    private static final String INDIVIDUALS_MENU = "[data-drupal-link-system-path='node\\/12631']";
    private static final String PLANSPONSORS_MENU = "li:nth-of-type(2) > .antialiased.block.dark\\:text-emp-nw-blue.font-medium.px-8.text-primary-blue.text-sm\\/4.transition-colors";
    private static final String FINANCIALPROFESS_MENU = "li:nth-of-type(3) > .antialiased.block.dark\\:text-emp-nw-blue.font-medium.px-8.text-primary-blue.text-sm\\/4.transition-colors";
    private static final String EXPENDSUBMENU_MENU = "[aria-label='Products \\& Services Secondary'] [type] .items-center";
    private static final String WEALTH_MANAGEMENT_MENU = "[aria-controls='dropdown-desktop-0-0']";
    private static final String PRIVET_CLIENT_MENU = "#dropdown-desktop-0-0 [aria-label='Private Client']";
    private static final String PERSONAL_STRATEGY_MENU = "#dropdown-desktop-0-0 [aria-label='Personal Strategy']";
    private static final String HIGH_YIELD_MENU = "nav[aria-label='Products & Services Secondary'] [aria-label='High-yield cash account']";
    private static final String ROLLOVER_MENU = "nav[aria-label='Products & Services Secondary'] [aria-label='Rollover']";
    private static final String IRAS_MENU = "nav[aria-label='Products & Services Secondary'] [aria-label='IRAs']";
    private static final String INVESTMENT_MENU = "nav[aria-label='Products & Services Secondary'] [aria-label='Investment accounts']";

    private static final String BENTO_BOX = "[class] [data-drupal-paragraph-name='card_v3']:nth-of-type(3) p";



    public AnalyticsEventsPage(Page page) {
        this.page = page;
        page.navigate(ANALYTICS_PAGE);
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
            case "securityCenterButton" -> page.locator(SEC_LINK);
            case "accessibilityButton" -> page.locator(ACCESSIBILITY_LINK);
            case "cybersecurityButton" -> page.locator(CYBERSECURITY_LINK);
            case "aboutUsButton" -> page.locator(ABOUTUS_LINK);
            case "contactUsButton" -> page.locator(CONTACTUS_LINK);
            case "loginButton" -> page.locator(LOGIN_BUTTON);
            case "registerButton" -> page.locator(REGISTER_BUTTON);
            case "ProdAndServMenu" -> page.locator(PROD_AND_SERV_MENU);
            case "ToolsMenu" -> page.locator(TOOLS_MENU);
            case "LearnMenu" -> page.locator(LEARN_MENU);
            case "WhyEmpowerMenu" -> page.locator(WHYEMPOWER_MENU);
            case "IndividualsMenu" -> page.locator(INDIVIDUALS_MENU);
            case "PlanSponsorsMenu" -> page.locator(PLANSPONSORS_MENU);
            case "FinancialProfessMenu" -> page.locator(FINANCIALPROFESS_MENU);
            case "expendSubmenuMain" -> page.locator(EXPENDSUBMENU_MENU);
            case "wealthManagementMenu" -> page.locator(WEALTH_MANAGEMENT_MENU);
            case "privetClientMenu" -> page.locator(PRIVET_CLIENT_MENU);
            case "personalStrategyMenu" -> page.locator(PERSONAL_STRATEGY_MENU);
            case "highYieldMenu" -> page.locator(HIGH_YIELD_MENU);
            case "rolloverMenu" -> page.locator(ROLLOVER_MENU);
            case "expectedBentoBox" -> page.locator(BENTO_BOX);
            case "irasMenu" -> page.locator(IRAS_MENU);
            case "investmentMenu" -> page.locator(INVESTMENT_MENU);





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

    public AnalyticsEventsPage getLabelOfElement() {
        elementLabel = currentElement.getAttribute("aria-label");
//        if (elementTitle == null) elementTitle = "";

        return this;
    }

    public AnalyticsEventsPage clickAndCaptureElement(String eventType, String eventName) {
        capturedEvent = DataLayerUtil.clickAndCaptureEvent(page, currentElement, eventType, eventName);
        if (capturedEvent == null) capturedEvent = new HashMap<>();

        if (elementText != null) capturedEvent.put("expectedElementText", elementText);
        if (elementTitle != null) capturedEvent.put("expectedElementTitle", elementTitle);
        if (elementLabel != null) capturedEvent.put("expectedElementLabel", elementLabel);

        return this;
    }

    public AnalyticsEventsPage hoverAndCaptureElement(String eventType, String eventName) {
        capturedEvent = DataLayerUtil.hoverAndCaptureEvent(page, currentElement, eventType, eventName);
        if (capturedEvent == null) capturedEvent = new HashMap<>();

        if (elementText != null) capturedEvent.put("expectedElementText", elementText);
//        if (elementTitle != null) capturedEvent.put("expectedElementTitle", elementTitle);
//        if (elementLabel != null) capturedEvent.put("expectedElementLabel", elementLabel);

        return this;
    }




    public Map<String, Object> getEvent() {
        return capturedEvent;
    }

    public AnalyticsEventsPage clickTextLink() {
        page.locator(LINK_TEXT).click();

        return this;
    }

    public AnalyticsEventsPage clickProdAndServiceMenu() {
        page.locator(PROD_AND_SERV_MENU).click();

        return this;
    }

    public AnalyticsEventsPage expandFAQ() {
        page.locator(FAQ_EXPAND_CONTRACT).click();

        return this;
    }


    public AnalyticsEventsPage clickWealthManagementSubmenu() {
        page.locator(WEALTH_MANAGEMENT_MENU).click();

        return this;
    }

}

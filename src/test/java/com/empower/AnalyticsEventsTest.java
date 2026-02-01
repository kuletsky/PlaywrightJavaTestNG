package com.empower;

import com.empower.pages.AnalyticsEventsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class AnalyticsEventsTest extends BaseTest {

    @DataProvider(name = "clickEvents")
    public Object[][] clickEvents() {
        return new Object[][]{
//               elementName,          expectedEvent,   expectedEventName,              expectedEventDetail
                {"primaryButton",        "button_click", "button_click_cta",             "/products-solutions/private-client"},
                {"primaryButton_PC",     "button_click", "button_click_cta",             "/products-solutions/private-client"},
                {"brandedGoldButton",    "button_click", "button_click_branded",         "/products-solutions/private-client"},
                {"secondaryButton",      "button_click", "button_click_secondary_white", "/products-solutions/private-client"},
                {"secondaryButton_PC",   "button_click", "button_click_secondary_white", "/products-solutions/private-client"},

                {"tile_1",               "tile_event",   "tile_click",                   "/the-currency/money/can-you-retire-a-million-dollars"},
                {"tile_2",               "tile_event",   "tile_click",                   "/press-center/empower-signs-new-partnership-hard-rock-stadium-and-miami-dolphins"},
                {"tile_3",               "tile_event",   "tile_click",                   "/the-currency/work/five-habits-of-excellent-retirement-savers"},
                {"linkText",             "link_click",   "link_click",                   "/"},
                {"linkCardText",         "link_click",   "link_click",                   "/"},

                {"secondaryBentoButton", "button_click", "button_click_bento_white",     "/products-solutions/private-client"},
                {"PrimaryBentoButton",   "button_click", "button_click_bento_blue",      "/products-solutions/private-client"},

                {"securityCenterButton",     "navigation_click",   "footer_sub_navigation_click",          "/participant/#/articles/securityCenter?"},
                {"accessibilityButton",      "navigation_click",   "footer_sub_navigation_click",          "/participant/#/articles/accessibility?"},

                {"cybersecurityButton",       "navigation_click",   "footer_navigation_click",          "/individuals/about-empower/cybersecurity"},
                {"aboutUsButton",             "navigation_click",   "footer_navigation_click",          "/about-us"},
                {"contactUsButton",             "navigation_click",   "footer_navigation_click",          "/contact"},

                {"loginButton",             "navigation_click",   "login_register_click",          "/login-v1"},
                {"registerButton",             "navigation_click",   "login_register_click",          "/signup"},

                //Main navigation - Contextual Menu
                {"IndividualsMenu",             "navigation_click",   "top_navigation_click",          "/home"},
                {"PlanSponsorsMenu",             "navigation_click",   "top_navigation_click",          "/plan-sponsors"},
                {"FinancialProfessMenu",             "navigation_click",   "top_navigation_click",          "/financial-professionals"},

                //Main navigation - expand/collapse submenuMain navigation
                {"expendSubmenuMain",             "navigation_click",   "sub_navigation_click",          "Expand"},


        };
    }
    @Test(dataProvider = "clickEvents")
    public void testClickAnalytics(String elementName, String expectedEvent,
                                   String expectedEventName, String expectedEventDetail) {

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .findElement(elementName)
                .getTextOfElement()
                .clickAndCaptureElement(expectedEvent, expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }







    @DataProvider(name = "clickSocialButtons")
    public Object[][] clickSocialButtons() {
        return new Object[][]{
//               elementName,             expectedEvent,   expectedEventName        expectedEventDetail
                {"facebookButton",     "social_click",   "social_click",          "/officialempowertoday"},
                {"xButton",             "social_click",   "social_click",          "/empowertoday?lang=en"},
                {"snapchatButton",     "social_click",   "social_click",          "/add/empowertoday"},
                {"linkedinButton",     "social_click",   "social_click",          "/company/empowertoday"},
                {"instagramButton",     "social_click",   "social_click",          "/officialempowertoday/"},
                {"youtubeButton",     "social_click",   "social_click",          "/channel/UCFPLlGp16vPjBb-G7SnUWhQ"},
                {"tiktokButton",     "social_click",   "social_click",          "/@empowertoday?lang=en"},
        };
    }
    @Test(dataProvider = "clickSocialButtons")
    public void testClickSocialButtonsAnalytics(String elementName, String expectedEvent,
                                                String expectedEventName, String expectedEventDetail) {

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .findElement(elementName)
                .getTitleOfElement()
                .clickAndCaptureElement(expectedEvent, expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementTitle"));
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }





    @DataProvider(name = "clickPrimaryMenu")
    public Object[][] clickPrimaryMenu() {
        return new Object[][]{
//               elementName,             expectedEvent,   expectedEventName
                {"ProdAndServMenu",     "navigation_click",   "main_navigation_click"},
                {"ToolsMenu",     "navigation_click",   "main_navigation_click"},
                {"LearnMenu",     "navigation_click",   "main_navigation_click"},
                {"WhyEmpowerMenu",     "navigation_click",   "main_navigation_click"},
        };
    }
    @Test(dataProvider = "clickPrimaryMenu")
    public void testClickPrimaryMenuAnalytics(String elementName, String expectedEvent,
                                                String expectedEventName) {

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .findElement(elementName)
                .getTextOfElement()
                .getLabelOfElement()
                .clickAndCaptureElement(expectedEvent, expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
        Assert.assertEquals(event.get("event_detail"), event.get("expectedElementLabel"));
    }









    @DataProvider(name = "clickWithSetCategory")
    public Object[][] clickWithSetCategory() {
        return new Object[][]{
//               elementName,             expectedEvent,   expectedEventName,         expectedEventCategory         expectedEventDetail
                {"downloadAppStore",     "button_click",   "app_store_click",         "App Store",              ""},
                {"downloadGooglePlay",   "button_click",   "app_store_click",         "Google Play",            ""},
                {"empowerLogo",          "social_click",   "social_click",            "Empower logo",            "/"},

                //Recommendation tiles/tools carousel
                {"carouselNext",          "tile_event",   "tile_move",            "prev_next",            ""},
                {"carouselPrev",          "tile_event",   "tile_move",            "prev_next",            ""},

        };
    }
    @Test(dataProvider = "clickWithSetCategory")
    public void testClickWithSetCategoryAnalytics(String elementName, String expectedEvent,
                                                  String expectedEventName, String expectedEventCategory, String expectedEventDetail) {

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .findElement(elementName)
                .clickAndCaptureElement(expectedEvent, expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), expectedEventCategory);
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }



    @Test
    public void testClickFAQExpendAnalytics() {
        String elementName = "faqExpendContract";

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .findElement(elementName)
                .getTextOfElement()
                .clickAndCaptureElement("expand_contract", "expand_contract")
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), "expand_contract");
        Assert.assertEquals(event.get("event_name"), "expand_contract");
        Assert.assertEquals(event.get("event_category"), "faq");
        Assert.assertEquals(event.get("event_detail"), event.get("expectedElementText"));
    }

    @Test
    public void testClickFAQContractAnalytics() {
        String elementName = "faqExpendContract";

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .expandFAQ()
                .findElement(elementName)
                .getTextOfElement()
                .clickAndCaptureElement("expand_contract", "expand_contract")
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), "expand_contract");
        Assert.assertEquals(event.get("event_name"), "expand_contract");
        Assert.assertEquals(event.get("event_category"), "faq");
        Assert.assertEquals(event.get("event_detail"), event.get("expectedElementText"));
    }








    @DataProvider(name = "clickMenuEvents")
    public Object[][] clickMenuEvents() {
        return new Object[][]{
//               elementName,          expectedEvent,   expectedEventName,              expectedEventDetail
                {"wealthManagementMenu",     "navigation_click",   "sub_navigation_click",         "Expand"},
                {"highYieldMenu",     "navigation_click",   "navigation_click",         "/cash"},
                {"rolloverMenu",     "navigation_click",   "navigation_click",         "/products-solutions/rollover"},

        };
    }
    @Test(dataProvider = "clickMenuEvents")
    public void testClickMenuAndCollapseAnalytics(String elementName, String expectedEvent,
                                                     String expectedEventName, String expectedEventDetail) {
        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickProdAndServiceMenu()
                .findElement(elementName)
                .getTextOfElement()
                .clickAndCaptureElement(expectedEvent,  expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }







    @DataProvider(name = "clickSubmenuEvents")
    public Object[][] clickSubmenuEvents() {
        return new Object[][]{
//               elementName,          expectedEvent,   expectedEventName,              expectedEventDetail
                {"wealthManagementMenu",     "navigation_click",   "sub_navigation_click",         "Expand"},
                {"privetClientMenu",           "navigation_click",   "navigation_click",         "/products-solutions/private-client"},
                {"personalStrategyMenu",           "navigation_click",   "navigation_click",         "/products-solutions/personal-strategy"},

        };
    }
    @Test(dataProvider = "clickSubmenuEvents")
    public void testClickSubmenuAndCollapseAnalytics(String elementName, String expectedEvent,
                                                     String expectedEventName, String expectedEventDetail) {
        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickProdAndServiceMenu()
                .clickWealthManagementSubmenu()
                .findElement(elementName)
                .getTextOfElement()
                .clickAndCaptureElement(expectedEvent,  expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }










    @DataProvider(name = "clickModalEvents")
    public Object[][] clickModalEvents() {
        return new Object[][]{
//               elementName,          expectedEvent,   expectedEventName,              expectedEventDetail
                {"continueButton",     "button_click",   "button_click_modal",         ""},
                {"cancelButton",       "button_click",   "button_click_modal",         ""},

        };
    }
    @Test(dataProvider = "clickModalEvents")
    public void testClickModalAnalytics(String elementName, String expectedEvent,
                                   String expectedEventName, String expectedEventDetail) {

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickTextLink()
                .findElement(elementName)
                .getTextOfElement()
                .clickAndCaptureElement(expectedEvent, expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }

//    @Test()
//    public void testClickFAQLinkAnalytics() {
//
//        Map<String, Object> event = new AnalyticsEventsPage(getPage())
//                .clickExpendButton()
//                .selectElement(elementName)
//                .clickAndCaptureElementWithText(expectedEvent, expectedEventName)
//                .getEvent();
//
//        Assert.assertNotNull(event, "Event not captured for: " + elementName);
//        Assert.assertEquals(event.get("event"), expectedEvent);
//        Assert.assertEquals(event.get("event_name"), expectedEventName);
//        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
//        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
//    }


























    @DataProvider(name = "hoverMenuEvents")
    public Object[][] hoverMenuEvents() {
        return new Object[][]{
//               elementName,          expectedEvent,   expectedEventName,              expectedEventDetail
                {"wealthManagementMenu",     "navigation_hover",   "navigation_hover",         ""},
                {"highYieldMenu",     "navigation_hover",   "navigation_hover",         ""},
                {"rolloverMenu",     "navigation_hover",   "navigation_hover",         ""},

        };
    }
    @Test(dataProvider = "hoverMenuEvents")
    public void testHoverMenuAndCollapseAnalytics(String elementName, String expectedEvent,
                                                  String expectedEventName, String expectedEventDetail) {
        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickProdAndServiceMenu()
                .findElement(elementName)
                .getTextOfElement()
                .hoverAndCaptureElement(expectedEvent,  expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }







    @DataProvider(name = "hoverSubmenuEvents")
    public Object[][] hoverSubmenuEvents() {
        return new Object[][]{
//               elementName,          expectedEvent,   expectedEventName,              expectedEventDetail
//                {"wealthManagementMenu",     "navigation_click",   "sub_navigation_click",         "Expand"},
                {"privetClientMenu",           "navigation_hover",   "navigation_hover",         ""},
                {"personalStrategyMenu",           "navigation_hover",   "navigation_hover",         ""},
        };
    }
    @Test(dataProvider = "hoverSubmenuEvents")
    public void testHoverSubmenuAndCollapseAnalytics(String elementName, String expectedEvent,
                                                     String expectedEventName, String expectedEventDetail) {
        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickProdAndServiceMenu()
                .clickWealthManagementSubmenu()
                .findElement(elementName)
                .getTextOfElement()
                .hoverAndCaptureElement(expectedEvent,  expectedEventName)
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), expectedEvent);
        Assert.assertEquals(event.get("event_name"), expectedEventName);
        Assert.assertEquals(event.get("event_category"), event.get("expectedElementText"));
        Assert.assertEquals(event.get("event_detail"), expectedEventDetail);
    }



//    @DataProvider(name = "hoverMenuEvents")
//    public Object[][] hoverMenuEvents() {
//        return new Object[][]{
////               elementName,          expectedEvent,   expectedEventName,              expectedEventDetail
//                {"wealthManagementMenu",     "navigation_hover",   "navigation_hover",         ""},
//                {"highYieldMenu",     "navigation_hover",   "navigation_hover",         ""},
//                {"rolloverMenu",     "navigation_hover",   "navigation_hover",         ""},
//
//        };
//    }
//    @Test()
//    public void testHoverBentoBoxAnalytics() {
//        String elementName = "expectedBentoBox";
//
//        Map<String, Object> event = new AnalyticsEventsPage(getPage())
////                .clickProdAndServiceMenu()
//                .findElement(elementName)
//                .getTextOfElement()
//                .hoverAndCaptureElement("hover_event",  "bento_hover")
//                .getEvent();
//
//        Assert.assertNotNull(event, "Event not captured for: " + elementName);
//        Assert.assertEquals(event.get("event"), "hover_event");
//        Assert.assertEquals(event.get("event_name"), "hover_event");
//        Assert.assertEquals(event.get("event_category"), event.get("expectedBentoBox"));
//        Assert.assertEquals(event.get("event_detail"), "");
//    }
}

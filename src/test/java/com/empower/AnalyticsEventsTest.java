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
//               elementName,             expectedEvent,   expectedEventNam        expectedEventDetail
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



    @DataProvider(name = "clickWithSetCategory")
    public Object[][] clickWithSetCategory() {
        return new Object[][]{
//               elementName,             expectedEvent,   expectedEventName,         expectedEventCategory         expectedEventDetail
                {"downloadAppStore",     "button_click",   "app_store_click",         "App Store",              ""},
                {"downloadGooglePlay",   "button_click",   "app_store_click",         "Google Play",            ""},
                {"empowerLogo",          "social_click",   "social_click",            "Empower logo",            "/"},

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
    public void testClickCarouselNextAnalytics() {
        String elementName = "carouselNext";

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .findElement(elementName)
                .clickAndCaptureElement("tile_event", "tile_move")
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), "tile_event");
        Assert.assertEquals(event.get("event_name"), "tile_move");
        Assert.assertEquals(event.get("event_category"), "prev_next");
        Assert.assertEquals(event.get("event_detail"), "");
    }

    @Test(dependsOnMethods = "testClickCarouselNextAnalytics")
    public void testClickCarouselPrevAnalytics() {
        String elementName = "carouselPrev";

        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .findElement(elementName)
                .clickAndCaptureElement("tile_event", "tile_move")
                .getEvent();

        Assert.assertNotNull(event, "Event not captured for: " + elementName);
        Assert.assertEquals(event.get("event"), "tile_event");
        Assert.assertEquals(event.get("event_name"), "tile_move");
        Assert.assertEquals(event.get("event_category"), "prev_next");
        Assert.assertEquals(event.get("event_detail"), "");
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

    @Test(dependsOnMethods = "testClickFAQExpendAnalytics")
    public void testClickFAQContractAnalytics() {
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





}

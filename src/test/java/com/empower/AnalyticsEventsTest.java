package com.empower;

import com.empower.pages.AnalyticsEventsPage;
import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class AnalyticsEventsTest extends BaseTest {

    @Test
    public void testBlueCTAButtonPOM() {
        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickAndCaptureEventOfPrimaryButton("button_click", "button_click_cta");

        Assert.assertNotNull(event, "Event 'button_click' not found!");
        Assert.assertEquals(event.get("event"), "button_click");
        Assert.assertEquals(event.get("event_name"), "button_click_cta");
        Assert.assertEquals(event.get("event_category"), event.get("buttonText"));
        Assert.assertEquals(event.get("event_detail"), "/products-solutions/private-client");
    }

    @Test
    public void testBlueCTAButton_PrivateClientPOM() {
        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickAndCaptureEventOfPrimaryButton_PC("button_click", "button_click_cta");

        Assert.assertNotNull(event, "Event 'button_click' not found!");
        Assert.assertEquals(event.get("event"), "button_click");
        Assert.assertEquals(event.get("event_name"), "button_click_cta");
        Assert.assertEquals(event.get("event_category"), event.get("buttonText"));
        Assert.assertEquals(event.get("event_detail"), "/products-solutions/private-client");
    }

    @Test
    public void testPrivateClientCTAButton_BrandedGoldPOM() {
        Map<String, Object> event = new AnalyticsEventsPage(getPage())
                .clickAndCaptureEventOfBrandedGoldenBotton("button_click", "button_click_branded");

        Assert.assertNotNull(event, "Event 'button_click' not found!");
        Assert.assertEquals(event.get("event"), "button_click");
        Assert.assertEquals(event.get("event_name"), "button_click_branded");
        Assert.assertEquals(event.get("event_category"), event.get("buttonText"));
        Assert.assertEquals(event.get("event_detail"), "/products-solutions/private-client");
    }


    @DataProvider(name = "buttonEvents")
    public Object[][] buttonEvents() {
        return new Object[][]{
                // buttonName,        eventType,      eventName,              eventDetail
                {"primaryButton", "button_click", "button_click_cta", "/products-solutions/private-client"},
                {"primaryButtonPC", "button_click", "button_click_cta", "/products-solutions/private-client"},
                {"brandedGoldButton", "button_click", "button_click_branded", "/products-solutions/private-client"},
        };
    }

    @Test
    public void testAnalytics(String buttonName, String eventType,
                              String eventName, String eventDetail) {

        new AnalyticsEventsPage(getPage())
                .selectElement()
                .clickAndCapture()
                .getEvent();

        Assert.assertTrue(event.exists(), "Event not captured for button: " + buttonName);
        Assert.assertEquals(event.get("event"), eventType);
        Assert.assertEquals(event.get("event_name"), eventName);
        Assert.assertEquals(event.get("event_category"), event.getButtonText());
        Assert.assertEquals(event.get("event_detail"), eventDetail);
    }
}

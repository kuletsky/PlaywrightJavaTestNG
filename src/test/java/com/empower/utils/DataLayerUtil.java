package com.empower.utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;
import java.util.Map;

public class DataLayerUtil {
    @SuppressWarnings("unchecked")
    public static Map<String, Object> clickAndCaptureEvent(Page page, Locator button,
                                                     String eventType, String eventName) {
        return (Map<String, Object>) page.evaluate("""
                    (args) => {
                        const [element, eventType, eventName] = args;
                        return new Promise((resolve) => {
                            const originalPush = window.dataLayer.push.bind(window.dataLayer);
                            window.dataLayer.push = function() {
                                for (let i = 0; i < arguments.length; i++) {
                                    const e = arguments[i];
                                    if (e && e.event === eventType && e.event_name === eventName) {
                                        resolve(JSON.parse(JSON.stringify(e)));
                                    }
                                }
                                return originalPush.apply(window.dataLayer, arguments);
                            };
                
                            element.click();
                
                            setTimeout(() => resolve(null), 3000);
                        });
                    }
                """, List.of(button.elementHandle(), eventType, eventName));
    }
}

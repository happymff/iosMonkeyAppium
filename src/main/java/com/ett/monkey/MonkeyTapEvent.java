package com.ett.monkey;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by mff on 17/09/12.
 */
public class MonkeyTapEvent extends MonkeyEvent{
    private int width, height;
    private IOSDriver driver;


    public MonkeyTapEvent(IOSDriver driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_TAP);
        this.width = width;
        this.height = height;
        this.driver = driver;
    }

    public int injectEvent() throws Exception {
        double x = Math.ceil(Math.random() * (width - 1));
        double y = Math.ceil(Math.random() * (height - 1));
        System.out.println("sending Tap Event : Tap->(" + x + ", " + y + ")");
        TouchAction action = new TouchAction(driver);
        action.tap((int)x,  (int)y).perform();
        //driver.touchAsync("tap", jSONObject);
        return MonkeyEvent.INJECT_SUCCESS;
    }
}

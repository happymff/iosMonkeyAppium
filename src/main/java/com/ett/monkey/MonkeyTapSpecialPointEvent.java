package com.ett.monkey;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by mff on 17/09/12.
 */
public class MonkeyTapSpecialPointEvent extends MonkeyEvent{
    private int width, height;
    private IOSDriver driver;


    public MonkeyTapSpecialPointEvent(IOSDriver driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_TAP);
        this.width = width;
        this.height = height;
        this.driver = driver;

    }


    public int injectEvent() throws Exception {
        System.out.println("sending SpecialPoint Tap Event : Tap->(" + this.width + ", " + this.height + ")");
        TouchAction action = new TouchAction(driver);
        action.tap(width, height).perform();
        //driver.touchAsync("tap", jSONObject);
        return MonkeyEvent.INJECT_SUCCESS;
    }
}

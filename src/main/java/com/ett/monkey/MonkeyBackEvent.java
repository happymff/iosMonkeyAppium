package com.ett.monkey;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

/**
 * Created by mff on 17/09/12.
 */

public class MonkeyBackEvent extends MonkeyEvent {
    private int backX, backY;
    private IOSDriver driver;

    public MonkeyBackEvent(IOSDriver driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_BACK);
        this.backX = width;
        this.backY = height;
        this.driver = driver;
    }

    public int injectEvent() throws Exception {
        System.out.println("sending Event : Back->(" + backX + "," + backY + ")");
        TouchAction action = new TouchAction(driver);
        action.tap(backX, backY).perform();
        return MonkeyEvent.INJECT_SUCCESS;
    }
}

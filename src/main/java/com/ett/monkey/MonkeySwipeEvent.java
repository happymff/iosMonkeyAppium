package com.ett.monkey;

import io.appium.java_client.ios.IOSDriver;

/**
 * Created by mff on 17/09/12.
 */
public class MonkeySwipeEvent extends MonkeyEvent {
    private int width, height;
    private IOSDriver driver;


    public MonkeySwipeEvent(IOSDriver driver, int width, int height) {
        super(MonkeyEvent.EVENT_TYPE_SWIPE);
        this.width = width;
        this.height = height;
        this.driver = driver;

    }

    public int injectEvent() throws Exception {
        double startX = Math.ceil(Math.random() * (width - 1));
        double startY = Math.ceil(Math.random() * (height - 1));
        double endX = Math.ceil(Math.random() * (width - 1));
        double endY = Math.ceil(Math.random() * (height - 1));
        System.out.println("sending Swipe Event : Swipe-> [start(" + startX + "," + startY + "), end(" + startX + "," + endY+")]");
        driver.swipe((int)startX,(int)startY,(int)endX,(int)endY,200);

        return MonkeyEvent.INJECT_SUCCESS;
    }
}

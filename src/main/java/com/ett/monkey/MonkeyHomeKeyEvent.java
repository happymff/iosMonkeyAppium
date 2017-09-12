package com.ett.monkey;

import io.appium.java_client.MobileCommand;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;

import com.ett.monkey.util.Shell;

/**
 * Created by mff on 17/09/12.
 */

public class MonkeyHomeKeyEvent extends MonkeyEvent{
	private String UDID, BUNDLEID;	
    private IOSDriver driver;

    public MonkeyHomeKeyEvent(IOSDriver driver, String udid, String bundleid) {
        super(MonkeyEvent.EVENT_TYPE_HOMEKEY);
        this.driver = driver;
        this.UDID = udid;
        this.BUNDLEID = bundleid;

    }


    public int injectEvent() throws Exception {
    	System.out.println("sending HOMEKEY Event.");
    	driver.execute(MobileCommand.RUN_APP_IN_BACKGROUND);
    	new Thread(new Runnable() {
            public void run() {
                try {
                    Shell.exec("pkill idevicedebug");
                    System.out.println("idevicedebug stop");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("launch App:" + BUNDLEID);
                try {
                    Shell.exec("idevicedebug -u " + UDID + " run " + BUNDLEID);
                    Thread.sleep(3000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        return MonkeyEvent.INJECT_SUCCESS;
    } 
}

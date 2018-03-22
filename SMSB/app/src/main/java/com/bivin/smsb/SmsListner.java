package com.bivin.smsb;

/**
 * Created by bivin on 3/19/2018.
 */

public interface SmsListner {
    public void messageReceived (String messageText,String sender);
}

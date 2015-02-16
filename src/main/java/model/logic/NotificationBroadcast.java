package model.logic;

import endpoints.Notification;

/**
 *
 * @author skuarch
 */
public class NotificationBroadcast {

    /**
     * this class doesn't need a constructor.
     */
    private NotificationBroadcast(){
    
    }
    
    //==========================================================================
    /**
     * send message to all clients
     *
     * @param text String
     */
    public static void sendMessage(String text) {
        
        if (text == null) {
            throw new NullPointerException("text is null");
        }

        new Notification().onMessage(text);
    } // end sendMessage

} // end class
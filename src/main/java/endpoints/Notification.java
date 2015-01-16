package endpoints;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import org.apache.log4j.Logger;
import javax.websocket.Session;

/**
 *
 * @author skuarch
 */
@ServerEndpoint("/notification")
public class Notification {
    
    private final static Logger logger = Logger.getLogger(Notification.class);
    private final static HashSet<Session> sessions = new HashSet<>();
    private final static Set set = Collections.synchronizedSet(sessions);

    //==========================================================================
    public Notification() {
    }
    
    //==========================================================================
    @OnOpen
    public void onOpen(Session session) {
        try {
            sessions.add(session);
        } catch (Exception e) {
            logger.error("onOpen", e);
        }
    } // end onOpen

    //==========================================================================
    @OnClose
    public void onClose(Session session) {
        try {
            set.remove(session);
        } catch (Exception e) {
            logger.error(e);
        }
    } // end onClose

    //==========================================================================
    @OnMessage
    public void onMessage(String text) {
        try {

            if (sessions.size() > 0) {

                sessions.stream().filter((session) -> (session.isOpen())).forEach((session) -> {
                    session.getAsyncRemote().sendText(text);
                });

            }

        } catch (Exception e) {
            logger.error(e);
        }

    } // end onMessage
} // end class
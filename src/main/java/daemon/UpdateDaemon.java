package daemon;


import model.data_node.ejb.DataNodeEJB;
import model.data_node.model.DataNode;
import util.Util;

import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

@LocalBean
public class UpdateDaemon {

    @EJB
    private DataNodeEJB dataNodeEJB;

    private String USER_NAME = Util.getUserName();
    private String PASSWORD = Util.getPassword();


    /**
     * heartbeat method updates is_active column in data_node table every 3 seconds checks if server is reachable
     * @throws IOException
     */
    @AccessTimeout(0)
    @Schedule(info = "update data_node table", persistent = false, hour = "*", minute = "*", second = "*/3")
    private void UpdateMainInfo() throws IOException {
        ArrayList<String> listOfNodes = Util.getNodeAddresses();
        for (String host : listOfNodes) {
            DataNode dataNode = dataNodeEJB.findByHost(host);
            if (dataNode != null) {
                if (!InetAddress.getByName(host).isReachable(3000)) {
                    dataNode.setActive(false);
                } else {
                    dataNode.setActive(true);
                }
            }
        }
    }
}

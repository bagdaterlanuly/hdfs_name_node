package daemon;

import javax.ejb.*;

@LocalBean
public class UpdateDaemon {

    @AccessTimeout(0)
    @Schedule(info = "Update main_info table", persistent = false, hour = "*", minute = "*/3")
    private void UpdateMainInfo(){
    }
}

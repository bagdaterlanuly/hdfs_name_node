import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Util {
    private static Properties cluster;

    static {
        cluster = new Properties();
        try {
            cluster.load(Util.class.getResourceAsStream("/cluster.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getcluster() {
        String[] clusters = cluster.getProperty("data_nodes").replaceAll("'", "").split(",");
        return new ArrayList<String>(Arrays.asList(clusters));
    }

    public static Integer getCount() {
        return Integer.valueOf(cluster.getProperty("data_node_count"));
    }


}

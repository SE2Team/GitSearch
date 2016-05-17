package data;

import org.kohsuke.github.GitHub;

import java.io.IOException;

/**
 * Created by moeyui on 2016/5/15 0015.
 */
public class InitConnection {
    static GitHub g;
    public InitConnection() throws IOException {
        g=GitHub.connect("moeyui1", "5fb3a84f2bf21c2913394d3e2f2a6356eaa42386");
    }

    public static GitHub getG() {
        return g;
    }
}

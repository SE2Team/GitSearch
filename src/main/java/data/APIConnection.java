package data;

import org.kohsuke.github.GitHub;

import java.io.IOException;

/**
 * Created by moeyui on 2016/5/15 0015.
 */
public class APIConnection {
    static GitHub g;

    public static GitHub getG() {
        return g;
    }
    public static void  initAPIConnection() throws IOException {
        g=GitHub.connect("moeyui1", "c749ca0690e38c11e859c2b2c59224ca3e6b5abd");
    }
}

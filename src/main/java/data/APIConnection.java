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
        g=GitHub.connect("moeyui1", "3fc17311397f77f57df3b683904af8fb950fc928");
    }
}

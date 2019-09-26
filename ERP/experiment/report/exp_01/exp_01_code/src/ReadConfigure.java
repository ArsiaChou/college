import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigure {
    private File configFile;

    public ReadConfigure(String configFile) {
        this.configFile = new File(configFile);
    }

    /* Getter and Setter */
    public void setConfigFile(String configFileName) {
        this.configFile = new File(configFileName);
    }

    public void setConfigFile(File configFile) {
        this.configFile = configFile;
    }

    public File getConfigFile() {
        return configFile;
    }

    /* Achieving Goals */
    public Properties getAllConfigure() throws IOException {
        Properties config = new Properties();
        FileInputStream configFileInputStream = new FileInputStream(configFile);
        InputStream configStream = new BufferedInputStream(configFileInputStream);
        config.load(configStream);
        return config;
    }
}
package db;

import java.io.*;
import java.util.Properties;

public class ReadConfigure {
    private File configFile;

    public ReadConfigure(String configFile) {
        this.configFile = new File(configFile);
    }

    public void setConfigFile(String configFileName) {
        this.configFile = new File(configFileName);
    }

    public void setConfigFile(File configFile) {
        this.configFile = configFile;
    }

    public File getConfigFile() {
        return configFile;
    }

    public Properties getAllConfigure()  {
        Properties config = new Properties();
        FileInputStream configFileInputStream = null;
//        System.out.println("rc: "+configFile.exists()+" path: "+this.getClass().getResource("/"));

        try {
            configFileInputStream = new FileInputStream(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert configFileInputStream != null;
        InputStream configStream = new BufferedInputStream(configFileInputStream);
        try {
            config.load(configStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}
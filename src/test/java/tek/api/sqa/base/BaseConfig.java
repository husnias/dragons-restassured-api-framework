package tek.api.sqa.base;

import org.testng.Assert;
import tek.api.utility.YamlPropertyReader;
import tek.api.model.AuthUser;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class BaseConfig {

    private static final String ENV_CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/env-config.yml";
    private YamlPropertyReader propertyReader;
    public BaseConfig() {
        try {
            propertyReader = YamlPropertyReader.getInstance(ENV_CONFIG_FILE_PATH);
        }catch (FileNotFoundException ex) {
            Assert.fail("Fail to read property files with message " + ex.getMessage());
        }
    }

    private HashMap getApiProperties() {
        return this.propertyReader.getProperty("api");
    }
    public String getBaseUrl() {
      return getApiProperties().get("base_url").toString();
    }

    public AuthUser getAuthUser() {
        HashMap<String, String> userMap = (HashMap<String, String>) getApiProperties().get("users");
        AuthUser authUser = new AuthUser();
        authUser.setUsername(userMap.get("username"));
        authUser.setPassword(userMap.get("password"));
    return authUser;
    }
    public HashMap<String, String> getDatabaseProperties() {
    	return (HashMap<String, String>) this.propertyReader.getProperty("db");
    }
}

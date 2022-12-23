package hillel;

import hillel.impl.ServiceImpl;

import java.io.File;
import java.io.IOException;

public interface ToJsonConverter {

    void convertToJson(File yamlFile, ServiceImpl service) throws IOException;

}

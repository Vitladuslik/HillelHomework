package hillel;

import hillel.impl.ServiceImpl;

import java.io.File;
import java.io.IOException;

public interface ToYamlConverter {

    void convertToYaml(File jsonFile, ServiceImpl service) throws IOException;

}

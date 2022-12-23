package hillel;

import hillel.impl.ServiceImpl;

import java.io.IOException;
import java.nio.file.Path;

public interface FileWriter {

    void write(Path path, String result, ServiceImpl service) throws IOException;

}

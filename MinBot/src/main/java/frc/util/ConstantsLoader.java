package frc.util;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import edu.wpi.first.wpilibj.Filesystem;

public class ConstantsLoader {
    ObjectMapper mapper;
    Collection<File> sources;
    Path constantsLocation;
    private ConstantsLoader(){
        constantsLocation = Filesystem.getDeployDirectory().toPath().resolve("constants");
        mapper = new ObjectMapper(new YAMLFactory());
        sources = FileUtils.listFiles(constantsLocation.toFile(), new RegexFileFilter("*"), DirectoryFileFilter.DIRECTORY);
    }

    public void addSource(){

    }
}

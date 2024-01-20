// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import edu.wpi.first.wpilibj.Filesystem;
import frc.robot.constants.DriveConstants;


public final class Constants {
    private static Constants m_instance;
    private DriveConstants drive;


    private Constants() {}

    public Constants loadConstants() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        return mapper.readValue(new File(Filesystem.getDeployDirectory().getAbsolutePath()+"/constants/constants.yaml"), Constants.class);

    }

    public DriveConstants getDrive() {
        return this.drive;
    }

    public void setDrive(DriveConstants constants) {
        this.drive = constants;
    }

    public static Constants getInstance() {
        if(m_instance == null) {
            m_instance = new Constants();
        }
        return m_instance;
    }

}

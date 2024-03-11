package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.cscore.VideoSource.ConnectionStrategy;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {
    public UsbCamera camera1;
    public UsbCamera camera2;
    public VideoSink server;
    
    private boolean camera1Active;
    
    public CameraSubsystem() {
        camera1 = CameraServer.startAutomaticCapture(0);
        camera2 = CameraServer.startAutomaticCapture(1);
        
        server = CameraServer.addSwitchedCamera("Switch Camera");
        
        camera1.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
        camera2.setConnectionStrategy(ConnectionStrategy.kKeepOpen);
        
        camera1Active = true;
    }
}
   
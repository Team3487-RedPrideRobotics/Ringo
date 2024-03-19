package frc.robot.subsystems;

import org.opencv.video.Video;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode;
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
        
        camera1.setFPS(30);
        camera1.setResolution(1152 , 648);
        //VideoMode.PixelFormat.kMJPEG;

    }
}
   
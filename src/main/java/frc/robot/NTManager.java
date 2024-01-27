package frc.robot;

import edu.wpi.first.networktables.BooleanPublisher;
import edu.wpi.first.networktables.BooleanSubscriber;
import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NTManager{

    
    public static DoubleSubscriber driveSpeedSub;
    
    public static BooleanSubscriber invertLowerArmMotorSub;
    public static BooleanSubscriber invertClawMotorSub;
    public static BooleanSubscriber invertUpperArmMotorSub;

    public static DoubleSubscriber armSpeedSub;

    public static DoubleSubscriber clawSpeedSub;

    public static BooleanPublisher invertClawMotorPub;

    public static DoublePublisher driveSpeedPub;

    public static BooleanPublisher invertLowerArmMotorPub;

    public static BooleanPublisher invertUpperArmMotorPub;

    public static DoublePublisher armSpeedPub;

    public static DoublePublisher clawSpeedPub;

    public static DoublePublisher pitchPub;

    public static DoublePublisher xDisplacementPub;

    public static DoublePublisher yDisplacementPub;

    public static DoublePublisher zDisplacementPub;

    public static DoublePublisher upperArmSpeedPub;

    public static DoubleSubscriber upperArmSpeedSub;

    public static DoubleSubscriber driveSprintSub;

    public static DoublePublisher driveSprintPub;
    

    public static void initialize(){
        var networkTable = NetworkTableInstance.getDefault();
        var driveTable = networkTable.getTable("Drive Table");

        
        // Drive Speed
        var driveSpeedTopic = driveTable.getDoubleTopic("Drive Speed"); 
        driveSpeedPub = driveSpeedTopic.publish();
        driveSpeedPub.setDefault(Constants.DriveEdits.DriveSpeed);
        driveSpeedSub = driveSpeedTopic.subscribe(Constants.DriveEdits.DriveSpeed);

        
    }
}
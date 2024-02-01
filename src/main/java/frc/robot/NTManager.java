package frc.robot;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.DoubleSubscriber;
import edu.wpi.first.networktables.NetworkTableInstance;

public class NTManager{

    
    public static DoubleSubscriber driveSpeedSub;
    public static DoublePublisher driveSpeedPub;

    public static DoubleSubscriber turnSpeedSub;
    public static DoublePublisher turnSpeedPub;

    public static DoubleSubscriber intakeSpeedSub;
    public static DoublePublisher intakeSpeedPub;

    public static DoubleSubscriber climbSpeedSub;
    public static DoublePublisher climbSpeedPub;

    public static DoubleSubscriber shootSpeedSub;
    public static DoublePublisher shootSpeedPub;
    
    public static void initialize(){
        var networkTable = NetworkTableInstance.getDefault();
        var speedTable = networkTable.getTable("Speed Table");

        
        var driveSpeedTopic = speedTable.getDoubleTopic("Drive Speed"); 
        driveSpeedPub = driveSpeedTopic.publish();
        driveSpeedPub.setDefault(Constants.DriveEdits.DriveSpeed);
        driveSpeedSub = driveSpeedTopic.subscribe(Constants.DriveEdits.DriveSpeed);

        var turnSpeedTopic = speedTable.getDoubleTopic("Turn Speed");
        turnSpeedPub = turnSpeedTopic.publish();
        turnSpeedPub.setDefault(Constants.DriveEdits.TurnSpeed);
        turnSpeedSub = turnSpeedTopic.subscribe(Constants.DriveEdits.TurnSpeed);

        
        var inakeSpeedTopic = speedTable.getDoubleTopic("Intake Speed"); 
        intakeSpeedPub = inakeSpeedTopic.publish();
        intakeSpeedPub.setDefault(Constants.intakeEdits.intakeSpeed);
        intakeSpeedSub = inakeSpeedTopic.subscribe(Constants.intakeEdits.intakeSpeed);

        var climbSpeedTopic = speedTable.getDoubleTopic("Climb Speed"); 
        climbSpeedPub = climbSpeedTopic.publish();
        climbSpeedPub.setDefault(Constants.climbEdits.climbSpeed);
        climbSpeedSub = climbSpeedTopic.subscribe(Constants.climbEdits.climbSpeed);

        var shootSpeedTopic = speedTable.getDoubleTopic("Shoot Speed"); 
        shootSpeedPub = shootSpeedTopic.publish();
        shootSpeedPub.setDefault(Constants.DriveEdits.DriveSpeed);
        shootSpeedSub = shootSpeedTopic.subscribe(Constants.DriveEdits.DriveSpeed); 

    }
}
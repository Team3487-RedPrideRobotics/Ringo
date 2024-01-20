package frc.robot.subsystems;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.DriveConstants;
import frc.robot.constants.DriveConstants.DriveConstantsFactory;

public class Drive extends SubsystemBase {        

    private Spark s_left;
    private SimpleMotorFeedforward ff_left;

    private Spark s_right;
    private SimpleMotorFeedforward ff_right;

    private DifferentialDrive m_driveBase = new DifferentialDrive(s_left, s_right);

    private DifferentialDriveOdometry m_odometry = new DifferentialDriveOdometry(new Rotation2d());
    private Pose2d m_pose;

    private Encoder e_left;
    private Encoder e_right;

    private Gyro m_gyro;

    private NetworkTableEntry reloadConstants;

    /**
     * 
     * @param gyro Any object of type Gryo needs to be supplied for the Drive.
     * @param constants
     */
    public Drive(Gyro gyro, DriveConstants constants) {
        this.m_gyro = gyro;
        loadConstants(constants);
        resetEncoders();
        
        reloadConstants = NetworkTableInstance.getDefault().getEntry("Shuffleboard/Drive/Reload Constants");
        reloadConstants.addListener(event -> {
            if ((event.flags & EntryListenerFlags.kLocal) == EntryListenerFlags.kLocal) {
                return;
            }
            if(!event.getEntry().getBoolean(false)) {
                //TODO Populate Factory
                DriveConstantsFactory factory = null;
                DriveConstants m_constants = factory.constructConstants();
                this.loadConstants(m_constants);
                event.getEntry().setBoolean(false);
            }
        }, EntryListenerFlags.kDelete | EntryListenerFlags.kUpdate);
    }

    private void loadConstants(DriveConstants constants) {

        s_left = new Spark(constants.getPwmLeft());
        ff_left = new SimpleMotorFeedforward(constants.getkSL(), constants.getkVC(),constants.getkAL());
        int[] left_encoder = constants.getdEncoderLeft();
        if(left_encoder.length > 2) {
            e_left = new Encoder(left_encoder[0], left_encoder[1], left_encoder[2], constants.isbLeftInverted());
        } else {
            e_left = new Encoder(left_encoder[0], left_encoder[1], constants.isbLeftInverted());
        }

        s_right = new Spark(constants.getPwmRight());
        ff_right = new SimpleMotorFeedforward(constants.getkSR(), constants.getkVR(), constants.getkAR());
        int[] right_encoder = constants.getdEncoderRight();
        if(right_encoder.length > 2) {
            e_right = new Encoder(right_encoder[0], right_encoder[1], right_encoder[2], constants.isbRightInverted());
        } else {
            e_right = new Encoder(right_encoder[0], right_encoder[1], constants.isbRightInverted());
        }

    }

    //updates distance per pulse for encoders with inches
    public void updateDistancePerPulse(double wheelDiameterIn) {
        double circumference = Math.PI*Units.inchesToMeters(wheelDiameterIn)/2048.0;
        e_left.setDistancePerPulse(circumference);
        e_right.setDistancePerPulse(circumference);
    }

    public void periodic() {
        //TODO get Gyro stuff
        m_pose = m_odometry.update(getHeading(), e_left.getDistance(), e_right.getDistance());
    }
    
    public void resetEncoders() {
        e_left.reset();
        e_right.reset();
    }

    //Resets the odometry on the encoders
    public void resetOdometry() {
        resetEncoders();
        m_odometry.resetPosition(new Pose2d(), new Rotation2d(0));
    }

    public Rotation2d getHeading() {
       return m_gyro.getRotation2d();
    }

    public Pose2d getPose() {
        return m_pose;
    }

    public void feedForwardTank(double leftSpeed, double rightSpeed) {
        s_left.setVoltage(ff_left.calculate(leftSpeed));
        s_right.setVoltage(ff_right.calculate(rightSpeed));

        m_driveBase.feed();
    }

    public void simpleTank(double propLeft, double propRight) {
        m_driveBase.tankDrive(propLeft, propRight);
    }
}

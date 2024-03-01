// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.simulation.ADXRS450_GyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;


public class DriveSubsystem extends SubsystemBase {
    
    private CANSparkMax left_Back_Motor;
    private CANSparkMax left_Front_Motor;
    private CANSparkMax right_Back_Motor;
    private CANSparkMax right_Front_Motor;
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;
    private DifferentialDrive drive;

    //drivetrain simulation
    public DifferentialDrivetrainSim drivetrainSimulator;
    private final EncoderSim LeftEncoderSim;
    private final EncoderSim RightEncoderSim;
    private final Field2d m_fieldSim;
    private final ADXRS450_GyroSim gyroSim;
    private final DifferentialDriveOdometry odometry;
    private final ADXRS450_Gyro gyro = new ADXRS450_Gyro();


    
    public DriveSubsystem() {
        left_Back_Motor = new CANSparkMax(Constants.DriveConstants.left_Back_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        left_Front_Motor = new CANSparkMax(Constants.DriveConstants.left_Front_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        
        left_Back_Motor.follow(left_Front_Motor);

        left_Front_Motor.setInverted(true);
        
        right_Back_Motor = new CANSparkMax(Constants.DriveConstants.right_Back_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        right_Front_Motor = new CANSparkMax(Constants.DriveConstants.right_Front_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        
        right_Back_Motor.follow(right_Front_Motor);
        
        drive = new DifferentialDrive(left_Front_Motor, right_Front_Motor);
        drive.setSafetyEnabled(true);
        drive.setExpiration(0.1);
        drive.setMaxOutput(1.0);

        leftEncoder = left_Front_Motor.getEncoder();
        leftEncoder.setPositionConversionFactor(Constants.DriveConstants.EncoderConversionFactor);
        rightEncoder = right_Front_Motor.getEncoder();
        rightEncoder.setPositionConversionFactor(Constants.DriveConstants.EncoderConversionFactor);

        

        
        // The left-side drive encoder
       final Encoder leftEncoder =
        new Encoder(
            DriveConstants.left_Front_Motor_ID,
            DriveConstants.left_Back_Motor_ID,
            false);

        // The right-side drive encoder
        final Encoder rightEncoder =
        new Encoder(
            DriveConstants.right_Front_Motor_ID,
            DriveConstants.right_Back_Motor_ID,
            true);

        odometry =
        new DifferentialDriveOdometry(
            Rotation2d.fromDegrees(getHeading()),
            leftEncoder.getDistance(),
            rightEncoder.getDistance());


    if (RobotBase.isSimulation()) { // If our robot is simulated
      // This class simulates our drivetrain's motion around the field.
      drivetrainSimulator =
          new DifferentialDrivetrainSim(
              DriveConstants.kDrivetrainPlant,
              DriveConstants.kDriveGearbox,
              DriveConstants.kDriveGearing,
              DriveConstants.kTrackwidthMeters,
              DriveConstants.kWheelDiameterMeters / 2.0,
              VecBuilder.fill(0, 0, 0.0001, 0.1, 0.1, 0.005, 0.005));

      // The encoder and gyro angle sims let us set simulated sensor readings
      LeftEncoderSim = new EncoderSim(leftEncoder);
      RightEncoderSim = new EncoderSim(rightEncoder);
      gyroSim = new ADXRS450_GyroSim(gyro);

      // the Field2d class lets us visualize our robot in the simulation GUI.
      m_fieldSim = new Field2d();
      SmartDashboard.putData("Field", m_fieldSim);
    } else {
      LeftEncoderSim = null;
      RightEncoderSim = null;
      gyroSim = null;

      m_fieldSim = null;
    }

    leftEncoder.setDistancePerPulse(DriveConstants.EncoderConversionFactor);
    rightEncoder.setDistancePerPulse(DriveConstants.EncoderConversionFactor);
    }
    
    @Override
    public void periodic() {
        Constants.DriveEdits.DriveSpeed = frc.robot.NTManager.driveSpeedSub.get();
        Constants.DriveEdits.TurnSpeed = frc.robot.NTManager.turnSpeedSub.get();
    }
    
    

    @Override
    public void simulationPeriodic() {
       
          // To update our simulation, we set motor voltage inputs, update the simulation,
          // and write the simulated positions and velocities to our simulated encoder and gyro.
          // We negate the right side so that positive voltages make the right side
          // move forward.

        drivetrainSimulator.setInputs(
            left_Front_Motor.get() * RobotController.getBatteryVoltage(),
            right_Front_Motor.get() * RobotController.getBatteryVoltage());
          
        drivetrainSimulator.update(0.020);
        
          m_fieldSim.setRobotPose(LeftEncoderSim.getDistance(), RightEncoderSim.getDistance(),Rotation2d.fromDegrees(getHeading()));

          LeftEncoderSim.setDistance(drivetrainSimulator.getLeftPositionMeters());
          LeftEncoderSim.setRate(drivetrainSimulator.getLeftVelocityMetersPerSecond());
          RightEncoderSim.setDistance(drivetrainSimulator.getRightPositionMeters());
          RightEncoderSim.setRate(drivetrainSimulator.getRightVelocityMetersPerSecond());
          gyroSim.setAngle(-drivetrainSimulator.getHeading().getDegrees());
    }
      
    
    
    public void arcadeDrive(double speed, double turning) {
        drive.arcadeDrive(speed * Constants.DriveEdits.DriveSpeed, turning * Constants.DriveEdits.TurnSpeed);
    }

    public void tankDrive(double left_speed, double right_speed){
        drive.tankDrive(left_speed * Constants.DriveEdits.DriveSpeed, right_speed * Constants.DriveEdits.DriveSpeed);
    }

    public double getLeftDriveEncoder(){
        return leftEncoder.getPosition();
    }

    public double getRightDriveEncoder(){
        return rightEncoder.getPosition();
    }

    public void resetEncoders(){
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }
    
    public double getHeading() {
        return Math.IEEEremainder(gyro.getAngle(), 360) * (true ? -1.0 : 1.0);
    }
}


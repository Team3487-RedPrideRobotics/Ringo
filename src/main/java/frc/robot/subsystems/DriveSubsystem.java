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

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveSubsystem extends SubsystemBase {
    
    private CANSparkMax left_Back_Motor;
    private CANSparkMax left_Front_Motor;
    private CANSparkMax right_Back_Motor;
    private CANSparkMax right_Front_Motor;
    private RelativeEncoder leftEncoder;
    private RelativeEncoder rightEncoder;
    private DifferentialDrive drive;
    
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
    }
    
    @Override
    public void periodic() {
        Constants.DriveEdits.DriveSpeed = frc.robot.NTManager.driveSpeedSub.get();
        Constants.DriveEdits.TurnSpeed = frc.robot.NTManager.turnSpeedSub.get();
    }
    
    @Override
    public void simulationPeriodic() {
    
    }
    
    public void arcadeDrive(double speed, double turning) {
        drive.arcadeDrive(speed * Constants.DriveEdits.DriveSpeed, turning * Constants.DriveEdits.TurnSpeed);
        //System.out.println("Left front: " + left_Front_Motor.getBusVoltage() + " Right front: " + right_Front_Motor.getBusVoltage());
        //System.out.println("Left back: " + left_Back_Motor.getBusVoltage() + " Right back: " + right_Back_Motor.getBusVoltage());
        //left_Front_Motor.enableVoltageCompensation(turning);
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
    
}


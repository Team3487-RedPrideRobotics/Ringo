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


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class Drivetrain extends SubsystemBase {

private CANSparkMax left_Back_Motor;
private CANSparkMax left_Front_Motor;


private CANSparkMax right_Back_Motor;
private CANSparkMax right_Front_Motor;


private DifferentialDrive drive;



    public Drivetrain() {
       left_Back_Motor = new CANSparkMax(Constants.DriveConstants.left_Back_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
       left_Front_Motor = new CANSparkMax(Constants.DriveConstants.left_Front_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);


       left_Back_Motor.follow(left_Front_Motor);

       right_Back_Motor = new CANSparkMax(Constants.DriveConstants.right_Back_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
       right_Front_Motor = new CANSparkMax(Constants.DriveConstants.right_Front_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);

       right_Back_Motor.follow(right_Front_Motor);

       drive = new DifferentialDrive(left_Front_Motor, right_Front_Motor);
       drive.setSafetyEnabled(true);
       drive.setExpiration(0.1);
       drive.setMaxOutput(1.0);
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }

    public void tankDrive(double leftSpeed, double rightSpeed){
        drive.tankDrive(-1*leftSpeed*Constants.DriveEdits.DriveSpeed, rightSpeed*Constants.DriveEdits.DriveSpeed);
    }

}


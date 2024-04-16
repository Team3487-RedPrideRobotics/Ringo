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

import frc.robot.Constants;
import frc.robot.Constants.shootConstants;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSubsystem extends SubsystemBase {
    private CANSparkMax leftShootMotor;
    private CANSparkMax rightShootMotor;

    //TODO motor ids should probably be arguments passed to the constructor
    public ShootSubsystem() {
        leftShootMotor = new CANSparkMax(shootConstants.left_Shoot_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        rightShootMotor = new CANSparkMax(shootConstants.right_Shoot_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    @Override
    public void periodic() {
        Constants.shootEdits.shootSpeed = frc.robot.NTManager.shootSpeedSub.get();
        Constants.shootEdits.slowShootSpeed = frc.robot.NTManager.slowShootSpeedSub.get();
    }

    @Override
    public void simulationPeriodic() {
    }

    public void shoot(double speed){
        leftShootMotor.set(speed);
        rightShootMotor.set(-speed);
    }

    public void shootOut(){
        leftShootMotor.set(Constants.shootEdits.shootSpeed);
        rightShootMotor.set(-Constants.shootEdits.shootSpeed);
    }
    
    public void disableShootMotors(){
        leftShootMotor.set(0);
        rightShootMotor.set(0);
    }
}


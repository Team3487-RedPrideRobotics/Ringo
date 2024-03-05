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
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeSubsystem extends SubsystemBase {
    private CANSparkMax floorIntake; 

    public IntakeSubsystem() {
        floorIntake = new CANSparkMax(Constants.intakeConstants.Intake_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    @Override
    public void periodic() {
        //TODO this code probably belongs in the NTManager class
        Constants.intakeEdits.intakeSpeed = frc.robot.NTManager.intakeSpeedSub.get();
    }

    @Override
    public void simulationPeriodic() {
    }

    public void intake(double speed){
        floorIntake.set(-speed);   
    }
}


package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.armEdits;

public class ArmSubsystem extends SubsystemBase {
    
    private CANSparkMax leftArmMotor;
    private CANSparkMax rightArmMotor;
    private RelativeEncoder armEncoder;

    public ArmSubsystem(){
        leftArmMotor = new CANSparkMax(Constants.armConstants.left_Arm_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        leftArmMotor.setInverted(true);

        rightArmMotor = new CANSparkMax(Constants.armConstants.right_Arm_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);

        armEncoder = leftArmMotor.getEncoder();
    }

    @Override
    public void periodic() {
        Constants.armEdits.armSpeed = frc.robot.NTManager.armSpeedSub.get();
    }

    public void armMotors(double armSpeed){
        leftArmMotor.set(armSpeed * armEdits.armSpeed);
        rightArmMotor.set(armSpeed * armEdits.armSpeed);
    }

    public double getPosition(){
        return armEncoder.getPosition();
    }

    public void resetEncoder(){
        armEncoder.setPosition(0);
    }
}

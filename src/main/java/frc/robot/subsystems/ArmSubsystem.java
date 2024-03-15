package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Encoder;
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

        armEncoder = rightArmMotor.getEncoder();
    }

    @Override
    public void periodic() {
        Constants.armEdits.armSpeed = frc.robot.NTManager.armSpeedSub.get();
    }

    public void setMotorSpeed(double speed){
        leftArmMotor.set(speed * armEdits.armSpeed);
        rightArmMotor.set(speed * armEdits.armSpeed);
    }

    public boolean goToAngle(double arm, double limit, double armkP, double threshold){
        double armDelta = Math.abs(arm) - Math.abs(armEncoder.getPosition());
        System.out.println("arm difference: " + armDelta);
        System.out.println("arm position: " + getPosition());

        if(Math.abs(armDelta) >= threshold){
            var motorSpeed = -armDelta*armkP;
            motorSpeed = Math.abs(motorSpeed) > limit ? limit * Math.signum(motorSpeed) : motorSpeed;
            System.out.println("motor speed: " + motorSpeed);
            setMotorSpeed(motorSpeed);
            return false;
          } else {
            setMotorSpeed(0);
            return true;
          }

    
      }

    public double getPosition(){
        return armEncoder.getPosition();
    }

    public void resetEncoder(){
        armEncoder.setPosition(0);
    }
  }

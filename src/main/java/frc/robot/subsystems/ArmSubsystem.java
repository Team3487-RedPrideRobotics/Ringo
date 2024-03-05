package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    
    private CANSparkMax leftArmMotor;
    private CANSparkMax rightArmMotor;
    private RelativeEncoder armEncoder;

    private RelativeEncoder armEncoder; 

    public ArmSubsystem(){
        leftArmMotor = new CANSparkMax(Constants.armConstants.left_Arm_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        leftArmMotor.setInverted(true);

        rightArmMotor = new CANSparkMax(Constants.armConstants.right_Arm_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);

        armEncoder = rightArmMotor.getEncoder();

        armEncoder = leftArmMotor.getEncoder();
    }

    @Override
    public void periodic() {
        Constants.shootEdits.shootSpeed = frc.robot.NTManager.shootSpeedSub.get();
    }

    public void armMotors(double speed){
        leftArmMotor.set(speed);
        rightArmMotor.set(speed);
    }

    public void goToAngle(double arm, double limit, double armkP){
        double delta_angle = armEncoder.getPosition() - arm;
        

        if(Math.abs(delta_angle) >= Constants.armEdits.AngleThreshold){
          armMotors(-1*Math.signum(delta_angle) * Math.abs(delta_angle*armkP));
        }else{
          arm.set(0);
        }
    
        if(Math.abs(arm.get()) >= limit){
          arm.set(limit * Math.signum(arm.get()));
        }
    
        

    
      }
    public double getPosition(){
        return armEncoder.getPosition();
    }

    public void resetEncoder(){
        armEncoder.setPosition(0);
    }
}

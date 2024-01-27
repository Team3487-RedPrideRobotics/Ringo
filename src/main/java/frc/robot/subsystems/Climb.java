
package frc.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.climbConstants;
import frc.robot.Constants.climbEdits;

public class Climb extends SubsystemBase {
    
    private CANSparkMax leftClimbMotor;
    private CANSparkMax rightClimbMotor;

    public Climb() {
       leftClimbMotor = new CANSparkMax(climbConstants.left_Shoot_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
       rightClimbMotor = new CANSparkMax(climbConstants.right_Shoot_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
    }

    @Override
    public void periodic() {
        Constants.climbEdits.climbSpeed = frc.robot.NTManager.climbSpeedSub.get();
    }

    @Override
    public void simulationPeriodic() {

    }
    
    public void climb(double speed){
        leftClimbMotor.set(speed * climbEdits.climbSpeed);
        rightClimbMotor.set(speed * climbEdits.climbSpeed * -1);
    }

}


package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.climbConstants;
import frc.robot.Constants.climbEdits;

public class ClimbSubsystem extends SubsystemBase {
    private CANSparkMax leftClimbMotor;
    private CANSparkMax rightClimbMotor;

    private DigitalInput topClimbSwitch;
    private DigitalInput bottomClimbSwitch;
    
    public ClimbSubsystem() {
        //TODO motor ids should probably be passed in as arguments
        leftClimbMotor = new CANSparkMax(climbConstants.left_Climb_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);
        rightClimbMotor = new CANSparkMax(climbConstants.right_Climb_Motor_ID, CANSparkLowLevel.MotorType.kBrushless);

        topClimbSwitch = new DigitalInput(Constants.climbConstants.top_Climb_Switch_ID);
        bottomClimbSwitch = new DigitalInput(Constants.climbConstants.bottom_Climb_Switch_ID);
    }
    
    @Override
    public void periodic() {
        Constants.climbEdits.climbSpeed = frc.robot.NTManager.climbSpeedSub.get();
    }
    
    @Override
    public void simulationPeriodic() {
    }
    
    public void climb(double speed) {
        leftClimbMotor.set(speed * climbEdits.climbSpeed);
        rightClimbMotor.set(speed * climbEdits.climbSpeed * -1);
    }

    public boolean topClimbSwitch(){
       return topClimbSwitch();
    }

    public boolean bottomClimbSwitch(){
        return bottomClimbSwitch();
    }
}

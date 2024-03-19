package frc.robot.commands.Autonomoose;

import frc.robot.Constants.armEdits;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.ArmSubsystem;

public class AutoArm extends AutonomousCommand {
    private ArmSubsystem armSubsystem;
    private Boolean _up;
 
    public AutoArm(ArmSubsystem _ArmSubsystem, boolean up){
        armSubsystem = _ArmSubsystem;
        _up = up;
    }

    @Override
    public void execute(){
        if(_up){    
            armSubsystem.goToAngle(-37, 0.6, armEdits.armKP, 15.5);
        } else {
            armSubsystem.goToAngle(0, 0.6, armEdits.armKP, 0);
        }
    }
    
    @Override
    public boolean isFinished() {
        if(_up){
            return armSubsystem.goToAngle(-37, 0.6, armEdits.armKP, 15.5);
        } else {
            return armSubsystem.goToAngle(0, 0.6, armEdits.armKP, 0);
        }
    }
}

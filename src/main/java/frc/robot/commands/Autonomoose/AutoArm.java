package frc.robot.commands.Autonomoose;

import frc.robot.Constants.armEdits;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.ArmSubsystem;

public class AutoArm extends AutonomousCommand {
    private ArmSubsystem armSubsystem;
    private Boolean _up;
    private Integer counter = 0;

    public AutoArm(ArmSubsystem _ArmSubsystem, boolean up){
        armSubsystem = _ArmSubsystem;
        _up = up;
    }

    @Override
    public void execute(){
        if(_up){    
            armSubsystem.goToAngle(-39, 0.6, armEdits.armKP, 15.5);
        } else {
            counter ++;
            armSubsystem.goToAngle(0, 0.6, armEdits.armKP, 0);
        }
    }
    
    @Override
    public boolean isFinished() {
        if(_up){
            return armSubsystem.goToAngle(-39, 0.6, armEdits.armKP, 15.5);
        } else {
            return counter >= 50;
        }
    }
}

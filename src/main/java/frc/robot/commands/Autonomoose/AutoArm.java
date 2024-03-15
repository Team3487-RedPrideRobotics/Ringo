package frc.robot.commands.Autonomoose;

import frc.robot.Constants.armEdits;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.ArmSubsystem;

public class AutoArm extends AutonomousCommand {
    private ArmSubsystem armSubsystem;
 
    public AutoArm(ArmSubsystem _ArmSubsystem){
        armSubsystem = _ArmSubsystem;
    }

    @Override
    public void execute(){
        armSubsystem.goToAngle(-37, 0.6, armEdits.armKP, 15.5);
    }
    
    @Override
    public boolean isFinished() {
        return armSubsystem.goToAngle(-37, 0.6, armEdits.armKP, 15.5);
    }
}

package frc.robot.commands.Autonomoose;

import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.ArmSubsystem;

public class AutoArm extends AutonomousCommand {
    private ArmSubsystem armSubsystem;
    private double armSpeed;
    private double distance;
    
    public AutoArm(ArmSubsystem _ArmSubsystem, double _armSpeed, double _distance){
        armSubsystem = _ArmSubsystem;
        armSpeed = _armSpeed;
        distance = _distance;
    }

    @Override
    public void execute(){
        if(armSubsystem.getPosition() <= distance){
            armSubsystem.setMotorSpeed(armSpeed);
        } else {
            armSubsystem.setMotorSpeed(0);
        }
    }
}

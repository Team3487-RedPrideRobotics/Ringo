package frc.robot.commands.Autonomoose;

import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntake extends AutonomousCommand {
    private IntakeSubsystem intake;
    private double intakeSpeed;

    public AutoIntake(IntakeSubsystem _intake, double _intakeSpeed){
        intake = _intake;
        intakeSpeed = _intakeSpeed;
    }

    @Override
    public void execute(){
        intake.intake(intakeSpeed);
    }
}

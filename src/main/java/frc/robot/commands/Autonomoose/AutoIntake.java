package frc.robot.commands.Autonomoose;

import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntake extends AutonomousCommand {
    private IntakeSubsystem _intake;
    private double _waitTime;
    private boolean done;
    private int counter;
    private double _speed;

    public AutoIntake(Double speed, IntakeSubsystem shoo, double waitTime){
        _intake = shoo;
        _waitTime = waitTime;
        done = false;
        counter = 0;
        _speed = speed;
    }

    @Override
    public void execute(){
        counter++;
        if(counter >= _waitTime){
            done = true;
            _intake.intake(0);
        } else {
            _intake.intake(_speed);
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}

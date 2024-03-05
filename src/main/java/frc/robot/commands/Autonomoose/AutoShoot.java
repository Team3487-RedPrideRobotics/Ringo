package frc.robot.commands.Autonomoose;

import edu.wpi.first.units.Time;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;

public class AutoShoot extends AutonomousCommand {
    private Timer timer;
    private ShootSubsystem _shoot;
    private IntakeSubsystem _intake;
    private double _intakeSpeed; 
    private double _waitTime;

    public AutoShoot(ShootSubsystem shoot, IntakeSubsystem intake, double intakeSpeed, double waitTime){
        _shoot = shoot;
        _intake = intake;
        _intakeSpeed = intakeSpeed;
        _waitTime = waitTime;
        timer.start();
    }

    @Override
    public void execute(){
        _shoot.shoot(1);
        if(timer.get() >= _waitTime){
            _intake.intake(_intakeSpeed);
        } else if(timer.get() >= _waitTime + .5){
           _shoot.shoot(0);
           _intake.intake(0); 
        }
    }
}

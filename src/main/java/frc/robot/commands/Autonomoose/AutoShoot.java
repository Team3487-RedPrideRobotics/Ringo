package frc.robot.commands.Autonomoose;

import edu.wpi.first.units.Time;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;

public class AutoShoot extends AutonomousCommand {
    private Timer timer;
    private ShootSubsystem _shoot;
    private double _waitTime;
    private boolean done;

    public AutoShoot(ShootSubsystem shoo, double waitTime){
        _shoot = shoo;
        _waitTime = waitTime;
        timer.start();
        done = false;
    }

    @Override
    public void execute(){
        if (timer.get() < _waitTime) {
            _shoot.shoot(1);    
        } else {
            _shoot.shoot(0);
            done = true;
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}

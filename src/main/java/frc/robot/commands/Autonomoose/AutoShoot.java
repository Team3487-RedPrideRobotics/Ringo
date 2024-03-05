package frc.robot.commands.Autonomoose;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.ShootSubsystem;

public class AutoShoot extends AutonomousCommand {
    private ShootSubsystem _shoot;
    private double _waitTime;
    private boolean done;
    private int counter;

    public AutoShoot(ShootSubsystem shoo, double waitTime){
        _shoot = shoo;
        _waitTime = waitTime;
        done = false;
        counter = 0;
    }

    @Override
    public void execute(){
        counter++;
        if(counter >= _waitTime){
            done = true;
            _shoot.shoot(0);
        } else {
            _shoot.shoot(-1);
        }
    }

    @Override
    public boolean isFinished() {
        return done;
    }
}

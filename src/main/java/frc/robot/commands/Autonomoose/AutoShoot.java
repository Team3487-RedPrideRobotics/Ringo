package frc.robot.commands.Autonomoose;
import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;

public class AutoShoot extends AutonomousCommand {
    private Timer timer;
    private ShootSubsystem _shoot;
    private double _waitTime;
    private boolean done;
    private REVPhysicsSim sim;
    private FlywheelSim flywheelSim;
    private DCMotor dcMotor;

    public AutoShoot(ShootSubsystem shoo, double waitTime){
        _shoot = shoo;
        _waitTime = waitTime;
        done = false;
        sim = new REVPhysicsSim();
        dcMotor = new DCMotor(12, 0.0000000026, 150, 1.8, 594.39, 2);
        flywheelSim = new FlywheelSim(dcMotor, 1, waitTime);
        //sim.addSparkMax(_shoot.leftShootMotor,  3, 1);
        //sim.addSparkMax(_shoot.rightShootMotor, 3, 1);
    }

    @Override
    public void execute(){
        /* 
        if (timer.get() < _waitTime) {
            _shoot.shoot(1); 
            sim.run();   
        } else {
            _shoot.shoot(0);
            done = true;
        }
        */
        
        flywheelSim.setInput(-1);

        _shoot.shoot(-1);
    }


    @Override
    public boolean isFinished() {
        return done;
    }
}

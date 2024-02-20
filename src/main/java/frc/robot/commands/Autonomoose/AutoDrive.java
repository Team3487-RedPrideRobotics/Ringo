package frc.robot.commands.Autonomoose;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive extends AutonomousCommand {
    private DriveSubsystem driveSubsystem;
    private double driveSpeed;
    private double distance;
    private boolean done;
    private Timer timer;
    
    public AutoDrive(DriveSubsystem _DriveSubsystem, double _driveSpeed, double distance){
        driveSubsystem = _DriveSubsystem;
        addRequirements(driveSubsystem);
        distance = -distance;
        driveSpeed = _driveSpeed;

        done = false;
        driveSubsystem.resetEncoders();

    }

    @Override
    public void execute(){
        //System.out.println("Left Encoder:" + driveSubsystem.getLeftDriveEncoder());
        System.out.println("only god knows");
        if(distance >= 0){
            if(driveSubsystem.getLeftDriveEncoder() >= distance ){
                driveSubsystem.tankDrive(0, 0);
                done = true;
            }else{
                driveSubsystem.tankDrive(Math.abs(driveSpeed),Math.abs(driveSpeed));
            }
        }else{
            if(-driveSubsystem.getLeftDriveEncoder() <= distance){
                driveSubsystem.tankDrive(0, 0);
                done = true;
            }else{
                driveSubsystem.tankDrive(-Math.abs(driveSpeed),-Math.abs(driveSpeed));
            }
        }
    }
    @Override
    public boolean isFinished() {
        if(done) driveSubsystem.resetEncoders();
        return done;
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.tankDrive(0, 0);
    }

}
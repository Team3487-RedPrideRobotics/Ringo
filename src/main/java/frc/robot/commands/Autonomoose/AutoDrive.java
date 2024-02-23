package frc.robot.commands.Autonomoose;

import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive extends AutonomousCommand {
    private DriveSubsystem driveSubsystem;
    private double driveSpeed;
    private double distance;
    private boolean done;
    
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
        System.out.println("Left Encoder:" + driveSubsystem.getLeftDriveEncoder());
        System.out.println("only god knows");
        if(distance >= 0){
            if(-driveSubsystem.getLeftDriveEncoder() >= distance ){
                driveSubsystem.tankDrive(0, 0);
                done = true;
            }else{
                driveSubsystem.tankDrive(driveSpeed,driveSpeed);
            }
        }else{
            if(driveSubsystem.getLeftDriveEncoder() <= distance){
                driveSubsystem.tankDrive(0, 0);
                done = true;
            }else{
                driveSubsystem.tankDrive(-driveSpeed,-driveSpeed);
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
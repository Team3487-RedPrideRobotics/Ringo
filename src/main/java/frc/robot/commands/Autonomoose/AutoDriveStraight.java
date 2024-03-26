package frc.robot.commands.Autonomoose;

import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveStraight extends AutonomousCommand {
    private DriveSubsystem m_drive;
    private double _distance;
    private double _drive_speed;
    private boolean done;
    private double pastEncoder;
    private int counter;

    public AutoDriveStraight(DriveSubsystem drive, double distance, double drive_speed)
    {
        m_drive = drive;
        _distance = distance;
        _drive_speed = drive_speed;
        counter = 0;
    }
     @Override
    public void execute() {
    pastEncoder = m_drive.getLeftDriveEncoder();
    System.out.println("Left Encoder:" + m_drive.getLeftDriveEncoder());
        if(_distance >= 0){
            if(m_drive.getLeftDriveEncoder() >= _distance ){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(_drive_speed,_drive_speed);
            }
        }else{
            if(m_drive.getLeftDriveEncoder() <= _distance){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(-_drive_speed,-_drive_speed);
            }
        }
        
    }

    
    @Override
    public boolean isFinished() {
        if(pastEncoder == m_drive.getLeftDriveEncoder()) counter++;
        if(counter > 5) done = true;
        if(done) m_drive.resetEncoders();
        return done;
        
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.tankDrive(0, 0);
    }
}
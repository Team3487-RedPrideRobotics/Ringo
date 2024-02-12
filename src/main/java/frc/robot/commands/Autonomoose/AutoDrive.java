package frc.robot.commands.Autonomoose;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive extends AutonomousCommand {
    private DriveSubsystem m_drive;
    private double _distance;
    private double _drive_speed;
    private double _turn_speed;
    private boolean done;

    public AutoDrive(DriveSubsystem drive, double distance, double drive_speed, double turn_speed)
    {
        m_drive = drive;
        _distance = -distance;
        _drive_speed = drive_speed;
        _turn_speed = turn_speed;

    }

     @Override
    public void execute() {
    System.out.println("Left Encoder:" + m_drive.getLeftDriveEncoder() + "Right Encoder: " + m_drive.getRightDriveEncoder());
        if(_distance >= 0){
            if(m_drive.getLeftDriveEncoder() >= _distance ){
                m_drive.arcadeDrive(0, 0);
                done = true;
            }else{
                m_drive.arcadeDrive(Math.abs(_drive_speed),Math.abs(_turn_speed));
            }
        }else{
            if(-m_drive.getLeftDriveEncoder() <= _distance){
                m_drive.arcadeDrive(0, 0);
                done = true;
            }else{
                m_drive.arcadeDrive(-Math.abs(_drive_speed),-Math.abs(_turn_speed));
            }
        }
        
    }

    
    @Override
    public boolean isFinished() {
        if(done) m_drive.resetEncoders();
        return done;
    }

}

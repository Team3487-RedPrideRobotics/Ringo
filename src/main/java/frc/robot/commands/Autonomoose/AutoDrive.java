package frc.robot.commands.Autonomoose;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends AutonomousCommand {
    private Drivetrain m_drive;
    private double _distance;
    private double _drive_speed;
    private boolean done;

    public AutoDrive(Drivetrain drive, double distance, double drive_speed)
    {
        m_drive = drive;
        _distance = -distance;
        _drive_speed = drive_speed;
        
    }

     @Override
    public void execute() {
    System.out.println("Left Encoder:" + m_drive.getLeftPosition());
        if(_distance >= 0){
            if(m_drive.getLeftPosition() >= _distance ){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(Math.abs(_drive_speed),Math.abs(_drive_speed));
            }
        }else{
            if(-m_drive.getLeftPosition() <= _distance){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(-Math.abs(_drive_speed),-Math.abs(_drive_speed));
            }
        }
        
    }

    
    @Override
    public boolean isFinished() {
        if(done) m_drive.resetEncoders();
        return done;
    }

}

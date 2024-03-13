package frc.robot.commands.Autonomoose;

import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTurn extends AutonomousCommand {
    private DriveSubsystem m_drive;
    private double _degree;
    private double _turning_distance;
    private double _drive_speed;
    private boolean done;

    public AutoTurn(DriveSubsystem drive, double degree, double drive_speed)
    {
        m_drive = drive;
        _degree = degree;
        _drive_speed = drive_speed;
        // need one or two more degrees in turnig ratiooss
        _turning_distance = _degree / 360 * 22 * Math.PI;
        // 22PI is circumference of rbobobtobot
        m_drive.resetEncoders();
    }
    // multiply encoder values by wheel circumference????
     @Override
    public void execute() {
        if(_turning_distance >= 0){
            if(m_drive.getLeftDriveEncoder() >= _turning_distance ){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(_drive_speed,-_drive_speed);
                System.out.println(m_drive.getLeftDriveEncoder() + " >= " + _turning_distance);
            }
        }else{
            if(m_drive.getLeftDriveEncoder() <= _turning_distance){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(-_drive_speed,_drive_speed);
                System.out.println("bottom");
            }
        }
        
    }

    
    @Override
    public boolean isFinished() {
        if(done) m_drive.resetEncoders();
        return done;
    }

    @Override
    public void end(boolean interrupted) {
        m_drive.tankDrive(0, 0);
    }
}
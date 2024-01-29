package frc.robot.commands.Autonomoose;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.AutonomousCommand;
import frc.robot.subsystems.Drivetrain;

public class AutoTurn extends AutonomousCommand {
    private Drivetrain m_drive;
    private double _degree;
    private double _turning_distance;
    private double _drive_speed;
    private boolean done;

    public AutoTurn(Drivetrain drive, double degree, double drive_speed)
    {
        m_drive = drive;
        _degree = degree;
        _drive_speed = drive_speed;
        // need one or two more degrees in turnig ratiooss
        _turning_distance = _degree / 360 * 22 * Math.PI;
        // 22PI is circumference of rbobobtobot
    }
    // multiply encoder values by wheel circumference????
     @Override
    public void execute() {
    System.out.println("Left Encoder:" + m_drive.getLeftPosition());
        if(_turning_distance >= 0){
            if(-m_drive.getLeftPosition() >= _turning_distance ){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(_drive_speed,-_drive_speed);
            }
        }else{
            if(m_drive.getLeftPosition() <= _turning_distance){
                m_drive.tankDrive(0, 0);
                done = true;
            }else{
                m_drive.tankDrive(-_drive_speed,_drive_speed);
            }
        }
        
    }

    
    @Override
    public boolean isFinished() {
        if(done) m_drive.resetEncoders();
        return done;
    }

}
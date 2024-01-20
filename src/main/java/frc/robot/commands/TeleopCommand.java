

package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class TeleopCommand extends Command {

    private Drivetrain m_drive;

    public TeleopCommand(Drivetrain drive) {

        m_drive = drive;
        addRequirements(m_drive);
        
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

    XboxController drive_controller = RobotContainer.getInstance().getDriveController();
    
   
    if (drive_controller.getLeftY() >= 0.05) {
            m_drive.tankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
        } else if(drive_controller.getLeftY() <= -0.05){
            m_drive.tankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
        } else if(drive_controller.getRightY() >= 0.05){
            m_drive.tankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
        } else if(drive_controller.getRightY() <= -0.05){
            m_drive.tankDrive(drive_controller.getLeftY(), drive_controller.getRightY());
        } else {
            m_drive.tankDrive(0, 0);
        }
    
    }
        



    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
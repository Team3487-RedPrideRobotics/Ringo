

package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveEdits;
import frc.robot.Constants.intakeEdits;
import frc.robot.Constants.shootEdits;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shoot;
import frc.robot.subsystems.Camera;

public class TeleopCommand extends Command {

    private Drivetrain m_drive;
    private Intake m_intake;
    private Climb m_climb;
    private Shoot m_shoot;
    private Camera m_camera;

    public TeleopCommand(Drivetrain drive, Intake intake, Climb climb, Shoot shoot, Camera camera) {

        m_drive = drive;
        addRequirements(m_drive);

        m_intake = intake;
        addRequirements(m_intake);

        m_climb = climb;
        addRequirements(m_climb);
        
        m_shoot = shoot;
        addRequirements(m_shoot);

        m_camera = camera;
        addRequirements(m_camera);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

    XboxController drive_controller = RobotContainer.getInstance().getDriveController();
    XboxController operator_Controller = RobotContainer.getInstance().getOperatorController();
    
    if(drive_controller.getLeftY() >= 0.05){
        m_drive.straightDrive(drive_controller.getLeftY() * DriveEdits.DriveSpeed);
    }

    if(drive_controller.getRightX() >= 0.05){
        m_drive.turning(drive_controller.getRightX() * DriveEdits.DriveSpeed);
    }
        
    if(drive_controller.getRightTriggerAxis() >= 0.05){
            m_intake.intake(intakeEdits.intakeSpeed);
        }
        
        if(operator_Controller.getRightTriggerAxis() >= 0.05){
            m_shoot.shoot(shootEdits.shootSpeed);
        }

        if(operator_Controller.getRightY() >= 0.05 || operator_Controller.getRightY() <= -0.05){
            m_climb.climb(operator_Controller.getRightY());
        }

        if(operator_Controller.getAButtonPressed()){
           m_camera.Switch();
           System.out.println("A Button Pressed");
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
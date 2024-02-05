package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Constants.DriveEdits;
import frc.robot.Constants.intakeEdits;
import frc.robot.Constants.shootEdits;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.CameraSubsystem;

public class TeleopCommand extends Command {
    private DriveSubsystem m_drive;
    private IntakeSubsystem m_intake;
    private ClimbSubsystem m_climb;
    private ShootSubsystem m_shoot;
    private CameraSubsystem m_camera;
    private ArmSubsystem m_arm;
    
    private XboxController drive_controller;
    private XboxController operator_controller;
    
    public TeleopCommand(DriveSubsystem drive, IntakeSubsystem intake, ClimbSubsystem climb, ShootSubsystem shoot, CameraSubsystem camera, ArmSubsystem arm) {
        
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

        m_arm = arm;
        //addRequirments has an error code here, we should not need to fix it due to the Arm Subsystem only having one method.
    }
    
    @Override
    public void initialize() {
        drive_controller = RobotContainer.getInstance().getDriveController();
        operator_controller = RobotContainer.getInstance().getOperatorController();
    }
    
    @Override
    public void execute() {
        //region Setup driver controls
        if (drive_controller.getLeftY() >= 0.25 ||
                drive_controller.getLeftY() <= -0.25 ||
                drive_controller.getRightX() >= 0.25 ||
                drive_controller.getRightX() <= -0.25
        ) {
            m_drive.arcadeDrive(drive_controller.getLeftY(), drive_controller.getRightX());
        }
        else {
            m_drive.arcadeDrive(0, 0);
        }
        
        if (drive_controller.getRightTriggerAxis() >= 0.05) {
            m_intake.intake(drive_controller.getRightTriggerAxis());
        } 
        
        //endregion
        
        //region Setup operator controls
        if (operator_controller.getRightTriggerAxis() >= 0.05) {
            m_shoot.shoot(shootEdits.shootSpeed);
        }
        
        if (operator_controller.getRightY() >= 0.05 || operator_controller.getRightY() <= -0.05) {
            m_climb.climb(operator_controller.getRightY());
        }
        
        if (operator_controller.getAButtonPressed()) {
            m_camera.Switch();
        }

        if (operator_controller.getRightY() >= 0.05 || operator_controller.getRightY() <= -0.05){
            m_arm.armMotors(operator_controller.getRightY());
        }    
        //endregion
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
package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.armEdits;
import frc.robot.Constants.intakeEdits;
import frc.robot.Constants.shootEdits;
import frc.robot.Constants.armConstants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ColorSensorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;

public class TeleopCommand extends Command {
    private DriveSubsystem m_drive;
    private IntakeSubsystem m_intake;
    private ClimbSubsystem m_climb;
    private ShootSubsystem m_shoot;
    private CameraSubsystem m_camera;
    private ArmSubsystem m_arm;
    private ColorSensorSubsystem m_color;
    
    private XboxController drive_controller;
    private XboxController operator_controller;
    
    public TeleopCommand(DriveSubsystem drive, IntakeSubsystem intake, ClimbSubsystem climb, ShootSubsystem shoot,
     CameraSubsystem camera, ArmSubsystem arm, ColorSensorSubsystem color) {
        
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

        m_color = color;
        addRequirements(m_color);
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
        

        if ( m_color.getProximity() >=2009 || (m_color.getProximity() <=2009 && operator_controller.getRightTriggerAxis() >= 0.05 ) ) {
           if (drive_controller.getRightTriggerAxis() >= 0.05) {
                m_intake.intake(intakeEdits.intakeSpeed);
           } 
        }
        
        //endregion
        
        //region Setup operator controls
        if (operator_controller.getRightTriggerAxis() >= 0.05) {
            m_shoot.shoot(-shootEdits.shootSpeed);
        } else if(operator_controller.getLeftTriggerAxis() >= 0.05) {
            m_shoot.shoot(shootEdits.shootSpeed);
        } else if(operator_controller.getRightBumper()){
            m_shoot.shoot(shootEdits.slowShootSpeed);
        } else {
            m_shoot.shoot(0);
        }
        
        if (operator_controller.getLeftY() >= 0.05 || operator_controller.getLeftY() <= -0.05) {
            m_climb.climb(operator_controller.getLeftY());
        } else {
            m_climb.climb(0);
        }
        
        if (operator_controller.getAButtonPressed()) {
            m_camera.Switch();
        }
        
        //How far arm is from stopping point
        double arm_from_stop = m_arm.getPosition() / armConstants.stop_distance;
        

        if(arm_from_stop < armConstants.distance_from_stop){
            armEdits.arm_speed_multiplier = 1;
        } else if(arm_from_stop > armConstants.distance_from_stop && arm_from_stop < armConstants.stop_distance){
            armEdits.arm_speed_multiplier = Math.pow(armEdits.arm_speed_multiplier, (-1 * arm_from_stop * 0.01));
        } else if(arm_from_stop >= 0.95){
            armEdits.arm_speed_multiplier = 0;
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
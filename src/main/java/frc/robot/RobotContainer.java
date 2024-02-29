// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.Autonomoose.AutoDrive;
import frc.robot.commands.Autonomoose.AutoDriveStraight;
import frc.robot.commands.Autonomoose.AutoIntake;
import frc.robot.commands.Autonomoose.AutoShoot;
import frc.robot.commands.Autonomoose.AutoTurn;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  
  private static RobotContainer m_robotContainer = new RobotContainer();
  
  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  // The robot's subsystems
  public final ClimbSubsystem m_climb = new ClimbSubsystem();
  public final ShootSubsystem m_shoot = new ShootSubsystem();
  public final IntakeSubsystem m_intake = new IntakeSubsystem();
  public final DriveSubsystem m_drive = new DriveSubsystem();
  public final CameraSubsystem m_camera = new CameraSubsystem();
  public final ArmSubsystem m_arm = new ArmSubsystem();
  
  public final TeleopCommand m_TeleopCommand = new TeleopCommand(m_drive, m_intake, m_climb, m_shoot, m_camera, m_arm);
  
  // Joysticks
  private final XboxController m_driveController = new XboxController(1);
  private final XboxController m_operatorController = new XboxController(0);

  //Auto Choosing
  private final SendableChooser<Command> autoChooser;
  //private final Command m_crossLineAuto = new AutoDriveStraight(m_drive, -40, .5);
  //private final Command m_shootSpeakerAuto = new AutoShoot(m_shoot, 0.5).andThen(m_crossLineAuto);
  
  private RobotContainer() {
    NTManager.initialize();
    autoChooser = new SendableChooser<Command>();
    autoChooser.setDefaultOption("Cross Line", new AutoDriveStraight(m_drive, -40, .5));
    //autoChooser.addOption("Shoot Speaker Auto", m_shootSpeakerAuto);
    Shuffleboard.getTab("Autonomous").add(autoChooser);
    configureButtonBindings();
  }
  
  public static RobotContainer getInstance() {
    return m_robotContainer;
  }
  
  private void configureButtonBindings() {
  }
  
  public Command getAutonomousCommand() {
    m_drive.resetEncoders();
    m_arm.resetEncoder();
    //return new AutoShoot(m_shoot, 1);
    //return new AutoIntake(m_intake, 0.2);
    //return new AutoDrive(m_drive, 0.3, 50);
    //return new AutoTurn(m_drive, 20, 0.3);
    //return new AutoDriveStraight(m_drive, 10, 0.3); 
    //return autoChooser.getSelected();
    //return new AutoDriveStraight(m_drive, -40, .5);
    return new AutoShoot(m_shoot, 0.5).andThen(new AutoDriveStraight(m_drive, -40, 0.5));
  }
  
  public TeleopCommand getTeleopCommand() {
    return m_TeleopCommand;
  }
  
  public XboxController getDriveController() {
    return m_driveController;
  }
  
  public XboxController getOperatorController() {
    return m_operatorController;
  }
}

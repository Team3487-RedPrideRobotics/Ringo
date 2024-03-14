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
  public final ColorSensorSubsystem m_color = new ColorSensorSubsystem();
  
  public final AutonomousCommand m_auto = new AutonomousCommand();
  public final TeleopCommand m_TeleopCommand = new TeleopCommand(m_drive, m_intake, m_climb, m_shoot, m_camera, m_arm, m_color);
  
  // Joysticks
  private final XboxController m_driveController = new XboxController(1);
  private final XboxController m_operatorController = new XboxController(0);

  //Auto Choosing
  private final SendableChooser<Command> autoChooser;
  private final Command m_middleLaneAuto = new AutoShoot(m_shoot, 30).andThen(new AutoDriveStraight(m_drive, -40, 0.5));
  private final Command m_0_rightLaneAuto = new WaitCommand(0).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, -100, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, -90, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, -90,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_1_rightLaneAuto = new WaitCommand(1).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, -100, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, -90, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, -90,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_2_rightLaneAuto = new WaitCommand(2).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, -100, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, -90, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, -90,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_3_rightLaneAuto = new WaitCommand(3).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, -100, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, -90, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, -90,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_4_rightLaneAuto = new WaitCommand(4).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, -100, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, -90, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, -90,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_5_rightLaneAuto = new WaitCommand(3).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, -100, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, -90, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, -90,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_runForrest = new AutoIntake(-1.00, m_intake, -50).andThen(new AutoDriveStraight(m_drive, -242, 0.6));
  private final Command m_0_leftLaneAuto = new WaitCommand(0).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, 45,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_1_leftLaneAuto = new WaitCommand(1).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, 45,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_2_leftLaneAuto = new WaitCommand(2).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, 45,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_3_leftLaneAuto = new WaitCommand(3).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, 45,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_4_leftLaneAuto = new WaitCommand(4).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, 45,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));
  private final Command m_5_leftLaneAuto = new WaitCommand(5).andThen(new AutoDriveStraight(m_drive, -30, 0.4)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoShoot(m_shoot, 30)).andThen(new AutoTurn(m_drive, 50, 0.4)).andThen(new AutoDriveStraight(m_drive, -50, 0.4)).andThen(new AutoTurn(m_drive, 45,0.4)).andThen(new AutoDriveStraight(m_drive, 50, 0.4));


  private RobotContainer() {
    NTManager.initialize();
    autoChooser = new SendableChooser<Command>();
    autoChooser.setDefaultOption("Cross Line", new AutoDriveStraight(m_drive, -50, .5));
    autoChooser.addOption("0 Second Right Lane", m_0_rightLaneAuto);
    autoChooser.addOption("1 Second Right Lane", m_1_rightLaneAuto);
    autoChooser.addOption("2 Second Right Lane", m_2_rightLaneAuto);
    autoChooser.addOption("3 Second Right Lane", m_3_rightLaneAuto);
    autoChooser.addOption("4 Second Right Lane", m_4_rightLaneAuto);
    autoChooser.addOption("5 Second Right Lane", m_5_rightLaneAuto);
    autoChooser.addOption("Middle Lane", m_middleLaneAuto);
    autoChooser.addOption("Spit note, then Drive To Middle", m_runForrest);
    autoChooser.addOption("0 Second Left Lane", m_0_leftLaneAuto);
    autoChooser.addOption("1 second Left Lane", m_1_leftLaneAuto);
    autoChooser.addOption("2 second Left Lane", m_2_leftLaneAuto);
    autoChooser.addOption("3 second Left Lane", m_3_leftLaneAuto);
    autoChooser.addOption("4 second Left Lane", m_4_leftLaneAuto);
    autoChooser.addOption("5 second Left Lane", m_5_leftLaneAuto);

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
    return autoChooser.getSelected();
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

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class IntakeIn extends Command {
  private final frc.robot.subsystems.IntakeSubsystem m_intake;
  private final DoubleSupplier m_controllerValue;

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param forward The control input for driving forwards/backwards
   * @param rotation The control input for turning
   */
  public IntakeIn(frc.robot.subsystems.IntakeSubsystem subsystem, DoubleSupplier value) {
    m_intake = subsystem;
    m_controllerValue = value;
    addRequirements(m_intake);
  }

  @Override
  public void execute() {
    if(m_controllerValue.getAsDouble() > 0.5){
        m_intake.intakeIn();
    } else {
        m_intake.disableIntakeMotors();
    }
  }
}
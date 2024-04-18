package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

/**
 * A command to drive the robot with joystick input (passed in as {@link DoubleSupplier}s). Written
 * explicitly for pedagogical purposes - actual code should inline a command this simple with {@link
 * edu.wpi.first.wpilibj2.command.RunCommand}.
 */
public class ShootOut extends Command {
  private final frc.robot.subsystems.ShootSubsystem m_shoot;
  private final DoubleSupplier m_controllerValue;

  /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The drive subsystem this command wil run on.
   * @param forward The control input for driving forwards/backwards
   * @param rotation The control input for turning
   */
  public ShootOut(frc.robot.subsystems.ShootSubsystem subsystem, DoubleSupplier value) {
    m_shoot = subsystem;
    m_controllerValue = value;
    addRequirements(m_shoot);
  }

  @Override
  public void execute() {
    if(m_controllerValue.getAsDouble() >= .5){
      m_shoot.shootOut();
    } else {
      m_shoot.disableShootMotors();
    }
  }
}

/* 
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class ShootOut extends Command {
  private final frc.robot.subsystems.ShootSubsystem m_shoot;

  public ShootOut(frc.robot.subsystems.ShootSubsystem subsystem) {
    m_shoot = subsystem;
    addRequirements(m_shoot);
  }

  @Override
  public void initialize() {
    m_shoot.shootOut();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

}
*/
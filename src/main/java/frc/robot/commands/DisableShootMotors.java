package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

public class DisableShootMotors extends Command {
  private final frc.robot.subsystems.ShootSubsystem m_shoot;

  public DisableShootMotors(frc.robot.subsystems.ShootSubsystem subsystem) {
    m_shoot = subsystem;
    addRequirements(m_shoot);
  }

  @Override
  public void initialize() {
    m_shoot.disableShootMotors();
  }

  @Override
  public boolean isFinished() {
    return true;
  }

}
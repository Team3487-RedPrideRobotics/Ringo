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
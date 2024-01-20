package frc.util;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveCommand extends CommandBase {
    
    protected Drive m_drive;

    public DriveCommand(Drive drive) {
        addRequirements(drive);
        m_drive = drive;
    }

    @Override
    public void initialize() {
        m_drive.resetOdometry();
    }

}

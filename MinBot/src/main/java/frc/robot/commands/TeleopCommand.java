package frc.robot.commands;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.Drive;
import frc.util.DriveCommand;

public class TeleopCommand extends DriveCommand {
    //TODO Control Scheme setup w/ NT Event handlers
    SendableChooser<String> controlScheme;
    NetworkTableEntry activeEntry;
    
 
    public TeleopCommand(Drive driveSubsystem) {
        super(driveSubsystem);

    }

    @Override
    public void execute() {

    }

}

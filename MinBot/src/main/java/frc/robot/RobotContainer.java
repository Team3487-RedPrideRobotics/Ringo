// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Collections;
import java.util.Set;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.util.TrajectoryLoader;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final Constants m_constants = Constants.getInstance();
    private static RobotContainer m_instance;
    private final TrajectoryLoader m_loader = TrajectoryLoader.getInstance();

    private SendableChooser<String> autoChooser;

    private SendableChooser<String> controlScheme;
    private NetworkTableEntry activeEntry;

    public static RobotContainer getInstance() {
        if (m_instance == null) {
            m_instance = new RobotContainer();
        }
        return m_instance;
    }

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    private RobotContainer() {
        System.out.println(" =-=- Loading Auto Options -=-= ");
        //Sendable Chooser
        autoChooser = new SendableChooser<String>();
        //Default so no null pointer exception.
        autoChooser.setDefaultOption("None", "none");
        //Load all potential options
        m_loader.getAllPaths().iterator().forEachRemaining(option -> {
            autoChooser.addOption(option, option);
        });

        Shuffleboard.getTab("Auto").add("Path", autoChooser);

        controlScheme = new SendableChooser<String>();

        //Control Scheme Cancels Current Teleop command and schedules the new one
        controlScheme.setDefaultOption("XBox", "xbox");
        controlScheme.addOption("Joysticks", "joys");
        Shuffleboard.getTab("Teleop").add("Control Scheme",controlScheme);
        activeEntry = NetworkTableInstance.getDefault().getTable("Shuffleboard").getSubTable("Teleop").getEntry("Control Scheme/active");
        activeEntry.addListener(event -> {
            configureButtonBindings(controlScheme.getSelected());
        }, EntryListenerFlags.kUpdate | EntryListenerFlags.kImmediate);
    
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings(String controls) {
    }

    public double[] getJoysticAxis() {

        return new double[] {0,0};
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // TODO Replace with actual command
        return new Command() {

            @Override
            public Set<Subsystem> getRequirements() {
                return Collections.emptySet();
            }

        };
    }

    public Constants getConstants() {
        return m_constants;
    }
}


package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.SerialPort.WriteBufferMode;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDSubsystem extends SubsystemBase {
  private Spark blinkin;
  private static double bRed  = -0.17;
  private static double bBlue = -0.15;
  private static double sRed = 0.61;
  private static double sBlue = 0.87;
  private static double rainbow = -0.99;

  public LEDSubsystem(){
      blinkin = new Spark(0);
  }




  @Override
  public void periodic() {
      /*
        if(DriverStation.isDisabled() && DriverStation.getAlliance().get() == DriverStation.Alliance.Blue){
          blinkin.set(-0.15);
        } else if (!DriverStation.isDisabled() && DriverStation.getAlliance().get() == DriverStation.Alliance.Blue){
          blinkin.set(0.87);
        } else if (DriverStation.isDisabled() && DriverStation.getAlliance().get() == DriverStation.Alliance.Red){
          blinkin.set(-0.17);
        } else if (!DriverStation.isDisabled() && DriverStation.getAlliance().get() == DriverStation.Alliance.Red){
          blinkin.set(0.61);
        }
        */
  }
  
  
}

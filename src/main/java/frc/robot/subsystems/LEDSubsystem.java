
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
  private static double red  = -0.25;
  private static double blue = -0.23;
  private static double rainbow = -0.99;

  public LEDSubsystem(){
      blinkin = new Spark(0);
  }




  @Override
  public void periodic() {
    if(DriverStation.getAlliance() != null){
        if(DriverStation.isDisabled()){
          toggleRainbow();
        } else if (DriverStation.getAlliance().get() == DriverStation.Alliance.Blue){
          toggleBlue();
        } else if (DriverStation.getAlliance().get() == DriverStation.Alliance.Red){
          toggleRed();
        }
    }
  }
  
  
  public void toggleRed(){
    blinkin.set(red);
  }
  public void toggleBlue(){
    blinkin.set(blue);
  }
  public void toggleRainbow(){
    blinkin.set(rainbow);
  }
}

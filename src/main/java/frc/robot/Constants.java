// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
   
    public static final class DriveConstants {
        public static final int left_Front_Motor_ID = 3;
        public static final int left_Back_Motor_ID = 4;
        public static final double WheelCircumferenceInches = 6 * Math.PI;
        public static final double EncoderConversionFactor = 1.0/8.5 * WheelCircumferenceInches;
        public static final int right_Front_Motor_ID = 9;
        public static final int right_Back_Motor_ID = 10; 
    }

    public static final class DriveEdits {
        public static double DriveSpeed = 1;
        public static double TurnSpeed = 1;
    }

    public static final class intakeConstants{
        public static final int Intake_Motor_ID = 2;
    }
    public static final class intakeEdits{
        public static double intakeSpeed = 1;
    }

    public static final class shootConstants{
        public static final int left_Shoot_Motor_ID = 6;
        public static final int right_Shoot_Motor_ID = 7;
    }

    public static final class shootEdits{
        public static double shootSpeed =  1;
        public static double slowShootSpeed = 0.2;
    }

    public static final class climbConstants{
        public static final int left_Climb_Motor_ID = 1;
        public static final int right_Climb_Motor_ID = 11;

        public static final int top_Climb_Switch_ID = 1;
        public static final int bottom_Climb_Switch_ID = 0;
    }

    public static final class climbEdits{
        public static double climbSpeed = 1;
    }

    public static final class armEdits{
        public static double armSpeed = 0.4;
        public static double arm_speed_multiplier ;
    }

    public static final class armConstants{
        public static final int left_Arm_Motor_ID = 5;
        public static final int right_Arm_Motor_ID = 8;
        public static final double stop_distance = 5;
        public static final double distance_from_stop = 0.75;
    }
}


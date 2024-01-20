package frc.robot.constants;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.util.Units;

public class DriveConstants {

    private double kSR;
    private double kVR;
    private double kAR;

    private double kSL;
    private double kVL;
    private double kAL;

    private double kSC;
    private double kVC;
    private double kAC;

    private double kPL;
    private double kPR;

    private double kAcceleration;

    private int pwmLeft;
    private int pwmRight;

    private double kTrackWidth;

    private double kDistancePerPulse; 

    private boolean bLeftInverted;
    private boolean bRightInverted;

    private int[] dEncoderLeft;
    private int[] dEncoderRight;
    
    public class DriveConstantsFactory {

        private double kSR;
        private double kVR;
        private double kAR;

        private double kSL;
        private double kVL;
        private double kAL;

        private double kSC;
        private double kVC;
        private double kAC;

        private double kPL;
        private double kPR;

        private double kAcceleration;

        private int pwmLeft;
        private int pwmRight;

        private double kTrackWidth;

        private double kDistancePerPulse; 

        private boolean bLeftInverted;
        private boolean bRightInverted;

        private int[] dEncoderLeft;
        private int[] dEncoderRight;

        public DriveConstants constructConstants() {
            return new DriveConstants(kAC,
             kAC,
              kAC,
               kAC,
                kAC,
                 kAC,
                  kAC,
                   kAC,
                    kAC,
                     kAC,
                      kAC,
                       kAC,
                        pwmLeft,
                         pwmLeft,
                          kAC,
                           kAC,
                            bLeftInverted,
                             bLeftInverted,
                              dEncoderLeft,
                               dEncoderLeft
            );
        }

        public double getKSR() {
            return this.kSR;
        }

        public void KSR(double kSR) {
            this.kSR = kSR;
        }

        public double getKVR() {
            return this.kVR;
        }

        public void KVR(double kVR) {
            this.kVR = kVR;
        }

        public double getKAR() {
            return this.kAR;
        }

        public void KAR(double kAR) {
            this.kAR = kAR;
        }

        public double getKSL() {
            return this.kSL;
        }

        public void KSL(double kSL) {
            this.kSL = kSL;
        }

        public double getKVL() {
            return this.kVL;
        }

        public void KVL(double kVL) {
            this.kVL = kVL;
        }

        public double getKAL() {
            return this.kAL;
        }

        public void KAL(double kAL) {
            this.kAL = kAL;
        }

        public double getKSC() {
            return this.kSC;
        }

        public void KSC(double kSC) {
            this.kSC = kSC;
        }

        public double getKVC() {
            return this.kVC;
        }

        public void KVC(double kVC) {
            this.kVC = kVC;
        }

        public double getKAC() {
            return this.kAC;
        }

        public void KAC(double kAC) {
            this.kAC = kAC;
        }

        public double getKPL() {
            return this.kPL;
        }

        public void KPL(double kPL) {
            this.kPL = kPL;
        }

        public double getKPR() {
            return this.kPR;
        }

        public void KPR(double kPR) {
            this.kPR = kPR;
        }

        public double getKAcceleration() {
            return this.kAcceleration;
        }

        public void KAcceleration(double kAcceleration) {
            this.kAcceleration = kAcceleration;
        }

        public int getPwmLeft() {
            return this.pwmLeft;
        }

        public void PwmLeft(int pwmLeft) {
            this.pwmLeft = pwmLeft;
        }

        public int getPwmRight() {
            return this.pwmRight;
        }

        public void PwmRight(int pwmRight) {
            this.pwmRight = pwmRight;
        }

        public double getKTrackWidth() {
            return this.kTrackWidth;
        }

        public void KTrackWidth(double kTrackWidth) {
            this.kTrackWidth = kTrackWidth;
        }

        public double getKDistancePerPulse() {
            return this.kDistancePerPulse;
        }

        //TODO Create changeable encoder resolution
        public void KWheelDiameter(double wheelDiameter) {
        // inches to meters (Pi * 6)/2048
            this.kDistancePerPulse = Units.inchesToMeters(Math.PI * wheelDiameter / 2048);
        }

        public boolean isBLeftInverted() {
            return this.bLeftInverted;
        }

        public void BLeftInverted(boolean bLeftInverted) {
            this.bLeftInverted = bLeftInverted;
        }

        public boolean isBRightInverted() {
            return this.bRightInverted;
        }

        public void BRightInverted(boolean bRightInverted) {
            this.bRightInverted = bRightInverted;
        }

        public int[] getDEncoderLeft() {
            return this.dEncoderLeft;
        }

        public void DEncoderLeft(int[] dEncoderLeft) {
            this.dEncoderLeft = dEncoderLeft;
        }

        public int[] getDEncoderRight() {
            return this.dEncoderRight;
        }

        public void DEncoderRight(int[] dEncoderRight) {
            this.dEncoderRight = dEncoderRight;
        }
        

        private DriveConstantsFactory() {
            
        }

        public DifferentialDriveKinematics getDifferentialDriveKinematics() {
            return new DifferentialDriveKinematics(this.kTrackWidth);
        }
    }

    //TODO Annotate
    /**
     * @param kSR
     * @param kVR
     * @param kAR
     * @param kSL
     * @param kVL
     * @param kAL
     * @param kSC
     * @param kVC
     * @param kAC
     * @param kPL
     * @param kPR
     * @param kAcceleration
     * @param pwmLeft
     * @param pwmRight
     * @param kTrackWidth
     * @param kDistancePerPulse
     * @param bLeftInverted
     * @param bRightInverted
     * @param dEncoderLeft
     * @param dEncoderRight
     */
    protected DriveConstants(double kSR, double kVR, double kAR, double kSL, double kVL, double kAL, double kSC,
            double kVC, double kAC, double kPL, double kPR, double kAcceleration, int pwmLeft, int pwmRight,
            double kTrackWidth, double kDistancePerPulse, boolean bLeftInverted, boolean bRightInverted,
            int[] dEncoderLeft, int[] dEncoderRight) {
        this.kSR = kSR;
        this.kVR = kVR;
        this.kAR = kAR;
        this.kSL = kSL;
        this.kVL = kVL;
        this.kAL = kAL;
        this.kSC = kSC;
        this.kVC = kVC;
        this.kAC = kAC;
        this.kPL = kPL;
        this.kPR = kPR;
        this.kAcceleration = kAcceleration;
        this.pwmLeft = pwmLeft;
        this.pwmRight = pwmRight;
        this.kTrackWidth = kTrackWidth;
        this.kDistancePerPulse = kDistancePerPulse;
        this.bLeftInverted = bLeftInverted;
        this.bRightInverted = bRightInverted;
        this.dEncoderLeft = dEncoderLeft;
        this.dEncoderRight = dEncoderRight;
    }

    /**
     * @return the dEncoderRight
     */
    public int[] getdEncoderRight() {
        return dEncoderRight;
    }

    /**
     * @return the dEncoderLeft
     */
    public int[] getdEncoderLeft() {
        return dEncoderLeft;
    }

    /**
     * @return the bRightInverted
     */
    public boolean isbRightInverted() {
        return bRightInverted;
    }

    /**
     * @return the bLeftInverted
     */
    public boolean isbLeftInverted() {
        return bLeftInverted;
    }

    /**
     * @return the kDistancePerPulse
     */
    public double getkDistancePerPulse() {
        return kDistancePerPulse;
    }

    /**
     * @return the kTrackWidth
     */
    public double getkTrackWidth() {
        return kTrackWidth;
    }

    /**
     * @return the pwmRight
     */
    public int getPwmRight() {
        return pwmRight;
    }

    /**
     * @return the pwmLeft
     */
    public int getPwmLeft() {
        return pwmLeft;
    }

    /**
     * @return the kAcceleration
     */
    public double getkAcceleration() {
        return kAcceleration;
    }

    /**
     * @return the kPR
     */
    public double getkPR() {
        return kPR;
    }

    /**
     * @return the kPL
     */
    public double getkPL() {
        return kPL;
    }

    /**
     * @return the kAC
     */
    public double getkAC() {
        return kAC;
    }

    /**
     * @return the kVC
     */
    public double getkVC() {
        return kVC;
    }

    /**
     * @return the kSC
     */
    public double getkSC() {
        return kSC;
    }

    /**
     * @return the kAL
     */
    public double getkAL() {
        return kAL;
    }

    /**
     * @return the kVL
     */
    public double getkVL() {
        return kVL;
    }

    /**
     * @return the kSL
     */
    public double getkSL() {
        return kSL;
    }

    /**
     * @return the kAR
     */
    public double getkAR() {
        return kAR;
    }

    /**
     * @return the kVR
     */
    public double getkVR() {
        return kVR;
    }

    /**
     * @return the kSR
     */
    public double getkSR() {
        return kSR;
    }

}

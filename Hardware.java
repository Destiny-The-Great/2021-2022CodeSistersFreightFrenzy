package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Destiny Hale 2022
 */

//Define elements of robot
public class Hardware {

    //Wheels
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    // Other Motors
    public DcMotor sweeper;
    public DcMotor rackLeft;
    public DcMotor rackRight;
    // Servos
    public CRServo nancyTurner;
    public DcMotor boxIntake;
    boolean isSpinning = false;

    // Sensors
   public ColorSensor color_sensor;


    //---------------------------------INIT--ROBOT---------------------------------------------------
   /*  This method allows us to initialize the motors and sensors only once.
       It is used in every other program after "Init" is pressed.
    */

    public void initializeRobot(HardwareMap hwMap) {

        HardwareMap HWMap = hwMap;

        //initialize Wheel motors

        leftFront = HWMap.dcMotor.get("leftFront");
        leftBack = HWMap.dcMotor.get("leftBack");
        rightFront = HWMap.dcMotor.get("rightFront");
        rightBack = HWMap.dcMotor.get("rightBack");

        //initialize intake motors
        sweeper = HWMap.dcMotor.get("sweeper");
        rackLeft = HWMap.dcMotor.get("rackLeft");
        rackRight = HWMap.dcMotor.get("rackRight");


        //initialize intake servos
        boxIntake = HWMap.dcMotor.get("boxIntake");
        nancyTurner = HWMap.crservo.get("nancyTurner");

        //sensors
        color_sensor = HWMap.get(ColorSensor.class, "colorSensor");



    }

//--------------------------Autonomous Driving Methods-------------------------------------------------------

   /*  Below are methods used to move Vector's wheels during autonomous
    */
//Drives Forwards and Backwards
    public void driveStraight(double power, int time) throws InterruptedException {
        //set wheels to a power for a set amount of seconds
        leftFront.setPower(-power);
        leftBack.setPower(-power);
        rightFront.setPower(power);
        rightBack.setPower(power);
        Thread.sleep(time);

    //then Stop
        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);

        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void turnLeftA(double power, int time) throws InterruptedException {
        //set all wheels to given power for a given amount of seconds
        rightFront.setPower(power);
        leftFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);
        Thread.sleep(time);
    }

    public void autoStrafe(double power, int time) throws InterruptedException {
        //set front wheels to a power and back to opposite of power for some time
        leftFront.setPower(power);
        leftBack.setPower(-power);
        rightFront.setPower(power);
        rightBack.setPower(-power);
        Thread.sleep(time);
    }

//Used to completely stop wheels
    public void WaitA(int time) throws InterruptedException {
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
        Thread.sleep(time);
    }
    //--------------------------Autonomous Apparatus Methods-------------------------------------------------------

    /*  Below are all of methods used to move non-wheel parts of Vector.
     */
   //bottom 2 methods start and stop the duck spinner
    public void spinningDuckA(double power) {
        isSpinning = true;
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        nancyTurner.setPower(power);
    }

    public void stopSpinningDuckA() {
        isSpinning = false;
        nancyTurner.setPower(0);
    }

    //Both methods turn the box intake down
    public void dropBox () throws InterruptedException {
        boxIntake.setPower(.2);
        Thread.sleep(600);
    }
    public void redDropBox () throws InterruptedException {
        boxIntake.setPower(-.2);
        Thread.sleep(600);
    }

    //--------------------------Experimental Unused AutonomousMethods-------------------------------------------------------

    /*  Below are methods I theorized about using and for variety of reasons never implemented.
        Since, these are weird and unfinished expect more comments explaining their intended
        purpose.
     */
//A method meant to drive straight using encoders
    public void driveStraightA(double power, int positionMoved) {
        // reset encoders
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Motors will set their target to given position
        leftBack.setTargetPosition(positionMoved);
        rightBack.setTargetPosition(positionMoved);
        leftFront.setTargetPosition(positionMoved);
        rightFront.setTargetPosition(positionMoved);

        // Motors will attempt to run to target
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Wheels will move forward
        rightBack.setPower(-power);
        leftFront.setPower(power);
        leftBack.setPower(-power);
        rightFront.setPower(power);

        // Robot will wait for wheels
        while (rightBack.isBusy() && rightFront.isBusy() && leftFront.isBusy() && leftBack.isBusy()) {}

        // Robot stops afterwards
        rightBack.setPower(0);
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        }
//This method tries to get encoders to work on a single wheel
    public void testA(double power, int positionMoved) {
        // reset encoders

        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Motors will set their target to given position
        leftBack.setTargetPosition(positionMoved);

        // Motors will attempt to run to target
        leftFront.setTargetPosition(positionMoved);
        leftBack.setTargetPosition(positionMoved);
        rightBack.setTargetPosition(positionMoved);
        rightFront.setTargetPosition(positionMoved);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Wheels will move forward
        leftBack.setPower(power);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        // Robot will wait for wheels
        while (leftBack.isBusy()) {}

        // Robot stops afterward
        leftBack.setPower(0);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

//An attempted turning method with encoders
    public void turnRightA(double power,int rTurnAmount) {
        leftBack.setPower(-power);
        leftFront.setPower
                (-power);
        leftBack.setTargetPosition(rTurnAmount);
        leftFront.setTargetPosition(rTurnAmount);
    }

// An unused method to move the rack & pinion during Autonomous
public void elevate(int power, int time) throws InterruptedException {
    rackRight.setPower(power);
    rackLeft.setPower(power);
    Thread.sleep(time);
}
    }




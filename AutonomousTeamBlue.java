package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Destiny Hale 2022
 */
@Autonomous(name= "ABlue", group= "Linear Opmode")
public class AutonomousTeamBlue extends LinearOpMode {
    // Establish Universal Variables
    Hardware Vector = new Hardware();
    // ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        System.out.println("Initialize Robot");
        Vector.initializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        telemetry.addData("Status", "Ready!");
        System.out.println("Howdy!");

        telemetry.update();
        Vector.isSpinning = false;
        Vector.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();

        // Vector goes to duck carousel and begins spinning it
       Vector.driveStraight(.3,700);
       Vector.turnLeftA(-.5,900);
       Vector.driveStraight(.6, 2000);
       Vector.autoStrafe(-.5,1200);
       Vector.WaitA(500);

       Vector.spinningDuckA(1);

       //While loop prevent wheels from moving before duck spinner finishes spinning
       while (Vector.isSpinning) {
           Vector.leftFront.setPower(0.0);
           Vector.leftBack.setPower(0.0);
           Vector.rightFront.setPower(0.0);
           Vector.rightBack.setPower(0.0);

           Vector.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           Vector.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           Vector.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           Vector.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

           Thread.sleep(7000);
           Vector.stopSpinningDuckA();
       }

//Vector strafes waits and then lowers box intake
        Vector.autoStrafe(.3,2500);
        Vector.WaitA(620);
        Vector.dropBox();
    }
        }

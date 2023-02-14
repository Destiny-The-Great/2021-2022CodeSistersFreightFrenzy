package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Destiny Hale 2022
 */


@Autonomous(name= "ARed", group= "Linear Opmode")
public class AutonomousTeamRed extends LinearOpMode {
    // Establish Universal Variables
    Hardware Vector = new Hardware();
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

        //make sure everything is reset
        Vector.isSpinning = false;
        Vector.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
// Vector go to duck spinner
       Vector.driveStraight(-.3,700);
       Vector.autoStrafe(-.3,5500);
       Vector.driveStraight(.3,500);
       Vector.WaitA(500);
       Vector.spinningDuckA(-1);
//spin duck,and pause
       while (Vector.isSpinning) {
           Vector.leftFront.setPower(0.0);
          Vector.leftBack.setPower(0.0);
           Vector.rightFront.setPower(0.0);
           Vector.rightBack.setPower(0.0);

           Vector.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           Vector.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           Vector.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           Vector.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
           Thread.sleep(7500);
           Vector.stopSpinningDuckA();
       }
       //park
        Vector.driveStraight(-.4,1200);
        Vector.autoStrafe(-.3,620);
        Vector.WaitA(620);

       //move sweeper out the way and then drop freight
        Vector.sweeper.setPower(-.7);
        Thread.sleep(620);
        Vector.sweeper.setPower(0);
        Vector.redDropBox();
        Vector.WaitA(420);

        //hit freight with sweeper to prevent it from touching the robot
        Vector.sweeper.setPower(-.6);
        Thread.sleep(740);
        Vector.sweeper.setPower(0);
    }
        }

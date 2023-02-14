package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Destiny Hale 2022
 */



@TeleOp (name= "TeleOpTeamBlue", group= "Linear Opmode")
public class TeleOpTeam extends LinearOpMode {

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

        telemetry.update();
        waitForStart();
            while (opModeIsActive()) {
                //defines driving mapping controls
                double fwdBack = -gamepad1.left_stick_y;
                double strafe = gamepad1.left_stick_x;
                double turn = gamepad1.right_stick_x;

                //defines sweeping controls
                boolean sweepDown = gamepad1.dpad_down;
                boolean sweepUp = gamepad1.dpad_up;

                if (sweepDown) {
                    Vector.sweeper.setPower(.5);
                } else if (sweepUp) {
                    Vector.sweeper.setPower(-.5);
                } else {
                    Vector.sweeper.setPower(0);
                }

                //Spinner Code
                if (gamepad1.a) {
                    Vector.nancyTurner.setPower(1);
                } else {
                    Vector.nancyTurner.setPower(0);
                }

                // Code for Intake Box
                if (gamepad1.left_trigger != 0) {
                    Vector.boxIntake.setPower(-.4);

                } else if (gamepad1.right_trigger != 0) {
                    Vector.boxIntake.setPower(.4);
                } else {
                    Vector.boxIntake.setPower(0);
                    Vector.boxIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                }

                //Code for Rack & Pinion
                if (gamepad1.right_bumper) {
                    Vector.rackLeft.setPower(.40);
                    Vector.rackRight.setPower(.30);
                } else if (gamepad1.left_bumper) {
                    Vector.rackRight.setPower(-.30);
                    Vector.rackLeft.setPower(-.40);
                } else {
                    Vector.rackRight.setPower(0);
                    Vector.rackLeft.setPower(0);
                }
                //IfIf X is held go forward at full speed
                if (gamepad1.x) {
                    Vector.leftFront.setPower(-2);
                    Vector.leftBack.setPower(-2);
                    Vector.rightFront.setPower(2);
                    Vector.rightBack.setPower(2);
                    //otherwise drive normally
                } else {
                    Vector.leftFront.setPower((-fwdBack + strafe - turn));
                    Vector.leftBack.setPower((-fwdBack - strafe - turn));
                    Vector.rightFront.setPower((fwdBack + strafe - turn));
                    Vector.rightBack.setPower((fwdBack - strafe - turn));
                }
            }
        }
    }





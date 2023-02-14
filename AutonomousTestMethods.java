package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Destiny Hale 2022
 */


@Autonomous(name= "Autononomous Tester", group= "Linear Opmode")
public class AutonomousTestMethods extends LinearOpMode {
    // Establish Universal Variables
    Hardware Vector = new Hardware();
    double boxServosPosition = 0.0;
    //int currentRed = Vector.color_sensor.red()
    //
    //int currentGreen = Vector.color_sensor.green();
    //int currentBlue = Vector.color_sensor.blue();

    boolean foundRed = false;
    boolean foundGreen = false;
    boolean foundBlue = false;
    boolean iSeeDuck = false;
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
        Vector.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Vector.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
        Vector.sweeper.setPower(-.7);
        Thread.sleep(350);
        Vector.redDropBox();
        Vector.WaitA(120);
        Vector.sweeper.setPower(-.7);
        Thread.sleep(350);
        //add a move forward
        //move forward not strafe
        //than strafe to storage unit
        // we can prob drop a duck
// Vector strafe





        //--------------------------Experimental Unused stuff with color sensor-------------------------------------------------------

    /*  This method was attempt to use a color sense to find a duck and change directions based on
        how long it took to find the duck. It remained theoretically and wasn't implemented.
     */

        while (opModeIsActive()) {
            telemetry.addData("Red", Vector.color_sensor.red());
            telemetry.addData("Green", Vector.color_sensor.green());
            telemetry.addData("Blue", Vector.color_sensor.blue());
            telemetry.update();
        }

        /*
        @Autonomous(name= "ABlue", group= "Linear Opmode")
        public class AutonomousTeamBlue extends LinearOpMode {
             Establish Universal Variables
            Hardware Vector = new Hardware();
            double boxServosPosition = 0.0;
            int currentRed = Vector.color_sensor.red()

            int currentGreen = Vector.color_sensor.green();
            int currentBlue = Vector.color_sensor.blue();

            boolean foundRed = false;
            boolean foundGreen = false;
            boolean foundBlue = false;
            boolean iSeeDuck = false;
            boolean overLap = true;
            /*
         */
           /*     // Min < x > Max 215, 188, 21 (range)
        if (189 < currentRed && currentRed >= 231 ) {
            foundRed = true;
        } else if (currentGreen == 188) {
            foundGreen = true;
        } else if (currentBlue == 21) {
            foundBlue = true;
        }
        if (foundRed && foundBlue && foundGreen) {
            System.out.println("I see it");
            iSeeDuck = true;
            telemetry.update();
        } else {
            System.out.println("I don't see it");
            telemetry.update();
            iSeeDuck = false;
        }

        // Mock State thing algorithim
        /*
        Method Search for duck
        Boolean Searching = true; (establish as universal)
        while (searching)
        if(encoder number && iSeeADuck)
            go to level 1
           else if (encoder || other Enoder)
           go level 2
         searching = false
    */
    }
}
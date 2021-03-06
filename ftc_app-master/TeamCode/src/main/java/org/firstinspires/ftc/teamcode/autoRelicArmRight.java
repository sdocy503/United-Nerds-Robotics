package org.firstinspires.ftc.teamcode;

//import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
/* Copyright (c) 2017 FIRST. All rights reserved.


 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


/**
 * This file contains an example of an iterative (Non-Linear) "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all iterative OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="AutoRelicArmRight", group="Iterative Opmode")
@Disabled
public class autoRelicArmRight extends LinearOpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor arm = null;
    private Servo hand1 = null;
    private Servo hand2 = null;
    private Servo smolArm = null;
    //private DcMotor arm = null;
    //private DcMotor S1 = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftDrive = hardwareMap.get(DcMotor.class, "lm");
        rightDrive = hardwareMap.get(DcMotor.class, "rm");
        arm = hardwareMap.get(DcMotor.class, "arm");
        hand1 = hardwareMap.get(Servo.class, "hand1");
        hand2 = hardwareMap.get(Servo.class, "hand2");
        smolArm = hardwareMap.get(Servo.class, "smolArm");
        //arm = hardwareMap.get(DcMotor.class, "arm");
        //S1 = hardwareMap.get(DcMotor.class, "S1");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
        //Wait for play to be pressed
        waitForStart();
        runtime.reset();
        smolArm.setPosition(1);
        hand1.setPosition(1);
        hand2.setPosition(0);
        leftDrive.setPower(0.25);
        rightDrive.setPower(0.25);
        while (opModeIsActive() &&(runtime.seconds() < 1.25)){
            telemetry.addData("Moving Forward", runtime.seconds());
        }
        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
        while (opModeIsActive() &&(runtime.seconds() < 2.5)){
            telemetry.addData("Turning", runtime.seconds());
        }
        leftDrive.setPower(0.5);
        rightDrive.setPower(-0.5);
        while (opModeIsActive() &&(runtime.seconds() < 3.25)){
            telemetry.addData("Turning", runtime.seconds());
        }
        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
        while (opModeIsActive() &&(runtime.seconds() < 3.75)){
            telemetry.addData("Turning", runtime.seconds());
        }
        arm.setPower(1.0);
        while (opModeIsActive() &&(runtime.seconds() < 4.25)){
            telemetry.addData("Turning", runtime.seconds());
        }
        arm.setPower(0.0);
        while (opModeIsActive() &&(runtime.seconds() < 5.25)){
            telemetry.addData("Turning", runtime.seconds());
        }
        leftDrive.setPower(0.15);
        rightDrive.setPower(0.15);
        while (opModeIsActive() &&(runtime.seconds() < 5.75)){
            telemetry.addData("Moving Forward", runtime.seconds());
        }
        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
        while (opModeIsActive() &&(runtime.seconds() < 6.0)){
            telemetry.addData("Moving Forward", runtime.seconds());
        }
        hand1.setPosition(0);
        hand2.setPosition(1);
        while (opModeIsActive() &&(runtime.seconds() < 7.25)){
            telemetry.addData("Moving Forward", runtime.seconds());
        }
        hand1.setPosition(0.5);
        hand2.setPosition(0.5);
        while (opModeIsActive() &&(runtime.seconds() < 7.75)){
            telemetry.addData("Moving Forward", runtime.seconds());
        }
        arm.setPower(1.0);
        while (opModeIsActive() &&(runtime.seconds() < 8.25)){
            telemetry.addData("Moving Forward", runtime.seconds());
        }
        arm.setPower(0.0);
        stop();
    }
}
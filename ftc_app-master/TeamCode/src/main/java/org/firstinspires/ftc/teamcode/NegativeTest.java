// This is now the encoder branch of the RedAutonomous program.
/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="NegativeTest", group="Linear Opmode")  // @RedAutonomous(...) is the other common choice
@Disabled
public class NegativeTest extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftMotor = null;
    DcMotor rightMotor = null;

    @Override
    public void runOpMode() {

        leftMotor  = hardwareMap.dcMotor.get("lm");
        rightMotor = hardwareMap.dcMotor.get("rm");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        sleep(250);

        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        sleep(250);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        sleep(1000);

        encoderDrive(0.3,  2500,  2500, 1000); //Forward
        //encoderDrive(0.5,  -1440,  1440, 1000); //Left
        encoderDrive(0.6,  1160,  -1160, 1000); //Right
        encoderDrive(0.3,  2500,  2500, 1000); //Forward
        //encoderDrive(0.05,  9999,  9999, 1000); //Forward
        //encoderDrive(0.5,  1440,  1440, 1000); //Backward

    }

    public void encoderDrive(double speed, double leftTicks, double rightTicks, double sleepTime) {
        int newLeftTarget;
        int newRightTarget;

        if (opModeIsActive()) {

            newLeftTarget = leftMotor.getCurrentPosition() + (int) leftTicks;
            newRightTarget = rightMotor.getCurrentPosition() + (int) rightTicks;


            runtime.reset();
            //if (leftTicks < 0 && rightTicks > 0){
              //  leftMotor.setPower(-speed);
                //rightMotor.setPower(speed);
            //}
            if (rightTicks < 0 && leftTicks > 0){
                rightMotor.setPower(-speed);
                leftMotor.setPower(speed);
                while (opModeIsActive() && leftMotor.getCurrentPosition() < newLeftTarget && rightMotor.getCurrentPosition() > newRightTarget) {
                    telemetry.addData("Path2", "Running at %7d :%7d", leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
                    telemetry.addData("debug", "while loop right backwards");
                    telemetry.update();
                }
            }
            if (rightTicks < 0 && leftTicks < 0){
                leftMotor.setPower(-speed);
                rightMotor.setPower(-speed);
                while (opModeIsActive() && leftMotor.getCurrentPosition() > newLeftTarget && rightMotor.getCurrentPosition() > newRightTarget){
                    telemetry.addData("Path2", "Running at %7d :%7d", leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
                    telemetry.addData("debug", "while loop backwards");
                    telemetry.update();
                }
            }
            if (rightTicks == leftTicks) {
                leftMotor.setPower(speed);
                rightMotor.setPower(speed);
                //telemetry.addData("debug", "rightTicks = leftTicks" + newLeftTarget + " " + newRightTarget);
                //telemetry.update();
                //sleep(500);
                while (opModeIsActive() && leftMotor.getCurrentPosition() < newLeftTarget && rightMotor.getCurrentPosition() < newRightTarget){
                    telemetry.addData("Path2", "Running at %7d :%7d", leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
                    telemetry.addData("debug", "while loop " + newLeftTarget + " " + newRightTarget);
                    telemetry.update();
                }
            }
            if (rightTicks == 0) {
                leftMotor.setPower(speed);
                //sleep(250);
                //rightMotor.setPower(speed);
                //telemetry.addData("debug", "rightTicks = 0" + newLeftTarget + " " + newRightTarget);
                //telemetry.update();
                //sleep(500);
                while (opModeIsActive() && leftMotor.getCurrentPosition() < newLeftTarget){
                    //rightMotor.setPower(0);
                    telemetry.addData("Path2", "Running at %7d :%7d", leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
                    telemetry.addData("debug rightTicks = 0", "while loop " + newLeftTarget + " " + newRightTarget + " " + speed);
                    telemetry.update();
                }
            }
            if (leftTicks == 0){
                rightMotor.setPower(speed);
                //leftMotor.setPower(0);
                //telemetry.addData("debug", "leftTicks = 0" + newLeftTarget + " " + newRightTarget);
                //telemetry.update();
                //sleep(500);
                while (opModeIsActive()&& rightMotor.getCurrentPosition() <newRightTarget) {
                    telemetry.addData("Path2", "Running at %7d :%7d", leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
                    telemetry.addData("debug leftTicks = 0", "while loop");
                    telemetry.update();
                }
            }

            //while (opModeIsActive() && (leftMotor.getCurrentPosition() <= Math.abs(newLeftTarget) && rightMotor.getCurrentPosition() <= Math.abs(newRightTarget))) {

                //telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                //telemetry.addData("Path2", "Running at %7d :%7d", leftMotor.getCurrentPosition(), rightMotor.getCurrentPosition());
                //telemetry.addData("debug", "while loop " + newLeftTarget + " " + newRightTarget);
              //  telemetry.update();
            //}

            leftMotor.setPower(0);
            rightMotor.setPower(0);

            //leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            //rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            //sleep(250);


            //leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            //rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            sleep((int) sleepTime);
        }
    }

}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by lemon on 11/8/16.
 */
@TeleOp(name="Linear OpMode", group="Linear Opmode")  // @Autonomous(...) is the other common choice
@Disabled
public class TrcDrive extends OpMode {
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;
    //private DcMotor scoop = null;
    //private DcMotor button = null;
    //private DcMotor linearSlide2;
    //private Servo button = null;
    //private Servo forkLift = null;
    //private DcMotor linearSlide = null;
    //private Servo brake = null;
    //private DcMotor bottomArm = null;


    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        leftMotor = hardwareMap.dcMotor.get("lm");
        rightMotor = hardwareMap.dcMotor.get("rm");
        //button = hardwareMap.dcMotor.get("b");
        //scoop = hardwareMap.dcMotor.get("sc");
        //linearSlide = hardwareMap.dcMotor.get("ls");
        //linearSlide2 = hardwareMap.dcMotor.get("ls2");
        //brake = hardwareMap.servo.get("br");
        //forkLift = hardwareMap.servo.get("fl");
        //bottomArm = hardwareMap.dcMotor.get("ba");

        // eg: Set the drive motor directions:
        // Reverse the motor that runs backwards when connected directly to the battery
        // leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        //rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        //linearSlide2.setDirection(DcMotor.Direction.REVERSE);
        // telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        telemetry.addData("Status", "Running: " + runtime.toString());

        // eg: Run wheels in tank mode (note: The joystick goes negative when pushed forwards)
        if (gamepad1.right_bumper == true) {
            leftMotor.setPower(gamepad1.right_stick_x);
            rightMotor.setPower(gamepad1.left_stick_y);
        } else if (gamepad1.left_bumper == true) {
            leftMotor.setPower(gamepad1.right_stick_x / 4);
            rightMotor.setPower(gamepad1.left_stick_y / 4);
        } else {
            leftMotor.setPower(gamepad1.right_stick_x / 2);
            rightMotor.setPower(gamepad1.left_stick_y / 2);
        }

    }
    public void stop() {
    }

}


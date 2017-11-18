package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by lemon on 11/8/16.
 */
@TeleOp(name="Quad", group="Linear Opmode")  // @Autonomous(...) is the other common choice
public class QuadDrive extends OpMode {
    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor frontLeftMotor = null;
    private DcMotor frontRightMotor = null;
    private DcMotor backLeftMotor = null;
    private DcMotor backRightMotor = null;
    private DcMotor Cannon = null;
    private TouchSensor touch;
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
        frontLeftMotor = hardwareMap.dcMotor.get("flm");
        frontRightMotor = hardwareMap.dcMotor.get("frm");
        backLeftMotor = hardwareMap.dcMotor.get("blm");
        backRightMotor = hardwareMap.dcMotor.get("brm");
        Cannon = hardwareMap.dcMotor.get("cannon");
        touch = hardwareMap.touchSensor.get("touch");
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

        if (touch.isPressed())
        {
            if (gamepad1.right_trigger > 0)
            {
                Cannon.setPower(1);
            }
            else
            {
                Cannon.setPower(0);
            }
        }
        else
        {
            Cannon.setPower(0);
        }

        if (gamepad1.left_stick_y == 1)
        {
            frontLeftMotor.setPower(1);
            frontRightMotor.setPower(-1);
            backLeftMotor.setPower(-1);
            backRightMotor.setPower(1);
        }
        if (gamepad1.left_stick_y == -1)
        {
            frontLeftMotor.setPower(-1);
            frontRightMotor.setPower(1);
            backLeftMotor.setPower(1);
            backRightMotor.setPower(-1);
        }
        if (gamepad1.left_stick_x == 1)
        {
            frontLeftMotor.setPower(-1);
            frontRightMotor.setPower(-1);
            backLeftMotor.setPower(1);
            backRightMotor.setPower(1);
        }
        if (gamepad1.left_stick_x == -1)
        {
            frontLeftMotor.setPower(1);
            frontRightMotor.setPower(1);
            backLeftMotor.setPower(-1);
            backRightMotor.setPower(-1);
        }
        if (gamepad1.right_stick_x > 0)
        {
            frontLeftMotor.setPower(-gamepad1.right_stick_x);
            frontRightMotor.setPower(-gamepad1.right_stick_x);
            backLeftMotor.setPower(-gamepad1.right_stick_x);
            backRightMotor.setPower(-gamepad1.right_stick_x);
        }
        if (gamepad1.right_stick_x < 0)
        {
            frontLeftMotor.setPower(-gamepad1.right_stick_x);
            frontRightMotor.setPower(-gamepad1.right_stick_x);
            backLeftMotor.setPower(-gamepad1.right_stick_x);
            backRightMotor.setPower(-gamepad1.right_stick_x);
        }
        if (gamepad1.left_stick_y != 1 && gamepad1.left_stick_y != -1 && gamepad1.left_stick_x != 1 && gamepad1.left_stick_x != -1 && gamepad1.right_stick_x == 0)
        {
            frontLeftMotor.setPower(0);
            frontRightMotor.setPower(0);
            backLeftMotor.setPower(0);
            backRightMotor.setPower(0);
        }
    }

    public void stop() {

    }
}


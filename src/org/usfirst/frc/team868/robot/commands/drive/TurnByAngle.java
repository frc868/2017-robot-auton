package org.usfirst.frc.team868.robot.commands.drive;

import org.usfirst.frc.team868.robot.RobotMap;
import org.usfirst.frc.team868.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team868.robot.subsystems.GyroSubsystem;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.util.HoundMath;

/**
 *
 */
public class TurnByAngle extends TimedCommand {
	
	private DriveSubsystem motors;
	private PIDController controller;
	private final double P = 0.036, I = 0, D = 0.07;
	private double setAngle;
	private int counter = 0;

	/**
	 * Rotates the robot by the given angle.
	 * (left is negative, right is positive)
	 * @param angle in degrees
	 */
    public TurnByAngle(double angle, double timeout) {
    	super(timeout);
    	motors = DriveSubsystem.getInstance();
    	requires(motors);
    	setAngle = angle;
    	controller = new PIDController(P, I, D, new PIDSource(){

		public void setPIDSourceType(PIDSourceType pidSource) {}

		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		public double pidGet() {
			return GyroSubsystem.getInstance().getRotation();
		}
		
	}, new PIDOutput(){
		
		public void pidWrite(double output) {
			if(output > .05 && output < RobotMap.Drive.MIN_DRIVE_SPEED)
				output = RobotMap.Drive.MIN_DRIVE_SPEED;
			if(output < -.05 && output > -RobotMap.Drive.MIN_DRIVE_SPEED)
				output = -RobotMap.Drive.MIN_DRIVE_SPEED;
			motors.setL(HoundMath.checkRange(output, -.6, .6));
			motors.setR(HoundMath.checkRange(-output, -.6, .6));
		}
		
	});
	controller.setAbsoluteTolerance(1.5);
    }
    
    public TurnByAngle(double angle) {
    	this(angle, 3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putData("Rotation PID", controller);
    	controller.setSetpoint(setAngle+GyroSubsystem.getInstance().getRotation());
    	controller.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(controller.onTarget()){
    		counter++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return counter > 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    	controller.disable();
    }
}


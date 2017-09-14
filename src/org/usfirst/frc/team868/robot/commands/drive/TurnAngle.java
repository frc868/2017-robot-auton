package org.usfirst.frc.team868.robot.commands.drive;

import org.usfirst.frc.team868.robot.RobotMap;
import org.usfirst.frc.team868.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TurnAngle extends TimedCommand {
	
	DriveSubsystem drive;
	double angle;

    public TurnAngle(double angle) {
        super(Math.abs(angle)/150);
        this.angle = angle;
    	drive = DriveSubsystem.getInstance();
    	requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(angle > 0) {
    		drive.setL(RobotMap.Drive.MAX_AUTON_DRIVE_SPEED);
    		drive.setR(-RobotMap.Drive.MAX_AUTON_DRIVE_SPEED);
    	} else {
    		drive.setL(-RobotMap.Drive.MAX_AUTON_DRIVE_SPEED);
    		drive.setR(RobotMap.Drive.MAX_AUTON_DRIVE_SPEED);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

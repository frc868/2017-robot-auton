package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.commands.drive.DriveDistance;
import org.usfirst.frc.team868.robot.commands.drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonDemo extends CommandGroup {

    public AutonDemo() {    	
    	/*
    	 * 2017 PRESEASON AUTON CHALLENGE (RATCHET)
    	 * 
    	 * Below, add commands to be run in autonomous mode to complete the auton challenge. 
    	 * Use addSequential(new Command()) to add the commands in series. 
    	 * 
    	 * Commands available to you:
    	 * DriveDistance(cm) - drive forward/backward a certain distance, in cm
    	 * TurnAngle(angle) - turn a certain number of degrees
    	 * 
    	 * EXAMPLE:
    	 * addSequential(new DriveDistance(50)); //drive forward 50 CM
    	 * addSequential(new TurnByAngle(30)); //turn to the right 30 degrees
    	 * addSequential(new DriveDistance(-20)); //back up 20 CM
    	 * addSequential(new TurnToAngle(180)); //turn around to exactly 180 degrees (not relative)
    	 */
    	
    	addSequential(new DriveDistance(20));
    	addSequential(new TurnAngle (90));
    	addSequential(new DriveDistance(30));
    	
    }
}

package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.commands.drive.DriveDistance;
import org.usfirst.frc.team868.robot.commands.drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

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
    	 * WaitCommand(seconds) - number of seconds to pause for
    	 */
    	
    	//EXAMPLE CODE
    	//PLACE YOUR CODE BELOW
    	
    	addSequential(new DriveDistance(20));	//drive forward 20 cm
    	addSequential(new WaitCommand(1));		//wait 1 second
    	addSequential(new TurnAngle (90));		//turn right 90 degrees
    	addSequential(new DriveDistance(30));	//back up 30 cm
    	
    	//DON'T PLACE CODE BELOW THIS LINE
    }
}

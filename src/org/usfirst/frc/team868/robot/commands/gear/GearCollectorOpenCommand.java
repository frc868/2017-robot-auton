package org.usfirst.frc.team868.robot.commands.gear;

import org.usfirst.frc.team868.robot.subsystems.GearCollectorSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearCollectorOpenCommand extends Command {
	
	private GearCollectorSubsystem holder;

    public GearCollectorOpenCommand() {
    	holder = GearCollectorSubsystem.getInstance();
    	requires(holder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(!holder.isGearCollectorOpen()){
    		holder.setGearCollectorOpen();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

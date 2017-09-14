
package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.AutonDemo;
import org.usfirst.frc.team868.robot.commands.UpdateSmartDashboard;
import org.usfirst.frc.team868.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team868.robot.subsystems.GearCollectorSubsystem;
import org.usfirst.frc.team868.robot.subsystems.GyroSubsystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {	

    /*****************************************************************************************************\
     *               ,,ggddY"""""Ybbgg,,                               ,,ggddY"""""Ybbgg,,               *
     *           ,gd""'               `""bg,                       ,gd""'               `""bg,           *
     *        ,gdP"                       "Ybg,                 ,gdP"                       "Ybg,        *
     *      ,dP"                             "Yb,             ,dP"                             "Yb,      *
     *    ,dP"                                 "Yb,         ,dP"                                 "Yb,    *
     *   ,8"                                     "8,       ,8"                                     "8,   *
     *  ,8'                                       `8,     ,8'                                       `8,  *
     * ,8'                   ###########           `8,   ,8'           ###########                   `8, *
     * d'                 #################         `b   d'         #################                 `b *
     * 8                #####################        8   8        #####################                8 *
     * 8               #######################       8   8       #######################               8 *
     * 8              #########################      8   8      #########################              8 *
     * 8             ###########################     8   8     ###########################             8 *
     * Y,            ###########################    ,P   Y,    ###########################            ,P *
     * `8,           ###########################   ,8'   `8,   ###########################           ,8' *
     *  `8,           #########################   ,8'     `8,   #########################           ,8'  *
     *   `8a           #######################   a8'       `8a   #######################           a8'   *
     *    `Yba          #####################  adP'         `Yba  #####################          adP'    *
     *      "Yba          #################  adY"             "Yba  #################          adY"      *
     *        `"Yba,         ###########  adP"'                 `"Yba, ###########         ,adP"'        *
     *           `"Y8ba,             ,ad8P"'                       `"Y8ba,             ,ad8P"'           *
     *                ``""YYbaaadPP""''                                 ``""YYbaaadPP""''                *
    \*****************************************************************************************************/

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

    	initSubsystems();
    	resetRobot();
		OI.getInstance().initialize();
		new Compressor().setClosedLoopControl(false);
		

    }

	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	resetRobot();
    	new AutonDemo().start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	resetRobot();    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
	
    /**
     * This function gets called to initialize the subsystems
     */
	private void initSubsystems() {
		DriveSubsystem.getInstance();
		GearCollectorSubsystem.getInstance();
		GyroSubsystem.getInstance();
	}
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    private void resetRobot() {
    	Scheduler.getInstance().removeAll();
    	new UpdateSmartDashboard().start();
    }
}

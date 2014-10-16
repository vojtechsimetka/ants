# About
This is my Bachelor's thesis program: Multi-agent Strategy Game with Ants. If you have any questions or requests, don't hesitate and contact me. The full report can be found [here](https://www.dropbox.com/s/q8ecl4ehlm37oq0/xsimet00.pdf?dl=0)

## Compiling from source code
To recompile the project, run the following command while in the game folder:

	ant -f bin/c-build.xml jar

This command should compile all source files and pack them to executable jar file in the game folder. It also adds any asl files from folder `./src/asl` and any images from folder `./img`.

## Java-Jason API

### Custom Internal Actions`calculateDistance(X1,Y1,X2,Y2,D)` 

- Unifies D with square distance between two points with coordinates X1, Y1 and X2, Y2.
` dead(Agent) `

- Returns true if agent with name unified with variable Agent is dead.
`finishedMovement(Agent)`

- Returns true if agent with name unified with variable Agent has finished all it’s actions.`getEscapeDirection(Agent, Enemy, X, Y)`

- Bounds X and Y with coordinates suitable for running away from Enemy.
`getGameTime(Time)`

- Unifies Time with current game time.`getHome(Agent,X,Y)` 

- Unifies X an Y with coordinates of anthill for Agent’s faction.`getPosition(Agent,X,Y)` 

- Unifies X and Y with position of Agent.

`getRandomDirection(X,Y)`

- Unifies X and Y with random coordinates within game area that are free of obstacles.`getUpdateRate(Rate)`

- Unifies Rate with period of perceptual update for current game settings.`isCloser(X1,Y1,X2,Y2,X3,Y3)`

 - Returns true if distance between points with coordinates X1, Y1 and X3, Y3 is lower then distance between points with coordinates X2, Y2 and X3, Y3.

`isWeaker(Enemy,Agent)` 

- Returns true if Enemy is stronger then Agent based on current updates.
`teamBroadcast(Action, Message)`

 - Sends the Message to all agents of the triggering agent’s team. How the message is interpreted depends on Action which can be one of following: achieve, askOne, tell or until. The semantics is same as in Jason’s build-in internal action .send.Internal actions can also be used for influencing environment, but better approach is use of environment’s executeAction() method. Following actions are used for any actions done by agents in Java.

### Ant Environment Actions
`update percepts`

 - Updates percepts about ant surrounding.
 `crawl(X,Y)` 

- Set new destination with coordinates X and Y for the ant.`collect(water)` 

- Collects water on ant’s current location. If there isn’t any returns false.`collect(food)`

 - Collects food on ant’s current location. If there isn’t any returns false.`unload`

- Unloads any food or water from ant to the anthill. Returns false if ant is not at Anthill location.`attack(Enemy)`

 - Sets enemy to be attacked by ant.`stop_attack`

 - Stops any attack.### Anthill Environment Actions`update_percepts`

 - Updates percepts about anthill resources, units status and up- grades price.`new_agent`

 - Creates new ant for the team of anthill. Removes adequate amount of resources.`upgrade_attack`

 - Upgrades attack for all ants under anthill command. Removes adequate amount of resources.`upgrade_armor`

 - Upgrades armour for all ants under anthill command. Removes adequate amount of resources.`upgrade_speed`

 - Upgrades speed for all ants under anthill command. Removes adequate amount of resources.

## Percepts### Ant Percepts`pos(X,Y)`

 - Agent’s current position.`hp(HP)`

 - Agent’s current health. When the HP drops to 0 the ant dies.`collected(Resource)`

 - Describes which resource, if any, the ant is carrying.`resource(X, Y, Amount, Type)`

 - Percept about resource field at location with co- ordinates X and Y, some amount and a certain type.`friend(X, Y, Name)`

 - Percept about perceived friendly ant.`enemy(X, Y, Name)`

 - Percept about perceived enemy ant.### Anthill Percepts`food(Amount)`

 - Amount of available food for the anthill.`water(Amount)`

 - Amount of available water for the anthill.`armour(Level)`

 - Level of current armour upgrade.`attack(Level)`

 - Level of current attack upgrade.`speed(Level)`

 - Level of current speed upgrade.`army(Number)`

 - Number of ants under anthill command.`armour_upgrade_price(Food,Water)`

 - Price of the next armour upgrade.

 `attack_upgrade_price(Food,Water)`
 
 - Price of the next attack upgrade.

 `speed_upgrade_price(Food,Water)`
 
- Price of the next speed upgrade.
## Initial Beliefs### Ant Beliefs`home(X,Y)`

 - Coordinates of the anthill for the faction.
 `update_rate(Rate)`

 - Time between perceptual upgrades.

 `anthill(Anthill)` 
 
- Name of the anthill for the faction.
 ### Anthill Beliefs`update_rate(Rate)`

 - Time between perceptual upgrades.`speed_cap(Cap)`

 - The speed upgrade cap.`new_ant_price(Food, Water)`

 - Price of creation of the new ant.
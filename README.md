## Jets Project

### Overview
This program creates a fleet of different jets with different capabilities, and allows the user to interact with them.

### Topics
- Java OOP
- Extending classes
- Abstract classes
- Interfaces
- I/O
- ArrayList

### Lessons learned
This is the largest project I have done so far, and it uses several different classes and interfaces. The biggest challenge was in implementing some of the stretch goals that I wanted to accomplish, but did not quite finish. Originally I wanted to have a mission mode that would simulate a full contingency operation where all the jets would simultaneously fly, simulate using fuel/having limited range, get air refueled by tankers as needed, have "target" objects that the reconnaissance jets would have to pass to the bombers, and have them bomb the targets. I didn't do all that, but I got close enough to where I was refactoring some of the things that would need to be changed for that - which was a learning experience just in thinking about the project's structure as a whole.

### How to Run
1. Upon running the program, the jets in jets.txt will be added to the fleet.
2. A menu will be presented allowing the user to:
    1. List Fleet: display the information for each jet
    2. Fly all jets: display the information for each jet and show how long they can fly
    3. View fastest jet: display information for the fastest jet(s)
    4. View jet with longest range: display information for the jet(s) with the longest range
    5. Perform refueling missions: all tanker jets will find a random air refuel capable jet and "refuel" it
    6. Perform reconnaissance missions: all reconnaissance jets will "perform reconnaissance" and select a bomber to "bomb" the target
    7. Perform bombing missions: all bombers will "bomb targets"
    8. Add/remove a jet: Select a jet from the fleet and remove it, or enter information for a new jet as prompted and add it to the Fleet
    9. Exit: exit the program

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
- Exceptions, Try/Catch

### Lessons learned
This is the largest project I have done so far, and it uses several different classes and interfaces. The biggest challenge was in implementing some of the stretch goals that I wanted to accomplish. I didn't quite finish everything I wanted, but I did barely manage to implement the "mission mode", which is an expanded simulation. The biggest difficulty was in figuring out how to structure and refactor as I added more things. I ran into difficulty in several places when I got runtime exceptions for "concurrent modification" because I tried to remove objects from an ArrayList while in a forEach loop for the ArrayList.

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
    0. Run mission mode: run a "full" simulation where you can select a number of targets and the range to the targets. All the jets will be launched, and those that need air refueling to reach the targets will attempt to do so. Recon jets will attempt to "locate" targets and put them in a target list for bombers. Bombers will attempt to bomb the targets. At the end a mission summary will be shown.

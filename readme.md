## TeamCode Module
Welcome to to the Code Sisters 2021 - 2022 Read MD for the season. Below is an explanation of the
challenge of this year and some explanations for highlights in our code. This is mostly meant to 
document it for future members that are looking at past code for guidance. I hope its useful.
~ Destiny Hale (Class 0f 2023)



## Intro to Challenge 
In the year of 2021-2022 the challenge was called Freight Frenzy. Robots needed to be able to pick 
up and drop off freight (blocks, balls, ducks) into various storage hub. There was also a large a 
carousel that could be spun to drop ducks. Robots needed a way to spin it or they'd lose a major 
source of points during end-game.

The most complex task in autonomous was that robot could gain 20 points for being able based on a 
ducks location on 3 blocks stack it to a correlating height. (if one first block it goes on the 
lowest level and so and so forth). There are theoretical methods exploring ways to accomplish this
you may find useful.

## Major Tele-op changes
Our Tele-op was completely revamped this year. We began with a focus on intuitive drive controls. 
Our old controls were difficult, cramped, and clunky. For example driving straight and turning used 
all be on only only on the left joystick and inverted. Our driving was edited to model that of a 
typical video games' mappings. 

During this challenge there was a barrier that robots could attempt to drive over. Vector will
drive forward at top speed if x is held. This was attempt to get Vector to brute force his way over
the obstacle.

Note there are 2 Tele-op (for blue & red side) because the duck spinner needed to spin in opposite 
directions to move the carousel on different sides. I considered simply tying two different buttons 
to carousel, but I feared that people would mess it up under high pressure situations. 


## Autonomous
Our Autonomous was fairly simple. Vector drives towards a duck carousel and spins it. Then he parks
in a storage unit drops a pre-loaded box. 

Note there are a few minor differences in between red and blue autonomous. For example, we had an 
issue of the block not falling all the way out when Vector would drop the block into the storage 
unit. I coded our sweeper to swing a few types to knock the block away so that it would remain in 
the storage unit but not touch Vector (if the block touched Vector we would not receive points.)

## Notable elements for the autonomous
For the Autonomous a few simple methods handled all of Vector's movements; most of them are fairly 
self explanatory. The most involved part of the autonomous is the spinning the duck spinner. 

For whatever reason, while coding I had a lot of weird sequencing issues with sleep. Usually sleep
works chronologically (first one thing starts & finishes, then the next starts & finishes and so on).
However, whenever I used sleep with a non-motor (servos) sometimes stuff would start occurring in 
parallel. In simple language, a the duck spinner might start, while the wheels are going rather than 
these being separate actions. My first solution for this issue was the WaitA method. It stops the 
wheels and tells them to resist any movement. This worked for most of my sequence issues with stuff
like the sweeper, but it was not enough to ensure the spinner wouldn't be interrupted. 

I had put a while loop in the autonomous to make sure the wheels would stay stationary. In the code,
there is a boolean named isSpinning. When Vector spins the carousel, it is set to true. When 
isSpinning is true a while loop sets the wheels not move at all, until the spinner stops spinning.

TLDR: Be aware that sleep acts weird with the order of movement when they are all not the same type
of hardware (motors and servos vs all motors).

## Experimental code
If you look any of the experimental autonomous methods you'll find a ton of my failed attempts to
get an encoder to work. Encoders would allow much more accuracy and precision with our autonomous
as sleep is both finicky and unreliable (as shown by my above issues). However, during the season 
all encoders did was spin the robot forever. I've no clue why that is. Hopefully I fix it before I
graduate.

The 2nd major experimental methods are my attempt as using a color sensor. I wanted the robot to 
strafe around the field pausing to see if it saw yellow (a duck), and then grab and drop the duck 
accordingly. Our light sensors gave back really weird values when I used them. I don't think it's a 
code issue, but I'm not 100% sure. It may be that the sensors are really old, or that I messed 
something up. 

If you're looking at using color sensors or encoders that code may be look looking at as a starting
point.
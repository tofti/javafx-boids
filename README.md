# javafx-boids - a JavaFX implementation of the Artificial Life flocking algorithm "Boids"

![javafx-boids](https://github.com/tofti/javafx-boids/blob/master/examples/ExampleAnimated.gif "javafx-boids")


### Background
Boids is an artificial life program, which simulates the flocking behaviour of birds. https://en.wikipedia.org/wiki/Boids. It was developed by Craig Reynolds in 1986, and was published in 1987 in the proceedings of the ACM SIGGRAPH conference. http://dl.acm.org/citation.cfm?id=37406

### Using javafx-boids
javafx-boids is a plain old java application, requiring a JRE 8 installation, and a mouse. The boids world is initliazed with a single boid. Left mouse click adds a boid to the world, and boid parameters can be controlled by right clicking and using the sliders/buttons on the context menu. The sliders affect the precedence of the three velocity vectors used to control the boids motion. A reset function on the menu resets the sliders, and removes all the boids bar one.

### Implementation
This implementation uses the javafx API to render the boids (see https://docs.oracle.com/javase/8/javase-clienttechnologies.htm). The javafx API ships with the JRE as of Java SE 8 meaning zero setup overhead, unlike other graphics libraries such as LWJGL (https://www.lwjgl.org/), and (http://jogamp.org/jogl/www/) which can take some effort to get up and running. The implementation also includes a basic 2D vector class, and corresponding unit tests.

### TODO
- Add obstacles, and obstacle avoidance.
- Add seperation of model, and view/controller.
- Add rendering of neighbourhoods with transparency (so you can see the sphere of influence).

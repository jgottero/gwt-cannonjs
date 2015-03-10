# gwt-cannonjs
A GWT wrapper around the [cannon.js](http://cannonjs.org) library.

## Demo

Most cannon.js demos were translated in Java/GWT: http://gwt-cannonjs.appspot.com/demoLauncher/

## Goals

### Zero overhead

The wrapper is guaranteed to add no overhead *(1)* over the cannon.js library code, both in terms of cpu and code size. Only JavaScriptObject (JSO) are manipulated, which will be eliminated during the inlining/pruning phases of the GWT compiler.

The drawback is that some methods expect a JsArray as a parameter or return type, which is harder to manipulate than plain Java array or collections.
If you prefer to use Java standard collections, you will have to write your own (un)wrapper. I may provide an utility class later, but keep in mind that it will probably affect performance.

*(1) The exception to the rule is methods that accept a JavaScript function as a parameter (event listeners for example): as it's impossible to instantiate a method object in Java, each function parameter must be wrapped in a interface that requires a lightweight (un)wrapping operation.*

### Minimal effort to maintain

Most GWT wrappers are hand written Java code, making the process of updating them when a new library version is released painful and error prone: the maintainer must read commits since previous release and updates Java interfaces accordingly. I think it explains that many wrappers are not updated anymore after a few releases.

I chose another approach: as cannon.js uses Yuidoc style comments, I wrote a small parser that read those comments and generate java classes, with minimal post processing required. When a new version is released, all is needed to do is to re-run this parser.

The drawback of this approach is that it directly relies on comments quality. But let's see the half filled glass: to fix generated code, you must improve comments in the underlying library, thus it also benefits from your work!

## Getting started

**1. Configure your project**

Download the latest release of [gwt-cannonjs.jar](https://github.com/jgottero/gwt-cannonjs/blob/master/build/gwt-cannonjs.jar). Add the jar to your project classpath.

**2. Configure your GWT module**

Add the following line in your GWT module file (*.gwt.xml).

```xml
<inherits name="com.github.gwtcannonjs.Core"/>
```

**3. Inject cannon.js runtime**

You must inject the cannon.js file **before** using any class of the library. The easiest way to achieve it is to use the following method:

```java
CANNON.injectRuntime();
```

It will embed cannon.js straight in GWT compilation output files. Alternatively, you can use a script tag to load cannon.js in your HTML page before your *.nocache.js file.

**4. Hello world!**

The sample code below is a GWT port of the cannon.js "hello world" example. It creates a sphere on a plane, steps the simulation, and prints the sphere simulation to the console.

```java
// Inject cannon.js file
CANNON.injectRuntime();

// Setup our world
World world = CANNON.newWorld();
world.setGravity(CANNON.newVec3(0, 0, -9.82));

// Create a sphere
double radius = 1; // m
Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().
    withMass(5). // kg
    withPosition(CANNON.newVec3(0, 0, 10)) // m
);
sphereBody.addShape(CANNON.newSphere(radius));
world.addBody(sphereBody);

// Create a plane
Body groundBody = CANNON.newBody(CANNON.newBodyOptions().
    withMass(0) // mass == 0 makes the body static
);
Shape groundShape = CANNON.newPlane();
groundBody.addShape(groundShape);
world.addBody(groundBody);

double timeStep = 1 / 60.; // seconds

// Start the simulation loop
for (int i = 0; i < 60; ++i){
    world.step(timeStep);
    System.out.println("Sphere z position: " + sphereBody.getPosition().getZ());
}
```

## Learn cannon.js

Have a look at http://cannonjs.org website!

### JavaScript vs Java/GWT syntax

#### Constructors

As a JSO cannot be instantiated in GWT, all constructors are provided as static methods in the CANNON class:

JavaScript:
```javascript
var world = new CANNON.World();
```

Java/GWT
```java
World world = CANNON.newWorld();
```

#### Constructor options

Use the chain setter (with*) to easily configure several options at once:

JavaScript:
```javascript
var sphereBody = new CANNON.Body({
    mass: 5, // kg
    position: new CANNON.Vec3(0, 0, 10) // m
});
```

Java/GWT
```java
Body sphereBody = CANNON.newBody(CANNON.newBodyOptions().
    withMass(5). // kg
    withPosition(CANNON.newVec3(0, 0, 10)) // m
);
```

#### Properties

Each property has a corresponding getter/setter/chain setter (with*).

JavaScript:
```javascript
world.gravity.set(0, 0, -9.82);
world.gravity = new CANNON.Vec3(0, 0, -9.82);
```

Java/GWT
```java
world.getGravity().set(0, 0, -9.82);
world.setGravity(CANNON.newVec3(0, 0, -9.82));
```

#### Callbacks

Function callbacks are implemented as Java interfaces.

JavaScript:
```javascript
sphereBody.addEventListener("collide", function(e) {
	...
});
```

Java/GWT
```java
sphereBody.addEventListener("collide", new EventListener() {
    public void onEvent(Event event) {
    	...
    }
});
```

## Release notes

 * (9th of march 2015) First release, built around cannon.js v0.6.1.

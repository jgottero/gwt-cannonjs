package com.github.gwtcannonjs.client;

import com.github.gwtcannonjs.client.collision.AABB;
import com.github.gwtcannonjs.client.collision.AABBOptions;
import com.github.gwtcannonjs.client.collision.ArrayCollisionMatrix;
import com.github.gwtcannonjs.client.collision.Broadphase;
import com.github.gwtcannonjs.client.collision.GridBroadphase;
import com.github.gwtcannonjs.client.collision.NaiveBroadphase;
import com.github.gwtcannonjs.client.collision.ObjectCollisionMatrix;
import com.github.gwtcannonjs.client.collision.Ray;
import com.github.gwtcannonjs.client.collision.RaycastResult;
import com.github.gwtcannonjs.client.collision.SAPBroadphase;
import com.github.gwtcannonjs.client.constraints.Constraint;
import com.github.gwtcannonjs.client.constraints.ConstraintOptions;
import com.github.gwtcannonjs.client.constraints.DistanceConstraint;
import com.github.gwtcannonjs.client.constraints.HingeConstraint;
import com.github.gwtcannonjs.client.constraints.HingeConstraintOptions;
import com.github.gwtcannonjs.client.constraints.PointToPointConstraint;
import com.github.gwtcannonjs.client.demo.Demo;
import com.github.gwtcannonjs.client.demo.DemoOptions;
import com.github.gwtcannonjs.client.equations.ContactEquation;
import com.github.gwtcannonjs.client.equations.Equation;
import com.github.gwtcannonjs.client.equations.FrictionEquation;
import com.github.gwtcannonjs.client.equations.RotationalEquation;
import com.github.gwtcannonjs.client.equations.RotationalMotorEquation;
import com.github.gwtcannonjs.client.material.ContactMaterial;
import com.github.gwtcannonjs.client.material.ContactMaterialOptions;
import com.github.gwtcannonjs.client.material.Material;
import com.github.gwtcannonjs.client.math.JacobianElement;
import com.github.gwtcannonjs.client.math.Mat3;
import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Transform;
import com.github.gwtcannonjs.client.math.Vec3;
import com.github.gwtcannonjs.client.objects.Body;
import com.github.gwtcannonjs.client.objects.BodyOptions;
import com.github.gwtcannonjs.client.objects.RaycastVehicle;
import com.github.gwtcannonjs.client.objects.RaycastVehicleOptions;
import com.github.gwtcannonjs.client.objects.RigidVehicle;
import com.github.gwtcannonjs.client.objects.RigidVehicleOptions;
import com.github.gwtcannonjs.client.objects.SPHSystem;
import com.github.gwtcannonjs.client.objects.Spring;
import com.github.gwtcannonjs.client.objects.SpringOptions;
import com.github.gwtcannonjs.client.objects.WheelInfo;
import com.github.gwtcannonjs.client.objects.WheelInfoOptions;
import com.github.gwtcannonjs.client.shapes.Box;
import com.github.gwtcannonjs.client.shapes.ConvexPolyhedron;
import com.github.gwtcannonjs.client.shapes.Cylinder;
import com.github.gwtcannonjs.client.shapes.Heightfield;
import com.github.gwtcannonjs.client.shapes.HeightfieldOptions;
import com.github.gwtcannonjs.client.shapes.Particle;
import com.github.gwtcannonjs.client.shapes.Plane;
import com.github.gwtcannonjs.client.shapes.Shape;
import com.github.gwtcannonjs.client.shapes.Sphere;
import com.github.gwtcannonjs.client.solver.GSSolver;
import com.github.gwtcannonjs.client.solver.Solver;
import com.github.gwtcannonjs.client.solver.SplitSolver;
import com.github.gwtcannonjs.client.utils.Event;
import com.github.gwtcannonjs.client.utils.EventTarget;
import com.github.gwtcannonjs.client.utils.Pool;
import com.github.gwtcannonjs.client.utils.TupleDictionary;
import com.github.gwtcannonjs.client.utils.Vec3Pool;
import com.github.gwtcannonjs.client.world.Narrowphase;
import com.github.gwtcannonjs.client.world.World;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class CANNON {
	/**
	 * Axis aligned bounding box class.
	 * @param options Optional.
	 */
	public static native AABB newAABB(AABBOptions options) /*-{
		return new $wnd.CANNON.AABB(options);
	}-*/;
	
	public static native AABBOptions newAABBOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * Collision "matrix". It's actually a triangular-shaped array of whether two bodies are touching this step, for reference next step
	 */
	public static native ArrayCollisionMatrix newArrayCollisionMatrix() /*-{
		return new $wnd.CANNON.ArrayCollisionMatrix();
	}-*/;
	
	/**
	 * Base class for all body types.
	 * @param options Optional.
	 */
	public static native Body newBody(BodyOptions options) /*-{
		return new $wnd.CANNON.Body(options);
	}-*/;
	
	public static native BodyOptions newBodyOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * A 3d box shape.
	 * @param halfExtents
	 */
	public static native Box newBox(Vec3 halfExtents) /*-{
		return new $wnd.CANNON.Box(halfExtents);
	}-*/;
	
	/**
	 * Base class for broadphase implementations
	 */
	public static native Broadphase newBroadphase() /*-{
		return new $wnd.CANNON.Broadphase();
	}-*/;
	
	/**
	 * Constraint base class
	 * @param bodyA
	 * @param bodyB
	 * @param options Optional.
	 */
	public static native Constraint newConstraint(Body bodyA, Body bodyB, ConstraintOptions options) /*-{
		return new $wnd.CANNON.Constraint(bodyA, bodyB, options);
	}-*/;
	
	public static native ConstraintOptions newConstraintOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * Contact/non-penetration constraint equation
	 * @param bj
	 * @param bi
	 */
	public static native ContactEquation newContactEquation(Body bj, Body bi) /*-{
		return new $wnd.CANNON.ContactEquation(bj, bi);
	}-*/;
	
	/**
	 * Defines what happens when two materials meet.
	 * @param m1
	 * @param m2
	 * @param options Optional.
	 */
	public static native ContactMaterial newContactMaterial(Material m1, Material m2, ContactMaterialOptions options) /*-{
		return new $wnd.CANNON.ContactMaterial(m1, m2, options);
	}-*/;
	
	public static native ContactMaterialOptions newContactMaterialOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * A set of polygons describing a convex shape.
	 * @param points An array of Vec3's
	 * @param faces Array of integer arrays, describing which vertices that is included in each face.
	 */
	public static native ConvexPolyhedron newConvexPolyhedron(JsArray<Vec3> points, JsArray<JsArrayInteger> faces) /*-{
		return new $wnd.CANNON.ConvexPolyhedron(points, faces);
	}-*/;
	
	/**
	 * @param radiusTop
	 * @param radiusBottom
	 * @param height
	 * @param numSegments The number of segments to build the cylinder out of
	 */
	public static native Cylinder newCylinder(double radiusTop, double radiusBottom, double height, double numSegments) /*-{
		return new $wnd.CANNON.Cylinder(radiusTop, radiusBottom, height, numSegments);
	}-*/;
	
	/**
	 * Demo framework class. If you want to learn how to connect Cannon.js with Three.js, please look at the examples/ instead.
	 * @param options
	 */
	public static native Demo newDemo(DemoOptions options) /*-{
		return new $wnd.CANNON.Demo(options);
	}-*/;
	
	/**
	 * Demo framework class. If you want to learn how to connect Cannon.js with Three.js, please look at the examples/ instead.
	 */
	public static native Demo newDemo() /*-{
		return new $wnd.CANNON.Demo();
	}-*/;
	
	/**
	 * Constrains two bodies to be at a constant distance from each other.
	 * @param bodyA
	 * @param bodyB
	 * @param distance
	 * @param maxForce
	 */
	public static native DistanceConstraint newDistanceConstraint(Body bodyA, Body bodyB, double distance, double maxForce) /*-{
		return new $wnd.CANNON.DistanceConstraint(bodyA, bodyB, distance, maxForce);
	}-*/;
	
	/**
	 * Equation base class
	 * @param bi
	 * @param bj
	 * @param minForce Minimum (read: negative max) force to be applied by the constraint.
	 * @param maxForce Maximum (read: positive max) force to be applied by the constraint.
	 */
	public static native Equation newEquation(Body bi, Body bj, double minForce, double maxForce) /*-{
		return new $wnd.CANNON.Equation(bi, bj, minForce, maxForce);
	}-*/;
	
	public static native Event newEvent() /*-{
		return {};
	}-*/;
	
	/**
	 * Base class for objects that dispatches events.
	 */
	public static native EventTarget newEventTarget() /*-{
		return new $wnd.CANNON.EventTarget();
	}-*/;
	
	/**
	 * Constrains the slipping in a contact along a tangent
	 * @param bi
	 * @param bj
	 * @param slipForce should be +-F_friction = +-mu * F_normal = +-mu * m * g
	 */
	public static native FrictionEquation newFrictionEquation(Body bi, Body bj, double slipForce) /*-{
		return new $wnd.CANNON.FrictionEquation(bi, bj, slipForce);
	}-*/;
	
	/**
	 * Axis aligned uniform grid broadphase.
	 * @param aabbMin
	 * @param aabbMax
	 * @param nx Number of boxes along x
	 * @param ny Number of boxes along y
	 * @param nz Number of boxes along z
	 */
	public static native GridBroadphase newGridBroadphase(Vec3 aabbMin, Vec3 aabbMax, double nx, double ny, double nz) /*-{
		return new $wnd.CANNON.GridBroadphase(aabbMin, aabbMax, nx, ny, nz);
	}-*/;
	
	/**
	 * Constraint equation Gauss-Seidel solver.
	 */
	public static native GSSolver newGSSolver() /*-{
		return new $wnd.CANNON.GSSolver();
	}-*/;
	
	/**
	 * Heightfield shape class. Height data is given as an array. These data points are spread out evenly with a given distance.
	 * @param data An array of Y values that will be used to construct the terrain.
	 * @param options
	 */
	public static native Heightfield newHeightfield(JsArray<JsArrayNumber> data, HeightfieldOptions options) /*-{
		return new $wnd.CANNON.Heightfield(data, options);
	}-*/;
	
	public static native HeightfieldOptions newHeightfieldOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * Hinge constraint. Tries to keep the local body axes equal.
	 * @param bodyA
	 * @param bodyB
	 * @param options Optional.
	 */
	public static native HingeConstraint newHingeConstraint(Body bodyA, Body bodyB, HingeConstraintOptions options) /*-{
		return new $wnd.CANNON.HingeConstraint(bodyA, bodyB, options);
	}-*/;
	
	public static native HingeConstraintOptions newHingeConstraintOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * An element containing 6 entries, 3 spatial and 3 rotational degrees of freedom.
	 */
	public static native JacobianElement newJacobianElement() /*-{
		return new $wnd.CANNON.JacobianElement();
	}-*/;
	
	/**
	 * A 3x3 matrix.
	 * @param elements Array of nine elements. Optional.
	 */
	public static native Mat3 newMat3(JsArrayNumber elements) /*-{
		return new $wnd.CANNON.Mat3(elements);
	}-*/;
	
	/**
	 * Defines a physics material.
	 * @param name
	 */
	public static native Material newMaterial(String name) /*-{
		return new $wnd.CANNON.Material(name);
	}-*/;
	
	/**
	 * Defines a physics material.
	 */
	public static native Material newMaterial() /*-{
		return new $wnd.CANNON.Material();
	}-*/;
	
	/**
	 * Naive broadphase implementation, used in lack of better ones.
	 */
	public static native NaiveBroadphase newNaiveBroadphase() /*-{
		return new $wnd.CANNON.NaiveBroadphase();
	}-*/;
	
	/**
	 * Helper class for the World. Generates ContactEquations.
	 */
	public static native Narrowphase newNarrowphase() /*-{
		return new $wnd.CANNON.Narrowphase();
	}-*/;
	
	/**
	 * Records what objects are colliding with each other
	 */
	public static native ObjectCollisionMatrix newObjectCollisionMatrix() /*-{
		return new $wnd.CANNON.ObjectCollisionMatrix();
	}-*/;
	
	/**
	 * Particle shape.
	 */
	public static native Particle newParticle() /*-{
		return new $wnd.CANNON.Particle();
	}-*/;
	
	/**
	 * A plane, facing in the Z direction. The plane has its surface at z=0 and everything below z=0 is assumed to be solid plane. To make the plane face in some other direction than z, you must put it inside a RigidBody and rotate that body. See the demos.
	 */
	public static native Plane newPlane() /*-{
		return new $wnd.CANNON.Plane();
	}-*/;
	
	/**
	 * Connects two bodies at given offset points.
	 * @param bodyA
	 * @param pivotA The point relative to the center of mass of bodyA which bodyA is constrained to.
	 * @param bodyB Body that will be constrained in a similar way to the same point as bodyA. We will therefore get sort of a link between bodyA and bodyB. If not specified, bodyA will be constrained to a static point.
	 * @param pivotB See pivotA.
	 * @param maxForce The maximum force that should be applied to constrain the bodies.
	 */
	public static native PointToPointConstraint newPointToPointConstraint(Body bodyA, Vec3 pivotA, Body bodyB, Vec3 pivotB, double maxForce) /*-{
		return new $wnd.CANNON.PointToPointConstraint(bodyA, pivotA, bodyB, pivotB, maxForce);
	}-*/;
	
	/**
	 * For pooling objects that can be reused.
	 */
	public static native Pool<?> newPool() /*-{
		return new $wnd.CANNON.Pool();
	}-*/;
	
	/**
	 * A Quaternion describes a rotation in 3D space. The Quaternion is mathematically defined as Q = x*i + y*j + z*k + w, where (i,j,k) are imaginary basis vectors. (x,y,z) can be seen as a vector related to the axis of rotation, while the real multiplier, w, is related to the amount of rotation.
	 * @param x Multiplier of the imaginary basis vector i.
	 * @param y Multiplier of the imaginary basis vector j.
	 * @param z Multiplier of the imaginary basis vector k.
	 * @param w Multiplier of the real part.
	 */
	public static native Quaternion newQuaternion(double x, double y, double z, double w) /*-{
		return new $wnd.CANNON.Quaternion(x, y, z, w);
	}-*/;
	
	/**
	 * A Quaternion describes a rotation in 3D space. The Quaternion is mathematically defined as Q = x*i + y*j + z*k + w, where (i,j,k) are imaginary basis vectors. (x,y,z) can be seen as a vector related to the axis of rotation, while the real multiplier, w, is related to the amount of rotation.
	 */
	public static native Quaternion newQuaternion() /*-{
		return new $wnd.CANNON.Quaternion();
	}-*/;
	
	/**
	 * A line in 3D space that intersects bodies and return points.
	 * @param from
	 * @param to
	 */
	public static native Ray newRay(Vec3 from, Vec3 to) /*-{
		return new $wnd.CANNON.Ray(from, to);
	}-*/;
	
	/**
	 * Storage for Ray casting data.
	 */
	public static native RaycastResult newRaycastResult() /*-{
		return new $wnd.CANNON.RaycastResult();
	}-*/;
	
	/**
	 * Vehicle helper class that casts rays from the wheel positions towards the ground and applies forces.
	 * @param options Optional.
	 */
	public static native RaycastVehicle newRaycastVehicle(RaycastVehicleOptions options) /*-{
		return new $wnd.CANNON.RaycastVehicle(options);
	}-*/;
	
	public static native RaycastVehicleOptions newRaycastVehicleOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * Simple vehicle helper class with spherical rigid body wheels.
	 */
	public static native RigidVehicle newRigidVehicle() /*-{
		return new $wnd.CANNON.RigidVehicle();
	}-*/;
	
	public static native RigidVehicleOptions newRigidVehicleOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * Rotational constraint. Works to keep the local vectors orthogonal to each other.
	 * @param bj
	 * @param localVectorInBodyA
	 * @param bi
	 * @param localVectorInBodyB
	 */
	public static native RotationalEquation newRotationalEquation(Body bj, Vec3 localVectorInBodyA, Body bi, Vec3 localVectorInBodyB) /*-{
		return new $wnd.CANNON.RotationalEquation(bj, localVectorInBodyA, bi, localVectorInBodyB);
	}-*/;
	
	/**
	 * Rotational motor constraint. Works to keep the relative angular velocity of the bodies to a given value
	 * @param bodyA
	 * @param bodyB
	 * @param maxForce
	 */
	public static native RotationalMotorEquation newRotationalMotorEquation(Body bodyA, Body bodyB, double maxForce) /*-{
		return new $wnd.CANNON.RotationalMotorEquation(bodyA, bodyB, maxForce);
	}-*/;
	
	/**
	 * Sweep and prune broadphase along one axis.
	 * @param world Optional.
	 */
	public static native SAPBroadphase newSAPBroadphase(World world) /*-{
		return new $wnd.CANNON.SAPBroadphase(world);
	}-*/;
	
	/**
	 * Base class for shapes
	 */
	public static native Shape newShape() /*-{
		return new $wnd.CANNON.Shape();
	}-*/;
	
	/**
	 * Constraint equation solver base class.
	 */
	public static native Solver newSolver() /*-{
		return new $wnd.CANNON.Solver();
	}-*/;
	
	/**
	 * Spherical shape
	 * @param radius
	 */
	public static native Sphere newSphere(double radius) /*-{
		return new $wnd.CANNON.Sphere(radius);
	}-*/;
	
	/**
	 * Smoothed-particle hydrodynamics system
	 */
	public static native SPHSystem newSPHSystem() /*-{
		return new $wnd.CANNON.SPHSystem();
	}-*/;
	
	/**
	 * Splits the equations into islands and solves them independently. Can improve performance.
	 * @param subsolver
	 */
	public static native SplitSolver newSplitSolver(Solver subsolver) /*-{
		return new $wnd.CANNON.SplitSolver(subsolver);
	}-*/;
	
	/**
	 * A spring, connecting two bodies.
	 * @param bodyA
	 * @param bodyB
	 * @param options Optional.
	 */
	public static native Spring newSpring(Body bodyA, Body bodyB, SpringOptions options) /*-{
		return new $wnd.CANNON.Spring(bodyA, bodyB, options);
	}-*/;
	
	public static native SpringOptions newSpringOptions() /*-{
		return {};
	}-*/;
	
	public static native Transform newTransform() /*-{
		return new $wnd.CANNON.Transform();
	}-*/;
	
	public static native TupleDictionary newTupleDictionary() /*-{
		return new $wnd.CANNON.TupleDictionary();
	}-*/;
	
	/**
	 * 3-dimensional vector
	 * @param x
	 * @param y
	 * @param z
	 */
	public static native Vec3 newVec3(double x, double y, double z) /*-{
		return new $wnd.CANNON.Vec3(x, y, z);
	}-*/;
	
	/**
	 * 3-dimensional vector
	 */
	public static native Vec3 newVec3() /*-{
		return new $wnd.CANNON.Vec3();
	}-*/;
	
	public static native Vec3Pool newVec3Pool() /*-{
		return new $wnd.CANNON.Vec3Pool();
	}-*/;
	
	/**
	 * @param options Optional.
	 */
	public static native WheelInfo newWheelInfo(WheelInfoOptions options) /*-{
		return new $wnd.CANNON.WheelInfo(options);
	}-*/;
	
	public static native WheelInfoOptions newWheelInfoOptions() /*-{
		return {};
	}-*/;
	
	/**
	 * The physics world
	 */
	public static native World newWorld() /*-{
		return new $wnd.CANNON.World();
	}-*/;
	
	public static interface RuntimeResource extends ClientBundle {
		public static final RuntimeResource INSTANCE = GWT.create(RuntimeResource.class);
		
		@Source("cannon.min.js")
		TextResource source();
	}
	
	public static interface DemoRuntimeResource extends ClientBundle {
		public static final DemoRuntimeResource INSTANCE = GWT.create(DemoRuntimeResource.class);
		
		@Source("cannon.demo.js")
		TextResource source();
	}
	
	private static boolean runtimeInjected = false;
	private static boolean demoRuntimeInjected = false;
	
	public static void injectRuntime() {
		if (!runtimeInjected) {
			ScriptInjector.fromString(RuntimeResource.INSTANCE.source().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
			runtimeInjected = true;
		}
	}
	
	public static void injectDemoRuntime() {
		if (!demoRuntimeInjected) {
			injectRuntime();
			ScriptInjector.fromString(DemoRuntimeResource.INSTANCE.source().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
			runtimeInjected = true;
		}
	}
}

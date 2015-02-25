package com.github.gwtcannonjs.client.shapes;

import com.github.gwtcannonjs.client.math.Quaternion;
import com.github.gwtcannonjs.client.math.Vec3;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;

/**
 * A set of polygons describing a convex shape.
 * @see http://www.altdevblogaday.com/2011/05/13/contact-generation-between-3d-convex-meshes/
 */
public class ConvexPolyhedron extends Shape {
	protected ConvexPolyhedron() {
		// A JavaScriptObject cannot be created directly
	}
	
	/**
	 * Array of Vec3
	 */
	public final native JsArray<Vec3> getVertices() /*-{
		return this.vertices;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native void setVertices(JsArray<Vec3> vertices) /*-{
		this.vertices = vertices;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native ConvexPolyhedron withVertices(JsArray<Vec3> vertices) /*-{
		this.vertices = vertices;
		return this;
	}-*/;
	
	/**
	 * Array of integer arrays, indicating which vertices each face consists of
	 */
	public final native JsArray<JsArrayInteger> getFaces() /*-{
		return this.faces;
	}-*/;
	
	/**
	 * Array of integer arrays, indicating which vertices each face consists of
	 */
	public final native void setFaces(JsArray<JsArrayInteger> faces) /*-{
		this.faces = faces;
	}-*/;
	
	/**
	 * Array of integer arrays, indicating which vertices each face consists of
	 */
	public final native ConvexPolyhedron withFaces(JsArray<JsArrayInteger> faces) /*-{
		this.faces = faces;
		return this;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native JsArray<Vec3> getFaceNormals() /*-{
		return this.faceNormals;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native void setFaceNormals(JsArray<Vec3> faceNormals) /*-{
		this.faceNormals = faceNormals;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native ConvexPolyhedron withFaceNormals(JsArray<Vec3> faceNormals) /*-{
		this.faceNormals = faceNormals;
		return this;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native JsArray<Vec3> getUniqueEdges() /*-{
		return this.uniqueEdges;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native void setUniqueEdges(JsArray<Vec3> uniqueEdges) /*-{
		this.uniqueEdges = uniqueEdges;
	}-*/;
	
	/**
	 * Array of Vec3
	 */
	public final native ConvexPolyhedron withUniqueEdges(JsArray<Vec3> uniqueEdges) /*-{
		this.uniqueEdges = uniqueEdges;
		return this;
	}-*/;
	
	/**
	 * Computes uniqueEdges
	 */
	public final native void computeEdges() /*-{
		this.computeEdges();
	}-*/;
	
	/**
	 * Compute the normals of the faces. Will reuse existing Vec3 objects in the .faceNormals array if they exist.
	 */
	public final native void computeNormals() /*-{
		this.computeNormals();
	}-*/;
	
	/**
	 * Get face normal given 3 vertices
	 * @param va
	 * @param vb
	 * @param vc
	 * @param target
	 */
	public static final native void getFaceNormal(Vec3 va, Vec3 vb, Vec3 vc, Vec3 target) /*-{
		this.getFaceNormal(va, vb, vc, target);
	}-*/;
	
	/**
	 * Compute the normal of a face from its vertices
	 * @param i
	 * @param target
	 */
	public final native void getFaceNormal(double i, Vec3 target) /*-{
		this.getFaceNormal(i, target);
	}-*/;
	
	/**
	 * @param posA
	 * @param quatA
	 * @param hullB
	 * @param posB
	 * @param quatB
	 * @param separatingNormal
	 * @param minDist Clamp distance
	 * @param maxDist
	 * @param result The an array of contact point objects, see clipFaceAgainstHull
	 * @see http://bullet.googlecode.com/svn/trunk/src/BulletCollision/NarrowPhaseCollision/btPolyhedralContactClipping.cpp
	 */
	public final native void clipAgainstHull(Vec3 posA, Quaternion quatA, ConvexPolyhedron hullB, Vec3 posB, Quaternion quatB, Vec3 separatingNormal, double minDist, double maxDist, JsArray<ContactPoint> result) /*-{
		this.clipAgainstHull(posA, quatA, hullB, posB, quatB, separatingNormal, minDist, maxDist, result);
	}-*/;
	
	/**
	 * Find the separating axis between this hull and another
	 * @param hullB
	 * @param posA
	 * @param quatA
	 * @param posB
	 * @param quatB
	 * @param target The target vector to save the axis in
	 * @return Returns false if a separation is found, else true
	 */
	public final native boolean findSeparatingAxis(ConvexPolyhedron hullB, Vec3 posA, Quaternion quatA, Vec3 posB, Quaternion quatB, Vec3 target) /*-{
		return this.findSeparatingAxis(hullB, posA, quatA, posB, quatB, target);
	}-*/;
	
	/**
	 * Test separating axis against two hulls. Both hulls are projected onto the axis and the overlap size is returned if there is one.
	 * @param axis
	 * @param hullB
	 * @param posA
	 * @param quatA
	 * @param posB
	 * @param quatB
	 * @return The overlap depth, or FALSE if no penetration.
	 */
	public final native double testSepAxis(Vec3 axis, ConvexPolyhedron hullB, Vec3 posA, Quaternion quatA, Vec3 posB, Quaternion quatB) /*-{
		return this.testSepAxis(axis, hullB, posA, quatA, posB, quatB);
	}-*/;
	
	/**
	 * @param mass
	 * @param target
	 */
	public final native void calculateLocalInertia(double mass, Vec3 target) /*-{
		this.calculateLocalInertia(mass, target);
	}-*/;
	
	/**
	 * @param face_i Index of the face
	 */
	public final native double getPlaneConstantOfFace(double face_i) /*-{
		return this.getPlaneConstantOfFace(face_i);
	}-*/;
	
	/**
	 * Clip a face against a hull.
	 * @param separatingNormal
	 * @param posA
	 * @param quatA
	 * @param worldVertsB1 An array of Vec3 with vertices in the world frame.
	 * @param minDist Distance clamping
	 * @param maxDist
	 * @param result Array to store resulting contact points in. Will be objects with properties: point, depth, normal. These are represented in world coordinates.
	 */
	public final native void clipFaceAgainstHull(Vec3 separatingNormal, Vec3 posA, Quaternion quatA, JsArray<Vec3> worldVertsB1, double minDist, double maxDist, JsArray<ContactPoint> result) /*-{
		this.clipFaceAgainstHull(separatingNormal, posA, quatA, worldVertsB1, minDist, maxDist, result);
	}-*/;
	
	/**
	 * Clip a face in a hull against the back of a plane.
	 * @param inVertices
	 * @param outVertices
	 * @param planeNormal
	 * @param planeConstant The constant in the mathematical plane equation
	 */
	public final native void clipFaceAgainstPlane(JsArray<Vec3> inVertices, JsArray<Vec3> outVertices, Vec3 planeNormal, double planeConstant) /*-{
		this.clipFaceAgainstPlane(inVertices, outVertices, planeNormal, planeConstant);
	}-*/;
	
	/**
	 * Updates .worldVertices and sets .worldVerticesNeedsUpdate to false.
	 * @param quat
	 */
	public final native void computeWorldFaceNormals(Quaternion quat) /*-{
		this.computeWorldFaceNormals(quat);
	}-*/;
	
	/**
	 * @param pos
	 * @param quat
	 * @param min
	 * @param max
	 */
	public final native void calculateWorldAABB(Vec3 pos, Quaternion quat, Vec3 min, Vec3 max) /*-{
		this.calculateWorldAABB(pos, quat, min, max);
	}-*/;
	
	/**
	 * Get an average of all the vertices positions
	 * @param target
	 */
	public final native Vec3 getAveragePointLocal(Vec3 target) /*-{
		return this.getAveragePointLocal(target);
	}-*/;
	
	/**
	 * Transform all local points. Will change the .vertices
	 * @param offset
	 * @param quat
	 */
	public final native void transformAllPoints(Vec3 offset, Quaternion quat) /*-{
		this.transformAllPoints(offset, quat);
	}-*/;
	
	/**
	 * Checks whether p is inside the polyhedra. Must be in local coords. The point lies outside of the convex hull of the other points if and only if the direction of all the vectors from it to those other points are on less than one half of a sphere around it.
	 * @param p A point given in local coordinates
	 */
	public final native boolean pointIsInside(Vec3 p) /*-{
		return this.pointIsInside(p);
	}-*/;
	
	/**
	 * Get max and min dot product of a convex hull at position (pos,quat) projected onto an axis. Results are saved in the array maxmin.
	 * @param hull
	 * @param axis
	 * @param pos
	 * @param quat
	 * @param result result[0] and result[1] will be set to maximum and minimum, respectively.
	 */
	public static final native void project(ConvexPolyhedron hull, Vec3 axis, Vec3 pos, Quaternion quat, JsArrayNumber result) /*-{
		this.project(hull, axis, pos, quat, result);
	}-*/;
	
}

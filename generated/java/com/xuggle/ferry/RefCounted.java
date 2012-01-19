/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.xuggle.ferry;

/**
 * Parent of all Ferry objects -- it mains reference counts  
 * in native code.  
 * <p>  
 * RefCounted objects cannot be made with new. They must be  
 * constructed with special factory methods, usually called  
 * make(...).  
 * </p>  
 * <h2>Special note for developers in languages other than C++</h2> 
 *  
 * <p>  
 * You should not need to worry about this class very much. Feel  
 * free to ignore it.  
 * </p>  
 * <h2>Special note for C++ Users</h2>  
 * <p>  
 * Users of RefCounted objects in Native (C++) code must make  
 * sure they acquire() a reference to an object if they  
 * intend to keep using it after they have returned from  
 * the method it was passed to, and  
 * must call release() when done to ensure memory is freed.  
 * </p>  
 * <p>  
 * Methods that return RefCounted objects on the stack are  
 * expected to acquire() the reference for the caller, and  
 * callers <b>must</b> release() any RefCounted object  
 * returned on the stack.  
 * <p>  
 * For example:  
 * </p>  
 * <code>  
 * <pre>  
 * RefCounted methodReturningRefCountedObject();  
 * {  
 * mValueToReturn->acquire(); acquire for caller  
 * return mValueToReturn; and return  
 * }  
 * {  
 * RefCounted *value = methodReturningRefCountedObject();  
 * ...  
 * caller must release  
 * if (value)  
 * value->release();  
 * }  
 * </pre>  
 * </code>  
 */
public class RefCounted {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  private volatile long swigCPtr;
  /**
   * Internal Only.
   */
  protected boolean swigCMemOwn;
  private com.xuggle.ferry.JNIReference mRefCounter;
  private Long mLifecycleReference;

  // the next object looks like it is unused by the compiler, but that's not true; it most
  // definitely is used :)
  @SuppressWarnings("unused")
  private com.xuggle.ferry.JNINativeFinalizer mObjectToForceFinalize;
  private java.util.concurrent.atomic.AtomicLong mJavaRefCount;

  /**
   * Internal Only.  Not part of public API.
   */
  protected RefCounted(long cPtr, boolean cMemoryOwn) {
    this(cPtr, cMemoryOwn, new java.util.concurrent.atomic.AtomicLong(0L));
  }
  
  /**
   * Internal Only.  Not part of public API.
   */
  protected RefCounted(long cPtr, boolean cMemoryOwn,
      java.util.concurrent.atomic.AtomicLong ref)
  {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
    // Create the reference count that java-only objects will use
    // to avoid calling acquire and release on copyReference
    ref.incrementAndGet();
    mJavaRefCount = ref;
    if (swigCPtr != 0)
    {
      // This object must:
      // (a) have no references to any other java object
      // (b) Have a finalizer that just calls gc() on our JNIMemoryManager
      // It exists only to force gc() to be called even if someone calls the Xuggle
      // libraries once and never again
      mObjectToForceFinalize = new com.xuggle.ferry.JNINativeFinalizer();
      // This is what the weak reference will watch; this object should
      // (a) have no references to any other Java object
      // (b) MUST NOT have a finalizer
      // (c) MUST NOT acquire any other references to it except for the strong reference
      //     right here, and the weak reference in mRefCounter
      mLifecycleReference = new Long(swigCPtr);      
      // Force the creation of a new weak reference, will will actually pin itself
      // inside the reference class.
      mRefCounter = JNIReference.createReference(
          this,
          mLifecycleReference, swigCPtr,
          mJavaRefCount);
    }
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  public static long getCPtr(RefCounted obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }
  
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */
  public long getMyCPtr() {
    if (swigCPtr == 0) throw new NullPointerException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Releases any underlying native memory and marks this object
   * as invalid.
   * <p>
   * Normally Ferry manages when to release native memory.
   * </p>
   * <p>
   * In the unlikely event you want to control EXACTLY when a native 
   * object is released, each Xuggler object has a {@link #delete()}
   * method that you can use. Once you call {@link #delete()},
   * you must ENSURE your object is never referenced again from
   * that Java object -- Ferry tries to help you avoid crashes if you
   * accidentally use an object after deletion but on this but we
   * cannot offer 100% protection (specifically if another thread
   *  is accessing that object EXACTLY when you {@link #delete()} it). 
   * </p>
   */
   
   public void delete()
   {
     if(swigCPtr != 0) {
       // assigning to an object removes an incorrect java
       // compiler warning for some
       // generated files
       Object object = this;
       if (object instanceof RefCounted && mRefCounter != null) {
         mRefCounter.delete();
       } else if (swigCMemOwn) {
         swigCMemOwn = false;
       }

     }
     mJavaRefCount = null;
     mRefCounter = null;
     mObjectToForceFinalize = null;
     mLifecycleReference = null;
     swigCPtr = 0;
   }
   
  /**
   * Create a new RefCounted object that is actually referring to the
   * exact same underlying native object.
   *
   * @return the new Java object.
   */
  public RefCounted copyReference() {
    if (swigCPtr == 0)
      return null;
    else
      return new RefCounted(swigCPtr, swigCMemOwn, getJavaRefCount());
  }

  /**
   * Internal Only.  Do not use.
   */
  protected java.util.concurrent.atomic.AtomicLong getJavaRefCount()
  {
    return mJavaRefCount;
  }
   

    /**
     * Return the current reference count on this object.
     * <p>
     * The number returned represents the value at the instant
     * the message was called, and the value can change even
     * before this method returns.  Callers are advised not to
     * depend on the value of this except to check that
     * the value == 1.
     * </p>
     * <p>
     * If the value returned is one, and you know you have a valid
     * reference to that object, then congratulations; you are the
     * only person referencing that object.
     * </p>
     * @return The current ref count.
     */
  public long getCurrentRefCount()
  {
    return mJavaRefCount.get()+getCurrentNativeRefCount()-1;
  }
     // <<<<<<<<<<<<<<<<<<<<<<<<<<<
   // JNIHelper.swg: End generated code
  
 
 
/**
 * Internal Only. <strong>DO NOT USE FROM JAVA</strong>.  
 * <p>  
 * Acquire a reference to this object.  
 * This increments the native internal ref count in native code by +1. 
 *  
 * </p>  
 * <p>  
 * This method is called internally by Ferry in Java, and you should 
 *  
 * not call it without knowing what you are doing. But if you do  
 * call it, make sure you call {@link #release()} once for each call 
 *  
 * you make to this method.  
 * </p>  
 * @return	The refcount after the acquire. Note due to multi-threaded 
 *		 issues, you should not rely on this value,  
 * as it may change before the method returns to you.  
 */
  public int acquire() {
    return FerryJNI.RefCounted_acquire(swigCPtr, this);
  }

/**
 * Internal Only. <strong>DO NOT USE FROM JAVA</strong>.  
 * <p>  
 * This decrements the native internal ref count by -1; the object is 
 * destroyed if its ref count reaches zero.  
 * </p>  
 * <p>  
 * This method is called internally by Ferry in Java, and you should 
 *  
 * not call it without knowing what you are doing. But if you do  
 * call it, make sure you had previously called {@link #acquire()} once 
 * for each call  
 * to {@link #release()} you make.  
 * </p>  
 * @return	The ref count after the release. Note due to multi-threaded 
 *		 issues, you should not rely on this value,  
 * as it may change before the method returns to you.  
 */
  public int release() {
    return FerryJNI.RefCounted_release(swigCPtr, this);
  }

/**
 * Return the current reference count on this object.  
 * The number returned represents the value at the instant  
 * the message was called, and the value can change even  
 * before this method returns. Callers are advised not to  
 * depend on the value of this except to check that  
 * the value == 1.  
 * <p>  
 * If the value returned is one, and you know you have a valid  
 * reference to that object, then congratulations; you are the  
 * only person referencing that object.  
 * </p>  
 * @return	The current ref count.  
 */
  private int getCurrentNativeRefCount() {
    return FerryJNI.RefCounted_getCurrentNativeRefCount(swigCPtr, this);
  }

}
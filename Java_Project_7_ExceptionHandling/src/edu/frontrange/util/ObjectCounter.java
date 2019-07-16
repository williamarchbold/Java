
package edu.frontrange.util;

import java.util.HashMap;
import java.util.Map;

/**
 * An instance of this class may be introduced as the value of a field in any
 * class in order to be able to count the number of instances of that class that
 * exist at any given time.
 *
 * @author		Dr. Bruce K. Haddon, Instructor
 * @version		1.0, 2018-03-06
 */
public class ObjectCounter
{
/**
 * A map to keep the association between a given class and a count of the instances
 * of that class.
 */
private static final Map<Class<?>, Integer> COUNTERS = new HashMap<>();

/**
 * The class being counted.
 */
private final Class<?> clazz;

/**
 * Constructor: this ObjectCounter is used by creating an instance of this counter
 * in each instance of the class whose instances are to be counted, and by passing
 * a reference to the Class object of the instance. So the argument value should be 
 * {@code this.getClass()}.
 *
 * @param clazz			the class whose instances are to be counted.
 */
public ObjectCounter(Class<?> clazz)
{
	if( clazz == null )
		throw new IllegalArgumentException("Argument is null");
	this.clazz = clazz;
	/* Protect the COUNTERS Map. */
	synchronized(COUNTERS)
	{
		/* Initialize the entry in the map if needed. */
		if( !COUNTERS.containsKey(this.clazz) ) COUNTERS.put(this.clazz, 0);
		/* Increment the count of instances of the given class. */
		COUNTERS.put(this.clazz, COUNTERS.get(clazz) + 1);
	}
}

/**
 * If the instance of the class that contains a reference to this counter instance
 * ceases to exist, then also the reference to this instance of the ObjectCounter
 * class will not be accessible, and so this instance of the ObjectCounter class
 * will eventually be finalized. So, in finalizing this instance, decrement the 
 * count of instances of the referencing class.
 *
 * @throws java.lang.Throwable required but not used
 */
@Override
@SuppressWarnings("FinalizeDeclaration")
protected void finalize() throws Throwable
{
	/* Protect the COUNTERS Map. */
	synchronized(COUNTERS)
	{
		if( this.clazz != null )
			COUNTERS.put(this.clazz, COUNTERS.get(clazz) - 1);
	}
	super.finalize();
}

/**
 * Get the count of instances of the requested class. If there is no count known
 * for the given class, a NullPointerException will be thrown. If there is no
 * exception thrown, then the count returned will be the count of the known
 * instances of that class.
 *
 * @param clazz		the desired class
 * @return			the count of known instances of that class
 * @throws NullPointerException if there is no record of that class
 */
public static int getCounter(Class<?> clazz) throws NullPointerException
{
	int result;
	synchronized(COUNTERS)
	{
		result = COUNTERS.get(clazz);
	}
	return result;
}
}

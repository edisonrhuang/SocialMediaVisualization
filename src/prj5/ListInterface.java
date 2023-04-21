package prj5;

/**
 * @author Edison Huang
 * @version 1.0 
 * @param <T> type
 */
public interface ListInterface<T> {
    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public abstract void add(Influencer obj);
    
    /**
     * returns the size
     * 
     * @return the size of the list
     */
    public abstract int size();
    
    /**
     * returns whether the list is empty or not
     * 
     * @return true if empty false if not
     */
    public abstract boolean isEmpty();
}

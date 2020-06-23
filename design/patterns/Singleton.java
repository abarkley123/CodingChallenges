// The singleton pattern ensures only one instance of the class exists in the virtual machine.

public class Singleton {

    private static Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

// or, if thread safety is required
public class ThreadSafeSingleton {

    private ThreadSafeSingleton() {}
    
    private static class SingletonHelper {
        private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
    }
    
    public static ThreadSafeSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

class Demo { 

    public static void main(String args[]) { 
        // instantiating Singleton class
        Singleton x = Singleton.getInstance(); 
  
        // instantiating thread safe Singleton class y 
        ThreadSafeSingleton y = ThreadSafeSingleton.getInstance(); 

        // use the objects
    } 
} 

// This pattern is useful for logging, drivers objects, caching and thread pools.
// Read more - https://www.geeksforgeeks.org/singleton-class-java/,https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples/
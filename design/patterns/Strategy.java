// In Strategy pattern, a class behavior or its algorithm can be changed at run time.
//  This type of design pattern comes under behavior pattern.

public interface Strategy {
    public int doOperation(int num1, int num2);
}

// concrete classes that implement this interface
public class OperationAdd implements Strategy {

   @Override
   public int doOperation(int num1, int num2) {
      return num1 + num2;
   }
}

public class OperationSubtract implements Strategy {
    
   @Override
   public int doOperation(int num1, int num2) {
      return num1 - num2;
   }
}

public class OperationMultiply implements Strategy {
    
   @Override
   public int doOperation(int num1, int num2) {
      return num1 * num2;
   }
}

// create a class for the context - wrapper for the strategy
public class Context {

   private Strategy strategy;

   public Context(Strategy strategy) {
      this.strategy = strategy;
   }

   public int executeStrategy(int num1, int num2) {
      return strategy.doOperation(num1, num2);
   }
}

// demo
public class StrategyPatternDemo {

   public static void main(String[] args) {
      Context context = new Context(new OperationAdd());		
      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationSubstract());		
      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

      context = new Context(new OperationMultiply());		
      System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
   }
}

// Pattern makes it easy to switch between different algorithms (strategies) in runtime because you're using polymorphism in the interfaces.
// Read more - https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm, https://refactoring.guru/design-patterns/strategy/java/example
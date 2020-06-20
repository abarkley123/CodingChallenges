// In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.

// interface

public interface Shape {
    void draw();
}

// conrete classes to implement the interface
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

// factory to create
public class ShapeFactory {

    public Shape getShape(String shape) {
        Shape s = null;

        if(shape.equalsIgnoreCase("CIRCLE")){
            s = new Circle();
        } else if(shape.equalsIgnoreCase("RECTANGLE")) {
            s = new Rectangle();
        } else if(shape.equalsIgnoreCase("SQUARE")) {
            s = new Square();
        }
    
        return s;
    }
}

public class FactoryDemo {

   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //get an object of Circle and call its draw method.
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //call draw method of Circle
      shape1.draw();

      //get an object of Rectangle and call its draw method.
      Shape shape2 = shapeFactory.getShape("RECTANGLE");

      //call draw method of Rectangle
      shape2.draw();

      //get an object of Square and call its draw method.
      Shape shape3 = shapeFactory.getShape("SQUARE");

      //call draw method of square
      shape3.draw();
   }
}

// Read more: https://www.journaldev.com/1392/factory-design-pattern-in-java, https://www.tutorialspoint.com/design_pattern/factory_pattern.htm.
// The abstract factory pattern is an extension of this - https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm.

/* Factory design pattern provides approach to code for interface rather than implementation.
 * Factory pattern removes the instantiation of actual implementation classes from client code. 
 * Factory pattern makes our code more robust, less coupled and easy to extend. 
 * For example, we can easily change PC class implementation because client program is unaware of this.
 * Factory pattern provides abstraction between implementation and client classes through inheritance.
 */
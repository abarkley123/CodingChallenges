// A Decorator pattern can be used to attach additional responsibilities to an object either statically or dynamically. 
// A Decorator provides an enhanced interface to the original object.


public interface ChristmasTree {
    String decorate();
}

public class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public String decorate() {
        return "Christmas Tree";
    }
}

public abstract class TreeDecorator implements ChristmasTree {

    private ChristmasTree tree;

    //constructors..

    @Override
    public String decorate() {
        return tree.decorate();
    }
}

public class FairyLights extends TreeDecorator {

    public FairyLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithFairyLights();
    }

    public String decorateWithFairyLights() {
        return " with Fairy Lights.";
    }
}

public class Garland extends TreeDecorator {

    public Garland(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithGarland();
    }

    public String decorateWithGarland() {
        return " with Garland.";
    }
}

// Then, the following test should pass.
@Test
public void whenDecoratorsInjectedAtRuntime_thenConfigSuccess() {
    ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
    assertEquals(tree1.decorate(), "Christmas tree with Garland");
      
    ChristmasTree tree2 = new BubbleLights(new Garland(new Garland(new ChristmasTreeImpl())));
    assertEquals(tree2.decorate(), "Christmas tree with Garland with Garland with Fairy Lights");
}
// https://www.baeldung.com/java-decorator-pattern

/* This pattern is a good choice in the following cases:

When we wish to add, enhance or even remove the behavior or state of objects
When we just want to modify the functionality of a single object of class and leave others unchanged

*/
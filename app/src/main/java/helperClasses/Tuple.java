package helperClasses;

/**
 * Created by Maciej on 2017-02-10.
 */
public class Tuple {
    public final int x;
    public final int y;
    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return Integer.toString(x)+" + "+Integer.toString(y)+" = "+Integer.toString(x+y);
    }
}

//C:\Users\Maciej\AndroidStudioProjects\SettlersOfCatan\app\src\main\java\helperClasses.Tuple.java
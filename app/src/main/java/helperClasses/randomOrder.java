package helperClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Maciej on 2017-02-10.
 */
public class randomOrder {
    public ArrayList<Tuple> tuples;
    int pips;

    public randomOrder(int p) {
        pips = p;
        tuples = new ArrayList<Tuple>();
        for (int i = 1; i <= pips; i++)
            for (int j = 1; j <= pips; j++) {
                tuples.add(new Tuple(i, j));
            }
        //shuffle();
    }

    public void shuffle() {
        Collections.shuffle(tuples);
    }
}

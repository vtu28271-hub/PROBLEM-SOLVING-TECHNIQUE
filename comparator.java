    
}
import java.util.*;


class Checker implements java.util.Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        // Higher score first
        if (a.score != b.score) {
            return b.score - a.score;
        }

        // Same score: alphabetical order
        return a.name.compareTo(b.name);
    }
}
// Write your Checker class here

class Player{
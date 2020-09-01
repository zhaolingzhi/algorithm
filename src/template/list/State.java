package template.list;

import java.util.Objects;

public class State {
    int x;
    int y;
    public State(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return x == state.x &&
                y == state.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

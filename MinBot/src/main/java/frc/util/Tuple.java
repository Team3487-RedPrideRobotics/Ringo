package frc.util;

//Thanks for https://stackoverflow.com/a/521235
//Good to learn from

//Immutable pair of two types.
public class Tuple<L,R> {
    
    private final L left;
    private final R right;

    public Tuple(L l, R r) {
        assert l != null;
        assert r != null;
        
        this.left = l;
        this.right = r;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return left.hashCode()^right.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Tuple<?,?>)) return false;
        Tuple<?,?> t_o = (Tuple<?,?>) o;
        return this.left.equals(t_o.getLeft()) && this.right.equals(t_o.getRight());
    }

}

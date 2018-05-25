package TheGuava.Base;

import com.google.common.base.Preconditions;

/**
 * Created by tangjialiang on 2018/1/30.
 *
 * Preconditions.checkArgument()
 * Preconditions.checkNotNull()
 * Preconditions.checkElementIndex()
 */
public class PreconditionsDemo {

    public static void main(String[] args) {
        try {
            getValue(5) ; 
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()) ;
        }

        try {
            sum(4, null) ;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage()) ;
        }

        try {
            sqrt(-1) ;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()) ;
        }
    }

    private static double sqrt(double input) {
        Preconditions.checkArgument(input>0.0,
                "Illegal Argument passed: Negative value %s.",input);
        return 0 ;
    }

    private static int sum(Integer a, Integer b) {
        Preconditions.checkNotNull(a,
                "Illegal Argument passed: First parameter is Null.") ;
        Preconditions.checkNotNull(b,
                "Illegal Argument passed: First parameter is Null.") ;

        return a+b ;
    }

    private static int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5} ;
        int index = Preconditions.checkElementIndex(input, data.length,
                "Illegal Argument passed: Invalid index.") ;
        return data[index] ;
    }
}

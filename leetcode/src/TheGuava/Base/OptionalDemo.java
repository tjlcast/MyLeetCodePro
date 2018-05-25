package TheGuava.Base;


import com.google.common.base.Optional;

/**
 * Created by tangjialiang on 2018/1/30.
 *
 * 通过使用Optional来避免java中的null，
 * Optional.get or Optional.or()
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Integer value1 = null ;
        Integer value2 = 10 ;
        /*创建指定引用的Optional实例，若引用为null则快速失败返回absent()
         absent()创建引用缺失的Optional实例
        */
        Optional<Integer> a = Optional.fromNullable(value1) ;
        Optional<Integer> b = Optional.of(value2) ;
        Optional<Integer> c = Optional.absent() ;

        System.out.println(sum(a, b)) ;
    }

    private static Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //isPresent():如果Optional包含非null的引用（引用存在），返回true
        System.out.println("First param is present: " + a.isPresent()) ;
        System.out.println("Second param is present: " + b.isPresent()) ;

        Integer value1 = a.or(0) ;      //返回Optional所包含的引用,若引用缺失,返回指定的值
        Integer value2 = b.get() ;         //返回所包含的实例,它必须存在,通常在调用该方法时会调用isPresent()判断是否为null

        return value1 + value2 ;
    }
}

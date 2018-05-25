package TheGuava.Collections2;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * Created by tangjialiang on 2018/1/30.
 */
public class FilterDemo {
    public static void main(String[] args) {
        List<String> list= Lists.newArrayList("moon","dad","refer","son");
        Collection<String> palindromeList= Collections2.filter(list, input -> {
            return new StringBuilder(input).reverse().toString().equals(input); //找回文串
        });
        System.out.println(palindromeList);
    }
}

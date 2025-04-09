package practice;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean func(int n, Set<Integer> set) {
        System.out.println(n);
        if(n == 1)
            return true;
        if(set.contains(n))
            return false;
        int result = 0;
        while(n > 0) {
            int reminder = (n % 10);
            result += (reminder * reminder);
            n /= 10;
        }

        set.add(n);
        return func(result, set);
    }
    public boolean isHappy(int n) {
        return func(n, new HashSet<>());
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(2));
    }
}

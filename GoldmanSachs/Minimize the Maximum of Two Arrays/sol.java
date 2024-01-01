//                            MATHEMATICs BASED PROBLEM
// //problem Statement-> We have two arrays arr1 and arr2 which are initially empty. 
// You need to add positive integers to them such that they satisfy all the following conditions:
// arr1 contains uniqueCnt1 distinct positive integers, each of which is not divisible by divisor1.
// arr2 contains uniqueCnt2 distinct positive integers, each of which is not divisible by divisor2.
// No integer is present in both arr1 and arr2.
// Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum possible maximum integer that can be present in either array.
// uniqueCnt1 ->c1
// uniqueCnt2 ->c2
// divisor1 ->d1
// divisor2 ->d2

class Solution {
    public int minimizeSet(int d1, int d2, int c1, int c2) {
        long  low = 1, high = (long)Math.pow(10,10);
        long  ans = Integer.MAX_VALUE;

        while (low <= high) {
            long mid = (low + high) >> 1;
            if (possible(d1, d2, c1, c2, mid)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)ans;
    }

    boolean possible(long d1, long d2, long c1, long c2, long mid) {
        long divBy1 = mid / d1;
        long divBy2 = mid / d2;
        long notDivBy1 = mid - divBy1;
        long notDivBy2 = mid - divBy2;
        long lcm = LCM(d1, d2);
        long notDivByBoth = mid - (mid / lcm);
        
        return (notDivBy1 >= c1 && notDivBy2 >= c2 && notDivByBoth >= (c1 + c2));
    }

    long GCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long LCM(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / GCD(a, b);
    }
}


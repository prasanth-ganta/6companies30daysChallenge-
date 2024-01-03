// Given a pattern containing only I's and D's. I for increasing and D for decreasing.
// Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can't repeat.
// Example 1:
// Input:
// D
// Output:
// 21
// Explanation:
// D is meant for decreasing, so we choose the minimum number among all possible numbers like 21,31,54,87,etc.
  
// Example 2:
// Input:
// IIDDD
// Output:
// 126543
// Explanation:
// 1 < 2 < 6 > 5 > 4 > 3
// I - I - D - D - D
class Solution{
    static String printMinNumberForPattern(String S){
          int n=S.length();
          StringBuilder sb=new StringBuilder();
          sb.append('1');
          int current=1;
          int i=0;
    
          while(i<n){
              if(S.charAt(i)=='D'){
                  int j=i;
                  while(j<n&&S.charAt(j)=='D'){
                      j++;
                  }
                  int NumOfD=j-i;
                  current=current+NumOfD;
                  char c=(char)('0'+current);
                  sb.setCharAt(i,c);
                  int count=current;
                  
                  while(i!=j){
                     count--;
                     sb.append(count);
                     i++;
                  }
                 
              }else{
                  current++;
                  sb.append(current);
                  
                  i++;
              }
          }
          return sb.toString();
    }
}



// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// Return the answer in any order.
class Solution {
    public List<String> letterCombinations(String digits) {
      //stored strings according to their number indexing
      String[]options={"" , "" , "abc" ,"def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      List<String>list=new ArrayList<>();
      if(digits.length()==0)return list;//to avoid number format exception
      int num=Integer.parseInt(digits);//convert string to number
      function(num,"",options,list);
      return list;  
    }
    void function(int num,String ans,String[]options,List<String>list ){
        if(num==0){
            list.add(ans);
            return;
        }
        int ind=num%10;//take out last number
        String s1=options[ind];//take out string value of that index
        for(int i=0;i<s1.length();i++){
            function(num/10,s1.charAt(i)+ans,options,list);
        } 
    }
}

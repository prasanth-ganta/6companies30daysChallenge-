// You are given a 2D 0-indexed array of strings, access_times, with size n.
// For each i where 0 <= i <= n - 1, access_times[i][0] represents the name of an employee, and access_times[i][1] represents the access time of that employee.
// All entries in access_times are within the same day.

// The access time is represented as four digits using a 24-hour time format, for example, "0800" or "2250".
// An employee is said to be high-access if he has accessed the system three or more times within a one-hour period.
// Times with exactly one hour of difference are not considered part of the same one-hour period. 
// For example, "0815" and "0915" are not part of the same one-hour period.
// Access times at the start and end of the day are not counted within the same one-hour period.
// For example, "0005" and "2350" are not part of the same one-hour period.

// Return a list that contains the names of high-access employees with any order you want.

class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
      //it stores time stamps of each unique name
        HashMap<String,ArrayList<Integer>>map=new HashMap<>();
        for(List<String>list:access_times){
             String name=list.get(0);                   //get name
             int time=Integer.parseInt(list.get(1));    //convert string time to int
              //store them in the Hashmap
             if(!map.containsKey(name)){
                 map.put(name,new ArrayList<>());
                 map.get(name).add(time);
             }else{
                 map.get(name).add(time);
             }
        }
        List<String>high=new ArrayList<>();
        //traverse the map
        for(String name:map.keySet()){
            ArrayList<Integer>list=map.get(name);
            Collections.sort(list);
            we are checking because we want 3 Consecutive times for name to be highAccess
            if(list.size()>=3){
               for(int i=0;i<list.size()-2;i++){
                   if(list.get(i+2)-list.get(i)<100){
                       high.add(name); //if get the name no need to check further break it
                       break;
                   }
               }
            }
        }
        return high;
    }
}


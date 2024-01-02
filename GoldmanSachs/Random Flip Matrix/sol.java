// Here we are modeling the matrix as a 1d array with initial size of row*cols.
// For each flip, randomly pick an index from 0 to size-1 and flip it.
// int r = rand.nextInt(total);
// Then swap that flipped element with the tail element (index: size-1),
// store that mapping info (key: origin index, value: index of the tail) into a Map and decrease the size.
// map.put(r, map.getOrDefault(total-1, total-1));
// Next time when we randomly pick a same index we can go to the map and find the actual element stores in that index
// int actual = map.getOrDefault(r, r);
class Solution {
    HashMap<Integer,Integer>map;
    Random rand;
    int rows,cols,total;
    public Solution(int m, int n) {
      map=new HashMap<>();
      rand=new Random();
      rows=m;
      cols=n;
      total=m*n; 
    }
    
    public int[] flip() {
        int r=rand.nextInt(total);
        int actual=map.getOrDefault(r,r);
        int[]arr=new int[]{actual/cols,actual%cols};
        map.put(r,map.getOrDefault(total-1,total-1));
        total--;
        return arr;
    }
    
    public void reset() {
        map.clear();
        total=rows*cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */

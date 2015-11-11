/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1; 
        int r = n; 
        
        while (l + 1 < r) {
            int mid = l + (r - l) / 2; 
            
            if (isBadVersion(mid)) {
                r = mid; 
            } else {
                l = mid; 
            }
        }
        
        if (isBadVersion(l)) {
            return l; 
        }
        
        return r; 
    }
    
}

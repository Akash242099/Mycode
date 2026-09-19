class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
//      double d=Math.abs((((y2-y1)*xCenter)+((x2-x1)*yCenter)+((x2*y1)-(x1*y2))))/Math.sqrt((((y2-y1)*(y2-y1))+((x2-x1)*(x2-x1))));
// if(radius>=d) return true;
// return false;
    int x = Math.max(x1, Math.min(xCenter, x2));
        int y = Math.max(y1, Math.min(yCenter, y2));

        int dx = xCenter - x;
        int dy = yCenter - y;

        return dx * dx + dy * dy <= radius * radius;
    }
}
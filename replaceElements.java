class Solution {
    public int[] replaceElements(int[] arr) {
     for (int i = arr.length - 1, mx = -1; i >= 0; --i)
            mx = Math.max(arr[i], arr[i] = mx);
        return arr;
    }
}

//or 



class Solution {
    public int[] replaceElements(int[] arr) {
        var max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            var tmp = arr[i];
            arr[i] = max;
            if (tmp > max) {
                max = tmp;
            }
        }
        return arr;
    }
}

//or


class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length == 0)
            return arr;
        
        int greatest = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] > greatest){
                int aux = greatest;
                greatest = arr[i];
                arr[i] = aux;
            } else arr[i] = greatest;
        }
        
        return arr;
    }
}
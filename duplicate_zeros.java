class Solution {
    public void duplicateZeros(int[] arr) {
        int l1=arr.length;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i =0; i<arr.length; i++)
            l.add(arr[i]);
        int j=0; //to increement the position in list whenever 0 is added to list
        for(int i=0;i<l1;i++){
            if(arr[i]==0){
                l.add(i+j,0);
                j++;
            }
        }
        for(int i =0; i<arr.length; i++)
            arr[i] = l.get(i);
       
    }
}

//or

public void duplicateZeros(int[] arr) {
    LinkedList<Integer> queue=new LinkedList<Integer>();  
    for(int i = 0; i < arr.length; i++) {
        queue.add(arr[i]);
        if(arr[i] == 0) {
            //add another 0
            queue.add(arr[i]);
        }
        arr[i] = queue.poll();
    }
}




//or 0ms


class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included  
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}


//or 1ms


class Solution {
    public void duplicateZeros(int[] arr) {
        int[] answer = new int[arr.length];
        int i = 0;
        int k = 0;
        while(k < answer.length){
            answer[k] = arr[i];
            if(arr[i] == 0 && k+1 < answer.length){
                k+=1;
                answer[k] = 0;
            }
            i++;
            k++;
        }
        for(int n=0; n<answer.length; n++){
            arr[n] = answer[n];
        }
    }
}

// or less memory 


class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0;
       /* for(int i=0; i<arr.length; i++){
            System.out.println("POS: " + i + " - Val: " + arr[i] );
        }*/
        
        for(int j=0; j< arr.length; j++){
            if(arr[j] == 0){
                for(int k = arr.length -1; k > j; k--){
                   // System.out.println("Sostituisco " + k + " " + arr[k] + " con " + arr[k-1]);
                    arr[k] = arr[k-1];
                }
                /* for(int i=0; i<arr.length; i++){
                      System.out.print(" " + arr[i]+ " " );
                }
                System.out.println(" ");*/
                j=j+1;
            }
        }
        
    }
}
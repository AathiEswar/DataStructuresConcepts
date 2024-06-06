package Concepts.DynamicProgramming;

public class ReplaceRightElementsMax {
    //Optimal Solution

    public int[] optimalReplaceElement(int[] arr) {
        int rightmax = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int newMax = Math.max(arr[i] , rightmax);

            arr[i] = rightmax;
            rightmax = newMax;
        }

        return arr;
    }


        // OWN SOLUTION
        public int[] replaceElements ( int[] arr){
            int maxOnRight = 0;
            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i] >= maxOnRight) {
                    // find max
                    int max = 0;
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] > max) {
                            max = arr[j];
                        }
                    }
                    maxOnRight = max;
                }

                arr[i] = maxOnRight;

            }
            arr[arr.length - 1] = -1;
            return arr;
        }
    }

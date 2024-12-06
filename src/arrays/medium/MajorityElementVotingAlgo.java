package arrays.medium;

public class MajorityElementVotingAlgo {
    public static int majorityElement(int[] votes) {
        int count = 0;
        int elected = 0;
        for (int i = 0; i < votes.length; i++) {
            if (count == 0) {
                count = 1;
                elected = votes[i];
            }
            else if (votes[i] == elected) {
                count++;
            }
            else {
                count--;
            }
        }
        int countConfirm = 0;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] == elected) {
                countConfirm++;
            }
        }

        if (countConfirm > votes.length/2) {
            return elected;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);
    }
}

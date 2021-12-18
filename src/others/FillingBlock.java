package others;

public class FillingBlock {

    int fillingBlocks(int n) {
        int[] noBumps = new int[n + 1];
        int[] sideBumps = new int[n + 1];
        int[] middleBumps = new int[n + 1];
        noBumps[0] = 1;
        noBumps[1] = 1; // c-c
        sideBumps[0] = 1; // c
        sideBumps[1] = 2; // c-c-c + r-r-c
        middleBumps[0] = 1; // c
        middleBumps[1] = 1; //  c-c-c

        for (int i = 2; i <= n; i++) {
            noBumps[i] = noBumps[i - 1] // c-c
                    + noBumps[i - 2] // r-r-r-r
                    + 2 * sideBumps[i - 2] // r-r-c + c-r-r
                    + middleBumps[i - 2]; // r-c-r
            sideBumps[i] = noBumps[i] // c
                    + sideBumps[i - 1]; // r-r
            middleBumps[i] = noBumps[i] // c
                    + middleBumps[i - 2]; // r-r-r-r
        }
        return noBumps[n];
    }

    public static void main(String[] args) {
        FillingBlock fillingBlock = new FillingBlock();
        System.out.println(fillingBlock.fillingBlocks(4));
    }
}

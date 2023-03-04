public class Main {
    public static void main(String[] args) {
        int[] bookShelf = {14, 16, 19, 32, 32, 32, 56, 69, 72};
        System.out.println(Boolean.TRUE.equals(9 == books(bookShelf, 1)));
        System.out.println(Boolean.TRUE.equals(8 == books(bookShelf, 14)));
        System.out.println(Boolean.TRUE.equals(3 == books(bookShelf, 32)));
        System.out.println(Boolean.TRUE.equals(3 == books(bookShelf, 33)));
        System.out.println(Boolean.TRUE.equals(2 == books(bookShelf, 56)));
        System.out.println(Boolean.TRUE.equals(2 == books(bookShelf, 66)));
        System.out.println(Boolean.TRUE.equals(1 == books(bookShelf, 69)));
        System.out.println(Boolean.TRUE.equals(1 == books(bookShelf, 70)));
        System.out.println(Boolean.TRUE.equals(0 == books(bookShelf, 72)));
        System.out.println(Boolean.TRUE.equals(0 == books(bookShelf, 73)));
        int[] arr = {1, 1, 1, 1};
        System.out.println(calc(arr));
    }

    static int books(int[] bookShelf, int newBook) {
        int left = 0;
        int right = bookShelf.length - 1;
        int lastMatchIndex = -1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (bookShelf[middle] == newBook) {
                lastMatchIndex = middle;
                left = middle;
                if (left < (bookShelf.length - 1) && bookShelf[left] == bookShelf[left + 1]) {
                    left++;
                    lastMatchIndex++;
                } else {
                    break;
                }
            } else if (bookShelf[middle] < newBook) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (lastMatchIndex == -1) {
            lastMatchIndex = left - 1;
        } else {
            lastMatchIndex = left;
        }
        return bookShelf.length - 1 - lastMatchIndex;
    }

    static int calc (int[] arr) {
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            ans += arr[i] + arr[i - 1];
        }
        return ans;
    }
}
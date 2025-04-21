import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    private int findInsertIndex(String value) {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high) {
            int mid = (low + high) /2;
            int comparison = value.compareTo(list.get(mid));
            if(comparison == 0) {
                return mid;
            } else if(comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public void add(String value) {
        int index = findInsertIndex(value);
        list.add(index,value);
    }

    public int search(String value) {
        int low = 0;
        int high = list.size() - 1;

        while(low <= high) {
            int mid = (low + high) /2;
            int comparison = value.compareTo(list.get(mid));
            if(comparison == 0) {
                return mid;
            } else if(comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -low - 1;
    }

    public ArrayList<String> getList() {
        return list;
    }
}

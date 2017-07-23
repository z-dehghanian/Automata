package final2;

public class Stack {

    int arr[];
    int maxLength;
    int now;

    public Stack(int maxLength) {
	// TODO Auto-generated constructor stub
	this.maxLength = maxLength;
	arr = new int[maxLength];
	now = 0;
    }

    public void push(int x) {

	arr[now] = x;
	now++;
    }

    public int pop() {

	if (now == 0) {
	    return 0;
	}
	now--;
	return arr[now];
    }

    public boolean isEmpty() {

	if (now == 0) {
	    return true;
	}

	return false;
    }
}

package Theorie.Kap2.MyTreeElement_12;

public class MyTreeElement {

    private final Character value;
    private MyTreeElement leftNode;
    private MyTreeElement rightNode;

    public MyTreeElement(final Character value) {
        this.value = value;
    }

    public void add(final Character c) {
        if (c <= value) {
            if (leftNode == null)
                leftNode = new MyTreeElement(c);
            else
                leftNode.add(c);
        } else {
            if (rightNode == null)
                rightNode = new MyTreeElement(c);
            else
                rightNode.add(c);
        }
    }

    public int count(final Character c) {
        if (c == this.value)
            return 0;
        else if (c <= value && leftNode != null)
            return 1 + leftNode.count(c);
        else if (c > value && rightNode != null)
            return 1 + rightNode.count(c);
        else
            throw new ArrayIndexOutOfBoundsException("Nicht drin");
    }
}

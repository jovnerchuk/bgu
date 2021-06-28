public class Tree {

  private static class TreeNode {

    private final Long value;
    private TreeNode next;
    private TreeNode prev;

    public TreeNode(Long value) {
      this.value = value;
    }

    public Long getValue() {
      return value;
    }

    public TreeNode getNext() {
      return next;
    }

    public TreeNode getPrev() {
      return prev;
    }

    public void setNext(TreeNode next) {
      this.next = next;
    }

    public void setPrev(TreeNode prev) {
      this.prev = prev;
    }

    @Override
    public String toString() {
      return "TreeNode{value=" + value + ", next=" + next + ", prev=" + prev + '}';
    }

  }

  private TreeNode root;

  public Tree(Long[] values) {
    insertValues(values);
  }

  public void insertValue(final Long value) {
    if (this.root == null) {
      this.root = new TreeNode(value);
      return;
    }

    var currentNode = this.root;
    while (true) {
      if (currentNode.getValue().equals(value)) {
        break;
      }

      if (currentNode.getValue() > value) {
        if (currentNode.getPrev() == null) {
          currentNode.setPrev(new TreeNode(value));
          break;
        } else {
          currentNode = currentNode.getPrev();
        }
      } else {
        if (currentNode.getNext() == null) {
          currentNode.setNext(new TreeNode(value));
          break;
        } else {
          currentNode = currentNode.getNext();
        }
      }
    }
  }

  public void insertValues(final Long[] values) {
    for (var value : values) {
      insertValue(value);
    }
  }

  public boolean isExists(final Long value) {
    var currentNode = this.root;

    while ((currentNode != null)) {
      if (currentNode.getValue().equals(value)) {
        return true;
      }
      if (currentNode.getValue() > value) {
        currentNode = currentNode.getPrev();
      } else {
        currentNode = currentNode.getNext();
      }
    }

    return false;
  }

  @Override
  public String toString() {
    return "Tree{root=" + root + '}';
  }

}

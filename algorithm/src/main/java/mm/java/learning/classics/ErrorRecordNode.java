package mm.java.learning.classics;

/**
 * @ClassName ErrorRecordNode
 * @Description TODO
 * @Author mars
 * @Date 2024/11/18 20:10
 * @Version 1.0
 **/
public class ErrorRecordNode {
    String fileNameAndLineNumber; // 文件名和行号
    int count; // 错误次数
    ErrorRecordNode next; // 下一个节点

    // 构造方法
    public ErrorRecordNode(String fileNameAndLineNumber, int count) {
        this.fileNameAndLineNumber = fileNameAndLineNumber;
        this.count = count;
        this.next = null; // 默认指向null
    }

    // 获取链表节点个数
    public static int getNodeCount(ErrorRecordNode head) {
        int count = 0; // 节点计数器
        ErrorRecordNode current = head; // 当前节点指针
        while (current != null) {
            count++; // 计数器加一
            current = current.next; // 移动到下一个节点
        }
        return count;
    }

    // 尾插法
    public static ErrorRecordNode appendTail(ErrorRecordNode head, String fileNameAndLineNumber, int count) {
        ErrorRecordNode newNode = new ErrorRecordNode(fileNameAndLineNumber, count);
        if (head == null) {
            // 如果链表为空，则新节点直接作为头结点返回
            return newNode;
        }
        ErrorRecordNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode; // 将新节点添加到链表尾部
        return head;
    }

    // 去除头结点
    public static ErrorRecordNode removeHead(ErrorRecordNode head) {
        if (head == null) {
            return null; // 链表为空，直接返回null
        }
        return head.next; // 返回原头结点的下一个节点
    }

    // 更新 count方法
    public static void updateCount(ErrorRecordNode head, String fileNameAndLineNumber) {
        ErrorRecordNode current = head;
        while (current != null) {
            if (current.fileNameAndLineNumber.equals(fileNameAndLineNumber)) {
                current.count++;
                return;
            }
            current = current.next;
        }
        System.out.println("未找到匹配的节点：" + fileNameAndLineNumber);
    }

    // 覆盖 toString 方法， 用于链表的可视化
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ErrorRecordNode current = this;
        while (current != null) {
            sb.append("{").append("fileNameAndLineNumber='").append(current.fileNameAndLineNumber).append("',").append(", count=").append(current.count).append("} -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

}

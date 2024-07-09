/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        ListNode newHead=new ListNode(0);
        newHead.next=head;

        ListNode curr=newHead,next=newHead,prev=newHead;
        int cnt=0;
        while(curr.next!=null){
            curr=curr.next;
            cnt++;
        }
        while(cnt>=k){
            curr=prev.next;
            next=curr.next;
            for(int i=1;i<k;i++){
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next=curr.next;
            }
            prev=curr;
            cnt-=k;
        }
        return newHead.next;
    }
}
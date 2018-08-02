while(first.next != null && first.next.next != null) {
  first = first.next;
}
first.next = null;
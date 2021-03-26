public class Event
{
  public static void main(String[] args)
  {
    Author author=new Author(5);
    Thread authorThread=new Thread(author, "Bob the Writer");
    Reader reader1=new Reader();
    Reader reader2=new Reader();
    Reader reader3=new Reader();
    Reader reader4=new Reader();
    Reader reader5=new Reader();
    Reader reader6=new Reader();
    Thread r1=new Thread(reader1,"Reader 1");
    Thread r2=new Thread(reader2,"Reader 2");
    Thread r3=new Thread(reader3,"Reader 3");
    Thread r4=new Thread(reader4,"Reader 4");
    Thread r5=new Thread(reader5,"Reader 5");
    Thread r6=new Thread(reader6,"Reader 6");
    authorThread.start();
    r1.start();
    r2.start();
    r3.start();
    r4.start();
    r5.start();
    r6.start();
  }
}

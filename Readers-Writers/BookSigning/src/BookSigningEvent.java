import java.util.ArrayDeque;
import java.util.Queue;

public class BookSigningEvent implements BookSigning
{
  private int readers;
  private int writer;
  private Queue<Thread> queue;

  public BookSigningEvent()
  {
    readers=0;
    writer=1;
    queue=new ArrayDeque<>();
  }
  @Override public synchronized void requestSignature()
  {
    queue.offer(Thread.currentThread());
    while(queue.peek()!=Thread.currentThread())
    {
      try
      {
        wait();
        System.out.println(Thread.currentThread().getName());
      }catch (InterruptedException e)
      {
        System.out.println("Interrupted");
      }
    }
    readers++;
    queue.remove();
    notifyAll();
  }

  @Override public synchronized void leaveWithASignedCopy()
  {
    readers--;
    if(readers==0)
    {
      notifyAll();
    }
  }

  @Override public synchronized void announceEndOfBookSigningEvent()
  {
    if(readers==0)
    {
      endBookSigningEvent();
    }
    while(queue.peek()!=Thread.currentThread())
    {
      try
      {
        System.out.println(Thread.currentThread().getName());
        wait();
      }
      catch (InterruptedException e)
      {

      }
      queue.remove();
      notifyAll();
    }
  }

  @Override public synchronized void endBookSigningEvent()
  {
    writer=0;
    notifyAll();
  }
}

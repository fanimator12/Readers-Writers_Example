public class Reader implements Runnable
{
  private BookSigning lock;
  public Reader()
  {
    lock=new BookSigningEvent();
  }
  @Override public void run()
  {
    while(true)
    {
      lock.requestSignature();
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {

      }
      lock.leaveWithASignedCopy();
    }
  }
}

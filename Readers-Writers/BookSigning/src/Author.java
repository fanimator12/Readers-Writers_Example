public class Author implements Runnable
{
  private BookSigning lock;
  private int time;

  public Author(int time)
  {
    this.time=time;
    lock=new BookSigningEvent();
  }
  @Override public void run()
  {
    while (time!=0)
    {
      time--;
    }
    lock.announceEndOfBookSigningEvent();
  }
}

public interface BookSigning
{
  void requestSignature();
  void leaveWithASignedCopy();
  void announceEndOfBookSigningEvent();
  void endBookSigningEvent();
}

package praktikum.AIFB.PRIS.exception;

public class StoreNotFoundException extends RuntimeException {

  public StoreNotFoundException(Long id) {
    super("Could not find store " + id);
  }

}

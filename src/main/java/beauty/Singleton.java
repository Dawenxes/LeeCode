package beauty;

/**
 * @author ZhangBoneng
 * @version 1.0.0 @ClassName Singleton @Description TODO
 * @createTime 2022年05月10日 17:07:00
 */
public class Singleton {

  private static volatile Singleton singleton = null;

  public static Singleton getInstance() {
    if (singleton == null) {
      synchronized (Singleton.class) {
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }
}

package richey.springaop.Aspectj.entity;

/**
 * 歌手类
 */
public interface Singer {

    public void singSomeSong() ;

    public void singSomeSong(String songName);

    public void songWriting();

    /**
     * 测试切点函数
     */
    public void singForAnnotation();

}

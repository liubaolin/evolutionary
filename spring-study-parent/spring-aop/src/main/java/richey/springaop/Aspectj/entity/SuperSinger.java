package richey.springaop.Aspectj.entity;

import richey.springaop.Aspectj.NeedTest;

/**
 * @author richey
 */
public class SuperSinger implements Singer {
    @Override
    public void singSomeSong() {
        System.out.println("我们不一样，不一样，每个人都有不同的境遇~~~~~");
    }

    @Override
    public void singSomeSong(String songName) {
        System.out.println("开始唱" + songName + "这首歌");
    }

    @Override
    public void singSomeSong(String songName, int times) {
        System.out.println("唱" + times + "次" + songName);
    }

    @Override
    public void songWriting() {
        System.out.println("写一首歌：<<我们不一样>>");
    }

    @NeedTest
    @Override
    public void singForAnnotation() {
        System.out.println("singSomeSong~~for annotation~~");
    }

}

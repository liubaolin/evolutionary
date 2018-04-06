package richey.springaop.Aspectj.entity;

import richey.springaop.Aspectj.NeedTest;

public class SuperSinger implements Singer {
    @Override
    public void sing() {
        System.out.println("我们不一样，不一样，每个人都有不同的境遇~~~~~");
    }

    @Override
    public void songWriting() {
        System.out.println("写一首歌：<<我们不一样>>");
    }

    @NeedTest
    @Override
    public void singForAnnotation() {
        System.out.println("sing~~for annotation~~");
    }
}

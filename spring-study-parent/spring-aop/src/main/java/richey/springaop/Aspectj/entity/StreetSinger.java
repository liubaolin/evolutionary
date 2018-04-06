package richey.springaop.Aspectj.entity;

import richey.springaop.Aspectj.NeetTestForStreetSinger;

@NeetTestForStreetSinger
public class StreetSinger implements Singer {
    @Override
    public void singSomeSong() {
        System.out.println("流浪歌手：" + "singSomeSong");
    }

    @Override
    public void singSomeSong(String songName) {
        System.out.println("流浪歌手：" + "singSomeSong-" + songName);
    }

    @Override
    public void singSomeSong(String songName, int times) {
        System.out.println("流浪歌手：" + "singSomeSong-" + songName + times + "次");
    }

    @Override
    public void songWriting() {
        System.out.println("流浪歌手：" + "songWriting");
    }

    @Override
    public void singForAnnotation() {
        System.out.println("流浪歌手：" + "singForAnnotation");
    }

}

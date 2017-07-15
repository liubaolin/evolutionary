package javatest.util.stream;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by richey on 17-7-9.
 */
public class StreamStudyTest {

    private StreamStudy streamStudy;

    @Before
    public void setUp() {
        streamStudy = new StreamStudy();
    }

    @Test
    public void TestForEach() {
        streamStudy.TestForEach();
    }

    @Test
    public void TestFilter() {
        streamStudy.TestFilter();
    }

    @Test
    public void TestDistinck() {
        streamStudy.TestDistinck();
    }

    @Test
    public void TestSorted() {
        streamStudy.TestSorted();
    }

    @Test
    public void TestMap() {
        streamStudy.TestMap();
    }

    @Test
    public void TestFlatMap() {
        streamStudy.TestFlatMap();
    }


    @Test
    public void TestReduce() {
        streamStudy.TestReduce();
    }

    @Test
    public void TestMax() {
        streamStudy.TestMax();
    }

    @Test
    public void TestReduceSum() {
        streamStudy.TestReduceSum();
    }

    @Test
    public void TestCollectDemo() {
        streamStudy.TestCollectDemo();
    }

    @Test
    public void TestCollector() {
        streamStudy.TestCollector();
    }

    @Test
    public void TestCollectMap() {
        streamStudy.TestCollectMap();
    }

    @Test
    public void TestCollectJoin() {
        streamStudy.TestCollectJoin();
    }

}
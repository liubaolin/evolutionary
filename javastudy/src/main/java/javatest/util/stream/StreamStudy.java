package javatest.util.stream;

import java.util.*;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DESCRIPTION: Stream的测试类
 *
 * @author richey
 * @create 2017-07-09-下午5:28
 */
public class StreamStudy {

    public void TestForEach() {
        Stream<String> stream = Stream.of("I","love","you","too");
        stream.forEach(str -> System.out.println(str));
    }

    public void TestFilter() {
        Stream<String> stream = Stream.of("I","love","you","too");
        stream.filter(str -> str.length() == 3).forEach(str -> System.out.println(str));
    }

    public void TestDistinck() {
        Stream<String> stream = Stream.of("I","love","you","too","too");
        stream.distinct().forEach(str -> System.out.println(str));
    }

    public void TestSorted() {
        Stream<String> stream = Stream.of("I","love","you","too");
        stream.sorted((str1, str2) -> str1.length() - str2.length()).forEach(str -> System.out.println(str));
    }

    public void TestMap() {
        Stream<String> stream = Stream.of("I","love","you","too");
        stream.map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));
    }

    public void TestFlatMap() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4));
        stream.flatMap(list -> list.stream()).forEach(i -> System.out.println(i));
    }


    public void TestReduce() {
        Stream<String> stream = Stream.of("I","love","you","too");
        Optional<String> longest = stream.reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2);
        System.out.println(longest.get());
    }

    public void TestMax() {
        Stream<String> stream = Stream.of("I","love","you","too");
        Optional<String> longest = stream.max((str1, str2) -> str1.length() - str2.length());
        System.out.println(longest.get());
    }

    public void TestReduceSum() {
        Stream<String> stream = Stream.of("I","love","you","too");
        Integer lengthSum = stream.reduce(0, // 初始值 参数1
                (sum, str) -> sum + str.length(),  //累加器 参数2
                (a, b) -> a + b); //部分结果拼接器 参数3
//        stream.mapToInt(str -> str.length()).sum();
        System.out.println(lengthSum);
    }


    public void TestCollectDemo() {
        Stream<String> stream = Stream.of("I","love","you","too");
        List<String> list = stream.collect(Collectors.toList());

//        Set<String> set = stream.collect(Collectors.toSet());
//        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(list);
    }

    public void TestCollectDemo2() {
        Stream<String> stream = Stream.of("I","love","you","too");
        // 使用toCollection()指定规约容器的类型
        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
        Set<String> set = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println(list);
    }

    public void TestCollector() {
        Stream<String> stream = Stream.of("I","love","you","too");
        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);
    }

    public void TestCollectMap() {
        List<ComputerVO> computers = new ArrayList<>();
        computers.add(new ComputerVO("联想笔记本",5500.0));
        computers.add(new ComputerVO("华硕笔记本",3500.0));
        computers.add(new ComputerVO("苹果笔记本",6500.0));
        Map<ComputerVO,Double> map = computers.stream().collect(Collectors.toMap(Function.identity(), computerVO -> getComputerPrice(computerVO)));
    }

    public void TestcollectMap2() {
        List<ComputerVO> computers = new ArrayList<>();
        computers.add(new ComputerVO("联想笔记本",5500.0));
        computers.add(new ComputerVO("华硕笔记本",3500.0));
        computers.add(new ComputerVO("苹果笔记本",6500.0));
        Map<Boolean,List<ComputerVO>> map = computers.stream().collect(Collectors.partitioningBy(c -> c.getPrice() >= 3500));
    }

    public void TestCollectMap3() {
        List<ComputerVO> computers = new ArrayList<>();
        computers.add(new ComputerVO("联想笔记本",5500.0));
        computers.add(new ComputerVO("华硕笔记本",3500.0));
        computers.add(new ComputerVO("苹果笔记本",6500.0));
        Map<String,List<ComputerVO>> map = computers.stream().collect(Collectors.groupingBy(ComputerVO::getName));
    }

    public void TestCollectMap4() {
        List<ComputerVO> computers = new ArrayList<>();
        computers.add(new ComputerVO("联想笔记本",5500.0));
        computers.add(new ComputerVO("华硕笔记本",3500.0));
        computers.add(new ComputerVO("苹果笔记本",6500.0));
        Map<String, Long> map = computers.stream().collect(Collectors.groupingBy(ComputerVO::getName, Collectors.counting()));
    }


    private Double getComputerPrice(ComputerVO computerVO) {
        return computerVO.getPrice();
    }

    public void TestCollectJoin() {
        Stream<String> stream = Stream.of("I","love","you","too");
//        String joined = stream.collect(Collectors.joining());
//        String joined = stream.collect(Collectors.joining(","));
        String joined = stream.collect(Collectors.joining(",","{","}"));
        System.out.println(joined);
    }

}

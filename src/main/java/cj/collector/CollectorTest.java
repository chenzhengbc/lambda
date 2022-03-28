package cj.collector;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectorTest {
    @AllArgsConstructor
    class Data {
        Integer id;
        String value;

        @Override
        public String toString() {
            return "Data{" + "partyId=" + id + ", taskId=" + value + '}';
        }
    }

    private List<Data> givenList = Arrays.asList(new Data(1, "V1"), new Data(1, "V11"), new Data(2, "V2"));
    @Test
    public void testCollectToList() {
        List<Data> result = givenList.stream().collect(toList());
        assertThat(result, equalTo(givenList));
    }


    @Test
    public void testPartitionBy() {
        System.out.println(givenList.stream().collect(partitioningBy((s) -> s.id > 1)));
    }

    @Test
    public void testGroupBy() {
        Map<Integer, Set<Data>> result = givenList.stream().collect(groupingBy((s) -> s.id, toSet()));
        for(Map.Entry<Integer, Set<Data>> entry : result.entrySet()) {
            System.out.println("PartyID=" + entry.getKey() + "Values=" + entry.getValue());
        }
    }
}

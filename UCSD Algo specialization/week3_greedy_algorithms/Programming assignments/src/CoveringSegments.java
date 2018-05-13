import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[segments.length];
        Segment[] sortedSegments;
        //boolean[] covered = new boolean[segments.length];
        //int length = segments.length;
        int start, end;
        int i = 0;
        int index = 0;
        for (int j = 0; j < segments.length; j++) {
            points[j] = -1;
        }

        sortedSegments = sortSegments(segments);
        start = sortedSegments[index].start;
        end = sortedSegments[index].end;
        while(index < sortedSegments.length) {
            if(start <= sortedSegments[index].start && end >= sortedSegments[index].start) {
                points[i] = sortedSegments[index].start;
                if(end > sortedSegments[index].end) {
                    start = sortedSegments[index].start;
                    end = sortedSegments[index].end;
                    //i++;
                }
                index++;
            }
            else {
                start = sortedSegments[index].start;
                end = sortedSegments[index].end;
                i++;
            }
        }
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static Segment[] sortSegments(Segment[] segments) {
        int length = segments.length;
        Segment[] sortedSegments = new Segment[length];
        boolean[] covered = new boolean[length];
        
        for(int j=0; j<length; j++) {
            covered[j] = false;
        }
        
        for(int j=0; j<length; j++) {  //while all segments are covered
            int minIndex = -1;
            int minStartValue = -1;
            int minEndValue = -1;
            //get first uncovered index and value
            for(int i=0; i<length; i++) {
                if(!covered[i]) {
                    minIndex = i;
                    minStartValue = segments[minIndex].start;
                    minEndValue = segments[minIndex].end;
                    break;
                }
            }
            
            for (int i = 1; i < segments.length; i++) {
                if ((minStartValue > segments[i].start || (minStartValue == segments[i].start && minEndValue > segments[i].end))
                        && !covered[i]) {
                    minIndex = i;
                    minStartValue = segments[minIndex].start;
                    minEndValue = segments[minIndex].end;
                }
            }
            sortedSegments[j] = new Segment(minStartValue, minEndValue);
            covered[minIndex] = true;
        }
        return sortedSegments;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        int num_points = 0;
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        for(int i = 0; i<points.length; i++) {
            if (points[i] != -1) {
                num_points++;
            }
        }
        System.out.println(num_points);
        for(int i = 0; i<points.length; i++) {
            if (points[i] != -1) {
                System.out.print(points[i] + " ");
            }
        }
    }
}
 

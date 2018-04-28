package com.hackerrank.search.GridLandMetro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SolutionOptimised {

    private static long gridLandMetro(long n, long m, int k, int[][] tracks) {

        long occupiedCells = 0;
        Map<Long, List<Pair>> grid = new TreeMap<>();

        for (int i = 0; i < k; i++) {
            long key = tracks[i][0];
            Pair value = new Pair(tracks[i][1], tracks[i][2]);
            if (grid.containsKey(key)) {
                grid.get(key).add(value);
            } else {
                List<Pair> list = new ArrayList<>();
                list.add(value);
                grid.put(key, list);
            }
        }
        // For each row
        for (Map.Entry row: grid.entrySet()){
            // sort the list of tracks from smaller to larger
            List<Pair> rowList = (ArrayList)(row).getValue();
            Map<Integer, Integer> resultMap = new HashMap<>();
            rowList.sort(Pair::compare);

            // Get Segment
            for (int i = 0; i < rowList.size(); i++) {
                // get current segment
                Pair segment = rowList.get(i);
                // if there is a next segment get it
                if(i < rowList.size() - 1){
                    Pair nextSegment = rowList.get(i+1);
                    // check case where the segments overlay
                    if (segment.overLay(nextSegment)) {
                        // non-complete containment - merge
                        if (nextSegment.getRight() > segment.getRight()) {
                            segment.setRight(nextSegment.getRight());
                        }
                        rowList.remove(nextSegment);
                        i --;
                    }
                }
                resultMap.put(segment.getLeft(), segment.getRight());
            }
            for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()) {
                occupiedCells += (entry.getValue()+1 - entry.getKey());
            }
        }
        return n * m - occupiedCells;
    }

    public static void main(String[] args) throws FileNotFoundException{
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\search\\GridLandMetro\\testcase6.txt");
        Scanner in = new Scanner(inFile);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] track = new int[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        long result = gridLandMetro(n, m, k, track);
        System.out.println(result);
        in.close();

        System.out.println(result);
    }

    static int twoDArraySum(int[][] array) {
        int sum = 0;
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                sum += anAnArray;
            }
        }
        return sum;
    }

    private static class Pair {

        private Integer left;
        private Integer right;

        private Pair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        private Integer getLeft() { return left; }
        private Integer getRight() { return right; }
        private void setRight(Integer right) {this.right = right;}

        @Override
        public int hashCode() { return left.hashCode() ^ right.hashCode(); }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair pairo = (Pair) o;
            return this.left.equals(pairo.getLeft()) &&
                    this.right.equals(pairo.getRight());
        }

        static int compare(Pair p1, Pair p2) {
            if (p1.getLeft() > p2.getLeft()) {return 1;}
            if (p1.getLeft() < p2.getLeft()) {return -1;}
            return 0;
        }

        boolean overLay(Pair p2) {
            return this.getRight() >= p2.getLeft() && p2.getRight() >= this.getLeft() && (this.getRight() >= p2.getLeft() || p2.getRight() >= this.getLeft());
        }
    }
}

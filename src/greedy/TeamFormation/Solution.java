package com.hackerrank.Greedy.TeamFormation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private static int splitTeams(List<Integer> contestantList) {
        int result = 0;
        int n = contestantList.size();
        if (n == 0) {
            return result;
        }
        contestantList.sort(Collections.reverseOrder());

        List<Group> groups = new ArrayList<>();
        groups.add(new Group(contestantList.get(0)));


        return result;
    }


    static class Group {
        int max;
        int count = 0;
        List<Integer> teamMembers = new ArrayList<>();

        public Group() {
        }
        public Group(int contestant) {
            this.max = contestant;
            this.count ++;
            this.teamMembers.add(contestant);
        }

        public void addMember(int contestant) {
            this.max = max;
            this.count = count++;
            this.teamMembers.add(contestant);
        }

        public boolean acceptsContestant(int contestant) {
            if (this.max+1 == contestant) {
                return true;
            }
            return false;
        }

        public int getMax() {
            return max;
        }


        public int getCount() {
            return count;
        }

        public int compareTo(Group g) {
            if (this.count > g.getCount()) {return 1;}
            if (this.count < g.getCount()) {return -1;}
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File inFile = new File(currentDir + "\\src\\com\\hackerrank\\Greedy\\TeamFormation\\example.txt");
        Scanner in = new Scanner(inFile);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            in.nextLine();
            int n = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                list.add(in.nextInt());
            }
            int result = splitTeams(list);
            System.out.println(result);
        }
    }

    private static void printArray(Object[] ar) {
        StringBuilder builder = new StringBuilder();
        for(Object integer : ar){
            builder.append(integer).append(" ");
        }
        System.out.println(builder.toString());
    }

}

package com.warbyparker.patternmatcher;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(System.out)) {

            List<List<String>> patterns = readSection(br, ",");
            List<List<String>> paths = readSection(br, "/");
            List<String> matches = PatternMatcher.findMatch(patterns, paths);
            for (String match : matches) {
                pw.println(match);
            }
        }
    }

    /**
     * Reads a line (count), then reads the next (count) lines and creates a list of list of strings split by delimiter
     * @param br
     * @param delimiter
     * @return
     * @throws IOException
     */
    private static List<List<String>> readSection(BufferedReader br, String delimiter) throws IOException {
        int count = Integer.parseInt(br.readLine());
        List<List<String>> section = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), delimiter);
            List<String> tokens = new ArrayList<>();
            while (st.hasMoreTokens()) {
                tokens.add(st.nextToken());
            }
            section.add(tokens);
        }
        return section;
    }
}

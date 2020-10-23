package com.warbyparker.patternmatcher;

import java.util.*;

public class PatternMatcher {

    /**
     * Finds matches for the patterns and paths. Stores patterns in a trie. Traverses trie for each path for best match.
     * @param patterns
     * @param paths
     * @return the best matched pattern for each path
     */
    public static List<String> findMatch(List<List<String>> patterns, List<List<String>> paths) {
        List<String> matches = new ArrayList<>();
        PatternTrie trie = new PatternTrie();
        for (List<String> pattern : patterns) {
            trie.insert(pattern);
        }
        for (List<String> path : paths) {
            matches.add(trie.find(path));
        }
        return matches;
    }
}

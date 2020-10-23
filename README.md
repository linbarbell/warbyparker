## Pattern Matcher

This solution uses Java 11. You can build with:

    mvn clean package

or with:

    make

This will create `/target/pattern-matcher-1.0-SNAPSHOT.jar`, which can then run like:

    cat input_file | java -jar pattern-matcher-1.0-SNAPSHOT.jar > output_file

### Extra Credit

The time complexity is O(logn * m), where
- n is the number of patterns
- m is the number of paths

The patterns are stored in a Trie, which stores a sequence of values. Each node's descendants contain the same prefix.
This is useful to avoid doing extra work for each prefix.
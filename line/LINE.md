pending:
    - 42, 221, 994, 167, 287, 560
    - 32, 819, 169, 217, 167, 16, 18, 287, 229
    - 84, 6, 151, 718, 304, 992, 340, 1004, 9, 290
    - 609, 239, 362, 706, 937(sort), 680

stack pending
    - 1249


Matrix type pending:
    - 289, 48, 54, 59, 73

Not Forward
    - 686

finished
    - 20, 15, 344, 67, 14, 989, 415, 66, 202, 28
    - 459, 189, 186, 38, 696, 271, 443, 345, 541, 557
    - 1119, 125, 11, 209, 325, 13, 303, 12, 1, 3
    - 159, 31, 448, 442, 268, 136, 389, 217, 219, 242
    - 266, 409, 49, 438, 567, 76, 771, 204, 187, 36
    - 387, 205, 535, 463, 349, 380, 560, 724, 523, 974
    - 981, 953, 811, 166, 7, 8, 9, 359, 238, 228
    - 412, 819, 299

one pass
    - 344, 20, 67, 989, 415, 66, 1119, 303, 268, 389, 136, 8, 412
    - hash
        - 13, 12, 1, 442, 217, 219

two pass
    - 14, 15, 202, 28, 459, 238
    - map
        - 448, 442, 242, 266, 409, 204, 387, 953

two pointer
    - left & right pointer, reverse, rotate
        - 189, 345, 541, 125, 11, 159, 31, 9
    - diff pointer
        - 186, 557, 38, 696, 271, 443, 3, 811, 228
    - sliding window
        - 209, 159, 438
    - slow & fast pointer, check cycle
        - 202
    - range sum
        - 209, 325

hash table
    - hash set
        - 202, 217, 187, 349
    - hash map
        - 1, 325, 219, 49, 187, 535, 380, 560, 523, 974, 981, 811, 166
    - array map (index)
        - 448, 442, 12, 204, 724
    - array map (character)
        - 387, 771, 242, 205, 266, 409, 49, 438, 567, 76, 13, 3, 36, 953
    - tree map
        - 981
    - design
        - 359
    - Advanced
        - 819, 299

matrix
    - general
        - 463
    - index mapping
        - 36

special topics
    - bit operation
        - 268, 389, 136
    - range sum
        - 303, 724, 560, 523, 974, 238(range product)
    - sliding window
        - 438, 567, 76
    - string operations
        - 811
    - number operations
        - 7, 9, 8, 166
    - check cycle
        - 166
    - Palindrome
        - 9, 125

design
    - 535, 380, 981, 359

Some knowledge

    Type        Description                 Default     Size        Example Literals
    boolean     true or false               false       1 bit       true, false
    byte        twos complement integer     0           8 bits      (none)
    char        Unicode character           \u0000      16 bits     'a', '\u0041', '\101', '\\', '\'', '\n', 'ß'
    short       twos complement integer     0           16 bits     (none)
    int         twos complement integer     0           32 bits     -2, -1, 0, 1, 2
    long        twos complement integer     0           64 bits     -2L, -1L, 0L, 1L, 2L
    float       IEEE 754 floating point     0.0         32 bits     1.23e100f, -1.23e-100f, .3f, 3.14F
    double      IEEE 754 floating point     0.0         64 bits     1.23456e300d, -1.23456e-300d, 1e1d

    /**
     * Problem Analysis:
     *     1.
     *
     * General Cases:
     *     1.
     *
     * Corner Cases:
     *     1.
     *
     * Time:
     * Space:
     */

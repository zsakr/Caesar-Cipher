# Caesar-Cipher
This project to write a simple encryption / decryption command line program that accepts three arguments:
the mode of operation, the name of the file where the message to be encrypted / decrypted
is stored as well as the encryption key (shift). My program will perform encryption / decryption
using a generalized Caesar Cipher. Part 1 explains how encryption / decryption works for this cipher.
The objectives for the project are to learn how to work
with Strings and learn how to utilize an existing Java API.

Part 1: Shift Ciphers

In cryptography, a Caesar Cipher1, also known as a Caesar Shift, is one of the simplest and most
widely known encryption techniques. The method is named after Julius Caesar, who used it in his
private correspondence. A Caesar cipher is a type of substitution cipher in which each letter in the
plaintext is replaced by a letter some fixed number of positions down the alphabet. Decryption is
done in reverse.

Both encryption and decryption operations can be represented using modular arithmetic by first
transforming the letters into numbers, according to the scheme, a ! 0, b ! 1, ..., z ! 25. All
lower-case letters and their corresponding positions are listed in the table above. Encryption of a
letter x by a shift n can be then described mathematically as:
En(x) = x + n (mod 26)

Decryption is performed similarly:
Dn(x) = x % n (mod 26)

The above equations yield a new letter position, which we then map back to an actual letter
using the same scheme. For this reason, the mod operation must yield a value in the range of 0 to
25 (if the position was outside this range, we would not be able to map it back to a letter). This
means that if x + n or x % n are not in the range 0 to 25, we have to subtract or add 26.

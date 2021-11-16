#include <stdio.h>

int is_decimal_palindrome(int);
int is_binary_palindrome(int);

int main(int argc, char const *argv[])
{
    int sum = 0, i = 0;
    while (i < 1000000)
    {
        if (is_decimal_palindrome(i) && is_binary_palindrome(i))
        {
            sum += i;
        }
        i++;
    }
    printf("%d", sum);
    return 0;
}

int is_decimal_palindrome(int i)
{
    int rev = 0, t = i;
    while (i != 0)
    {
        rev *= 10;
        rev += i % 10;
        i /= 10;
    }
    return rev == t;
}

int is_binary_palindrome(int i)
{
    int rev = 0, t = i;
    while (i != 0)
    {
        rev <<= 1;
        rev |= (i & 1);
        i >>= 1;
    }
    return rev == t;
}
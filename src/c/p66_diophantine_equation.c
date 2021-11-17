#include <stdio.h>

int binary_search(int x, int d);
int eval(int x, int d, int y);

int main(int argc, char const *argv[])
{
    int len = 1001;
    int p_squares[1001] = {0};

    int i = 1;
    while (i * i <= 1000)
    {
        p_squares[i * i] = 1;
        i++;
    }

    int max_x = 0;
    int max_d = 0;
    for (int d = 1; d <= 1000; d++)
    {
        if (!p_squares[d])
        {
            int min_x = 0, x = 1;
            while (x < 100000)
            {
                int y = binary_search(x, d);
                if (!y)
                {
                    x++;
                    continue;
                }
                min_x = x;
                break;
            }

            //printf("%d-%d\n", min_x, d);
            if (min_x > max_x)
            {
                max_x = min_x;
                max_d = d;
                // printf("%d-%d\n", min_x, d);
            }
        }
    }

    printf("%d", max_d);

    return 0;
}

int binary_search(int x, int d)
{
    int s = 1, e = x;
    while (s <= e)
    {
        if (eval(x, d, s) == 1)
            return s;
        if (eval(x, d, e) == 1)
            return e;
        int m = (s + e) / 2;
        int ev = eval(x, d, m);
        if (ev == 1)
            return m;
        else if (ev > 1)
            s = m + 1;
        else
            e = m - 1;
    }
    return 0;
}

int eval(int x, int d, int y)
{
    return (x * x) - (d * (y * y));
}
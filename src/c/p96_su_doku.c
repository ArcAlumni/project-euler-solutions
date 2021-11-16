#include <stdio.h>
#include <stdlib.h>

int solve(int **, int);
int is_valid_placement(int **, int, int, int, int);
void print_board(int **, int);
int verify_board(int **, int);

int main(void)
{
    FILE *file_ptr;

    // allocate 2D array
    int **board;
    int rows = 9, cols = 9;
    board = malloc(rows * sizeof *board);
    for (int i = 0; i < rows; i++)
        board[i] = malloc(cols * sizeof *board[i]);

    // open and buffer file
    int bufferLength = 255, row = 0, col = 0;
    char buffer[bufferLength];
    file_ptr = fopen("../resources/p096_sudoku.txt", "r");

    int sum = 0, c = 0;

    while (fgets(buffer, bufferLength, file_ptr))
    {
        if (buffer[0] == 'G')
            continue;
        col = 0;
        for (int i = 0; i < rows; i++)
            board[row][col++] = buffer[i] - '0';
        row++;
        if (row == 9)
        {
            c++;
            if (!solve(board, rows))
                printf("Unable to solve board");
            sum += (board[0][0] * 100) + (board[0][1] * 10) + board[0][2];
            row = col = 0;
        }
    }

    printf("%d = %d", c, sum);

    // deallocate the array
    for (int i = 0; i < rows; i++)
        free(board[i]);
    free(board);

    //close file
    fclose(file_ptr);
}

int solve(int **board, int len)
{
    for (int i = 0; i < len; i++)
    {
        for (int j = 0; j < len; j++)
        {
            if (board[i][j] != 0)
                continue;

            for (int k = 1; k <= len; k++)
            {
                if (is_valid_placement(board, len, i, j, k))
                {
                    board[i][j] = k;
                    if (solve(board, len))
                        return 1;
                    board[i][j] = 0;
                }
            }
            return 0;
        }
    }

    return 1;
}

int is_valid_placement(int **board, int len, int i, int j, int k)
{

    for (int c = 0; c < len; c++)
        if (board[i][c] == k)
            return 0;

    for (int r = 0; r < len; r++)
        if (board[r][j] == k)
            return 0;

    int r = (i / 3) * 3, c = (j / 3) * 3;

    for (int m = 0; m < 3; m++)
        for (int n = 0; n < 3; n++)
            if (board[r + m][c + n] == k)
                return 0;

    return 1;
}

int verify_board(int **board, int len)
{
    for (int i = 0; i < len; i++)
    {
        for (int j = 0; j < len; j++)
        {
            if (board[i][j] == 0)
            {
                return 0;
            }
        }
    }
    return 1;
}

void print_board(int **board, int len)
{
    printf("\n");
    for (int i = 0; i < len; i++)
    {
        for (int j = 0; j < len; j++)
        {
            printf("%d ", board[i][j]);
        }
        printf("\n");
    }
}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include <assert.h>
#include "ass4.h"

#define SIZE 8

void printColumns();
void printSpacers();
// PGN characters
extern const char PAWN;
extern const char ROOK;
extern const char KNIGHT;
extern const char BISHOP;
extern const char QUEEN;
extern const char KING;
extern const char CAPTURE;
extern const char PROMOTION;
extern const char CHECK;
extern const char MATE;
extern const char FIRST_COL;

// FEN & Board characters
extern const char WHITE_PAWN;
extern const char WHITE_ROOK;
extern const char WHITE_KNIGHT;
extern const char WHITE_BISHOP;
extern const char WHITE_QUEEN;
extern const char WHITE_KING;
extern const char BLACK_PAWN;
extern const char BLACK_ROOK;
extern const char BLACK_KNIGHT;
extern const char BLACK_BISHOP;
extern const char BLACK_QUEEN;
extern const char BLACK_KING;

// FEN separator for strtok()
extern const char SEP[];

// Board characters
extern const char EMPTY;

/**************************
 * convert char to digit
 **************************/
extern int toDigit(char c);

// Is it a digit
int isADigit(char c)
{
    return '0' <= c && c <= '9';
}
// is it White, is srcPiece not a Pawn
int isUpperPiece(char c)
{
    return c == 'K' || c == 'Q' || c == 'B' || c == 'N' || c == 'R';
}
// Is it a Pawn
int isLower(char c)
{
    return 'a' <= c && c <= 'h';
}

//Col char to Col number
int lowerToNumber(char c)
{
    assert('a' <= c && c <= 'h');
    return c - 'a';
}

void createBoard(char board[][SIZE], char fen[])
{
    int i = 0;
    int j = 0;
    char *pieces = fen;
    while (*pieces != 0)
    {
        if (isADigit(*pieces))
        {
            int spaces = toDigit(*pieces);
            for (int h = 0; h < spaces; h++)
            {
                board[i][j] = ' ';
                j++;
            }
        }
        else if (*pieces == '/')
        {
            i++;
            j = 0;
        }
        else
        {
            board[i][j] = *pieces;
            j++;
        }
        pieces++;
    }
}

void printBoard(char board[][SIZE])
{
    printColumns();
    printSpacers();
    int numLim = SIZE;
    for (int i = 0; i < 8; i++)
    {
        printf("%d ", numLim);
        for (int j = 0; j < 8; j++)
        {
            printf("|%c", board[i][j]);
        }
        printf("| %d", numLim);
        numLim--;
        printf("\n");
    }

    printSpacers();
    printColumns();
}

// Move logical representation
typedef struct
{
    char srcPiece, srcCol, destCol;
    int iSrc, jSrc, iDest, jDest, srcRow, destPiece, destRow;
    int isWhite, isCapture, isPromotion, isCheck, isMate, isLegal;
} Move;

void makeMove(char board[][SIZE], char pgn[], int isWhiteTurn)
{
    Move currMove;
    int lengthOfMove;
    char *pgnMove = pgn;
    int i = 0;
    lengthOfMove = strlen(pgn);

    while (*pgnMove != 0)
    {
        if (isUpperPiece(*pgnMove)) // Normal Pieces Rules
        {
            currMove.srcPiece = *pgnMove;
        }
        if (*pgnMove == 'x') //If there's a capture
        {
        }
        else if (isLower(*pgnMove))
            currMove.destCol = lowerToNumber(*pgnMove);
        if (isADigit(*pgnMove))
            currMove.destRow = toDigit(*pgnMove);

        else if (isLower(*pgnMove)) // Pawn Rules
        {
            currMove.srcCol = lowerToNumber(*pgnMove);

            if (isWhiteTurn)
            {
                currMove.srcPiece = WHITE_PAWN;
            }
            else
                currMove.srcPiece = BLACK_PAWN;

            if (pgn[2] == '=') // If there's a coronation
            {
            }

            if (isADigit(pgn[1]))
                currMove.destRow = toDigit(pgn[1]);
            else if (pgn[1] == 'x') //If there's a capture
            {
                currMove.destCol = pgn[2];
                currMove.destRow = toDigit(pgn[3]);
            }
        }
        pgnMove++;
    }
    if (isWhiteTurn)
    {
        if (currMove.srcPiece == 'K')
        {
        }
        else if (currMove.srcPiece == 'Q')
        {
        }
        else if (currMove.srcPiece == 'B')
        {
        }
        else if (currMove.srcPiece == 'N')
        {
        }
        else if (currMove.srcPiece == 'R')
        {
        }
        else if (currMove.srcPiece == WHITE_PAWN)
        {
        }
    }
    if (!isWhiteTurn)
    {

        if (currMove.srcPiece == 'K')
        {
        }
        else if (currMove.srcPiece == 'Q')
        {
        }
        else if (currMove.srcPiece == 'B')
        {
        }
        else if (currMove.srcPiece == 'N')
        {
        }
        else if (currMove.srcPiece == 'R')
        {
        }
        else if (currMove.srcPiece == BLACK_PAWN)
        {
        }
    }

    printBoard(board);
}
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxs = [set() for _ in range(9)]
        for i in range(9):
            row = rows[i]
            b = 0 
            if i >= 3:
                b = 3
            if i >= 6:
                b = 6
            for j in range(9):
                num = board[i][j]
                if num == ".":
                    continue
                col = cols[j]
                box = boxs[b + j // 3]
                if num in row or num in col or num in box:
                    # print(num in row)
                    # print(num in col)
                    # print(num in box)
                    # print(num, i, j)
                    return False
                row.add(num)
                col.add(num)
                box.add(num)
        return True
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows, cols, boxes = collections.defaultdict(set), collections.defaultdict(set), collections.defaultdict(set)
        for r in range(9):
            for c in range(9):
                entry = board[r][c]
                if entry == '.':
                    continue
                if entry in rows[r] or entry in cols[c] or entry in boxes[(r // 3, c // 3)]:
                    return False
                rows[r].add(entry)
                cols[c].add(entry)
                boxes[(r // 3, c // 3)].add(entry)
        return True
        return True
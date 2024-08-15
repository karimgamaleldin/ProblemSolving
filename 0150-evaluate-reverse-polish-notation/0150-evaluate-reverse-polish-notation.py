class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = deque()
        for t in tokens:
            if self.isOperator(t):
                val = self.operation(stack.pop(), stack.pop(), t)
                stack.append(int(val))
            else:
                stack.append(int(t))
        return stack.pop()
    
    @staticmethod
    def isOperator(t: str) -> bool:
        return t in ['+', '-', '*', '/']
    
    @staticmethod
    def operation(second:str, first:str, op: str):
        if op == '+':
            return first + second
        elif op == '-':
            return first - second
        elif op == '/':
            return first / second
        return first * second
        
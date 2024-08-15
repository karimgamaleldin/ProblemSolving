class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        for c in s:
            if self.isClosing(c): 
                if len(stack) > 0 and self.closes(stack[-1], c):
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        return len(stack) == 0
                
        
    
    @staticmethod
    def isClosing(s:str) -> bool:
        return s ==']' or s ==')' or s =='}'
    
    @staticmethod
    def closes(s:str, t:str) -> bool:
        return s == '[' and t == ']' or s == '(' and t == ')' or s == '{' and t == '}'
        